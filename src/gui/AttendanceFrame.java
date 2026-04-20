package gui;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.qrcode.QRCodeReader;
import model.MySQL2;
import javax.swing.JOptionPane;
import visuals.JOptionIcon;
import java.sql.ResultSet;

public class AttendanceFrame extends JFrame {

    private static Home home;
    private final JLabel cameraLabel;
    private final JLabel createAccountLabel;
    private final JButton closeButton;
    private VideoCapture videoCapture;
    private Timer cameraTimer;
    private final Map<String, LocalDateTime> lastAttendance;

    public AttendanceFrame(Home home) {
        AttendanceFrame.home = home;
        System.load("C:\\opencv\\build\\java\\x64\\opencv_java490.dll");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        createAccountLabel = new JLabel("Mark your attendance!");
        createAccountLabel.setForeground(Color.WHITE);
        createAccountLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        createAccountLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        add(createAccountLabel, BorderLayout.NORTH);

        // JLabel to display the camera feed
        cameraLabel = new JLabel();
        cameraLabel.setHorizontalAlignment(JLabel.CENTER);
        add(cameraLabel, BorderLayout.CENTER);

        closeButton = new JButton("Close");
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Poppins", Font.PLAIN, 18) {
        });
        closeButton.setBackground(new Color(26, 135, 85));
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> stopCamera());
        add(closeButton, BorderLayout.SOUTH);

        // Map to track last attendance times
        lastAttendance = new HashMap<>();
        startCamera();

        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);
    }

    private void startCamera() {
        videoCapture = new VideoCapture(0);
        if (!videoCapture.isOpened()) {
            JOptionPane.showMessageDialog(this, "Unable to open camera.", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
            return;
        }

        cameraTimer = new Timer(30, e -> {
            Mat frame = new Mat();
            if (videoCapture.read(frame)) {
                BufferedImage img = OpenCVUtils.matToBufferedImage(frame);
                cameraLabel.setIcon(new ImageIcon(img));

                // QR Code scanning logic
                String qrData = scanQRCode(img);
                if (qrData != null) {
                    handleAttendance(qrData);
                }
            }
        });
        cameraTimer.start();
    }

    private String scanQRCode(BufferedImage img) {
        try {
            LuminanceSource source = new BufferedImageLuminanceSource(img);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new QRCodeReader().decode(bitmap);
            return result.getText();

        } catch (NotFoundException | ChecksumException | FormatException e) {
            return null;
        }
    }

    private void handleAttendance(String employeeEmail) {
        LocalDateTime now = LocalDateTime.now();

        // Check if attendance already marked within 5 minutes
        if (lastAttendance.containsKey(employeeEmail) && lastAttendance.get(employeeEmail).plusMinutes(2).isAfter(now)) {
            JOptionPane.showMessageDialog(this, "Cannot mark attendance again within 2 minutes.", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
            return;
        }

        String currentDate = java.time.LocalDate.now().toString();
        String currentTime = java.time.LocalTime.now().toString();

        try {
            // Check if an entry already exists for the employee for today
            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee_attendance` WHERE `employee_email` = '" + employeeEmail + "' AND `date` = '" + currentDate + "'");

            if (resultSet.next()) {
                // Entry exists; check if `checkout` is null
                String checkout = resultSet.getString("checkout");

                if (checkout == null) {
                    // Update checkout time
                    MySQL2.executeIUD("UPDATE `employee_attendance` SET `checkout` = '" + currentTime + "' WHERE `employee_email` = '" + employeeEmail + "' AND `date` = '" + currentDate + "'");
                    JOptionPane.showMessageDialog(this, "Checkout time recorded successfully.", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                } else {
                    JOptionPane.showMessageDialog(this, "Attendance already fully marked for today.", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());
                }
            } else {
                // No entry exists; insert new record with check-in time
                MySQL2.executeIUD("INSERT INTO `employee_attendance`(`date`, `checkin`,`employee_email`) VALUES('" + currentDate + "', '" + currentTime + "', '" + employeeEmail + "')");
                JOptionPane.showMessageDialog(this, "Check-in time recorded successfully.", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
            }

            // Update the last attendance time
            lastAttendance.put(employeeEmail, now);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
        }
    }

    private void stopCamera() {
        if (cameraTimer != null) {
            cameraTimer.stop();
        }
        if (videoCapture != null) {
            videoCapture.release();
        }
        if (home != null) {
            home.goHome();
        }
        dispose();
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new AdminDashboard(home).setVisible(true);
        });
    }
}

class OpenCVUtils {

    // Utility method to convert Mat to BufferedImage
    public static BufferedImage matToBufferedImage(Mat mat) {
        int width = mat.cols();
        int height = mat.rows();
        int channels = mat.channels();

        byte[] sourcePixels = new byte[width * height * channels];
        mat.get(0, 0, sourcePixels);

        BufferedImage image;
        if (channels == 3) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            System.arraycopy(sourcePixels, 0, ((DataBufferByte) image.getRaster().getDataBuffer()).getData(), 0, sourcePixels.length);
        } else {
            image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            System.arraycopy(sourcePixels, 0, ((DataBufferByte) image.getRaster().getDataBuffer()).getData(), 0, sourcePixels.length);
        }

        return image;
    }
}

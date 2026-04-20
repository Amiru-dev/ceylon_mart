package model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.JOptionPane;
import visuals.JOptionIcon;

public final class QRCodeGenerator {

    private final String email;

    public QRCodeGenerator(String email) {
        this.email = email;
        init();
    }

    public void init() {
        String qrContent = this.email;
        String filePath = "C:\\Users\\ASUS™\\Desktop\\QR\\" + this.email + ".png";
        int width = 300;
        int height = 300;

        try {
            generateQRCode(qrContent, filePath, width, height);
            JOptionPane.showMessageDialog(null, "QR Code generated successfully. You can access it from QR folder in Desktop.", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.QR.setICon());

        } catch (WriterException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while generating QR Code.", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
        }
    }

    public static void generateQRCode(String content, String filePath, int width, int height)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}

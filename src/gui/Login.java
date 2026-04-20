package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import model.MySQL2;
import raven.toast.Notifications;
import java.util.logging.*;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS™
 */
public class Login extends JFrame {

    public static final Logger logger = Logger.getLogger("ceylon_mart");

    private static String employeeEmail;

    public static String getEmployeeEmail() {
        return employeeEmail;
    }

    public static void setEmployeeEmail(String employeeEmail) {
        Login.employeeEmail = employeeEmail;
    }

    public Login() {
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        Frame login = this;
        Notifications.getInstance().setJFrame(this);

        try {
            FileHandler fileHandler = new FileHandler("ceylon_mart.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Log file creation error", e);
        }

        // the main panel with a grid layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBackground(new Color(0, 0, 0, 0)); 

        // panel (left side)
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(26, 135, 85)); 
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel welcomeLabel = new JLabel("Welcome Back!");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 32));
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(welcomeLabel, gbc);

        JLabel signInMsg = new JLabel("<html>To keep connected with us please<br>sign in with your personal info</html>");
        signInMsg.setForeground(Color.WHITE);
        signInMsg.setFont(new Font("Arial", Font.ITALIC, 14) {
        });
        gbc.gridy = 1;
        loginPanel.add(signInMsg, gbc);

        try {
            InputStream imgStream1 = getClass().getResourceAsStream("/resourses/new.png");
            ImageIcon originalIcon1 = new ImageIcon(ImageIO.read(imgStream1));
            this.setIconImage(originalIcon1.getImage());

        } catch (IOException e) {
            logger.log(Level.WARNING, "Couldn't load image", e);
        }

        // Create the register panel (right side)
        JPanel registerPanel = new JPanel();
        registerPanel.setBackground(Color.WHITE);
        registerPanel.setLayout(new GridBagLayout());

        JLabel createAccountLabel = new JLabel("Sign In");
        createAccountLabel.setForeground(Color.BLACK);
        createAccountLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        gbc.gridy = 0;
        registerPanel.add(createAccountLabel, gbc);

        JTextField emailField = new JTextField(15);
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Email");
        emailField.setBorder(border);

        // Add FocusListener to highlight border on focus
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                border.setTitleColor(Color.BLUE);
                emailField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Email"));
                emailField.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setTitleColor(Color.BLACK); 
                emailField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Email"));
                emailField.repaint(); 
            }
        });
        gbc.gridy = 2;
        registerPanel.add(emailField, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        TitledBorder border1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Password");
        passwordField.setBorder(border1);

        // Add FocusListener to highlight border on focus
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                border1.setTitleColor(Color.BLUE); 
                passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Password"));
                passwordField.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                border1.setTitleColor(Color.BLACK); 
                passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Password"));
                passwordField.repaint();
            }
        });
        gbc.gridy = 3;
        registerPanel.add(passwordField, gbc);

        JButton signInButton = new JButton("SIGN IN");
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Poppins", Font.BOLD, 15) {
        });
        signInButton.setBackground(new Color(26, 135, 85));
        signInButton.setFocusPainted(false);
        
        // Add ActionListener to the button
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (email.isEmpty()) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Please Enter Employee Email");
                    emailField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Email"));
                } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                        + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Invalid Employee Email");
                    emailField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Email"));
                } else if (password.isEmpty()) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Please Enter Employee Password");
                    passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Password"));
                } else if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please enter minimum eight characters,  at least one letter and one number");
                    passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Password"));
                } else {

                    try {
                        ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee` "
                                + "INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.`id` "
                                + "INNER JOIN `employee_status` ON `employee`.`employee_status_id` = `employee_status`.`id` "
                                + "WHERE `email` = '" + email + "' AND `password`= '" + password + "'");

                        if (resultSet.next()) {
                            String fName = resultSet.getString("first_name");
                            String lName = resultSet.getString("last_name");
                            String type = resultSet.getString("employee_type.name");
                            String status = resultSet.getString("employee_status.name");

                            if ("Active".equals(status)) {
                                FlatMacDarkLaf.setup();

                                if ("Admin".equals(type)) {
                                    new AdminDashboard().setVisible(true);

                                } else if ("Employee".equals(type)) {
                                    Login.setEmployeeEmail(email);
                                    Home home = new Home(email, fName, lName);
                                    home.setVisible(true);

                                    new AttendanceFrame(home).setVisible(true);
                                }

                            } else {
                                String message = "This " + type.toLowerCase() + " account is deactivated";
                                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, message);
                            }

                            emailField.setText("");
                            passwordField.setText("");
                            login.dispose();

                        } else {
                            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Invalid email or password");
                        }
                    } catch (Exception ex) {
                        logger.log(Level.WARNING, "Error", ex);
                    }
                }
            }
        });

        gbc.gridy = 4;
        registerPanel.add(signInButton, gbc);

        // Add panels to the main panel
        mainPanel.add(loginPanel);
        mainPanel.add(registerPanel);

        // Add the main panel to the frame
        add(mainPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

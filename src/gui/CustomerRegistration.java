package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import static gui.Login.logger;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import model.MySQL2;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;
import visuals.JOptionIcon;

/**
 *
 * @author Amiru
 */
public class CustomerRegistration extends javax.swing.JFrame {

    private Invoice invoice;
    private static CustomerRegistration customerReg;

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public CustomerRegistration() {
        initComponents();
        loadCustomers("first_name", "ASC", "07");

        jLabel8.setText("0");

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);

        jButton1.setEnabled(true);
        jButton2.setEnabled(false);

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);

        jTable1.setDefaultRenderer(Object.class, renderer);

        jTextField1.putClientProperty("JComponent.roundRect", true);
        jTextField2.putClientProperty("JComponent.roundRect", true);
        jTextField3.putClientProperty("JComponent.roundRect", true);
        jTextField4.putClientProperty("JComponent.roundRect", true);

        jTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter mobile");
        jTextField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter first name");
        jTextField3.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter last name");
        jTextField4.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter email");

        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(255, 51, 51));
                jButton1.setForeground(new Color(0, 0, 0));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
                jButton2.setBackground(new Color(255, 51, 51));
                jButton2.setForeground(new Color(0, 0, 0));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(255, 51, 51));
                jButton3.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        Notifications.getInstance().setJFrame(this);
    }

    private void loadCustomers(String column, String orderby, String mobile) {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `customer` WHERE `mobile` LIKE '" + mobile + "%' ORDER BY `" + column + "` " + orderby + "");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("points"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Registration");
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Registration");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mobile");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(30, 144, 255));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
                        .addGap(7, 7, 7))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Email", "Points"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer Sort By :");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Names (A - Z)", "Names (Z - A)", "Points (0 - 9)", "Points (9 - 0)" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Invoices :");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("INVOICES COUNT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String mobile = jTextField1.getText();
        String firstName = jTextField2.getText();
        String lastName = jTextField3.getText();
        String email = jTextField4.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

        if (firstName.isEmpty()) {
            jTextField2.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(firstName).matches()) {
            jTextField2.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for first name.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (lastName.isEmpty()) {
            jTextField3.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(lastName).matches()) {
            jTextField3.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for last name.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (email.isEmpty()) {
            jTextField4.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            jTextField4.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter valid email address", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else {

            try {
                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `customer` WHERE `email` = '" + email + "'");

                boolean canUpdate = false;

                if (resultSet.next()) {
                    if (resultSet.getString("mobile").equals(mobile)) {
                        canUpdate = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Email already added", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                    }

                } else {
                    canUpdate = false;
                    JOptionPane.showMessageDialog(this, "There isn't any customer", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                }

                if (canUpdate) {
                    ResultSet resultSet1 = MySQL2.executeSearch("SELECT * FROM `customer` WHERE `first_name` = '" + firstName + "' AND `last_name` = '" + lastName + "' AND `email` = '" + email + "'");

                    if (resultSet1.next()) {
                        JOptionPane.showMessageDialog(this, "No changes detected", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                    } else {
                        MySQL2.executeIUD("UPDATE `customer` SET `first_name` = '" + firstName + "' , `last_name`='" + lastName + "' ,`email` = '" + email + "'"
                                + "WHERE `mobile` = '" + mobile + "'");

                        reset();
                        JOptionPane.showMessageDialog(this, "Update successful", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                    }
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String mobile = jTextField1.getText();
        String firstName = jTextField2.getText();
        String lastName = jTextField3.getText();
        String email = jTextField4.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

        if (mobile.isEmpty()) {
            jTextField1.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            jTextField1.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter valid mobile number", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (firstName.isEmpty()) {
            jTextField2.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (!pattern.matcher(firstName).matches()) {
            jTextField2.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for first name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (lastName.isEmpty()) {
            jTextField3.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (!pattern.matcher(lastName).matches()) {
            jTextField3.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for last name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (email.isEmpty()) {
            jTextField4.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            jTextField4.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else {
            try {
                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `customer` WHERE `mobile` = '" + mobile + "' OR `email` = '" + email + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Customer already registerd", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    MySQL2.executeIUD("INSERT INTO `customer`(`mobile`,`first_name`,`last_name`,`email`,`points`)"
                            + "VALUES('" + mobile + "','" + firstName + "','" + lastName + "','" + email + "','0')");

                    reset();
                    JOptionPane.showMessageDialog(this, "Customer registered successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());

                    CustomerMailDialog mail = new CustomerMailDialog(customerReg, true, firstName, lastName, email);
                    mail.setVisible(true);
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();

        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please select a row in the table");
        } else {
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);

            String mobile = String.valueOf(jTable1.getValueAt(row, 0));
            String fname = String.valueOf(jTable1.getValueAt(row, 1));
            String lname = String.valueOf(jTable1.getValueAt(row, 2));
            String email = String.valueOf(jTable1.getValueAt(row, 3));

            jTextField1.setText(mobile);
            jTextField1.setEditable(false);

            jTextField2.setText(fname);
            jTextField3.setText(lname);
            jTextField4.setText(email);

            if (evt.getClickCount() == 2) {

                if (invoice != null) {
                    invoice.getjTextField2().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                    invoice.getjLabel6().setText(String.valueOf(jTable1.getValueAt(row, 1)));
                    invoice.getjTextField4().setText(String.valueOf(jTable1.getValueAt(row, 4)));
                    this.dispose();
                }
            }

            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT COUNT(id) FROM `invoice` WHERE `customer_mobile` = '" + mobile + "'");

                if (resultSet.next()) {
                    jLabel8.setText(resultSet.getString(1));
                } else {
                    jLabel8.setText("0");
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                customerReg = new CustomerRegistration();
                customerReg.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField1.grabFocus();
        jTextField1.setEditable(true);
        jTable1.clearSelection();
        jComboBox1.setSelectedIndex(0);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        loadCustomers("first_name", "ASC", "07");
    }

    private void search() {
        int sort = jComboBox1.getSelectedIndex();

        switch (sort) {
            case 0:
                loadCustomers("first_name", "ASC", jTextField1.getText());
                break;
            case 1:
                loadCustomers("first_name", "DESC", jTextField1.getText());
                break;
            case 2:
                loadCustomers("points", "ASC", jTextField1.getText());
                break;
            case 3:
                loadCustomers("points", "DESC", jTextField1.getText());
                break;
            default:
                break;
        }
    }

    private void reset1() {

        jButton1.setBackground(new Color(30, 144, 255));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton2.setBackground(new Color(255, 0, 51));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton3.setBackground(new Color(255, 255, 51));
        jButton3.setForeground(new Color(0, 0, 0));
    }
}

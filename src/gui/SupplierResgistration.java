package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import static gui.Login.logger;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL2;
import raven.toast.Notifications;
import visuals.JOptionIcon;

/**
 *
 * @author Amiru
 */
public class SupplierResgistration extends javax.swing.JFrame {

    private GRN grn;

    public void setGrn(GRN grn) {
        this.grn = grn;
    }

    private String companyId;

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public SupplierResgistration() {
        initComponents();
        loadSuppliers("first_name", "ASC", "");

        jButton3.setEnabled(false);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);

        jTable1.setDefaultRenderer(Object.class, renderer);

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);
        jButton4.setFocusPainted(false);

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
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
            }
        });

        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new Color(255, 51, 51));
                jButton2.setForeground(new Color(0, 0, 0));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
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
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(255, 51, 51));
                jButton3.setForeground(new Color(0, 0, 0));
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(255, 51, 51));
                jButton4.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        Notifications.getInstance().setJFrame(this);
    }

    public void setCompanyName(String name) {
        jLabel2.setText(name);
    }

    public void mobileGrabFocus() {
        jTextField1.grabFocus();
    }

    private void loadSuppliers(String column, String orderby, String mobile) {
        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `supplier` INNER JOIN `company`"
                    + "ON `supplier`.`company_id` = `company`.`id` WHERE `mobile` LIKE '" + mobile + "%' ORDER BY `" + column + "` " + orderby + "");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("company.name"));

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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supplier Resgistration");
        setLocation(new java.awt.Point(480, 120));
        setUndecorated(true);
        setResizable(false);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Select Company");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COMPANY NAME HERE");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mobile");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(30, 144, 255));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 51));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Update Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3)
                                            .addComponent(jTextField4))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(4, 4, 4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Email", "Company"
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

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Supplier Sort By :");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Names (A - Z)", "Names (Z - A)", "Companies (A - Z)", "Companies (Z - A)" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total GRN :");

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pending Payment :");

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("0");

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CompanyRegistration cr = new CompanyRegistration(this, true);
        cr.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField4.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

        if (this.companyId == null) {
            JOptionPane.showMessageDialog(this, "Please select a company", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!mobile.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid mobile number", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(fname).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for first name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(lname).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for last name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else {
            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `supplier` WHERE `mobile` = '" + mobile + "' OR `email` = '" + email + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "This supplier is already registered", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    MySQL2.executeIUD("INSERT INTO `supplier`(`mobile`,`first_name`,`last_name`,`email`,`company_id`)"
                            + "VALUES ('" + mobile + "','" + fname + "','" + lname + "','" + email + "','" + this.companyId + "')");
                    reset();
                    JOptionPane.showMessageDialog(this, "Supplier added successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField4.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(fname).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for first name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(lname).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for last name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (this.companyId == null) {
            JOptionPane.showMessageDialog(this, "Please select a company", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else {
            try {
                ResultSet resultSet1 = MySQL2.executeSearch("SELECT * FROM `supplier` WHERE `mobile` = '" + mobile + "'");

                if (resultSet1.next()) {
                    String originalFname = resultSet1.getString("first_name");
                    String originalLname = resultSet1.getString("last_name");
                    String originalEmail = resultSet1.getString("email");
                    String originalCompanyId = resultSet1.getString("company_id");

                    boolean isChanged = !fname.equals(originalFname)
                            || !lname.equals(originalLname)
                            || !email.equals(originalEmail)
                            || !this.companyId.equals(originalCompanyId);

                    if (!isChanged) {
                        JOptionPane.showMessageDialog(this, "No changes detected", "No changes", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                    } else {

                        ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `supplier` WHERE `email` = '" + email + "' AND `mobile` != '" + mobile + "'");

                        if (resultSet.next()) {
                            JOptionPane.showMessageDialog(this, "Email is already used by another supplier", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                        } else {

                            String updateQuery = "UPDATE `supplier` SET "
                                    + "`first_name` = '" + fname + "', "
                                    + "`last_name` = '" + lname + "', "
                                    + "`email` = '" + email + "'";

                            if (!this.companyId.equals(originalCompanyId)) {
                                updateQuery += ", `company_id` = '" + this.companyId + "'";
                            }

                            updateQuery += " WHERE `mobile` = '" + mobile + "'";

                            MySQL2.executeIUD(updateQuery);

                            reset();
                            JOptionPane.showMessageDialog(this, "Updated successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Supplier not found", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error occurred during supplier update", e);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Please select a row in the table");
        } else {
            jButton2.setEnabled(false);
            jButton3.setEnabled(true);

            jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 0)));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1)));
            jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 2)));
            jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 3)));
            jLabel2.setText(String.valueOf(jTable1.getValueAt(row, 4)));

            jTextField1.setEnabled(false);
            jButton2.setEnabled(false);

            if (evt.getClickCount() == 2) {
                if (grn != null) {
                    grn.getjTextField2().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                    grn.getjLabel21().setText(String.valueOf(jTable1.getValueAt(row, 1)));
                    this.dispose();
                }
            }

            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `grn` INNER JOIN `grn_item`"
                        + "ON `grn`.`id` = `grn_item`.`grn_id` WHERE `grn`.`supplier_mobile` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'");

                double total = 0;

                HashMap<Long, Double> grns = new HashMap<>();

                while (resultSet.next()) {

                    double qty = resultSet.getDouble("grn_item.qty");

                    double buyingPrice = resultSet.getDouble("grn_item.price");

                    double itemTotal = qty * buyingPrice;

                    //total = total + itemTotal;
                    total += itemTotal;

                    grns.put(resultSet.getLong("grn.id"), resultSet.getDouble("grn.paid_amount"));
                }

                double totalPaid = 0;

                for (Double paid : grns.values()) {

                    //totalPaid+=paid;
                    totalPaid = totalPaid + paid;
                }

                jLabel10.setText(String.valueOf(grns.size()));
                jLabel11.setText(String.format("%.2f", total - totalPaid));

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierResgistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
        jLabel2.setText("Company Name Here");
        companyId = null;
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jLabel10.setText("0");
        jLabel11.setText("0");
        jTextField1.grabFocus();
        jTable1.clearSelection();
        loadSuppliers("first_name", "ASC", jTextField1.getText());
        jTextField1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
    }

    private void search() {

        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                loadSuppliers("first_name", "ASC", jTextField1.getText());
                break;
            case 1:
                loadSuppliers("first_name", "DESC", jTextField1.getText());
                break;
            case 2:
                loadSuppliers("company`.`name", "ASC", jTextField1.getText());
                break;
            case 3:
                loadSuppliers("company`.`name", "DESC", jTextField1.getText());
                break;
            default:
                break;
        }
    }

    private void reset1() {

        jButton2.setBackground(new Color(30, 144, 255));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton3.setBackground(new Color(255, 0, 51));
        jButton3.setForeground(new Color(255, 255, 255));
        jButton4.setBackground(new Color(255, 255, 51));
        jButton4.setForeground(new Color(0, 0, 0));
    }

}

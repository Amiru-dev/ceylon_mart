package gui;

import static gui.Login.logger;
import visuals.JOptionIcon;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL2;
import model.QRCodeGenerator;
import raven.toast.Notifications;

public class EmployeeRegistration extends javax.swing.JFrame {

    private static EmployeeRegistration employeeReg;
    private static final HashMap<String, String> employeeTypeMap = new HashMap<>();
    private static final HashMap<String, String> employeeGenderMap = new HashMap<>();
    private static final HashMap<String, String> employeeStatusMap = new HashMap<>();

    public EmployeeRegistration() {
        initComponents();
        init();
        Notifications.getInstance().setJFrame(this);
    }

    private void loadTypes() {
        try {
            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                employeeTypeMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadGender() {
        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `gender`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                employeeGenderMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadStatus() {
        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee_status`");

            Vector<String> vector = new Vector<>();

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                employeeStatusMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox3.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadEmployees(String column, String orderby, String search) {
        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee` "
                    + "INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.`id` "
                    + "INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` "
                    + "INNER JOIN `employee_status` ON `employee`.`employee_status_id` = `employee_status`.`id` "
                    + "WHERE (`email` LIKE '" + search + "%' OR `nic` LIKE '" + search + "%') "
                    + "ORDER BY `" + column + "` " + orderby);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("password"));
                vector.add(resultSet.getString("gender.name"));
                vector.add(resultSet.getString("employee_type.name"));
                vector.add(resultSet.getString("employee_status.name"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();

        jMenuItem1.setText("Copy email");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Registration  |  Ceylon Mart ");
        setLocation(new java.awt.Point(320, 100));
        setUndecorated(true);
        setResizable(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIC");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mobile");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gender");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Type");

        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jTextField6.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(30, 144, 255));
        jButton1.setFont(new java.awt.Font("JetBrains Mono NL Medium", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("JetBrains Mono NL Medium", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(255, 255, 51));
        jButton3.setFont(new java.awt.Font("JetBrains Mono NL Medium", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Status");

        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Employee Information");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField1)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Password", "Gender", "Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(15);
        }

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Employee Sort By :");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Names (A - Z)", "Names (Z - A)", "NIC (0 - 9)", "NIC (9 - 0)" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String email = jTextField2.getText();
            String firstName = jTextField3.getText();
            String lastName = jTextField4.getText();
            String nic = jTextField5.getText();
            String mobile = jTextField6.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String type = String.valueOf(jComboBox2.getSelectedItem());
            String status = String.valueOf(jComboBox3.getSelectedItem());
            Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
            Pattern pattern1 = Pattern.compile("^[0-9]+V?$");

            if (firstName.isEmpty()) {
                jTextField3.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee first name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern.matcher(firstName).matches()) {
                jTextField3.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for first name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (lastName.isEmpty()) {
                jTextField4.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee last name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern.matcher(lastName).matches()) {
                jTextField4.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for last name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (nic.isEmpty()) {
                jTextField5.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee NIC", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!nic.matches(".{10,}")) {
                jTextField5.grabFocus();
                JOptionPane.showMessageDialog(this, "NIC should have minimum 10 characters", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern1.matcher(nic).matches()) {
                jTextField5.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter valid NIC", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (mobile.isEmpty()) {
                jTextField6.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee mobile", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                jTextField6.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter valid employee mobile", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (password.isEmpty()) {
                jPasswordField1.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee password", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
                jPasswordField1.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter minimum 8 characters", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (gender.equals("Select")) {
                jComboBox1.grabFocus();
                JOptionPane.showMessageDialog(this, "Please select a gender", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (type.equals("Select")) {
                jComboBox2.grabFocus();
                JOptionPane.showMessageDialog(this, "Please select a type", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else {

                ResultSet resultSet1 = MySQL2.executeSearch("SELECT * FROM `employee` WHERE `email` = '" + email + "' AND `password` = '" + password + "' "
                        + "AND `first_name` = '" + firstName + "' AND `last_name` = '" + lastName + "' AND `nic` = '" + nic + "' AND `mobile` = '" + mobile + "' "
                        + "AND `employee_type_id` = '" + employeeTypeMap.get(type) + "' AND `gender_id` = '" + employeeGenderMap.get(gender) + "' AND `employee_status_id` = '" + employeeStatusMap.get(status) + "'");

                if (resultSet1.next()) {
                    JOptionPane.showMessageDialog(this, "No changes detected", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee` WHERE `nic` = '" + nic + "' OR `mobile` = '" + mobile + "'");

                    boolean canUpdate = false;

                    if (resultSet.next()) {
                        if (!resultSet.getString("email").equals(email)) {
                            JOptionPane.showMessageDialog(this, "This mobile number or nic already used", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                        } else {
                            canUpdate = true;
                        }

                    } else {
                        canUpdate = false;
                        JOptionPane.showMessageDialog(this, "There is no such employee", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                    }

                    if (canUpdate) {
                        MySQL2.executeIUD("UPDATE `employee` SET `password` = '" + password + "', "
                                + "`first_name` = '" + firstName + "', `last_name` = '" + lastName + "', "
                                + "`nic` = '" + nic + "', `mobile` = '" + mobile + "', "
                                + "`employee_type_id` = '" + employeeTypeMap.get(type) + "', "
                                + "`gender_id` = '" + employeeGenderMap.get(gender) + "', "
                                + "`employee_status_id` = '" + employeeStatusMap.get(status) + "' "
                                + "WHERE `email` = '" + email + "'");

                        reset();
                        JOptionPane.showMessageDialog(this, "Employee account updated successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                    }
                }
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String email = jTextField2.getText();
            String firstName = jTextField3.getText();
            String lastName = jTextField4.getText();
            String nic = jTextField5.getText();
            String mobile = jTextField6.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String type = String.valueOf(jComboBox2.getSelectedItem());
            String status = String.valueOf(jComboBox3.getSelectedItem());
            Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
            Pattern pattern1 = Pattern.compile("^[0-9]+V?$");

            if (email.isEmpty()) {
                jTextField2.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                    + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                jTextField2.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalid employee email", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (firstName.isEmpty()) {
                jTextField3.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee first name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern.matcher(firstName).matches()) {
                jTextField3.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for first name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (lastName.isEmpty()) {
                jTextField4.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee last name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern.matcher(lastName).matches()) {
                jTextField4.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter only letters and spaces for last name", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (nic.isEmpty()) {
                jTextField5.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee NIC", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!nic.matches(".{10,}")) {
                jTextField5.grabFocus();
                JOptionPane.showMessageDialog(this, "NIC should have minimum 10 characters", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern1.matcher(nic).matches()) {
                jTextField5.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter valid NIC", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (mobile.isEmpty()) {
                jTextField6.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee mobile", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                jTextField6.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter valid employee mobile", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (password.isEmpty()) {
                jPasswordField1.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter employee password", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
                jPasswordField1.grabFocus();
                JOptionPane.showMessageDialog(this, "Please enter minimum 8 characters", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (gender.equals("Select")) {
                jComboBox1.grabFocus();
                JOptionPane.showMessageDialog(this, "Please select a gender", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (type.equals("Select")) {
                jComboBox2.grabFocus();
                JOptionPane.showMessageDialog(this, "Please select a type", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (status.equals("Deactive")) {
                jComboBox3.grabFocus();
                JOptionPane.showMessageDialog(this, "Status should be 'Active'", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee` WHERE `email` = '" + email + "' OR  `nic` = '" + nic + "' OR `mobile`='" + mobile + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "This employee is already registered", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL2.executeIUD("INSERT INTO `employee`(`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`date_registered`,`employee_type_id`,`gender_id`,`employee_status_id`) "
                            + "VALUES('" + email + "','" + password + "','" + firstName + "','" + lastName + "','" + nic + "','" + mobile + "', "
                            + "'" + sdf.format(date) + "','" + employeeTypeMap.get(type) + "','" + employeeGenderMap.get(gender) + "','" + employeeStatusMap.get(status) + "')");

                    reset();
                    JOptionPane.showMessageDialog(this, "Account created successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());

                    QRCodeGenerator qr = new QRCodeGenerator(email);

                    EmployeeMailDialog mail = new EmployeeMailDialog(employeeReg, true, firstName, lastName, email);
                    mail.setVisible(true);
                }
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_CENTER, "Please select a row in table");
        } else {
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);

            String email = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField2.setText(email);
            jTextField2.setEditable(false);

            String firstName = String.valueOf(jTable1.getValueAt(row, 1));
            jTextField3.setText(firstName);

            String lastName = String.valueOf(jTable1.getValueAt(row, 2));
            jTextField4.setText(lastName);

            String nic = String.valueOf(jTable1.getValueAt(row, 3));
            jTextField5.setText(nic);

            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            jTextField6.setText(mobile);

            String password = String.valueOf(jTable1.getValueAt(row, 5));
            jPasswordField1.setText(password);

            String gender = String.valueOf(jTable1.getValueAt(row, 6));
            jComboBox1.setSelectedItem(gender);

            String type = String.valueOf(jTable1.getValueAt(row, 7));
            jComboBox2.setSelectedItem(type);

            String status = String.valueOf(jTable1.getValueAt(row, 8));
            jComboBox3.setSelectedItem(status);

            if (evt.getClickCount() == 2) {
                int row1 = jTable1.getSelectedRow();

                if (row1 == -1) {
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_CENTER, "Please select a row");
                } else {
                    String email1 = String.valueOf(jTable1.getValueAt(row1, 0));

                    AddressView addressView = new AddressView(this, true, email1);
                    addressView.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        search();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3 && jTable1.getSelectedRow() != -1) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = jTable1.getSelectedRow();

        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_CENTER, "Please select a row in the table");
        } else {

            String text = String.valueOf(jTable1.getValueAt(row, 0));

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Copied");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                employeeReg = new EmployeeRegistration();
                employeeReg.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jTable1.clearSelection();
        jTextField2.setEditable(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        loadEmployees("first_name", "ASC", "");
    }

    private void reset1() {
        jButton1.setBackground(new Color(30, 144, 255));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton2.setBackground(new Color(255, 0, 51));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton3.setBackground(new Color(255, 255, 51));
        jButton3.setForeground(new Color(0, 0, 0));
    }

    private void init() {

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);

        jTable1.setDefaultRenderer(Object.class, renderer);

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

        loadTypes();
        loadGender();
        loadStatus();
        loadEmployees("first_name", "ASC", "");

        jTextField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter email");
        jTextField3.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter first name");
        jTextField4.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter last name");
        jTextField5.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter nic");
        jTextField6.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter mobile");
        jTextField7.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search email or nic");
        jPasswordField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter password");

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);

        jButton2.setEnabled(false);
    }

    private void search() {
        int sort = jComboBox4.getSelectedIndex();

        switch (sort) {
            case 0:
                loadEmployees("first_name", "ASC", jTextField7.getText());
                break;
            case 1:
                loadEmployees("first_name", "DESC", jTextField7.getText());
                break;
            case 2:
                loadEmployees("nic", "ASC", jTextField7.getText());
                break;
            case 3:
                loadEmployees("nic", "DESC", jTextField7.getText());
                break;
            default:
                break;
        }
    }
}

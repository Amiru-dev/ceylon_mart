package gui;

import visuals.JOptionIcon;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import static gui.Login.logger;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL2;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import raven.toast.Notifications;

public class EmployeeAttendance extends javax.swing.JFrame {

    private final String formattedDate;

    public EmployeeAttendance() {
        initComponents();
        formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        init();
        Notifications.getInstance().setJFrame(this);
    }

    private void loadEmployees(String column, String orderby, String search) {

        int sort = jComboBox5.getSelectedIndex();
        String type = null;

        switch (sort) {
            case 0:
                type = "Daily";
                break;
            case 1:
                type = "Monthly";
                break;
            case 2:
                type = "Annual";
                break;
            default:
                break;
        }

        try {

            String query = "SELECT * FROM `employee_attendance` "
                    + "INNER JOIN `employee` ON `employee_attendance`.`employee_email` = `employee`.`email` "
                    + "WHERE (`email` LIKE '" + search + "%' OR `nic` LIKE '" + search + "%') AND ";

            switch (type) {
                case "Daily":
                    query += "DATE(date) = CURDATE()";
                    break;
                case "Monthly":
                    query += "MONTH(date) = MONTH(CURDATE()) "
                            + "AND YEAR(date) = YEAR(CURDATE())";
                    break;
                case "Annual":
                    query += "YEAR(date) = YEAR(CURDATE())";
                    break;
                default:
                    break;
            }
            query += " ORDER BY `" + column + "` " + orderby;

            ResultSet resultSet = MySQL2.executeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("checkin"));
                vector.add(resultSet.getString("checkout"));
                vector.add(resultSet.getString("employee_email"));
                vector.add(resultSet.getString("nic"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Registration  |  Ceylon Mart ");
        setLocation(new java.awt.Point(480, 200));
        setUndecorated(true);
        setResizable(false);

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date", "Checkin Time", "Checkout Time", "Employee Email", "NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
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

        jButton1.setBackground(new java.awt.Color(30, 144, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Print");
        jButton1.setToolTipText("Left click to print, Right click to view");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Report Type :");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Monthly", "Annual" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/reset34.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/paste.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        search();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {

            try {
                int rowCount = jTable1.getRowCount();
                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(this, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    int sort = jComboBox5.getSelectedIndex();

                    switch (sort) {
                        case 0: {
                            InputStream s = this.getClass().getResourceAsStream("/reports/dailyAttendance.jasper");
                            HashMap<String, Object> params = new HashMap<>();
                            params.put("Parameter1", dateTime);
                            params.put("Parameter3", String.valueOf(rowCount));
                            params.put("Parameter4", formattedDate);
                            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);
                            JasperPrintManager.printReport(jasperPrint, false);
                            break;
                        }
                        case 1: {
                            InputStream s = this.getClass().getResourceAsStream("/reports/monthlyAttendance.jasper");
                            HashMap<String, Object> params = new HashMap<>();
                            params.put("Parameter1", dateTime);
                            params.put("Parameter3", String.valueOf(rowCount));
                            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);
                            JasperPrintManager.printReport(jasperPrint, false);
                            break;
                        }
                        case 2: {
                            InputStream s = this.getClass().getResourceAsStream("/reports/annualAttendance.jasper");
                            HashMap<String, Object> params = new HashMap<>();
                            params.put("Parameter1", dateTime);
                            params.put("Parameter3", String.valueOf(rowCount));
                            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);
                            JasperPrintManager.printReport(jasperPrint, false);
                            break;
                        }
                        default:
                            break;
                    }

                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                int rowCount = jTable1.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(this, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    int sort = jComboBox5.getSelectedIndex();

                    switch (sort) {
                        case 0: {
                            InputStream s = this.getClass().getResourceAsStream("/reports/dailyAttendance.jasper");
                            HashMap<String, Object> params = new HashMap<>();
                            params.put("Parameter1", dateTime);
                            params.put("Parameter3", String.valueOf(rowCount));
                            params.put("Parameter4", formattedDate);
                            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);
                            JasperViewer.viewReport(jasperPrint, false);
                            break;
                        }
                        case 1: {
                            InputStream s = this.getClass().getResourceAsStream("/reports/monthlyAttendance.jasper");
                            HashMap<String, Object> params = new HashMap<>();
                            params.put("Parameter1", dateTime);
                            params.put("Parameter3", String.valueOf(rowCount));
                            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);
                            JasperViewer.viewReport(jasperPrint, false);
                            break;
                        }
                        case 2: {
                            InputStream s = this.getClass().getResourceAsStream("/reports/annualAttendance.jasper");
                            HashMap<String, Object> params = new HashMap<>();
                            params.put("Parameter1", dateTime);
                            params.put("Parameter3", String.valueOf(rowCount));
                            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);
                            JasperViewer.viewReport(jasperPrint, false);
                            break;
                        }
                        default:
                            break;
                    }

                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton1MouseReleased

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String pastedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            jTextField7.setText(pastedText);

            if (!jTextField7.getText().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Pasted");
                search();
            }
        } catch (Exception e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_CENTER, "Failed to paste");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

    private void init() {

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);

        jTable1.setDefaultRenderer(Object.class, renderer);

        loadEmployees("first_name", "ASC", "");

        jTextField7.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search email or NIC");
        jButton1.setFocusPainted(false);

        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);

        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
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

    private void reset() {
        jTextField7.setText("");
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jTable1.clearSelection();
    }
}

package gui;

import static gui.Login.logger;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import visuals.JOptionIcon;
import javaswingdev.chart.ModelPieChart;
import raven.chart.ModelChart;
import charts.CurveLineChart;
import charts.PieChart;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;

/**
 *
 * @author ASUS
 */
public class AdminDashboard extends javax.swing.JFrame {

    private String one = "Meeting scheduled at 4.00 p.m.";
    private String two;
    private String three;

    private PieChart pieChart1;
    private PieChart pieChart2;
    private PieChart pieChart3;
    private CurveLineChart chart1;
    private CurveLineChart chart2;

    private EmployeeRegistration employeeReg;
    private SupplierResgistration supplierReg;
    private LoyaltyCard loyalty;
    private EmployeeAttendance employeeAttend;
    private Backup_Restore backup;

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        init();
    }

    AdminDashboard(Home home) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void loadEmployees() {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT COUNT(*) AS total_employees FROM `employee`");

            if (resultSet.next()) {
                String count = resultSet.getString("total_employees");
                int count1 = Integer.parseInt(count);
                jProgressBar1.setValue(count1 * 10);
                jLabel20.setText(count);
                jLabel6.setText(count1 * 10 + "%");
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadSuppliers() {
        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT COUNT(*) AS total_suppliers FROM `supplier`");

            if (resultSet.next()) {
                String count = resultSet.getString("total_suppliers");
                int count1 = Integer.parseInt(count);
                jProgressBar4.setValue(count1 * 5);
                jLabel21.setText(count);
                jLabel9.setText(count1 * 5 + "%");
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadExpense() {
        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT SUM(paid_amount) AS paid_amount FROM `grn`");

            if (resultSet.next()) {
                String paid = resultSet.getString("paid_amount");
                if (paid == null) {
                    jLabel17.setText("0.00");
                } else {
                    jLabel17.setText(String.format("%.2f", Double.parseDouble(paid)));
                }
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadIncome() {

        double before = LoyaltyCard.getBefore();

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT SUM(paid_amount) AS paid_amount FROM `invoice`");
            ResultSet resultSet1 = MySQL2.executeSearch("SELECT COUNT(*) AS total_customers FROM `customer`");

            if (resultSet.next()) {
                String paid = resultSet.getString("paid_amount");

                if (paid == null) {
                    if (resultSet1.next()) {
                        String count = resultSet1.getString("total_customers");
                        double total = Double.parseDouble(count) * 300;
                        jLabel16.setText(String.format("%.2f", total));
                    } else {
                        jLabel16.setText("0.00");
                    }

                } else {
                    if (resultSet1.next()) {
                        String count = resultSet1.getString("total_customers");
                        double total = Double.parseDouble(count) * before;
                        jLabel16.setText(String.format("%.2f", total + Double.parseDouble(paid)));

                    } else {
                        jLabel16.setText(String.format("%.2f", Double.parseDouble(paid)));
                    }
                }
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void reset() {
        jTextField1.setBackground(Color.WHITE);
        jTextField1.setForeground(Color.BLACK);
        jTextField2.setBackground(Color.WHITE);
        jTextField2.setForeground(Color.BLACK);
        jTextField3.setBackground(Color.WHITE);
        jTextField3.setForeground(Color.BLACK);
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel19 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton16 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1570, 790));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("JetBrains Mono NL", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Admin");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/emp white.png"))); // NOI18N
        jButton1.setText("  Employee Management");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/emp black.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/sup white.png"))); // NOI18N
        jButton2.setText("     Supplier Management");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/sup black.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/loyal white.png"))); // NOI18N
        jButton3.setText("     Loyality Card Amount");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/loyal black.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 153, 153));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/reports white.png"))); // NOI18N
        jButton9.setText("    Reports");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/reports black.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/analytics white.png"))); // NOI18N
        jButton10.setText("  Analytics");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/analytics black.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(51, 51, 51));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/attendance white.png"))); // NOI18N
        jButton19.setText("  Attendance");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/attendance black.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 10, 300, 780));

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 0, 2, 790));

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dashboard");

        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 5));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 240));

        jProgressBar1.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employees");
        jLabel2.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("2");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("25%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 240));

        jProgressBar2.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar2.setForeground(new java.awt.Color(255, 255, 255));
        jProgressBar2.setValue(45);
        jProgressBar2.setString("35%");

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Income");
        jLabel3.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setOpaque(true);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("1500");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("LKR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("45%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(java.awt.Color.darkGray);
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 5));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 240));

        jProgressBar3.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar3.setForeground(new java.awt.Color(255, 255, 255));
        jProgressBar3.setValue(30);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Expense");
        jLabel4.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setOpaque(true);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("1500");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("LKR");

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("30%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16))
        );

        jPanel5.setBackground(java.awt.Color.darkGray);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
        jPanel5.setPreferredSize(new java.awt.Dimension(240, 240));

        jProgressBar4.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar4.setForeground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Suppliers");
        jLabel5.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setOpaque(true);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("2");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("35%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));

        jLabel22.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Tag your main tasks");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField3))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2))
                .addGap(23, 23, 23)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Save");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton6)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(168, 168, 168))
        );

        jTabbedPane1.addTab("tab1", jPanel17);

        jLabel29.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Employee Management");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 599, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel20);

        jPanel21.setMaximumSize(new java.awt.Dimension(1331, 917));
        jPanel21.setMinimumSize(new java.awt.Dimension(1331, 917));
        jPanel21.setPreferredSize(new java.awt.Dimension(1331, 917));

        jLabel30.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Supplier Management");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 598, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel21);

        jLabel33.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Loyalty Card Amount");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(599, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel22);

        jLabel35.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Reports");

        jPanel24.setBackground(new java.awt.Color(0, 0, 0));
        jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel24MouseClicked(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Customers");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));
        jPanel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel25MouseClicked(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Stock");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel26.setBackground(new java.awt.Color(0, 0, 0));
        jPanel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel26MouseClicked(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Suppliers");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel27.setBackground(new java.awt.Color(0, 0, 0));
        jPanel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Daily GRNs");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(898, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel35)
                .addGap(74, 74, 74)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel23);

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jPanel28.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 790, 350));

        jLabel37.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Customers of Ceylon Mart");
        jPanel28.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 440, 30));

        jLabel38.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Customer Sort By :");
        jPanel28.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, 30));

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Names in Ascending order", "Names in Descending order", "Points in Ascending order", "Points in Descending order" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel28.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, 30));

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Back");
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel28.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 640, 120, 40));

        jButton18.setBackground(new java.awt.Color(0, 0, 255));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Print");
        jButton18.setToolTipText("Left click to print, Right click to view");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton18MouseReleased(evt);
            }
        });
        jPanel28.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, 100, 40));
        jPanel28.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1170, 720));

        jTabbedPane1.addTab("tab6", jPanel28);

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel29.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 740, 310));

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Names in Ascending order", "Names in Descending order", "Companies in Ascending order", "Companies in Descending order" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jPanel29.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, 30));

        jLabel39.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Supplier Sort By :");
        jPanel29.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, 30));

        jLabel40.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("0");
        jPanel29.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 60, 20));

        jLabel41.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("0");
        jPanel29.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 70, -1));

        jLabel42.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Total GRN :");
        jPanel29.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, -1, -1));

        jLabel43.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Pending Payment :");
        jPanel29.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, -1, -1));

        jLabel44.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Suppliers of Ceylon Mart");
        jPanel29.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 410, 30));

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Back");
        jButton12.setOpaque(true);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 750, 100, 40));

        jButton17.setBackground(new java.awt.Color(30, 144, 255));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Print");
        jButton17.setToolTipText("Left click to print, Right click to view");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton17MouseReleased(evt);
            }
        });
        jPanel29.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 750, 100, 40));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jPanel29.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 1160, 720));

        jTabbedPane1.addTab("tab7", jPanel29);

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Stock of Ceylon Mart");
        jPanel30.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 390, 50));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Product Id", "Brand", "Name", "Selling Price", "Quantity", "MFD", "EXP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        jPanel30.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 1010, 360));

        jButton13.setBackground(new java.awt.Color(51, 51, 51));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Back");
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel30.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 690, 130, 40));

        jLabel47.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Sort By :");
        jPanel30.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, 30));

        jComboBox3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock IDs in Ascending order", "Stock IDs in Descending order", "Product IDs in Ascending order", "Product IDs in Descending order", "Brands in Ascending order", "Brands in Descending order", "Names in Ascending order", "Names in Descending order", "Selling Prices in Ascending order", "Selling Prices in Descending order", "Quantity in Ascending order", "Quantity in Descending order" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jPanel30.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, 30));

        jButton16.setBackground(new java.awt.Color(30, 144, 255));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Print");
        jButton16.setToolTipText("Left click to print, Right click to view");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton16MouseReleased(evt);
            }
        });
        jPanel30.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 690, 120, 40));

        jLabel48.setBackground(new java.awt.Color(30, 144, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jPanel30.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(-85, 90, 1250, 720));

        jTabbedPane1.addTab("tab8", jPanel30);

        jLabel57.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Daily GRNs of Ceylon Mart");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Paid Amount", "Supplier Name", "Supplier Mobile", "Employee Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("da");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Today  :");

        jButton14.setBackground(new java.awt.Color(51, 51, 51));
        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Back");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(30, 144, 255));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Print");
        jButton15.setToolTipText("Left click to print, Right click to view");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton15MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(706, 706, 706))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(686, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", jPanel31);

        jLabel62.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 0));
        jLabel62.setText("Ceylon Mart Analytics");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Sales by Brand Names");

        jPanel40.setPreferredSize(new java.awt.Dimension(316, 282));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Top Customers");

        jPanel41.setPreferredSize(new java.awt.Dimension(308, 279));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Supplier Performance");

        jPanel42.setPreferredSize(new java.awt.Dimension(312, 276));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel39.setMinimumSize(new java.awt.Dimension(1100, 320));
        jPanel39.setPreferredSize(new java.awt.Dimension(1100, 320));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel32Layout.createSequentialGroup()
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(598, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        jTabbedPane1.addTab("tab10", jPanel32);

        jLabel61.setFont(new java.awt.Font("JetBrains Mono NL", 1, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Employee Attendance");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 598, Short.MAX_VALUE))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel61)
                .addGap(18, 18, 18)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab11", jPanel33);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1764, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab12", jPanel34);

        jPanel19.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, -47, -1, 950));

        getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 1250, 800));

        jMenu1.setText("File");

        jMenuItem1.setText("Backup | Restore");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        one = jTextField1.getText();
        two = jTextField2.getText();
        three = jTextField3.getText();
        JOptionPane.showMessageDialog(this, "Tasks saved successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(1);
        employeeReg = new EmployeeRegistration();
        employeeReg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(2);
        supplierReg = new SupplierResgistration();
        supplierReg.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(3);
        loyalty = new LoyaltyCard();
        loyalty.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jPanel24MouseClicked

    private void jPanel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseClicked
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jPanel26MouseClicked

    private void jPanel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseClicked
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jPanel25MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int row = jTable2.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());
        } else {

            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `grn` INNER JOIN `grn_item`"
                        + "ON `grn`.`id` = `grn_item`.`grn_id` WHERE `grn`.`supplier_mobile` = '" + String.valueOf(jTable2.getValueAt(row, 0)) + "'");

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

                jLabel40.setText(String.valueOf(grns.size()));
                jLabel41.setText(String.valueOf(total - totalPaid));

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        search1();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        loadStock();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {

            try {
                int rowCount = jTable4.getRowCount();
                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    InputStream s = this.getClass().getResourceAsStream("/reports/grn.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", jLabel58.getText());

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable4.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperPrintManager.printReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                int rowCount = jTable4.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    InputStream s = this.getClass().getResourceAsStream("/reports/grn.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", jLabel58.getText());

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable4.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperViewer.viewReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton15MouseReleased

    private void jButton18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {

            try {
                int rowCount = jTable1.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    InputStream s = this.getClass().getResourceAsStream("/reports/customer.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", "");

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperPrintManager.printReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                int rowCount = jTable1.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    InputStream s = this.getClass().getResourceAsStream("/reports/customer.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", "");

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperViewer.viewReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton18MouseReleased

    private void jButton17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {

            try {
                int rowCount = jTable2.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    InputStream s = this.getClass().getResourceAsStream("/reports/supplier.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", "");

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable2.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperPrintManager.printReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                int rowCount = jTable2.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    InputStream s = this.getClass().getResourceAsStream("/reports/supplier.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", "");

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable2.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperViewer.viewReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton17MouseReleased

    private void jButton16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {

            try {
                int rowCount = jTable3.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    InputStream s = this.getClass().getResourceAsStream("/reports/stock.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", "");

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable3.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperPrintManager.printReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                int rowCount = jTable3.getRowCount();

                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "The table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {

                    InputStream s = this.getClass().getResourceAsStream("/reports/stock.jasper");

                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", "");

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable3.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperViewer.viewReport(jasperPrint, false);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
    }//GEN-LAST:event_jButton16MouseReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(10);
        employeeAttend = new EmployeeAttendance();
        employeeAttend.setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        closeUI();
        jTabbedPane1.setSelectedIndex(11);
        backup = new Backup_Restore();
        backup.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        closeUI();
        this.dispose();
        FlatMacLightLaf.setup();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdminDashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void loadCustomers(String column, String orderby) {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `customer` ORDER BY `" + column + "` " + orderby + "");

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

    private void loadSuppliers(String column, String orderby) {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `supplier` INNER JOIN `company`"
                    + "ON `supplier`.`company_id` = `company`.`id` ORDER BY `" + column + "` " + orderby + "");

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
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

    private void loadStock() {

        try {

            String query = "SELECT * FROM `stock` INNER JOIN `product`"
                    + "ON `stock`.`product_id` = `product`.`id` "
                    + "INNER JOIN `brand` ON `brand`.`id` = `product`.`brand_id` ";

            String sort = String.valueOf(jComboBox3.getSelectedItem());
            query += "ORDER BY ";

            switch (sort) {
                case "Stock IDs in Ascending order":
                    query += "`stock`.`id` ASC";
                    break;
                case "Stock IDs in Descending order":
                    query += "`stock`.`id` DESC";
                    break;
                case "Product IDs in Ascending order":
                    query += "`product`.`id` ASC";
                    break;
                case "Product IDs in Descending order":
                    query += "`product`.`id` DESC";
                    break;
                case "Brands in Ascending order":
                    query += "`brand`.`id` ASC";
                    break;
                case "Brands in Descending order":
                    query += "`brand`.`id` DESC";
                    break;
                case "Names in Ascending order":
                    query += "`brand`.`name` ASC";
                    break;
                case "Names in Descending order":
                    query += "`brand`.`name` DESC";
                    break;
                case "Selling Prices in Ascending order":
                    query += "`stock`.`price` ASC";
                    break;
                case "Selling Prices in Descending order":
                    query += "`stock`.`price` DESC";
                    break;
                case "Quantity in Ascending order":
                    query += "`stock`.`qty` ASC";
                    break;
                case "Quantity in Descending order":
                    query += "`stock`.`qty` DESC";
                    break;
                default:
                    break;
            }

            ResultSet resultSet = MySQL2.executeSearch(query);

            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("stock.id"));
                vector.add(resultSet.getString("product.id"));
                vector.add(resultSet.getString("brand.name"));
                vector.add(resultSet.getString("product.name"));
                vector.add(resultSet.getString("stock.price"));
                vector.add(resultSet.getString("qty"));
                vector.add(resultSet.getString("mfd"));
                vector.add(resultSet.getString("exp"));
                model.addRow(vector);
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }

    }

    private void search() {
        int sort = jComboBox1.getSelectedIndex();

        switch (sort) {
            case 0:
                loadCustomers("first_name", "ASC");
                break;
            case 1:
                loadCustomers("first_name", "DESC");
                break;
            case 2:
                loadCustomers("points", "ASC");
                break;
            case 3:
                loadCustomers("points", "DESC");
                break;
            default:
                break;
        }
    }

    private void search1() {

        switch (jComboBox2.getSelectedIndex()) {
            case 0:
                loadSuppliers("first_name", "ASC");
                break;
            case 1:
                loadSuppliers("first_name", "DESC");
                break;
            case 2:
                loadSuppliers("company`.`name", "ASC");
                break;
            case 3:
                loadSuppliers("company`.`name", "DESC");
                break;
            default:
                break;
        }
    }

    private void loadGrn() {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        jLabel58.setText(formattedDate);

        try {

            String query = "SELECT * FROM `grn` INNER JOIN `supplier` "
                    + "ON `grn`.`supplier_mobile` = `supplier`.`mobile` "
                    + "WHERE `grn`.`date` = '" + formattedDate + "'";

            ResultSet resultSet = MySQL2.executeSearch(query);

            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("paid_amount"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("supplier.mobile"));
                vector.add(resultSet.getString("employee_email"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void init() {
        jPanel10.setLayout(new BoxLayout(jPanel10, BoxLayout.X_AXIS));
        loadCustomers("first_name", "ASC");
        loadSuppliers("first_name", "ASC");
        loadStock();
        loadGrn();
        // load charts
        loadPieChart1();
        loadPieChart2();
        loadPieChart3();
        loadLineChart1();
        loadLineChart2();

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);

        jTable1.setDefaultRenderer(Object.class, renderer);
        jTable2.setDefaultRenderer(Object.class, renderer);
        jTable3.setDefaultRenderer(Object.class, renderer);
        jTable4.setDefaultRenderer(Object.class, renderer);

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);
        jButton6.setFocusPainted(false);
        jButton7.setFocusPainted(false);
        jButton9.setFocusPainted(false);
        jButton10.setFocusPainted(false);
        jButton19.setFocusPainted(false);

        try {
            InputStream imgStream = getClass().getResourceAsStream("/resourses/3.png");
            ImageIcon originalIcon = new ImageIcon(ImageIO.read(imgStream));
            Image scaledImage = originalIcon.getImage().getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
            jLabel10.setIcon(new ImageIcon(scaledImage));

            InputStream imgStream1 = getClass().getResourceAsStream("/resourses/4.png");
            ImageIcon originalIcon1 = new ImageIcon(ImageIO.read(imgStream1));
            Image scaledImage1 = originalIcon1.getImage().getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), Image.SCALE_SMOOTH);
            jLabel12.setIcon(new ImageIcon(scaledImage1));

            InputStream imgStream2 = getClass().getResourceAsStream("/resourses/5.png");
            ImageIcon originalIcon2 = new ImageIcon(ImageIO.read(imgStream2));
            Image scaledImage2 = originalIcon2.getImage().getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_SMOOTH);
            jLabel13.setIcon(new ImageIcon(scaledImage2));

            InputStream imgStream3 = getClass().getResourceAsStream("/resourses/6.png");
            ImageIcon originalIcon3 = new ImageIcon(ImageIO.read(imgStream3));
            Image scaledImage3 = originalIcon3.getImage().getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
            jLabel14.setIcon(new ImageIcon(scaledImage3));

            InputStream imgStream4 = getClass().getResourceAsStream("/resourses/7.png");
            ImageIcon originalIcon4 = new ImageIcon(ImageIO.read(imgStream4));
            Image scaledImage4 = originalIcon4.getImage().getScaledInstance(jLabel15.getWidth(), jLabel15.getHeight(), Image.SCALE_SMOOTH);
            jLabel15.setIcon(new ImageIcon(scaledImage4));

            InputStream imgStream8 = getClass().getResourceAsStream("/resourses/9.png");
            ImageIcon originalIcon8 = new ImageIcon(ImageIO.read(imgStream8));
            Image scaledImage8 = originalIcon8.getImage().getScaledInstance(jLabel24.getWidth(), jLabel24.getHeight(), Image.SCALE_SMOOTH);
            jLabel24.setIcon(new ImageIcon(scaledImage8));

            Image scaledImage9 = originalIcon8.getImage().getScaledInstance(jLabel25.getWidth(), jLabel25.getHeight(), Image.SCALE_SMOOTH);
            jLabel25.setIcon(new ImageIcon(scaledImage9));

            Image scaledImage10 = originalIcon8.getImage().getScaledInstance(jLabel26.getWidth(), jLabel26.getHeight(), Image.SCALE_SMOOTH);
            jLabel26.setIcon(new ImageIcon(scaledImage10));

            InputStream imgStream11 = getClass().getResourceAsStream("/resourses/1.jpg");
            ImageIcon originalIcon11 = new ImageIcon(ImageIO.read(imgStream11));
            Image scaledImage11 = originalIcon11.getImage().getScaledInstance(jLabel27.getWidth(), jLabel27.getHeight(), Image.SCALE_SMOOTH);
            jLabel27.setIcon(new ImageIcon(scaledImage11));

            InputStream imgStream12 = getClass().getResourceAsStream("/resourses/12.png");
            ImageIcon originalIcon12 = new ImageIcon(ImageIO.read(imgStream12));
            Image scaledImage12 = originalIcon12.getImage().getScaledInstance(jLabel31.getWidth(), jLabel31.getHeight(), Image.SCALE_SMOOTH);
            jLabel31.setIcon(new ImageIcon(scaledImage12));

            InputStream imgStream13 = getClass().getResourceAsStream("/resourses/13.png");
            ImageIcon originalIcon13 = new ImageIcon(ImageIO.read(imgStream13));
            Image scaledImage13 = originalIcon13.getImage().getScaledInstance(jLabel32.getWidth(), jLabel32.getHeight(), Image.SCALE_SMOOTH);
            jLabel32.setIcon(new ImageIcon(scaledImage13));

            InputStream imgStream17 = getClass().getResourceAsStream("/resourses/15.png");
            ImageIcon originalIcon17 = new ImageIcon(ImageIO.read(imgStream17));
            Image scaledImage17 = originalIcon17.getImage().getScaledInstance(jLabel34.getWidth(), jLabel34.getHeight(), Image.SCALE_SMOOTH);
            jLabel34.setIcon(new ImageIcon(scaledImage17));

            InputStream imgStream18 = getClass().getResourceAsStream("/resourses/16.png");
            ImageIcon originalIcon18 = new ImageIcon(ImageIO.read(imgStream18));
            Image scaledImage18 = originalIcon18.getImage().getScaledInstance(jLabel36.getWidth(), jLabel36.getHeight(), Image.SCALE_SMOOTH);
            jLabel36.setIcon(new ImageIcon(scaledImage18));

            InputStream imgStream19 = getClass().getResourceAsStream("/resourses/17.png");
            ImageIcon originalIcon19 = new ImageIcon(ImageIO.read(imgStream19));
            Image scaledImage19 = originalIcon19.getImage().getScaledInstance(jLabel45.getWidth(), jLabel45.getHeight(), Image.SCALE_SMOOTH);
            jLabel45.setIcon(new ImageIcon(scaledImage19));

            InputStream imgStream20 = getClass().getResourceAsStream("/resourses/14.png");
            ImageIcon originalIcon20 = new ImageIcon(ImageIO.read(imgStream20));
            Image scaledImage20 = originalIcon20.getImage().getScaledInstance(jLabel48.getWidth(), jLabel48.getHeight(), Image.SCALE_SMOOTH);
            jLabel48.setIcon(new ImageIcon(scaledImage20));

            InputStream imgStream21 = getClass().getResourceAsStream("/resourses/20.png");
            ImageIcon originalIcon21 = new ImageIcon(ImageIO.read(imgStream21));
            Image scaledImage21 = originalIcon21.getImage().getScaledInstance(jLabel52.getWidth(), jLabel52.getHeight(), Image.SCALE_SMOOTH);
            jLabel52.setIcon(new ImageIcon(scaledImage21));

            Image scaledImage22 = originalIcon4.getImage().getScaledInstance(jLabel53.getWidth(), jLabel53.getHeight(), Image.SCALE_SMOOTH);
            jLabel53.setIcon(new ImageIcon(scaledImage22));

            InputStream imgStream23 = getClass().getResourceAsStream("/resourses/22.png");
            ImageIcon originalIcon23 = new ImageIcon(ImageIO.read(imgStream23));
            Image scaledImage23 = originalIcon23.getImage().getScaledInstance(jLabel54.getWidth(), jLabel54.getHeight(), Image.SCALE_SMOOTH);
            jLabel54.setIcon(new ImageIcon(scaledImage23));

            InputStream imgStream24 = getClass().getResourceAsStream("/resourses/23.png");
            ImageIcon originalIcon24 = new ImageIcon(ImageIO.read(imgStream24));
            Image scaledImage24 = originalIcon24.getImage().getScaledInstance(jLabel56.getWidth(), jLabel56.getHeight(), Image.SCALE_SMOOTH);
            jLabel56.setIcon(new ImageIcon(scaledImage24));

            InputStream imgStream15 = getClass().getResourceAsStream("/resourses/19.png");
            ImageIcon originalIcon15 = new ImageIcon(ImageIO.read(imgStream15));
            Image scaledImage15 = originalIcon15.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            jButton7.setIcon(new ImageIcon(scaledImage15));

            InputStream imgStream25 = getClass().getResourceAsStream("/resourses/new.png");
            ImageIcon originalIcon25 = new ImageIcon(ImageIO.read(imgStream25));
            this.setIconImage(originalIcon25.getImage());

        } catch (IOException e) {
            logger.log(Level.WARNING, "Couldn't load images", e);
        }

        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6.setBackground(new Color(255, 51, 0));
                jLabel12.setBackground(new Color(255, 51, 0));
                jLabel2.setBackground(new Color(255, 51, 0));
                jLabel2.setForeground(new Color(0, 0, 0));
                jLabel20.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6.setBackground(new Color(0, 0, 0));
                jLabel12.setBackground(new Color(0, 0, 0));
                jLabel2.setBackground(new Color(0, 0, 0));
                jLabel2.setForeground(new Color(255, 255, 255));
                jLabel20.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7.setBackground(new Color(255, 51, 0));
                jLabel13.setBackground(new Color(255, 51, 0));
                jLabel3.setBackground(new Color(255, 51, 0));
                jLabel3.setForeground(new Color(0, 0, 0));
                jLabel16.setForeground(new Color(0, 0, 0));
                jLabel18.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7.setBackground(new Color(0, 0, 0));
                jLabel13.setBackground(new Color(0, 0, 0));
                jLabel3.setBackground(new Color(0, 0, 0));
                jLabel3.setForeground(new Color(255, 255, 255));
                jLabel16.setForeground(new Color(255, 255, 255));
                jLabel18.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8.setBackground(new Color(255, 51, 0));
                jLabel14.setBackground(new Color(255, 51, 0));
                jLabel4.setBackground(new Color(255, 51, 0));
                jLabel4.setForeground(new Color(0, 0, 0));
                jLabel17.setForeground(new Color(0, 0, 0));
                jLabel19.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8.setBackground(new Color(0, 0, 0));
                jLabel14.setBackground(new Color(0, 0, 0));
                jLabel4.setBackground(new Color(0, 0, 0));
                jLabel4.setForeground(new Color(255, 255, 255));
                jLabel17.setForeground(new Color(255, 255, 255));
                jLabel19.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9.setBackground(new Color(255, 51, 0));
                jLabel15.setBackground(new Color(255, 51, 0));
                jLabel5.setBackground(new Color(255, 51, 0));
                jLabel5.setForeground(new Color(0, 0, 0));
                jLabel21.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9.setBackground(new Color(0, 0, 0));
                jLabel15.setBackground(new Color(0, 0, 0));
                jLabel5.setBackground(new Color(0, 0, 0));
                jLabel5.setForeground(new Color(255, 255, 255));
                jLabel21.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel24.setBackground(new Color(255, 51, 0));
                jLabel49.setBackground(new Color(255, 51, 0));
                jLabel52.setBackground(new Color(255, 51, 0));
                jLabel49.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel24.setBackground(new Color(0, 0, 0));
                jLabel49.setBackground(new Color(0, 0, 0));
                jLabel52.setBackground(new Color(0, 0, 0));
                jLabel49.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel26.setBackground(new Color(255, 51, 0));
                jLabel53.setBackground(new Color(255, 51, 0));
                jLabel50.setBackground(new Color(255, 51, 0));
                jLabel50.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel26.setBackground(new Color(0, 0, 0));
                jLabel53.setBackground(new Color(0, 0, 0));
                jLabel50.setBackground(new Color(0, 0, 0));
                jLabel50.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel25.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel25.setBackground(new Color(255, 51, 0));
                jLabel54.setBackground(new Color(255, 51, 0));
                jLabel51.setBackground(new Color(255, 51, 0));
                jLabel51.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel25.setBackground(new Color(0, 0, 0));
                jLabel54.setBackground(new Color(0, 0, 0));
                jLabel51.setBackground(new Color(0, 0, 0));
                jLabel51.setForeground(new Color(255, 255, 255));
            }
        });

        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel27.setBackground(new Color(255, 51, 0));
                jLabel56.setBackground(new Color(255, 51, 0));
                jLabel55.setBackground(new Color(255, 51, 0));
                jLabel55.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel27.setBackground(new Color(0, 0, 0));
                jLabel56.setBackground(new Color(0, 0, 0));
                jLabel55.setBackground(new Color(0, 0, 0));
                jLabel55.setForeground(new Color(255, 255, 255));
            }
        });

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(255, 51, 0));
                jButton1.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
            }
        });

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new Color(255, 51, 0));
                jButton2.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
            }
        });

        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3.setBackground(new Color(255, 51, 0));
                jButton3.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
            }
        });

        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9.setBackground(new Color(255, 51, 0));
                jButton9.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9.setBackground(new Color(51, 51, 51));
                jButton9.setForeground(new Color(255, 255, 255));
            }
        });

        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10.setBackground(new Color(255, 51, 0));
                jButton10.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10.setBackground(new Color(51, 51, 51));
                jButton10.setForeground(new Color(255, 255, 255));
            }
        });

        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19.setBackground(new Color(255, 51, 0));
                jButton19.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19.setBackground(new Color(51, 51, 51));
                jButton19.setForeground(new Color(255, 255, 255));
            }
        });

        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7.setBackground(new Color(255, 51, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7.setBackground(new Color(153, 153, 153));
            }
        });

        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6.setBackground(new Color(255, 255, 51));
                jButton6.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6.setBackground(new Color(0, 0, 0));
                jButton6.setForeground(new Color(255, 255, 255));
            }
        });

        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField1.setBackground(Color.DARK_GRAY);
                jTextField1.setForeground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                reset();
            }

        });

        jTextField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField2.setBackground(Color.DARK_GRAY);
                jTextField2.setForeground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                reset();
            }
        });

        jTextField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField3.setBackground(Color.DARK_GRAY);
                jTextField3.setForeground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                reset();
            }
        });

        loadEmployees();
        loadSuppliers();
        loadIncome();
        loadExpense();

        jTextField1.setText(one);
        jTextField2.setText(two);
        jTextField3.setText(three);
    }

    private void loadPieChart1() {
        pieChart1 = new PieChart();
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart1.clearData();

        int index = 0;
        pieChart1.addData(new ModelPieChart("Maliban", 30, getColor(index++)));
        pieChart1.addData(new ModelPieChart("Munchee", 20, getColor(index++)));
        pieChart1.addData(new ModelPieChart("Lifebuoy", 5, getColor(index++)));
        pieChart1.addData(new ModelPieChart("Rathna", 15, getColor(index++)));
        pieChart1.addData(new ModelPieChart("Nipuna", 10, getColor(index++)));

        pieChart1.setBounds(0, 0, jPanel40.getWidth(), jPanel40.getHeight());
        jPanel40.setLayout(new BorderLayout());
        jPanel40.add(pieChart1, BorderLayout.CENTER);
        jPanel40.revalidate();
        jPanel40.repaint();
    }

    private void loadLineChart1() {
        chart1 = new CurveLineChart();

        chart1.addLegend("Sales Revenue", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart1.addLegend("Transaction Count", Color.decode("#4682B4"), Color.decode("#32CD32"));
        chart1.addLegend("Product Categories Sold", Color.decode("#FF1493"), Color.decode("#FFD700"));
        chart1.addLegend("Customer Visits", Color.decode("#FFA500"), Color.decode("#0099F7"));

        setChartData();
        jPanel35.setLayout(new BorderLayout());
        jPanel35.add(chart1, BorderLayout.CENTER);
        jPanel35.revalidate();
        jPanel35.repaint();
    }

    private void setChartData() {
        chart1.clear();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String date1 = today.minusDays(3).format(formatter);
        String date2 = today.minusDays(2).format(formatter);
        String date3 = today.minusDays(1).format(formatter);
        String date4 = today.format(formatter);

        chart1.addData(new ModelChart(date1, new double[]{30, 3, 6, 12}));
        chart1.addData(new ModelChart(date2, new double[]{30, 15, 7.5, 15}));
        chart1.addData(new ModelChart(date3, new double[]{6.67, 1.67, 40, 13.33}));
        chart1.addData(new ModelChart(date4, new double[]{20, 30, 4.29, 25}));

        chart1.start();
    }

    private void loadPieChart2() {
        pieChart2 = new PieChart();
        pieChart2.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart2.clearData();

        int index = 5;
        pieChart2.addData(new ModelPieChart("Nipun", 30, getColor(index++)));
        pieChart2.addData(new ModelPieChart("Gihan", 20, getColor(index++)));
        pieChart2.addData(new ModelPieChart("Venuja", 5, getColor(index++)));
        pieChart2.addData(new ModelPieChart("Kanthi", 10, getColor(index++)));
        pieChart2.addData(new ModelPieChart("Chamila", 15, getColor(index++)));

        pieChart2.setBounds(0, 0, jPanel41.getWidth(), jPanel41.getHeight());
        jPanel41.setLayout(new BorderLayout());
        jPanel41.add(pieChart2, BorderLayout.CENTER);
        jPanel41.revalidate();
        jPanel41.repaint();
    }

    private void loadPieChart3() {
        pieChart3 = new PieChart();
        pieChart3.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart3.clearData();

        int index = 10;
        pieChart3.addData(new ModelPieChart("Ranjith", 5, getColor(index++)));
        pieChart3.addData(new ModelPieChart("Kamal", 10, getColor(index++)));
        pieChart3.addData(new ModelPieChart("Hansa", 7, getColor(index++)));
        pieChart3.addData(new ModelPieChart("Rasika", 3, getColor(index++)));
        pieChart3.addData(new ModelPieChart("Kumara", 4, getColor(index++)));

        pieChart3.setBounds(0, 0, jPanel42.getWidth(), jPanel42.getHeight());
        jPanel42.setLayout(new BorderLayout());
        jPanel42.add(pieChart3, BorderLayout.CENTER);
        jPanel42.revalidate();
        jPanel42.repaint();
    }

    private void loadLineChart2() {
        chart2 = new CurveLineChart();

        try {
            chart2.setTitle("Annual Productivity of Ceylon Mart");
            chart2.addLegend("Total Sales", Color.decode("#4682B4"), Color.decode("#32CD32"));
            chart2.addLegend("Product Restocks (GRNs)", Color.decode("#e65c00"), Color.decode("#F9D423"));
            chart2.addLegend("Customer Acquisition", Color.decode("#0099F7"), Color.decode("#F11712"));
            chart2.clear();

            chart2.addData(new ModelChart("January", new double[]{30, 3, 12}));
            chart2.addData(new ModelChart("February", new double[]{24, 18, 18}));
            chart2.addData(new ModelChart("March", new double[]{12, 10, 8}));
            chart2.addData(new ModelChart("April", new double[]{28.8, 6, 3}));
            chart2.addData(new ModelChart("May", new double[]{3, 15, 9}));
            chart2.addData(new ModelChart("June", new double[]{21, 9, 3}));
            chart2.addData(new ModelChart("July", new double[]{14, 24, 3}));
            chart2.addData(new ModelChart("August", new double[]{6, 15, 18}));
            chart2.addData(new ModelChart("September", new double[]{12, 6, 9}));
            chart2.addData(new ModelChart("October", new double[]{24, 18, 21}));
            chart2.addData(new ModelChart("November", new double[]{18, 9, 15}));
            chart2.addData(new ModelChart("December", new double[]{12, 6, 21}));

        } catch (Exception e) {
            e.printStackTrace();
        }
        chart2.start();

        jPanel39.setLayout(new BorderLayout());
        jPanel39.add(chart2, BorderLayout.CENTER);
        jPanel39.revalidate();
        jPanel39.repaint();
    }

    private Color getColor(int index) {
        Color[] color = new Color[]{
            new Color(255, 99, 132),
            new Color(54, 162, 235),
            new Color(75, 192, 192),
            new Color(255, 159, 64),
            new Color(153, 102, 255),
            new Color(128, 0, 128),
            new Color(0, 128, 128),
            new Color(220, 20, 60),
            new Color(30, 170, 186),
            new Color(34, 139, 34),
            new Color(255, 0, 51),
            new Color(50, 215, 50),
            new Color(255, 69, 0),
            new Color(70, 130, 180),
            new Color(40, 100, 238),
            new Color(176, 196, 222)
        };
        return color[index % color.length];
    }

    private void closeUI() {
        if (employeeReg != null) {
            employeeReg.dispose();
        }
        if (supplierReg != null) {
            supplierReg.dispose();
        }
        if (loyalty != null) {
            loyalty.dispose();
        }
        if (employeeAttend != null) {
            employeeAttend.dispose();
        }
        if (backup != null) {
            backup.dispose();
        }
    }
}

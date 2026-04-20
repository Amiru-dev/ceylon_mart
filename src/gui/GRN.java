package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.Login.logger;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.GRNItem;
import model.MySQL2;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import raven.toast.Notifications;
import visuals.JOptionIcon;

/**
 *
 * @author Vishwa
 */
public class GRN extends javax.swing.JFrame {
    
    HashMap<String, GRNItem> grnItemMap = new HashMap<>();

    /**
     * Creates new form GRN
     */
    public GRN() {
        initComponents();
        
        generateGRNId();
        jButton4.setFocusPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setEnabled(false);
        
        jLabel3.setText(Login.getEmployeeEmail());
        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);
        jButton4.setFocusPainted(false);
        jButton5.setFocusPainted(false);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.LIGHT_GRAY);
        
        jTable1.setDefaultRenderer(Object.class, renderer);
        
        jFormattedTextField4.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter payment");
        jFormattedTextField1.putClientProperty("JComponent.roundRect", true);
        jFormattedTextField2.putClientProperty("JComponent.roundRect", true);
        jFormattedTextField3.putClientProperty("JComponent.roundRect", true);
        jFormattedTextField4.putClientProperty("JComponent.roundRect", true);
        jTextField2.putClientProperty("JComponent.roundRect", true);
        jTextField2.grabFocus();
        Notifications.getInstance().setJFrame(this);
        jButton1.grabFocus();
    }
    
    private void generateGRNId() {
        long id = System.currentTimeMillis();
        jTextField1.setText(String.valueOf(id));
    }

    //mobile
    public JTextField getjTextField2() {
        return jTextField2;
    }

    //name
    public JLabel getjLabel21() {
        return jLabel21;
    }

    //product ID
    public JTextField getjTextField3() {
        return jTextField3;
    }

    //brand
    public JLabel getjLabel9() {
        return jLabel9;
    }

    //product Name
    public JLabel getjLabel11() {
        return jLabel11;
    }
    
    private void loadGRNItems() {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        double total = 0;
        
        for (GRNItem grnItem : grnItemMap.values()) {
            Vector<String> vector = new Vector<>();
            vector.add(grnItem.getProductId());
            vector.add(grnItem.getBrandName());
            vector.add(grnItem.getProductName());
            vector.add(String.valueOf(grnItem.getQty()));
            vector.add(String.valueOf(grnItem.getBuyingPrice()));
            vector.add(String.valueOf(grnItem.getSellingPrice()));
            vector.add(format.format(grnItem.getMfd()));
            vector.add(format.format(grnItem.getExp()));
            
            double itemTotal = grnItem.getQty() * grnItem.getBuyingPrice();
            total += itemTotal;
            vector.add(String.valueOf(itemTotal));
            
            model.addRow(vector);
        }
        
        jLabel18.setText(String.valueOf(total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();

        jMenuItem1.setText("Remove");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GRN");
        setLocation(new java.awt.Point(230, 0));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("GRN");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Employee");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("GRN Number");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Supplier");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Product ID");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Quantity");

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Brand");

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("PRODUCT BRAND HERE");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Name");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("PRODUCT NAME HERE");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Buying Price");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Selling Price");

        jButton3.setBackground(new java.awt.Color(30, 144, 255));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add to GRN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("MFD");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("EXP");

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("SUPPLIER NAME");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyReleased(evt);
            }
        });

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField1))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel14)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Brand", "Name", "Quantity", "Buying Price", "Selling Price", "MFD", "EXP", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Total");

        jLabel17.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Payment");

        jLabel18.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("0.00");

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Balance");

        jLabel20.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("0.00");

        jButton5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton5.setText("Save GRN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jFormattedTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jFormattedTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jFormattedTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jFormattedTextField4))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FlatMacDarkLaf.setup();
        SupplierResgistration sr = new SupplierResgistration();
        sr.setVisible(true);
        sr.setGrn(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FlatMacLightLaf.setup();
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.setGrn(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String product = jTextField3.getText();
        String qty = jFormattedTextField1.getText();
        String buying_price = jFormattedTextField2.getText();
        String selling_price = jFormattedTextField3.getText();
        Date mfd = jDateChooser1.getDate();
        Date exp = jDateChooser2.getDate();
        
        if (product.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter quantity", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (buying_price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter buying price", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (selling_price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter selling price", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (mfd == null) {
            JOptionPane.showMessageDialog(this, "Please choose the MFD", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (exp == null) {
            JOptionPane.showMessageDialog(this, "Please choose the EXP", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (Double.parseDouble(selling_price) <= Double.parseDouble(buying_price)) {
            JOptionPane.showMessageDialog(this, "Selling price cannot be smaller than buying price", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jFormattedTextField3.setText("");
            jFormattedTextField3.grabFocus();
        } else {
            
            GRNItem grnItem = new GRNItem();
            grnItem.setProductId(jTextField3.getText());
            grnItem.setBrandName(jLabel9.getText());
            grnItem.setProductName(jLabel11.getText());
            grnItem.setQty(Double.parseDouble(qty));
            grnItem.setBuyingPrice(Double.parseDouble(buying_price));
            grnItem.setSellingPrice(Double.parseDouble(selling_price));
            grnItem.setMfd(mfd);
            grnItem.setExp(exp);
            
            if (grnItemMap.get(jTextField3.getText()) == null) {
                grnItemMap.put(jTextField3.getText(), grnItem);
                
                loadGRNItems();
                JOptionPane.showMessageDialog(this, "GRN item added successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                jFormattedTextField4.grabFocus();
            } else {
                
                GRNItem found = grnItemMap.get(jTextField3.getText());
                
                if (found.getExp().compareTo(exp) == 0
                        && found.getMfd().compareTo(mfd) == 0
                        && found.getBuyingPrice() == Double.parseDouble(buying_price)
                        && found.getSellingPrice() == Double.parseDouble(selling_price)) {
                    
                    found.setQty(found.getQty() + Double.parseDouble(qty));
                    
                    loadGRNItems();
                    JOptionPane.showMessageDialog(this, "GRN item updated successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                    jFormattedTextField4.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "GRN item already exists with diffrent dates and prices", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                }
            }
            jButton5.setEnabled(true);
            jFormattedTextField4.grabFocus();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField4KeyReleased
        String total = jLabel18.getText();
        String payment = jFormattedTextField4.getText();
        
        if (payment.isEmpty()) {
            payment = "0";
            jLabel20.setText("0.00");
            jLabel20.setForeground(Color.BLACK);
            jButton5.setEnabled(false);
            
        } else if (!payment.matches("^(?!0$)([1-9][0-9]*|0\\.[0-9]{0,2}|[1-9][0-9]*\\.[0-9]{0,2})$")) {
            jLabel20.setText("INVALID INPUT");
            jLabel20.setForeground(Color.BLACK);
            jFormattedTextField4.setText("");
            jButton5.setEnabled(false);
            
        } else {
            jLabel20.setText(String.valueOf(Double.parseDouble(payment) - Double.parseDouble(total)));
            jLabel20.setForeground(Color.BLACK);
            jButton5.setEnabled(true);
        }
    }//GEN-LAST:event_jFormattedTextField4KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        String grnNumber = jTextField1.getText();
        String supplierMobile = jTextField2.getText();
        String employeeEmail = jLabel3.getText();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String payment = jLabel20.getText();
        String paidAmount = jFormattedTextField4.getText();
        int rowCount = jTable1.getRowCount();
        
        if (employeeEmail == null) {
            JOptionPane.showMessageDialog(this, "Employee should be logged in to process", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (supplierMobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a supplier", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (payment.equals("INVALID INPUT")) {
            JOptionPane.showMessageDialog(this, "Please input a valid payment amount", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (paidAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input a payment amount", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "The GRN table is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
        } else {
            try {
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                MySQL2.executeIUD("INSERT INTO `grn` VALUES('" + grnNumber + "','" + supplierMobile + "','" + date + "',"
                        + "'" + employeeEmail + "','" + paidAmount + "')");
                
                for (GRNItem grnItem : grnItemMap.values()) {
                    
                    ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `stock` WHERE "
                            + "`product_id`= '" + grnItem.getProductId() + "' AND "
                            + "`price`='" + grnItem.getSellingPrice() + "' AND"
                            + "`mfd` = '" + sdf.format(grnItem.getMfd()) + "' AND "
                            + "`exp` = '" + sdf.format(grnItem.getExp()) + "'");
                    
                    String sid = "";
                    
                    if (resultSet.next()) {
                        //existing stock
                        sid = resultSet.getString("id");
                        
                        String currentQty = resultSet.getString("qty");
                        String updatedQuantity = String.valueOf(Double.parseDouble(currentQty) + grnItem.getQty());
                        MySQL2.executeIUD("UPDATE `stock` SET `qty` = '" + updatedQuantity + "' WHERE `id` = '" + sid + "'");
                        
                    } else {

                        // new stock
                        MySQL2.executeIUD("INSERT INTO `stock`(`product_id`,`qty`,`price`,`mfd`,`exp`) "
                                + "VALUES('" + grnItem.getProductId() + "','" + grnItem.getQty() + "','" + grnItem.getSellingPrice() + "', "
                                + "'" + sdf.format(grnItem.getMfd()) + "','" + sdf.format(grnItem.getExp()) + "')");
                        
                        ResultSet resultSet2 = MySQL2.executeSearch("SELECT * FROM `stock` WHERE "
                                + "`product_id`= '" + grnItem.getProductId() + "' AND "
                                + "`price`='" + grnItem.getSellingPrice() + "' AND"
                                + "`mfd` = '" + sdf.format(grnItem.getMfd()) + "' AND "
                                + "`exp` = '" + sdf.format(grnItem.getExp()) + "'");
                        
                        if (resultSet2.next()) {
                            sid = resultSet2.getString("id");
                        }
                        
                    }
                    
                    MySQL2.executeIUD("INSERT INTO `grn_item`(`stock_id`,`qty`,`price`,`grn_id`) "
                            + "VALUES('" + sid + "','" + grnItem.getQty() + "','" + grnItem.getBuyingPrice() + "','" + grnNumber + "')");
                }
                reset1();
                JOptionPane.showMessageDialog(this, "GRN added successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            FlatMacLightLaf.setup();
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to remove", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());
        } else {
            String productId = String.valueOf(jTable1.getValueAt(row, 0));
            grnItemMap.remove(productId);
            loadGRNItems();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
        String qty = jFormattedTextField1.getText();
        Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
        
        if (!pattern.matcher(qty).matches()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please input a valid integer quantity");
            jFormattedTextField1.setText("");
        }
    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jFormattedTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyReleased
        String buy = jFormattedTextField2.getText();
        
        if (!buy.matches("^(?!0$)([1-9][0-9]*|0\\.[0-9]{0,2}|[1-9][0-9]*\\.[0-9]{0,2})$")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please enter a valid amount for buying price");
            jFormattedTextField2.setText("");
        }
    }//GEN-LAST:event_jFormattedTextField2KeyReleased

    private void jFormattedTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField3KeyReleased
        String buy = jFormattedTextField2.getText();
        String sell = jFormattedTextField3.getText();
        
        if (buy.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please enter buying price");
            jFormattedTextField3.setText("");
        } else {
            
            if (!sell.matches("^(?!0$)([1-9][0-9]*|0\\.[0-9]{0,2}|[1-9][0-9]*\\.[0-9]{0,2})$")) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please enter a valid amount for selling price");
                jFormattedTextField3.setText("");
            }
        }
    }//GEN-LAST:event_jFormattedTextField3KeyReleased

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        Date MFD = jDateChooser1.getDate();
        Date EXP = jDateChooser2.getDate();
        
        if (MFD != null && EXP != null) {
            Calendar dueCal = Calendar.getInstance();
            dueCal.setTime(MFD);
            dueCal.set(Calendar.HOUR_OF_DAY, 0);
            dueCal.set(Calendar.MINUTE, 0);
            dueCal.set(Calendar.SECOND, 0);
            dueCal.set(Calendar.MILLISECOND, 0);
            
            Calendar completionCal = Calendar.getInstance();
            completionCal.setTime(EXP);
            completionCal.set(Calendar.HOUR_OF_DAY, 0);
            completionCal.set(Calendar.MINUTE, 0);
            completionCal.set(Calendar.SECOND, 0);
            completionCal.set(Calendar.MILLISECOND, 0);
            
            if (completionCal.before(dueCal)) {
                JOptionPane.showMessageDialog(null, "Please choose a date after the MFD", "Invalid Date", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                jDateChooser2.setDate(null);
            }
        }
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        Date MFD = jDateChooser1.getDate();
        Date EXP = jDateChooser2.getDate();
        
        if (MFD != null && EXP != null) {
            Calendar dueCal = Calendar.getInstance();
            dueCal.setTime(MFD);
            dueCal.set(Calendar.HOUR_OF_DAY, 0);
            dueCal.set(Calendar.MINUTE, 0);
            dueCal.set(Calendar.SECOND, 0);
            dueCal.set(Calendar.MILLISECOND, 0);
            
            Calendar completionCal = Calendar.getInstance();
            completionCal.setTime(EXP);
            completionCal.set(Calendar.HOUR_OF_DAY, 0);
            completionCal.set(Calendar.MINUTE, 0);
            completionCal.set(Calendar.SECOND, 0);
            completionCal.set(Calendar.MILLISECOND, 0);
            
            if (completionCal.before(dueCal)) {
                JOptionPane.showMessageDialog(null, "Please choose a date before the EXP", "Invalid Date", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                jDateChooser1.setDate(null);
            }
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GRN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jFormattedTextField4.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTable1.clearSelection();
        jLabel9.setText("PRODUCT BRAND HERE");
        jLabel11.setText("PRODUCT NAME HERE");
        jLabel21.setText("SUPPLIER NAME");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }
    
    private void reset1() {
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jFormattedTextField4.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jLabel9.setText("PRODUCT BRAND HERE");
        jLabel11.setText("PRODUCT NAME HERE");
        jLabel21.setText("SUPPLIER NAME");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }
}

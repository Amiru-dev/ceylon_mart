package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.Login.logger;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.InvoiceItem;
import model.MySQL2;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import visuals.JOptionIcon;

/**
 *
 * @author Vishwa
 */
public class Invoice2 extends javax.swing.JFrame {

    private Home home;

    public void setHome(Home home) {
        this.home = home;
    }

    HashMap<String, InvoiceItem> invoiceItemMap = new HashMap<>();
    HashMap<String, String> paymentMethodMap = new HashMap<>();

    private void loadPaymentMethods() {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `payment_method`");

            Vector<String> vector = new Vector<>();

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                paymentMethodMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadInvoiceItems() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        total = 0;

        for (InvoiceItem invoiceItem : invoiceItemMap.values()) {
            Vector<String> vector = new Vector<>();
            vector.add(invoiceItem.getStockID());
            vector.add(invoiceItem.getBrand());
            vector.add(invoiceItem.getName());
            vector.add(invoiceItem.getQty());
            vector.add(invoiceItem.getSellingPrice());
            vector.add(invoiceItem.getMfd());
            vector.add(invoiceItem.getExp());

            double itemTotal = Double.parseDouble(invoiceItem.getQty()) * Double.parseDouble(invoiceItem.getSellingPrice());
            total += itemTotal;
            vector.add(String.valueOf(itemTotal));

            model.addRow(vector);
        }

        totalField.setText(String.valueOf(total));

        //2
        calculate();
    }

    //stock id
    public JTextField getjTextField3() {
        return jTextField3;
    }

    // Brand Name
    public JLabel getjLabel10() {
        return jLabel10;
    }

    // Product Name
    public JLabel getjLabel12() {
        return jLabel12;
    }

    //Selling Price 
    public JTextField getjTextField5() {
        return jTextField5;
    }

    // MFD
    public JLabel getjLabel14() {
        return jLabel14;
    }

    // EXP
    public JLabel getjLabel16() {
        return jLabel16;
    }

    //QTY
    public JFormattedTextField getjFormattedTextField1() {
        return jFormattedTextField1;
    }

    // Available Qty
    public JLabel getjLabel21() {
        return jLabel21;
    }

    public Invoice2() {
        initComponents();
        employeeLable.setText(Login.getEmployeeEmail());
        generateInvoiceID();
        loadPaymentMethods();

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);

        jTable1.setDefaultRenderer(Object.class, renderer);

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);
        printInvoiceButton.setFocusPainted(false);
        printInvoiceButton.setEnabled(false);
        discountField.setEditable(false);
        netTotalField.setEditable(false);

        totalField.putClientProperty("JComponent.roundRect", true);
        discountField.putClientProperty("JComponent.roundRect", true);
        paymentField.putClientProperty("JComponent.roundRect", true);
        balanceFiled.putClientProperty("JComponent.roundRect", true);
        netTotalField.putClientProperty("JComponent.roundRect", true);

        try {
            InputStream imgStream3 = getClass().getResourceAsStream("/resourses/new.png");
            ImageIcon originalIcon3 = new ImageIcon(ImageIO.read(imgStream3));
            this.setIconImage(originalIcon3.getImage());

        } catch (IOException e) {
            logger.log(Level.WARNING, "Couldn't load image", e);
        }

        paymentField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                netTotalField.setBackground(new Color(70, 73, 75));
                netTotalField.setForeground(Color.WHITE);
                paymentField.setBackground(new Color(255, 51, 0));
                paymentField.setForeground(Color.BLACK);
                paymentField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                paymentField.setBackground(new Color(70, 73, 75));
                paymentField.setForeground(Color.WHITE);
            }

        });

        balanceFiled.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                balanceFiled.setBackground(new Color(255, 51, 0));
                balanceFiled.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                balanceFiled.setBackground(new Color(70, 73, 75));
                balanceFiled.setForeground(Color.WHITE);
            }

        });
    }

    private void generateInvoiceID() {
        long id = System.currentTimeMillis();
        invoiceNumberField.setText(String.valueOf(id));
    }

    private double total = 0;
    private double discount = 0;
    private double payment = 0;
    private double balance = 0;
    private String paymentMethod = "Select";

    private void calculate() {
        try {
            // Validate totalField input
            if (totalField.getText().isEmpty() || !totalField.getText().matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, "Enter a valid total amount.", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                totalField.grabFocus();
                return;
            }
            total = Double.parseDouble(totalField.getText());

            // Apply discount if total exceeds threshold
            double discountThreshold = 5000; // Discount threshold
            double discountPercentage = 10; // Discount percentage
            if (total > discountThreshold) {
                discount = total * discountPercentage / 100;
                discountField.setText(String.format("%.2f", discount));
            } else {
                discount = 0;
                discountField.setText("0.00");
            }

            // Adjust total after discount
            total -= discount;

            // Validate paymentField input
            if (!paymentField.getText().isEmpty()) {
                if (!paymentField.getText().matches("^(?!0$)([1-9][0-9]*|0\\.[0-9]{0,2}|[1-9][0-9]*\\.[0-9]{0,2})$")) {
                    JOptionPane.showMessageDialog(this, "Input a valid payment amount.", "Warning", JOptionPane.WARNING_MESSAGE);
                    paymentField.grabFocus();
                    return;
                }
                payment = Double.parseDouble(paymentField.getText());
            } else {
                payment = 0;
            }

            // Validate total after discount
            if (total < 0) {
                JOptionPane.showMessageDialog(this, "Total cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            netTotalField.setText(String.format("%.2f", total));

            // Handle payment methods
            paymentMethod = String.valueOf(jComboBox1.getSelectedItem());
            if ("Cash".equals(paymentMethod)) {
                handleCashPayment();
            } else if ("Card".equals(paymentMethod)) {
                handleCardPayment();
            }

            // Update balance field
            balanceFiled.setText(String.format("%.2f", balance));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input detected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

// Handle cash payment
    private void handleCashPayment() {
        paymentField.setEditable(true);
        balance = payment - total;
        printInvoiceButton.setEnabled(balance >= 0);
    }

// Handle card payment
    private void handleCardPayment() {
        payment = total; // Card payment matches total directly
        balance = 0; // No balance for card payments
        paymentField.setText(String.format("%.2f", payment));
        paymentField.setEditable(false);
        printInvoiceButton.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        employeeLable = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceNumberField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        balanceFiled = new javax.swing.JFormattedTextField();
        paymentField = new javax.swing.JFormattedTextField();
        printInvoiceButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        totalField = new javax.swing.JFormattedTextField();
        netTotalField = new javax.swing.JFormattedTextField();
        discountField = new javax.swing.JFormattedTextField();

        jMenuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Remove");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice");
        setLocation(new java.awt.Point(-10, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INVOICE");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Employee");

        employeeLable.setForeground(new java.awt.Color(255, 255, 255));
        employeeLable.setText("EMPLOYEE DETAILS");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Invoice Number");

        invoiceNumberField.setEditable(false);
        invoiceNumberField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stock ID");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField3.setToolTipText("Select the item first");

        jButton1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Select");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Brand");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Name");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Selling Price");

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 255));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("MFD");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 255));

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("EXP");

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear All");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(30, 144, 255));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add to Invoice");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("0");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeeLable, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addComponent(invoiceNumberField))
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(employeeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock ID", "Brand", "Name", "Quantity", "Selling Price", "MFD", "EXP", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 255, 255));
        jLabel22.setText("Payment");

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("Balance");

        balanceFiled.setEditable(false);
        balanceFiled.setForeground(new java.awt.Color(255, 255, 255));
        balanceFiled.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        balanceFiled.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balanceFiled.setText("0.00");
        balanceFiled.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        paymentField.setForeground(new java.awt.Color(255, 255, 255));
        paymentField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        paymentField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        paymentField.setText("0.00");
        paymentField.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        paymentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paymentFieldKeyReleased(evt);
            }
        });

        printInvoiceButton.setBackground(new java.awt.Color(0, 0, 0));
        printInvoiceButton.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        printInvoiceButton.setForeground(new java.awt.Color(255, 255, 255));
        printInvoiceButton.setText("Print Invoice");
        printInvoiceButton.setToolTipText("Left click to print, Right click to view");
        printInvoiceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printInvoiceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                printInvoiceButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceFiled, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paymentField)
                    .addComponent(printInvoiceButton, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(34, 34, 34)
                .addComponent(printInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Total");

        jLabel27.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Discount");

        jLabel28.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Payment Method");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 0));
        jLabel29.setText("Net Total");

        totalField.setEditable(false);
        totalField.setForeground(new java.awt.Color(255, 255, 255));
        totalField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        totalField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalField.setText("0.00");
        totalField.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        netTotalField.setBackground(new java.awt.Color(255, 51, 0));
        netTotalField.setForeground(new java.awt.Color(0, 0, 0));
        netTotalField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        netTotalField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netTotalField.setText("0.00");
        netTotalField.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        discountField.setForeground(new java.awt.Color(255, 255, 255));
        discountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        discountField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        discountField.setText("0.00");
        discountField.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 264, Short.MAX_VALUE)
                    .addComponent(totalField)
                    .addComponent(netTotalField)
                    .addComponent(discountField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FlatMacLightLaf.setup();
        Stock2 stock2 = new Stock2();
        stock2.setVisible(true);
        stock2.setInvoice2(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String stockID = jTextField3.getText();
        String brand = jLabel10.getText();
        String productName = jLabel12.getText();
        String qty = jFormattedTextField1.getText();
        String availQty = jLabel21.getText();
        String mfd = jLabel14.getText();
        String exp = jLabel16.getText();
        String sellingPrice = jTextField5.getText();

        if (stockID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select the item first", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter quantity", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (Double.parseDouble(qty) > Double.parseDouble(availQty)) {
            JOptionPane.showMessageDialog(this, "Not enough available quantity", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else {
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setBrand(brand);
            invoiceItem.setExp(exp);
            invoiceItem.setMfd(mfd);
            invoiceItem.setName(productName);
            invoiceItem.setQty(qty);
            invoiceItem.setSellingPrice(sellingPrice);
            invoiceItem.setStockID(stockID);

            if (invoiceItemMap.get(stockID) == null) {
                invoiceItemMap.put(stockID, invoiceItem);
            } else {

                InvoiceItem found = invoiceItemMap.get(stockID);

                int option = JOptionPane.showConfirmDialog(this, "Do you want to Update the Quantity of " + productName, "Message",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());

                if (option == JOptionPane.YES_OPTION) {

                    found.setQty(String.valueOf(Double.parseDouble(found.getQty()) + Double.parseDouble(qty)));
                }
            }
            loadInvoiceItems();
            reset();
            totalField.grabFocus();
            discountField.grabFocus();
            netTotalField.grabFocus();
            balanceFiled.grabFocus();
            paymentField.grabFocus();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        calculate();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void paymentFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentFieldKeyReleased
        // 4
        calculate();

        if (evt.getKeyCode() == 10) {
            if (!printInvoiceButton.isEnabled()) {
                return;
            }
            printInvoice();
        }
    }//GEN-LAST:event_paymentFieldKeyReleased

    private void printInvoiceButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printInvoiceButtonMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (!printInvoiceButton.isEnabled()) {
                return;
            }
            printInvoice();
        }
    }//GEN-LAST:event_printInvoiceButtonMouseReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            FlatMacDarkLaf.setup();
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to remove", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());
        } else {
            String stockId = String.valueOf(jTable1.getValueAt(row, 0));
            invoiceItemMap.remove(stockId);
            loadInvoiceItems();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
        String qty = jFormattedTextField1.getText();
        Pattern pattern = Pattern.compile("^[1-9][0-9]*$");

        if (!pattern.matcher(qty).matches()) {
            JOptionPane.showMessageDialog(this, "Please input a valid integer quantity", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jFormattedTextField1.setText("");
        }
    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField balanceFiled;
    private javax.swing.JFormattedTextField discountField;
    private javax.swing.JLabel employeeLable;
    private javax.swing.JTextField invoiceNumberField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JFormattedTextField netTotalField;
    private javax.swing.JFormattedTextField paymentField;
    private javax.swing.JButton printInvoiceButton;
    private javax.swing.JFormattedTextField totalField;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jTextField3.setText("");
        jFormattedTextField1.setText("");
        jLabel21.setText("0");
        jLabel10.setText("");
        jTextField5.setText("");
        jLabel12.setText("");
        jLabel14.setText("");
        jLabel16.setText("");
        jTable1.clearSelection();
    }

    private void printInvoice() {

        try {
            String invoiceID = invoiceNumberField.getText();
            String employeeEmail = employeeLable.getText();
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String paidAmount = paymentField.getText();
            String paymentMethodID = paymentMethodMap.get(String.valueOf(jComboBox1.getSelectedItem()));
            String discount1 = String.valueOf(discountField.getText());
            int rowCount = jTable1.getRowCount();

            if (employeeEmail == null) {
                JOptionPane.showMessageDialog(this, "Employee should be logged in to process", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (paidAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please input a payment amount", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (Double.parseDouble(paidAmount) == 0) {
                JOptionPane.showMessageDialog(this, "Please input a payment amount", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, "The invoice is empty!", "No Data", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
            } else if (Double.parseDouble(paidAmount) < total) {
                JOptionPane.showMessageDialog(this, "Customer has to pay more LKR " + (total - Double.parseDouble(paidAmount)), "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

            } else {
                if (total > 5000) {
                    //insert to invoice
                    MySQL2.executeIUD("INSERT INTO `invoice`(`id`,`employee_email`,`date`,`paid_amount`,`payment_method_id`,`discount_value`,`discount_id`) "
                            + "VALUES('" + invoiceID + "','" + employeeEmail + "',"
                            + "'" + dateTime + "','" + paidAmount + "','" + paymentMethodID + "','" + discount1 + "','1')");
                    //insert to invoice

                } else {
                    //insert to invoice
                    MySQL2.executeIUD("INSERT INTO `invoice`(`id`,`employee_email`,`date`,`paid_amount`,`payment_method_id`,`discount_value`) "
                            + "VALUES('" + invoiceID + "','" + employeeEmail + "',"
                            + "'" + dateTime + "','" + paidAmount + "','" + paymentMethodID + "','" + discount1 + "')");
                    //insert to invoice
                }

                for (InvoiceItem invoiceItem : invoiceItemMap.values()) {

                    //insert to invoiceItem
                    MySQL2.executeIUD("INSERT INTO `invoice_item`(`stock_id`,`qty`,`invoice_id`) "
                            + "VALUES('" + invoiceItem.getStockID() + "','" + invoiceItem.getQty() + "','" + invoiceID + "')");
                    //insert to invoiceItem

                    //stock update
                    MySQL2.executeIUD("UPDATE `stock` SET `qty`=`qty`-'" + invoiceItem.getQty() + "' WHERE `id`='" + invoiceItem.getStockID() + "'");
                    //stock update
                }

                //view or print report
                InputStream s = this.getClass().getResourceAsStream("/reports/ceylon_mart.jasper");

                HashMap<String, Object> params = new HashMap<>();
                params.put("Parameter1", totalField.getText());
                params.put("Parameter2", discountField.getText());
                params.put("Parameter3", String.valueOf(jComboBox1.getSelectedItem()));
                params.put("Parameter4", paymentField.getText());
                params.put("Parameter5", balanceFiled.getText());
                params.put("Parameter6", dateTime);
                params.put("Parameter7", employeeLable.getText());
                params.put("Parameter8", invoiceNumberField.getText());
                params.put("Parameter10", String.format("%.2f", total));

                JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

                JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                JasperPrintManager.printReport(jasperPrint, false);

                if (home != null) {
                    home.getjLabel7().setText(String.format("%.2f", balance));
                    home.getjLabel20().setText(String.format("%.2f", total));
                    home.getjLabel21().setText(String.format("%.2f", payment));
                    home.getjLabel22().setText(String.format("%.2f", discount));
                    this.dispose();
                }
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Jasper Report Print Error", e);
        }
    }
}

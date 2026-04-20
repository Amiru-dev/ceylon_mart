package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.Login.logger;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL2;
import raven.toast.Notifications;
import visuals.JOptionIcon;

public class Stock2 extends javax.swing.JFrame {

    HashMap<String, String> brandMap = new HashMap<>();

    private GRN grn;

    public void setGrn(GRN grn) {
        this.grn = grn;
    }

    private Invoice2 invoice2;

    public void setInvoice2(Invoice2 invoice2) {
        this.invoice2 = invoice2;
    }

    /**
     * Creates new form Stock2
     */
    public Stock2() {
        initComponents();
        loadBrand();
        loadProducts();
        loadStock();
        generateProductID();

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.LIGHT_GRAY);
        renderer.setForeground(Color.BLACK);

        jTable1.setDefaultRenderer(Object.class, renderer);
        jTable2.setDefaultRenderer(Object.class, renderer);

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);
        jButton4.setFocusPainted(false);
        jButton5.setFocusPainted(false);
        jButton6.setFocusPainted(false);
        jButton7.setFocusPainted(false);

        jButton6.setEnabled(false);
        jTextField1.setEditable(false);

        try {
            InputStream imgStream1 = getClass().getResourceAsStream("/resourses/new.png");
            ImageIcon originalIcon1 = new ImageIcon(ImageIO.read(imgStream1));
            this.setIconImage(originalIcon1.getImage());

        } catch (IOException e) {
            logger.log(Level.WARNING, "Couldn't load image", e);
        }

        jTextField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField4.setText("");
                jTextField4.setBackground(Color.BLACK);
                jTextField4.setForeground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                jTextField4.setText("  Search");
                jTextField4.setBackground(Color.WHITE);
                jTextField4.setForeground(Color.BLACK);
            }
        });

        jFormattedTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jFormattedTextField1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        jFormattedTextField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jFormattedTextField2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(255, 255, 51));
                jButton1.setForeground(new Color(0, 0, 0));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
                jButton5.setBackground(new Color(51, 51, 51));
                jButton5.setForeground(new Color(255, 255, 255));
                jButton6.setBackground(new Color(51, 51, 51));
                jButton6.setForeground(new Color(255, 255, 255));
                jButton7.setBackground(new Color(51, 51, 51));
                jButton7.setForeground(new Color(255, 255, 255));
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
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
                jButton5.setBackground(new Color(51, 51, 51));
                jButton5.setForeground(new Color(255, 255, 255));
                jButton6.setBackground(new Color(51, 51, 51));
                jButton6.setForeground(new Color(255, 255, 255));
                jButton7.setBackground(new Color(51, 51, 51));
                jButton7.setForeground(new Color(255, 255, 255));
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
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
                jButton5.setBackground(new Color(51, 51, 51));
                jButton5.setForeground(new Color(255, 255, 255));
                jButton6.setBackground(new Color(51, 51, 51));
                jButton6.setForeground(new Color(255, 255, 255));
                jButton7.setBackground(new Color(51, 51, 51));
                jButton7.setForeground(new Color(255, 255, 255));
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
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(255, 51, 51));
                jButton4.setForeground(new Color(0, 0, 0));
                jButton5.setBackground(new Color(51, 51, 51));
                jButton5.setForeground(new Color(255, 255, 255));
                jButton6.setBackground(new Color(51, 51, 51));
                jButton6.setForeground(new Color(255, 255, 255));
                jButton7.setBackground(new Color(51, 51, 51));
                jButton7.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        jButton5.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
                jButton5.setBackground(new Color(255, 51, 51));
                jButton5.setForeground(new Color(0, 0, 0));
                jButton6.setBackground(new Color(51, 51, 51));
                jButton6.setForeground(new Color(255, 255, 255));
                jButton7.setBackground(new Color(51, 51, 51));
                jButton7.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        jButton6.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
                jButton5.setBackground(new Color(51, 51, 51));
                jButton5.setForeground(new Color(255, 255, 255));
                jButton6.setBackground(new Color(255, 51, 51));
                jButton6.setForeground(new Color(0, 0, 0));
                jButton7.setBackground(new Color(51, 51, 51));
                jButton7.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });

        jButton7.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(new Color(51, 51, 51));
                jButton1.setForeground(new Color(255, 255, 255));
                jButton2.setBackground(new Color(51, 51, 51));
                jButton2.setForeground(new Color(255, 255, 255));
                jButton3.setBackground(new Color(51, 51, 51));
                jButton3.setForeground(new Color(255, 255, 255));
                jButton4.setBackground(new Color(51, 51, 51));
                jButton4.setForeground(new Color(255, 255, 255));
                jButton5.setBackground(new Color(51, 51, 51));
                jButton5.setForeground(new Color(255, 255, 255));
                jButton6.setBackground(new Color(51, 51, 51));
                jButton6.setForeground(new Color(255, 255, 255));
                jButton7.setBackground(new Color(255, 51, 51));
                jButton7.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1();
            }
        });
        jTextField4.grabFocus();
        Notifications.getInstance().setJFrame(this);
    }

    private void generateProductID() {
        long id = System.currentTimeMillis();
        jTextField1.setText(String.valueOf(id));
    }

    private void loadBrand() {

        try {

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `brand`");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                brandMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox1.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    private void loadProducts() {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `product` INNER JOIN `brand`"
                    + "ON `product`.`brand_id` = `brand`.`id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("product.id"));
                vector.add(resultSet.getString("brand.id"));
                vector.add(resultSet.getString("brand.name"));
                vector.add(resultSet.getString("product.name"));
                model.addRow(vector);
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }

    }

    private void loadStock() {

        try {

            String query = "SELECT * FROM `stock` INNER JOIN `product` "
                    + "ON `stock`.`product_id` = `product`.`id` "
                    + "INNER JOIN `brand` ON `brand`.`id` = `product`.`brand_id` ";

            int row = jTable1.getSelectedRow();

            if (row != -1) {
                String pid = String.valueOf(jTable1.getValueAt(row, 0));
                query += "WHERE `stock`.`product_id` = '" + pid + "' ";
            }

            if (query.contains("WHERE")) {
                query += "AND ";
            } else {
                query += "WHERE ";
            }

            double min_price = 0;
            double max_price = 0;

            if (!jFormattedTextField1.getText().isEmpty()) {
                min_price = Double.parseDouble(jFormattedTextField1.getText());
            }

            if (!jFormattedTextField2.getText().isEmpty()) {
                max_price = Double.parseDouble(jFormattedTextField2.getText());
            }

            if (min_price > 0 && max_price == 0) {
                query += "`stock`.`price` > '" + min_price + "' ";
            } else if (min_price == 0 && max_price > 0) {
                query += "`stock`.`price` < '" + max_price + "' ";
            } else if (min_price > 0 && max_price > 0) {
                if (min_price == max_price) {
                    JOptionPane.showMessageDialog(this, "Minimum price is equal to maximum price", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                    return;
                } else if (min_price > max_price) {
                    JOptionPane.showMessageDialog(this, "Minimum price is larger than maximum price", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                    return;

                } else {
                    query += "`stock`.`price` > '" + min_price + "' AND `stock`.`price` <  '" + max_price + "'";
                }
            }

            //exp
            Date start = null;
            Date end = null;

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            if (jDateChooser1.getDate() != null) {
                start = jDateChooser1.getDate();
                query += "`stock`.`exp` > '" + format.format(start) + "' AND";
            }

            if (jDateChooser2.getDate() != null) {
                end = jDateChooser2.getDate();
                query += "`stock`.`exp` < '" + format.format(end) + "' ";
            }

            int sort = jComboBox2.getSelectedIndex();
            query += "ORDER BY ";
            query = query.replace("WHERE ORDER BY ", "ORDER BY ");
            query = query.replace("AND ORDER BY ", "ORDER BY ");

            switch (sort) {
                case 0 ->
                    query += "`stock`.`id` ASC";
                case 1 ->
                    query += "`stock`.`id` DESC";
                case 2 ->
                    query += "`product`.`id` ASC";
                case 3 ->
                    query += "`product`.`id` DESC";
                case 4 ->
                    query += "`brand`.`id` ASC";
                case 5 ->
                    query += "`brand`.`id` DESC";
                case 6 ->
                    query += "`brand`.`name` ASC";
                case 7 ->
                    query += "`brand`.`name` DESC";
                case 8 ->
                    query += "`stock`.`price` ASC";
                case 9 ->
                    query += "`stock`.`price` DESC";
                case 10 ->
                    query += "`stock`.`qty` ASC";
                case 11 ->
                    query += "`stock`.`qty` DESC";
                default -> {
                }
            }

            ResultSet resultSet = MySQL2.executeSearch(query);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product & Stock");
        setResizable(false);

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Brand");

        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField3.setToolTipText("Select a brand first");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("+");
        jButton1.setToolTipText("click to add a brand");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Product Name");

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Product ID");

        jLabel10.setText("Use below field to add a brand name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(8, 8, 8))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Brand ID", "Brand", "Product Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1313, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, false, false, false, false
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
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(6);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        jButton5.setBackground(new java.awt.Color(30, 144, 255));
        jButton5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Add New Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 255, 255));
        jButton6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Update Product ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Product & Stock ");

        jButton3.setBackground(new java.awt.Color(30, 144, 255));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Find");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jDateChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setForeground(new java.awt.Color(0, 0, 0));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jDateChooser1.setOpaque(false);
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setText("TO");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("EXP");

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setText("0.00");
        jFormattedTextField2.setToolTipText("Enter maximum price here");
        jFormattedTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("TO");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setText("0.00");
        jFormattedTextField1.setToolTipText("Enter minimum price here");
        jFormattedTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Selling Price ");

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock ID (0 - 9)", "Stock ID (9 - 0)", "Product ID (0 - 9)", "Product ID (9 - 0)", "Brands (A - Z)", "Brands (Z - A)", "Product Names (A - Z)", "Product Names (Z - A)", "Selling Prices in Ascending order", "Selling Prices in Descending order", "Quantity in Ascending order", "Quantity in Descending order" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setText("Sort By :");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.setText("  Search");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 0, 51));
        jButton7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Clear All");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(461, 461, 461))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String brand = jTextField3.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

        if (brand.isEmpty()) {
            jTextField3.grabFocus();
            JOptionPane.showMessageDialog(this, "Please enter a brand name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(brand).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jTextField3.setText("");
        } else {

            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `brand` WHERE `name` = '" + brand + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Brand is already added", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());

                } else {

                    if (jComboBox1.getSelectedIndex() == 0) {
                        //Select
                        MySQL2.executeIUD("INSERT INTO `brand`(`name`) VALUES('" + brand + "')");
                        JOptionPane.showMessageDialog(this, "New brand added", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                    } else {

                        int showConfirm = JOptionPane.showConfirmDialog(this, "Do you want to update brand?", "Update", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        if (showConfirm == JOptionPane.YES_OPTION) {
                            MySQL2.executeIUD("UPDATE `brand` SET `name`='" + brand + "' WHERE `name` = '" + String.valueOf(jComboBox1.getSelectedItem()) + "'");
                            JOptionPane.showMessageDialog(this, "Brand name updated", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                        }
                    }

                    loadBrand();
                    jTextField3.setText("");
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
        generateProductID();
        jTextField3.grabFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jButton5.grabFocus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id = jTextField1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String name = jTextField2.getText();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 _-]{2,30}$");

        if (brand.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a brand", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jTextField2.grabFocus();
        } else if (!pattern.matcher(name).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid product name.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jTextField2.setText("");
            jTextField2.grabFocus();
        } else {

            try {
                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `product` WHERE `id` = '" + id + "' OR (`name` = '" + name + "' AND `brand_id` = '" + brandMap.get(brand) + "')");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Product is already added", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    MySQL2.executeIUD("INSERT INTO `product`(`id`,`name`,`brand_id`) VALUES('" + id + "','" + name + "','" + brandMap.get(brand) + "')");
                    loadProducts();
                    resetProductUI();
                    JOptionPane.showMessageDialog(this, "New product added", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }

        }
        generateProductID();
        jTextField2.grabFocus();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed

        if (evt.getKeyCode() == 10) {
            jTextField2.grabFocus();
        }

    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        resetProductUI();
        loadStock();
        generateProductID();
        jTextField2.grabFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();

        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Please select a row first");
        } else {
            jButton5.setEnabled(false);
            jButton6.setEnabled(true);

            jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 0)));
            jComboBox1.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 2)));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 3)));

            loadStock();

            if (evt.getClickCount() == 2) {
                if (grn != null) {
                    grn.getjTextField3().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                    grn.getjLabel9().setText(String.valueOf(jTable1.getValueAt(row, 2)));
                    grn.getjLabel11().setText(String.valueOf(jTable1.getValueAt(row, 3)));
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String id = jTextField1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String name = jTextField2.getText();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 _-]{2,30}$");

        if (brand.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a brand", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jTextField2.grabFocus();
        } else if (!pattern.matcher(name).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid product name.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            jTextField2.setText("");
            jTextField2.grabFocus();
        } else {

            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `product` WHERE `name` = '" + name + "' AND `brand_id` = '" + brandMap.get(brand) + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Change name or brand to update", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    MySQL2.executeIUD("UPDATE `product` SET `brand_id` = '" + brandMap.get(brand) + "' , `name` ='" + name + "' "
                            + "WHERE `id` = '" + id + "'");
                    loadProducts();
                    resetProductUI();
                    JOptionPane.showMessageDialog(this, "Product updated successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }
        }
        generateProductID();
        jTextField2.grabFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        loadStock();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadStock();
        generateProductID();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadStock();
        generateProductID();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jFormattedTextField1.setText("0.00");
        jFormattedTextField2.setText("0.00");
        jComboBox2.setSelectedIndex(0);
        loadStock();
        generateProductID();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int row = jTable2.getSelectedRow();

        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Please select a row first");
        } else {

            if (evt.getClickCount() == 2) {
                if (invoice2 != null) {
                    invoice2.getjTextField3().setText(String.valueOf(jTable2.getValueAt(row, 0)));
                    invoice2.getjLabel10().setText(String.valueOf(jTable2.getValueAt(row, 2)));
                    invoice2.getjLabel12().setText(String.valueOf(jTable2.getValueAt(row, 3)));
                    invoice2.getjTextField5().setText(String.valueOf(jTable2.getValueAt(row, 4)));
                    invoice2.getjLabel14().setText(String.valueOf(jTable2.getValueAt(row, 6)));
                    invoice2.getjLabel16().setText(String.valueOf(jTable2.getValueAt(row, 7)));
                    invoice2.getjFormattedTextField1().grabFocus();
                    invoice2.getjLabel21().setText(String.valueOf(jTable2.getValueAt(row, 5)));
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `stock` INNER JOIN `product` "
                    + "ON `stock`.`product_id` = `product`.`id` "
                    + "INNER JOIN `brand` ON `brand`.`id` = `product`.`brand_id` "
                    + "WHERE `product`.`name` LIKE '" + jTextField4.getText() + "%' OR `stock`.`id` LIKE '" + jTextField4.getText() + "%' OR `brand`.`name` LIKE '" + jTextField4.getText() + "%'");

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
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

            if (model.getRowCount() == 1) {
                jTable2.setRowSelectionInterval(0, 0);

                if (evt.getKeyCode() == 10) {
                    if (invoice2 != null) {
                        invoice2.getjTextField3().setText(String.valueOf(jTable2.getValueAt(0, 0)));
                        invoice2.getjLabel10().setText(String.valueOf(jTable2.getValueAt(0, 2)));
                        invoice2.getjLabel12().setText(String.valueOf(jTable2.getValueAt(0, 3)));
                        invoice2.getjTextField5().setText(String.valueOf(jTable2.getValueAt(0, 4)));
                        invoice2.getjLabel14().setText(String.valueOf(jTable2.getValueAt(0, 6)));
                        invoice2.getjLabel16().setText(String.valueOf(jTable2.getValueAt(0, 7)));
                        invoice2.getjFormattedTextField1().grabFocus();
                        invoice2.getjLabel21().setText(String.valueOf(jTable2.getValueAt(0, 5)));
                        this.dispose();
                    }
                }
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        Date from = jDateChooser1.getDate();
        Date to = jDateChooser2.getDate();

        if (from != null && to != null) {
            Calendar dueCal = Calendar.getInstance();
            dueCal.setTime(from);
            dueCal.set(Calendar.HOUR_OF_DAY, 0);
            dueCal.set(Calendar.MINUTE, 0);
            dueCal.set(Calendar.SECOND, 0);
            dueCal.set(Calendar.MILLISECOND, 0);

            Calendar completionCal = Calendar.getInstance();
            completionCal.setTime(to);
            completionCal.set(Calendar.HOUR_OF_DAY, 0);
            completionCal.set(Calendar.MINUTE, 0);
            completionCal.set(Calendar.SECOND, 0);
            completionCal.set(Calendar.MILLISECOND, 0);

            if (completionCal.before(dueCal)) {
                JOptionPane.showMessageDialog(null, "Invalid EXP date sorting", "Invalid Date", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                jDateChooser1.setDate(null);
            }
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        Date from = jDateChooser1.getDate();
        Date to = jDateChooser2.getDate();

        if (from != null && to != null) {
            Calendar dueCal = Calendar.getInstance();
            dueCal.setTime(from);
            dueCal.set(Calendar.HOUR_OF_DAY, 0);
            dueCal.set(Calendar.MINUTE, 0);
            dueCal.set(Calendar.SECOND, 0);
            dueCal.set(Calendar.MILLISECOND, 0);

            Calendar completionCal = Calendar.getInstance();
            completionCal.setTime(to);
            completionCal.set(Calendar.HOUR_OF_DAY, 0);
            completionCal.set(Calendar.MINUTE, 0);
            completionCal.set(Calendar.SECOND, 0);
            completionCal.set(Calendar.MILLISECOND, 0);

            if (completionCal.before(dueCal)) {
                JOptionPane.showMessageDialog(null, "Invalid EXP date sorting", "Invalid Date", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
                jDateChooser2.setDate(null);
            }
        }
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
        String from = jFormattedTextField1.getText();

        if (!from.matches("^(?!0$)([1-9][0-9]*|0\\.[0-9]{0,2}|[1-9][0-9]*\\.[0-9]{0,2})$")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please enter a valid amount for minimum price");
            jFormattedTextField1.setText("");
        }
    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jFormattedTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyReleased
        String to = jFormattedTextField2.getText();

        if (!to.matches("^(?!0$)([1-9][0-9]*|0\\.[0-9]{0,2}|[1-9][0-9]*\\.[0-9]{0,2})$")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please enter a valid amount for maximum price");
            jFormattedTextField2.setText("");
        }
    }//GEN-LAST:event_jFormattedTextField2KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void resetProductUI() {
        jTextField3.setText("");
        jTextField2.setText("");
        jTable1.clearSelection();
        jTextField1.grabFocus();
        jComboBox1.setSelectedIndex(0);
        jButton5.setEnabled(true);
        jButton6.setEnabled(false);
    }

    private void reset1() {

        jButton1.setBackground(new Color(255, 51, 51));
        jButton1.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(51, 255, 255));
        jButton2.setForeground(new Color(0, 0, 0));
        jButton3.setBackground(new Color(30, 144, 255));
        jButton3.setForeground(new Color(255, 255, 255));
        jButton4.setBackground(new Color(255, 0, 51));
        jButton4.setForeground(new Color(255, 255, 255));
        jButton5.setBackground(new Color(30, 144, 255));
        jButton5.setForeground(new Color(255, 255, 255));
        jButton6.setBackground(new Color(51, 255, 255));
        jButton6.setForeground(new Color(0, 0, 0));
        jButton7.setBackground(new Color(255, 0, 51));
        jButton7.setForeground(new Color(255, 255, 255));
    }
}

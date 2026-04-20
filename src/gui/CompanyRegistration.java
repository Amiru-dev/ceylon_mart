package gui;

import static gui.Login.logger;
import java.awt.Color;
import java.awt.Cursor;
import model.MySQL2;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import visuals.JOptionIcon;

public class CompanyRegistration extends javax.swing.JDialog {

    SupplierResgistration sr;

    public CompanyRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sr = (SupplierResgistration) parent;
        initComponents();
        init();
    }

    private void loadCompanies() {

        try {

            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `company`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("hotline"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Company Registration");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Company Name");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hotline");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.setToolTipText("Company Name Here");

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(30, 144, 255));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Company Name", "Hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String name = jTextField1.getText();
        String hotline = jTextField2.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter company name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!pattern.matcher(name).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter only letters and spaces.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (hotline.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter company hotline", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
        } else if (!hotline.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid hotline number", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

        } else {

            try {

                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `company` WHERE `name`= '" + name + "' OR `hotline` = '" + hotline + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Company name or hotline is already used", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                } else {
                    MySQL2.executeIUD("INSERT INTO `company`(`name`,`hotline`) VALUES('" + name + "','" + hotline + "')");

                    reset();
                    JOptionPane.showMessageDialog(this, "Company added successfully", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error", e);
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());
        } else {
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);

            jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));

            if (evt.getClickCount() == 2) {

                String name = String.valueOf(jTable1.getValueAt(row, 1));

                sr.setCompanyName(name);

                this.dispose();

                sr.mobileGrabFocus();

                sr.setCompanyId(String.valueOf(jTable1.getValueAt(row, 0)));
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update", "Information", JOptionPane.INFORMATION_MESSAGE, JOptionIcon.INFO.setICon());
        } else {

            String name = jTextField1.getText();
            String hotline = jTextField2.getText();
            Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");

            String selectedId = String.valueOf(jTable1.getValueAt(row, 0));
            String selectedName = String.valueOf(jTable1.getValueAt(row, 1));
            String selectedHotline = String.valueOf(jTable1.getValueAt(row, 2));

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter company name", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!pattern.matcher(name).matches()) {
                JOptionPane.showMessageDialog(this, "Please enter only letters and spaces.", "Invalid Input", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (hotline.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter company hotline", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (!hotline.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
                JOptionPane.showMessageDialog(this, "Please enter valid hotline number", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());
            } else if (selectedName.equals(name) && selectedHotline.equals(hotline)) {
                JOptionPane.showMessageDialog(this, "Please change name or hotline number to update", "Warning", JOptionPane.WARNING_MESSAGE, JOptionIcon.WARNING.setICon());

            } else {

                try {
                    ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `company` WHERE (`name`= '" + name + "' OR `hotline` = '" + hotline + "') AND `id` != '" + selectedId + "'");

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Company name or hotline is already used", "Error", JOptionPane.ERROR_MESSAGE, JOptionIcon.ERROR.setICon());
                    } else {

                        MySQL2.executeIUD("UPDATE `company` SET `name` = '" + name + "' , `hotline` = '" + hotline + "' WHERE `id` = '" + selectedId + "'");

                        reset();
                        JOptionPane.showMessageDialog(this, "Successfully updated", "Success", JOptionPane.PLAIN_MESSAGE, JOptionIcon.SUCCESS.setICon());
                    }
                } catch (Exception e) {
                    logger.log(Level.WARNING, "Error", e);
                }
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.grabFocus();
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jTable1.clearSelection();
        loadCompanies();
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
        loadCompanies();

        jButton1.setEnabled(true);
        jButton2.setEnabled(false);

        jButton1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton3.setFocusPainted(false);

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
    }
}

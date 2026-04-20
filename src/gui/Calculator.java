package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author ASUS™
 */
public class Calculator extends javax.swing.JFrame implements ActionListener {
    
    class Close extends WindowAdapter {
        
        @Override
        public void windowClosing(WindowEvent e) {
            f.dispose();
        }
    }
    
    static Frame f;
    TextField tf;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30;
    String fv, sv, op;
    Double fdv, sdv, tot;

    /**
     * Creates new form Calculator
     */
    public Calculator() {
        initComponents();
        
        f = new Frame();
        f.addWindowListener(new Close());
        f.setBackground(Color.black);
        f.setTitle("Calculator");
        f.setResizable(false);
        f.setSize(340, 500);
        f.setLocationRelativeTo(null);
        f.setUndecorated(true);
        
        Font f1 = new Font("Segoe UI Black", Font.BOLD, 30);
        Font f2 = new Font("Microsoft YaHei", Font.BOLD, 27);
        Font f3 = new Font("Microsoft YaHei", Font.BOLD, 40);
        Font f4 = new Font("Arial", Font.BOLD, 33);
        Font f5 = new Font("Arial", Font.BOLD, 29);
        Font f6 = new Font("Microsoft YaHei", Font.PLAIN, 25);
        
        MenuBar mb = new MenuBar();
        
        Menu m1 = new Menu("View");
        MenuItem mi = new MenuItem("Standard");
        m1.add(mi);
        
        Menu m2 = new Menu("Edit");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        MenuItem selectAll = new MenuItem("Select All");
        m2.add(copy);
        m2.add(paste);
        m2.add(selectAll);
        
        Menu m3 = new Menu("Help");
        MenuItem mi2 = new MenuItem("View Help F1");
        MenuItem mi3 = new MenuItem("About Calculator");
        m3.add(mi2);
        m3.add(mi3);
        
        f.setMenuBar(mb);
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
        Panel p1 = new Panel();
        p1.setBackground(Color.BLACK);
        Panel p2 = new Panel();
        GridLayout gl = new GridLayout(6, 5, 4, 4);
        p2.setLayout(gl);
        p2.setBackground(Color.BLACK);
        
        tf = new TextField(13);
        tf.setFont(f1);
        tf.setEditable(false);
        tf.setForeground(Color.white);
        tf.setBackground(Color.black);
        tf.setText("0");
        p1.add(tf);
        
        b1 = new Button("MC");
        b2 = new Button("MR");
        b3 = new Button("MS");
        b4 = new Button("M+");
        b5 = new Button("M-");
        b6 = new Button("<--");
        b7 = new Button("CE");
        b8 = new Button("C");
        b9 = new Button("\u00B1");
        b10 = new Button("\u221A");
        b11 = new Button("7");
        b12 = new Button("8");
        b13 = new Button("9");
        b14 = new Button("\u00F7");
        b15 = new Button("%");
        b16 = new Button("4");
        b17 = new Button("5");
        b18 = new Button("6");
        b19 = new Button("\u00D7");
        b20 = new Button("1/x");
        b21 = new Button("1");
        b22 = new Button("2");
        b23 = new Button("3");
        b24 = new Button("-");
        b25 = new Button("x\u00B2");
        b26 = new Button("");
        b27 = new Button("0");
        b28 = new Button(".");
        b29 = new Button("+");
        b30 = new Button("=");
        
        b1.setBackground(Color.DARK_GRAY);
        b2.setBackground(Color.DARK_GRAY);
        b3.setBackground(Color.DARK_GRAY);
        b4.setBackground(Color.DARK_GRAY);
        b5.setBackground(Color.DARK_GRAY);
        b6.setBackground(Color.DARK_GRAY);
        b7.setBackground(Color.DARK_GRAY);
        b8.setBackground(Color.DARK_GRAY);
        b9.setBackground(Color.DARK_GRAY);
        b10.setBackground(Color.DARK_GRAY);
        b11.setBackground(Color.GRAY);
        b12.setBackground(Color.GRAY);
        b13.setBackground(Color.GRAY);
        b14.setBackground(Color.DARK_GRAY);
        b15.setBackground(Color.DARK_GRAY);
        b16.setBackground(Color.GRAY);
        b17.setBackground(Color.GRAY);
        b18.setBackground(Color.GRAY);
        b19.setBackground(Color.DARK_GRAY);
        b20.setBackground(Color.DARK_GRAY);
        b21.setBackground(Color.GRAY);
        b22.setBackground(Color.GRAY);
        b23.setBackground(Color.GRAY);
        b24.setBackground(Color.DARK_GRAY);
        b25.setBackground(Color.DARK_GRAY);
        b26.setBackground(Color.DARK_GRAY);
        b27.setBackground(Color.GRAY);
        b28.setBackground(Color.DARK_GRAY);
        b29.setBackground(Color.DARK_GRAY);
        b30.setBackground(Color.CYAN);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        b6.setForeground(Color.WHITE);
        b7.setForeground(Color.WHITE);
        b8.setForeground(Color.WHITE);
        b9.setForeground(Color.WHITE);
        b10.setForeground(Color.WHITE);
        b11.setForeground(Color.BLACK);
        b12.setForeground(Color.BLACK);
        b13.setForeground(Color.BLACK);
        b14.setForeground(Color.WHITE);
        b15.setForeground(Color.WHITE);
        b16.setForeground(Color.BLACK);
        b17.setForeground(Color.BLACK);
        b18.setForeground(Color.BLACK);
        b19.setForeground(Color.WHITE);
        b20.setForeground(Color.WHITE);
        b21.setForeground(Color.BLACK);
        b22.setForeground(Color.BLACK);
        b23.setForeground(Color.BLACK);
        b24.setForeground(Color.WHITE);
        b25.setForeground(Color.WHITE);
        b26.setForeground(Color.WHITE);
        b27.setForeground(Color.BLACK);
        b28.setForeground(Color.WHITE);
        b29.setForeground(Color.WHITE);
        b30.setForeground(Color.BLACK);
        
        b1.setFont(f6);
        b2.setFont(f6);
        b3.setFont(f6);
        b4.setFont(f6);
        b5.setFont(f6);
        b6.setFont(f2);
        b7.setFont(f5);
        b8.setFont(f5);
        b9.setFont(f4);
        b10.setFont(f1);
        b11.setFont(f1);
        b12.setFont(f1);
        b13.setFont(f1);
        b14.setFont(f3);
        b15.setFont(f1);
        b16.setFont(f1);
        b17.setFont(f1);
        b18.setFont(f1);
        b19.setFont(f3);
        b20.setFont(f5);
        b21.setFont(f1);
        b22.setFont(f1);
        b23.setFont(f1);
        b24.setFont(f3);
        b25.setFont(f1);
        b26.setFont(f1);
        b27.setFont(f1);
        b28.setFont(f3);
        b29.setFont(f3);
        b30.setFont(f4);
        
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b10);
        p2.add(b11);
        p2.add(b12);
        p2.add(b13);
        p2.add(b14);
        p2.add(b15);
        p2.add(b16);
        p2.add(b17);
        p2.add(b18);
        p2.add(b19);
        p2.add(b20);
        p2.add(b21);
        p2.add(b22);
        p2.add(b23);
        p2.add(b24);
        p2.add(b25);
        p2.add(b26);
        p2.add(b27);
        p2.add(b28);
        p2.add(b29);
        p2.add(b30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        b21.addActionListener(this);
        b22.addActionListener(this);
        b23.addActionListener(this);
        b24.addActionListener(this);
        b25.addActionListener(this);
        b26.addActionListener(this);
        b27.addActionListener(this);
        b28.addActionListener(this);
        b29.addActionListener(this);
        b30.addActionListener(this);
        
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);
        f.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if (o.equals(b6)) {
            if (tf.getText().equals("0")) {
                tf.setText("0");
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("0");
            } else {
                String text = tf.getText();
                if (!text.isEmpty()) {
                    tf.setText(text.substring(0, text.length() - 1));
                }
                if (tf.getText().isEmpty()) {
                    tf.setText("0");
                }
            }
            
        } else if (o.equals(b7)) {
            sv = null;
            sdv = 0.0;
            tf.setText("");
            
        } else if (o.equals(b8)) {
            fv = null;
            sv = null;
            op = null;
            fdv = 0.0;
            sdv = 0.0;
            tot = 0.0;
            tf.setText("0");
            
        } else if (o.equals(b9)) {
            if (tf.getText().equals("0")) {
                tf.setText("0");
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("Error: Click C");
            } else {
                fv = tf.getText();
                if (!fv.isEmpty()) {
                    if (fv.startsWith("-")) {
                        fv = fv.substring(1);
                    } else {
                        fv = "-" + fv;
                    }
                    tf.setText(fv);
                } else {
                    tf.setText("Error: Enter input!");
                }
            }
            
        } else if (o.equals(b10)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else {
                fv = tf.getText();
                try {
                    fdv = Double.parseDouble(fv);
                    if (fdv >= 0) {
                        tot = Math.sqrt(fdv);
                        tf.setText(tot + "");
                    } else {
                        tf.setText("Error: Invalid input");
                    }
                    
                } catch (NumberFormatException ex) {
                    tf.setText("Error: Invalid input!");
                }
            }
            
        } else if (o.equals(b11)) {
            if (tf.getText().equals("0")) {
                tf.setText(b11.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b11.getLabel());
            } else {
                tf.setText(tf.getText() + b11.getLabel());
            }
            
        } else if (o.equals(b12)) {
            if (tf.getText().equals("0")) {
                tf.setText(b12.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b12.getLabel());
            } else {
                tf.setText(tf.getText() + b12.getLabel());
            }
            
        } else if (o.equals(b13)) {
            if (tf.getText().equals("0")) {
                tf.setText(b13.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b13.getLabel());
            } else {
                tf.setText(tf.getText() + b13.getLabel());
            }
            
        } else if (o.equals(b14)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("Error: Click C");
            } else {
                fv = tf.getText();
                op = b14.getLabel();
                tf.setText("");
            }
            
        } else if (o.equals(b15)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else {
                fv = tf.getText();
                try {
                    fdv = Double.parseDouble(fv);
                    tot = fdv / 100;
                } catch (NumberFormatException ex) {
                    tf.setText("Error: Invalid input!");
                }
                tf.setText(tot + "");
            }
            
        } else if (o.equals(b16)) {
            if (tf.getText().equals("0")) {
                tf.setText(b16.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b16.getLabel());
            } else {
                tf.setText(tf.getText() + b16.getLabel());
            }
            
        } else if (o.equals(b17)) {
            
            if (tf.getText().equals("0")) {
                tf.setText(b17.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b17.getLabel());
            } else {
                tf.setText(tf.getText() + b17.getLabel());
            }
            
        } else if (o.equals(b18)) {
            if (tf.getText().equals("0")) {
                tf.setText(b18.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b18.getLabel());
            } else {
                tf.setText(tf.getText() + b18.getLabel());
            }
            
        } else if (o.equals(b19)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("Error: Click C");
            } else {
                fv = tf.getText();
                op = b19.getLabel();
                tf.setText("");
            }
            
        } else if (o.equals(b20)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else {
                if (tf.getText().startsWith("Error")) {
                    tf.setText("Error: Click C");
                } else {
                    fv = tf.getText();
                    try {
                        fdv = Double.parseDouble(fv);
                        if (fdv == 0) {
                            tf.setText("Error: Zero Division");
                        } else {
                            fv = String.valueOf(1 / fdv);
                        }
                    } catch (NumberFormatException ex) {
                        tf.setText("Error: Invalid input!");
                    }
                    tf.setText(fv);
                }
            }
            
        } else if (o.equals(b21)) {
            if (tf.getText().equals("0")) {
                tf.setText(b21.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b21.getLabel());
            } else {
                tf.setText(tf.getText() + b21.getLabel());
            }
            
        } else if (o.equals(b22)) {
            if (tf.getText().equals("0")) {
                tf.setText(b22.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b22.getLabel());
            } else {
                tf.setText(tf.getText() + b22.getLabel());
            }
            
        } else if (o.equals(b23)) {
            if (tf.getText().equals("0")) {
                tf.setText(b23.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b23.getLabel());
            } else {
                tf.setText(tf.getText() + b23.getLabel());
            }
            
        } else if (o.equals(b24)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("Error: Click C");
            } else {
                fv = tf.getText();
                op = b24.getLabel();
                tf.setText("");
            }
            
        } else if (o.equals(b25)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else {
                fv = tf.getText();
                try {
                    fdv = Double.parseDouble(fv);
                    tot = fdv * fdv;
                } catch (NumberFormatException ex) {
                    tf.setText("Error: Invalid input!");
                }
                tf.setText(tot + "");
            }
            
        } else if (o.equals(b27)) {
            if (tf.getText().equals("0")) {
                tf.setText(b27.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText(b27.getLabel());
            } else {
                tf.setText(tf.getText() + b27.getLabel());
            }
            
        } else if (o.equals(b28)) {
            if (tf.getText().equals("")) {
                tf.setText("0" + b28.getLabel());
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("Error: Click C");
            } else {
                tf.setText(tf.getText() + b28.getLabel());
            }
            
        } else if (o.equals(b29)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
            } else if (tf.getText().startsWith("Error")) {
                tf.setText("Error: Click C");
            } else {
                fv = tf.getText();
                op = b29.getLabel();
                tf.setText("");
            }
            
        } else if (o.equals(b30)) {
            if (tf.getText().isEmpty()) {
                tf.setText("Error: Enter input!");
                
            } else {
                if (op == null) {
                    tf.setText("Error: No Operator");
                    
                } else {
                    sv = tf.getText();
                    try {
                        fdv = Double.parseDouble(fv);
                        sdv = Double.parseDouble(sv);
                        
                    } catch (NumberFormatException ex) {
                        tf.setText("Error: Invalid input!");
                    }
                    
                    tf.setText("");
                    
                    if (op.equals("+")) {
                        tot = fdv + sdv;
                        tf.setText(tot + "");
                        
                    } else if (op.equals("-")) {
                        tot = fdv - sdv;
                        tf.setText(tot + "");
                        
                    } else if (op.equals("\u00D7")) {
                        tot = fdv * sdv;
                        tf.setText(tot + "");
                        
                    } else if (op.equals("\u00F7")) {
                        if (sdv == 0.0) {
                            tf.setText("Error: Zero Division");
                            
                        } else {
                            tot = fdv / sdv;
                            tf.setText(tot + "");
                        }
                    }
                }
            }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(0, 0));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class Bill extends javax.swing.JInternalFrame implements globalvariables {

    /**
     * Creates new form Bill
     */
    public static double rate;
    public static double tax;
    public static double charge;
    public static double total;
    public static double perday;
    public static int days;

    public Bill() {
        initComponents();
        jScrollPane1.setVisible(false);

        try {
            Connection myconnection;

            myconnection = DriverManager.getConnection(PATH + PLACE, USERNAME, PASSWORD);
            try {
                String a = "select * from customer";
                PreparedStatement mystatement = myconnection.prepareStatement(a);
                ResultSet myresult = mystatement.executeQuery();

                if (myresult.next()) {
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem("Select Guest Id");
                    do {
                        jComboBox1.addItem(myresult.getString("name") + "," + myresult.getString("cust_code"));
                    } while (myresult.next());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No records exist");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error in Query " + e.getMessage());
            } finally {
                myconnection.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in Connection " + e.getMessage());
        }

        try {
            Connection myconnection;

            myconnection = DriverManager.getConnection(PATH + PLACE, USERNAME, PASSWORD);

            try {
                String a = "select max(bill_no) from payment";
                PreparedStatement mystatement = myconnection.prepareStatement(a);
                ResultSet myresult = mystatement.executeQuery();

                if (myresult.next()) {
                    int code = myresult.getInt(1);
                    if (code == 0) {
                        code = 100;
                    }
                    jLabel3.setText(String.valueOf(code + 1));
                }

                java.util.Date obj = new java.util.Date();
                SimpleDateFormat myformat = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat myformat2 = new SimpleDateFormat("HH:mm::ss");
                jLabel5.setText(myformat.format(obj));
                jLabel7.setText(myformat2.format(obj));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error in Query " + e.getMessage());
            } finally {
                myconnection.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in Connection " + e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Customer Id :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Guest Id" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Bill No. : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setText("Date :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setText("Time :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setText("Room No. :");
        jLabel8.setName(""); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setText("Room Type :");
        jLabel10.setName(""); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel12.setText("Arrival Date :");
        jLabel12.setName(""); // NOI18N

        jLabel14.setText("Departure Date :");
        jLabel14.setName(""); // NOI18N

        jScrollPane1.setName(""); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Room Rent", null, null, null},
                {"CGST+SGST", "18%", null, null},
                {"Service Charge", "10%", null, null},
                {"Discount", null, null, null},
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {"<html><b>Total</b></html>", null, null, "<html><b>"}
            },
            new String [] {
                "Particulars", "Rate", "Days", "Amount"
            }
        ));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jLabel16.setText("Customer Name :");
        jLabel16.setName(""); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jButton1.setText("Print Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(217, 217, 217)
                                        .addComponent(jButton1)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() > 0) {
            try {
                Connection myconnection;

                myconnection = DriverManager.getConnection(PATH + PLACE, USERNAME, PASSWORD);
                try {
                    String a = "select * from customer where cust_code = ?";
                    String st = "select * from payment where cust_code=?";
                    PreparedStatement mystatement = myconnection.prepareStatement(a);
                    mystatement.setString(1, jComboBox1.getSelectedItem().toString().substring(jComboBox1.getSelectedItem().toString().lastIndexOf(",") + 1));
                    PreparedStatement mystatement3 = myconnection.prepareStatement(st);
                    mystatement3.setString(1, jComboBox1.getSelectedItem().toString().substring(jComboBox1.getSelectedItem().toString().lastIndexOf(",") + 1));
                    ResultSet myresult = mystatement.executeQuery();
                    ResultSet myresult3 = mystatement3.executeQuery();
                    if (!myresult3.next()) {
                        if (myresult.next()) {
                            String myfile = myresult.getString("image");
                    
                    Image simg = ImageIO.read(new File("userimages//" + myfile)).getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_DEFAULT);
                    jLabel13.setIcon(new ImageIcon(simg));
                            jLabel9.setText(myresult.getString("room_no"));
                            jLabel11.setText(myresult.getString("type"));
                            jDateChooser1.setDate(myresult.getDate("arrival"));
                            jDateChooser2.setDate(myresult.getDate("departure"));
                            jLabel17.setText(myresult.getString("name").toUpperCase());
                            jScrollPane1.setVisible(true);
                        } else {
                            jScrollPane1.setVisible(false);
                            JOptionPane.showMessageDialog(rootPane, "Error");
                        }

                        days = (int) (Math.round(jDateChooser2.getDate().getTime() - jDateChooser1.getDate().getTime()) / (1000 * 60 * 60 * 24));

                        String b = "select * from roomdetails where roomno=?";
                        PreparedStatement mystatement2 = myconnection.prepareStatement(b);
                        mystatement2.setString(1, jLabel9.getText());
                        ResultSet myresult2 = mystatement2.executeQuery();

                        if (myresult2.next()) {
                            String price = myresult2.getString("rate");
                            perday = Double.parseDouble(price);
                            rate = perday * days;
                            tax = (rate * 18) / 100;
                            charge = (rate * 10) / 100;
                            total = rate + tax + charge;

                            jTable1.setValueAt(perday, 0, 1);
                            jTable1.setValueAt(days, 0, 2);
                            jTable1.setValueAt(rate, 0, 3);
                            jTable1.setValueAt(tax, 1, 3);
                            jTable1.setValueAt(charge, 2, 3);
                            jTable1.setValueAt(total, 8, 3);

                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Bill already generated");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Error in Query " + e.getMessage());
                } finally {
                    myconnection.close();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error in Connection " + e.getMessage());
            }
        }


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Connection myconnection;

            myconnection = DriverManager.getConnection(PATH + PLACE, USERNAME, PASSWORD);

            try {
                String a = "insert into payment values(?,?,?,?,?)";
                PreparedStatement mystatement = myconnection.prepareStatement(a);
                mystatement.setString(1, jLabel3.getText());
                mystatement.setString(2, jComboBox1.getSelectedItem().toString().substring(jComboBox1.getSelectedItem().toString().lastIndexOf(",") + 1));
                java.util.Date obj = new java.util.Date();
                SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
                mystatement.setString(3, myformat.format(obj));
                mystatement.setString(4, jLabel7.getText());
                mystatement.setString(5, jTable1.getValueAt(8, 3).toString());

                if (mystatement.executeUpdate() == 1) {
                    if (Login.usertype.equals("Admin")) {
                        PrintBill obj2 = new PrintBill();
                        ParentFrame.jDesktopPane1.add(obj2);
                        obj2.setVisible(true);
                        this.dispose();
                    } else if (Login.usertype.equals("Staff")) {
                        PrintBill obj2 = new PrintBill();
                        ParentFrame2.jDesktopPane1.add(obj2);
                        obj2.setVisible(true);
                        this.dispose();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error in Query " + e.getMessage());
            } finally {
                myconnection.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in Connection " + e.getMessage());
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    public static com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class TransactionsAdmin extends javax.swing.JFrame {

    /**
     * Creates new form TransactionsAdmin
     */
    String admin_name;
    public TransactionsAdmin(String adminname) {
        
        initComponents();
        admin_name = adminname;
        
        int numberofbookings = 0;
        
            Connection conn = null ;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = dbm3.dbconnect();
             String query="SELECT * FROM booking";
             ps =conn.prepareStatement(query);
             rs=ps.executeQuery();
             
             while(rs.next())
             {
                 numberofbookings++;
             }
        }
         catch (SQLException ex) 
        {
            System.out.println( ex.getMessage());
        }
          finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
}
        
        
         conn = null ;
         ps = null;
         rs = null;
         
          try
        {
             conn = dbm3.dbconnect();
             String query="SELECT * FROM booking";
             ps =conn.prepareStatement(query);
           
             int i = 0 ;
             Object[] cname={"Reference Number","User ID","Driver ID","Pickup Location","Drop Location","Fare","Trip Start Time","Trip End Time"};
            DefaultTableModel model=new DefaultTableModel(cname,numberofbookings);
            table.setModel(model);
            
               rs=ps.executeQuery();
              while(rs.next())
              {
                String referencenumber = rs.getString("REFERENCENUMBER");
                String username = rs.getString("USERNAME");
                int driverid = rs.getInt("DRIVERID");
                String pickuplocation = HeadQuater.getLocationDescription(Integer.parseInt(rs.getString("PICKUPLOCATION")));
                String droplocation = HeadQuater.getLocationDescription(Integer.parseInt(rs.getString("DROPLOCATION")));
                int  tripstarttime = rs.getInt("TRIPSTARTTIME");
                int  tripendtime = rs.getInt("TRIPENDTIME");
                

               table.setValueAt((Object)(referencenumber),i,0);
                table.setValueAt((Object)(username),i,1);
                table.setValueAt((Object)(driverid),i,2);
                table.setValueAt((Object)(pickuplocation),i,3);
                table.setValueAt((Object)(droplocation),i,4);
                table.setValueAt((Object)(HeadQuater.CalculateFare(pickuplocation, droplocation)),i,5);
                table.setValueAt((Object)(tripstarttime),i,6);
                table.setValueAt((Object)(tripendtime),i,7);

                i++;
              }
        }
        catch (SQLException | NumberFormatException ex) 
        {
            System.out.println( ex.getMessage());
        }
          finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (ps != null) ps.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
    try { if (conn != null) conn.close(); } catch (SQLException e) {System.out.println(e.getMessage());}
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
        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 115));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Details of all Transactions");

        Back.setBackground(new java.awt.Color(153, 153, 0));
        Back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(14, 140, 214));
        table.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reference Number", "User ID", "Driver ID", "Pickup Location", "Drop Location", "Fare", "Trip Start Time", "Trip End Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setEnabled(false);
        table.setGridColor(new java.awt.Color(14, 140, 214));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(389, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 704, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        new Admin(admin_name).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //new TransactionsAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankminiproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rudan
 */
public class Transfer extends javax.swing.JFrame {
    existingCustomer user;
    Connection con;
    Menu mn;
    Double OverdraftLimit, InterestRate;
    /**
     * Creates new form Transfer
     */
    public Transfer(existingCustomer user,Connection con,Menu mn) {
        this.mn = mn;
        this.con = con;
        this.user = user;
        initComponents();
        setSize(550,220);
        balancelbl.setText("Balance : " + user.Balance);
    }
    public Transfer() {
        initComponents();
        setSize(550,220);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        balancelbl = new javax.swing.JLabel();
        amountlbl = new javax.swing.JLabel();
        amounttxt = new javax.swing.JTextField();
        sourceAcclbl = new javax.swing.JLabel();
        destAcctxt = new javax.swing.JTextField();
        transferbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 220));

        balancelbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        balancelbl.setText("Balance : ");

        amountlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountlbl.setText("Enter the amount whom you want to transfer to        :");

        sourceAcclbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sourceAcclbl.setText("Enter the Acc. number to whom you want to transfer :");

        transferbtn.setText("Transfer");
        transferbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferbtnActionPerformed(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(balancelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sourceAcclbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amounttxt)
                            .addComponent(destAcctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(transferbtn)
                .addGap(18, 18, 18)
                .addComponent(cancelbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balancelbl)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountlbl)
                    .addComponent(amounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceAcclbl)
                    .addComponent(destAcctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transferbtn)
                    .addComponent(cancelbtn))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void transferbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferbtnActionPerformed
        // TODO add your handling code here:
        Double balance, newSourceBal;
        int destAccNumber;
        
         if("".equals(amounttxt.getText()) & "".equals(destAcctxt.getText())) {
				JOptionPane.showMessageDialog(this,"Please enter your details","No data",JOptionPane.WARNING_MESSAGE);
				destAcctxt.requestFocus();
			}
			else if("".equals(destAcctxt.getText())) {
				JOptionPane.showMessageDialog(this,"Enter your Destination account number","Username Missing",JOptionPane.WARNING_MESSAGE);
				destAcctxt.requestFocus();
			}	
			else if("".equals(amounttxt.getText())) {
				JOptionPane.showMessageDialog(this,"Enter your amount","Password Missing",JOptionPane.WARNING_MESSAGE);
				amounttxt.requestFocus();
			}
                        else{ // all the feilds are there
                                try {
                                    balance = Double.parseDouble(amounttxt.getText());
                                    destAccNumber = Integer.parseInt(destAcctxt.getText());
                                    if(balance > 0) 
                                    {
                                        if(destAccNumber > 0) {
                                            
                                            if((user.AccountType).equals("Current")) { // setting the overdraft interest and limit according to type of account
                                                    OverdraftLimit = 20000.0;
                                                    InterestRate = 0.06;
                                            }
                                            else {
                                                    OverdraftLimit = 5000.0;
                                                    InterestRate = 0.04;
                                            }
                                            
                                            newSourceBal = user.Balance - balance;
                                            if(newSourceBal < 0) {    // if no balance in the account
                                                int result = JOptionPane.showConfirmDialog(this,"Do you want to use OverDraft facility?","No Balance",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                                
                                                if(result == JOptionPane.YES_OPTION) { // if user uses overdraft facility
                                                        
                                                        Double extra=0.0;
                                                        Double tax=0.0;
                                                        if(user.Balance>=0) {
                                                            extra = newSourceBal;
                                                            tax = extra * InterestRate;
                                                            newSourceBal =  extra + tax;
                                                        }
                                                        else {
                                                            extra = -balance;
                                                            tax = extra * InterestRate;
                                                            newSourceBal = extra + user.Balance + tax;
                                                        }
                                                       if((extra - extra*2) <= OverdraftLimit) {
                                                        
                                                                try {
                                                                    //String checkdestAcc = "select AccountNumber from customers where AccountNumber=" + destAccNumber+";";
                                                                    if(destAccNumber != user.AccountNumber) {
                                                                        Statement smt = con.createStatement();
                                                                        if(smt.executeQuery("select AccountNumber from customers where AccountNumber=" + destAccNumber+";").first()) {
                                                                            Double preTotal = null;
                                                                            ResultSet rs = smt.executeQuery("select sum(Balance) as total from customers where AccountNumber in("+user.AccountNumber+","+destAccNumber+");");
                                                                            if(rs.first()) {
                                                                                preTotal = rs.getDouble("total");
                                                                                    if(smt.executeUpdate("update customers set Balance="+newSourceBal+" where AccountNumber="+user.AccountNumber+";") == 1) {
                                                                                            
                                                                                        if(smt.executeUpdate("update customers set Balance= (Balance + "+balance+") where AccountNumber="+destAccNumber+";") == 1) {
                                                                                            
                                                                                            rs = smt.executeQuery("select sum(Balance) as total from customers where AccountNumber in("+user.AccountNumber+","+destAccNumber+");");
                                                                                            if(rs.first())
                                                                                               if(preTotal == (rs.getDouble("total") - tax )) {
                                                                                                  JOptionPane.showMessageDialog(this,"Transaction of amount "+balance+" is made to Account Number "+destAccNumber,"Transaction Successful",JOptionPane.INFORMATION_MESSAGE);
                                                                                                    user.Balance = newSourceBal;
                                                                                                    mn.changeBal();
                                                                                                    setVisible(false);
                                                                                                }
                                                                                        }
                                                                                    }
                                                                            }
                                                                        }
                                                                        else {
                                                                            JOptionPane.showMessageDialog(this,"Acccount number does not exist","Invalid account number",JOptionPane.ERROR_MESSAGE);
                                                                        }
                                                                    }
                                                                    else { 
                                                                        JOptionPane.showMessageDialog(this,"You entered your own account number","Invalid account number",JOptionPane.ERROR_MESSAGE);
                                                                    } 
                                                                    }
                                                                  catch (SQLException ex) {
                                                                    Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
                                                                }
                                                        }
                                                       else {
                                                           JOptionPane.showMessageDialog(this,"Amount is more than overdraft limit","OverdraftLimit Exceeded",JOptionPane.ERROR_MESSAGE);
                                                       }
                                                }
                                                else if(result == JOptionPane.NO_OPTION){ // if user uses dosen't overdraft facility
                                                    JOptionPane.showMessageDialog(this,"Insufficient Balance","Transaction Cancelled",JOptionPane.ERROR_MESSAGE);
                                                }
                                                setVisible(false);
                                            }
                                            else {  // if there is sufficient balance in the account
                                                try {
                                                    //String checkdestAcc = "select AccountNumber from customers where AccountNumber=" + destAccNumber+";";
                                                    if(destAccNumber != user.AccountNumber) {
                                                        Statement smt = con.createStatement();
                                                        if(smt.executeQuery("select AccountNumber from customers where AccountNumber=" + destAccNumber+";").first()) {
                                                            Double preTotal = null;
                                                            ResultSet rs = smt.executeQuery("select sum(Balance) as total from customers where AccountNumber in("+user.AccountNumber+","+destAccNumber+");");
                                                            if(rs.first()) {
                                                                preTotal = rs.getDouble("total");
                                                                    if(smt.executeUpdate("update customers set Balance="+newSourceBal+" where AccountNumber="+user.AccountNumber+";") == 1) {
                                                                        
                                                                        if(smt.executeUpdate("update customers set Balance= (Balance + "+balance+") where AccountNumber="+destAccNumber+";") == 1) {
                                                                            
                                                                            rs = smt.executeQuery("select sum(Balance) as total from customers where AccountNumber in("+user.AccountNumber+","+destAccNumber+");");
                                                                            if(rs.first())
                                                                                if(preTotal == rs.getDouble("total")){
                                                                                    JOptionPane.showMessageDialog(this,"Transaction of amount "+balance+" is made to Account Number "+destAccNumber,"Transaction Successful",JOptionPane.INFORMATION_MESSAGE);
                                                                                    user.Balance = newSourceBal;
                                                                                    mn.changeBal();
                                                                                    setVisible(false);
                                                                                }
                                                                        }
                                                                    }
                                                            }
                                                        }
                                                        else {
                                                            JOptionPane.showMessageDialog(this,"Acccount number does not exist","Invalid account number",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                    else { 
                                                        JOptionPane.showMessageDialog(this,"You entered your own account number","Invalid account number",JOptionPane.ERROR_MESSAGE);
                                                    } 
                                                    }
                                                  catch (SQLException ex) {
                                                    Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        }
                                        else
                                            JOptionPane.showMessageDialog(this,"Please enter a valid account number","Invalid account number format",JOptionPane.ERROR_MESSAGE);
                                }
                                    else 
                                        JOptionPane.showMessageDialog(this,"Please enter a valid aamout","Invalid amount format",JOptionPane.ERROR_MESSAGE);
                                }    
                                catch(NumberFormatException nfe) {
                                    JOptionPane.showMessageDialog(this,"Please enter only numerical value","Invalid amount format",JOptionPane.ERROR_MESSAGE);
                                    System.out.println(nfe);
                                }
                            }
    }//GEN-LAST:event_transferbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountlbl;
    private javax.swing.JTextField amounttxt;
    private javax.swing.JLabel balancelbl;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JTextField destAcctxt;
    private javax.swing.JLabel sourceAcclbl;
    private javax.swing.JButton transferbtn;
    // End of variables declaration//GEN-END:variables
}
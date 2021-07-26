/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Faa
 */
public class loginTeacher extends javax.swing.JFrame {

    /**
     * Creates new form loginTeacher
     */
    public loginTeacher() {
        initComponents();
        
        //Meletakkan frame di tengah layar
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
       
        int x = d.width/2 - this.getSize().width/2;
        int y = d.height/2 - this.getSize().height/2;
        
        this.setLocation(x, y); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        butLog = new javax.swing.JLabel();
        fieldUser = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        butBack = new javax.swing.JLabel();
        fRAME = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("USERNAMAE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 80, 40));

        butLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login.png"))); // NOI18N
        butLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butLogMouseClicked(evt);
            }
        });
        getContentPane().add(butLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 100, 40));

        fieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUserActionPerformed(evt);
            }
        });
        getContentPane().add(fieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 510, 40));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 510, 30));

        butBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button kembali.png"))); // NOI18N
        butBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butBackMouseClicked(evt);
            }
        });
        getContentPane().add(butBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, 40));

        fRAME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manager.jpg"))); // NOI18N
        getContentPane().add(fRAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 740, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butBackMouseClicked
        //kembali ke halaman login
          new login ().show();
          this.dispose();
    }//GEN-LAST:event_butBackMouseClicked

    private void butLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butLogMouseClicked
        // inputan Username dan Password Manager
          if (fieldUser.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Isi Username Anda Terlebih Dahulu!!");
            fieldUser.requestFocus();
            
        }
        else if (pass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Isi Password Ands Terlebih Dahulu!!");
            pass.requestFocus();
        }
        else if (fieldUser.getText().contains("Admin")&& pass.getText().contains("12345")) {
            new menuAdmin ().show();
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Username dan Password Tidak Sesuai");
        }
    }//GEN-LAST:event_butLogMouseClicked

    private void fieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUserActionPerformed

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
            java.util.logging.Logger.getLogger(loginTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel butBack;
    private javax.swing.JLabel butLog;
    private javax.swing.JLabel fRAME;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}

package com.soycj.shopassist.views;
import javax.swing.*;

public class WelcomeForm extends javax.swing.JFrame {

    public WelcomeForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHOPASSIST");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("¡BIENVENIDOS!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, 89));

        btnContinuar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        btnList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnList.setText("Lista de Compras");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });
        getContentPane().add(btnList, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        new SalesForm().setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        new ListForm().setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnListActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnList;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

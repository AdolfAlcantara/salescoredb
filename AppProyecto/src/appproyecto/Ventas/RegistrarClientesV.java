/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appproyecto.Ventas;

import Ventas.Clientes;
import appproyecto.MainV;

/**
 *
 * @author FuryCoder
 */
public class RegistrarClientesV extends javax.swing.JPanel {
    Clientes cli  = new Ventas.Clientes();
    /**
     * Creates new form RegistrarProveedorV
     */
    public RegistrarClientesV() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameF = new javax.swing.JTextField();
        streetF = new javax.swing.JTextField();
        cityF = new javax.swing.JTextField();
        avenueF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        regactB = new javax.swing.JButton();
        backB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        codeF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        deleteB = new javax.swing.JButton();

        nameF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFActionPerformed(evt);
            }
        });

        streetF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetFActionPerformed(evt);
            }
        });

        cityF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFActionPerformed(evt);
            }
        });

        avenueF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avenueFActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Ciudad:");

        jLabel3.setText("Calle:");

        jLabel4.setText("Avenida:");

        regactB.setText("Registrar/Actualizar");
        regactB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regactBMouseClicked(evt);
            }
        });

        backB.setText("Regresar");
        backB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("REGISTRO O ACTUALIZACION DE DATOS DE CLIENTE");

        codeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFActionPerformed(evt);
            }
        });

        jLabel6.setText("Codigo:");

        deleteB.setText("Eliminar");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteB)
                        .addGap(18, 18, 18)
                        .addComponent(regactB)
                        .addGap(18, 18, 18)
                        .addComponent(backB)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codeF, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avenueF, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityF, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetF, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameF, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avenueF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regactB)
                    .addComponent(backB)
                    .addComponent(deleteB))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFActionPerformed

    private void streetFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetFActionPerformed

    private void cityFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityFActionPerformed

    private void avenueFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avenueFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avenueFActionPerformed

    private void regactBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regactBMouseClicked
        String code = codeF.getText();
        String name = nameF.getText();
        String city = cityF.getText();
        int street, ave;
        street = Integer.parseInt(streetF.getText());
        ave = Integer.parseInt(avenueF.getText());
        if(code.equals("")){
            cli.regtClientes(name, city, ave, street);
            
        }else{
            cli.actClientes(code, name, city, ave, street);
        }
        codeF.setText("");
        nameF.setText("");
        cityF.setText("");
        avenueF.setText("");
        streetF.setText("");
    }//GEN-LAST:event_regactBMouseClicked

    private void codeFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeFActionPerformed

    private void backBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBMouseClicked
        MainV.SETPANEL(new mainVentas());
    }//GEN-LAST:event_backBMouseClicked

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        String code = codeF.getText();
        codeF.setText("");
    }//GEN-LAST:event_deleteBActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField avenueF;
    private javax.swing.JButton backB;
    private javax.swing.JTextField cityF;
    private javax.swing.JTextField codeF;
    private javax.swing.JButton deleteB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameF;
    private javax.swing.JButton regactB;
    private javax.swing.JTextField streetF;
    // End of variables declaration//GEN-END:variables
}

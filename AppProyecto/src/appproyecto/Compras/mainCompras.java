/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appproyecto.Compras;

import appproyecto.MainMenu;
import appproyecto.MainV;

/**
 *
 * @author alejandro
 */
public class mainCompras extends javax.swing.JPanel {

    /**
     * Creates new form mainCompras
     */
    public mainCompras() {
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

        bProveedores = new javax.swing.JButton();
        bProductos = new javax.swing.JButton();
        bDocumentos = new javax.swing.JButton();
        bRegreso = new javax.swing.JButton();
        bOrdenC = new javax.swing.JButton();

        bProveedores.setText("Proveedores");
        bProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bProveedoresMousePressed(evt);
            }
        });

        bProductos.setText("Productos");
        bProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bProductosMousePressed(evt);
            }
        });

        bDocumentos.setText("Documentos");
        bDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDocumentosActionPerformed(evt);
            }
        });

        bRegreso.setText("Regresar");
        bRegreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bRegresoMousePressed(evt);
            }
        });

        bOrdenC.setText("Orden de compras");
        bOrdenC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bOrdenCMousePressed(evt);
            }
        });
        bOrdenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bRegreso)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bOrdenC, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(bProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bOrdenC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(bRegreso)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bRegresoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRegresoMousePressed
        MainV.SETPANEL(new MainMenu());
    }//GEN-LAST:event_bRegresoMousePressed

    private void bProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bProveedoresMousePressed
        MainV.SETPANEL(new ProveedoresV());
    }//GEN-LAST:event_bProveedoresMousePressed

    private void bProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bProductosMousePressed
        MainV.SETPANEL(new ProductosV());
    }//GEN-LAST:event_bProductosMousePressed

    private void bOrdenCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOrdenCMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bOrdenCMousePressed

    private void bOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenCActionPerformed
        MainV.SETPANEL(new OrdenComprasV());
    }//GEN-LAST:event_bOrdenCActionPerformed

    private void bDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDocumentosActionPerformed
        MainV.SETPANEL(new DocumentosV());
    }//GEN-LAST:event_bDocumentosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDocumentos;
    private javax.swing.JButton bOrdenC;
    private javax.swing.JButton bProductos;
    private javax.swing.JButton bProveedores;
    private javax.swing.JButton bRegreso;
    // End of variables declaration//GEN-END:variables
}

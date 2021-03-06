/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.AdministrativeRole;

import Business.PharmaDirectory;
import Business.Store;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class StoreAdminWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form StoreAdminWorkAreaPanel
     */
    Store store;
    JPanel userProcessContainer;
    PharmaDirectory pharmaDirectory;

    public StoreAdminWorkAreaPanel(JPanel upc, Store s,PharmaDirectory pd) {
        initComponents();
        userProcessContainer = upc;
        store = s;
        pharmaDirectory=pd;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtManageDrugInventory = new javax.swing.JButton();
        btnInventoryReport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtManageDrugInventory.setText("Manage Drug Inventory");
        txtManageDrugInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManageDrugInventoryActionPerformed(evt);
            }
        });
        add(txtManageDrugInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 80, 166, -1));

        btnInventoryReport.setText("Inventory report");
        btnInventoryReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryReportActionPerformed(evt);
            }
        });
        add(btnInventoryReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 114, 166, -1));

        jButton1.setText("<<back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Store Admin Work Area Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 21, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtManageDrugInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManageDrugInventoryActionPerformed
        // TODO add your handling code here:
        ManageInventoryJPanel panel = new ManageInventoryJPanel(userProcessContainer, store,pharmaDirectory);
        userProcessContainer.add("ManageInventoryJPanel", panel);
        CardLayout cradlayout = (CardLayout) userProcessContainer.getLayout();
        cradlayout.next(userProcessContainer);
    }//GEN-LAST:event_txtManageDrugInventoryActionPerformed

    private void btnInventoryReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryReportActionPerformed
        // TODO add your handling code here:
        InventoryReportJPanel panel=new InventoryReportJPanel(userProcessContainer,store.getInventory());
        userProcessContainer.add("ManageInventoryJPanel", panel);
        CardLayout cradlayout = (CardLayout) userProcessContainer.getLayout();
        cradlayout.next(userProcessContainer);

    }//GEN-LAST:event_btnInventoryReportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInventoryReport;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton txtManageDrugInventory;
    // End of variables declaration//GEN-END:variables
}

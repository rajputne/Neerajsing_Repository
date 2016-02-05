/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Person;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class ViewPersonJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;

    Person person;

    /**
     * Creates new form ViewPersonJPanel
     */
    public ViewPersonJPanel(JPanel upc, Person p) {
        initComponents();
        person = p;
        userProcessContainer = upc;
        populateForm();
        setComponentsEnabled(false);
        btnSavePersonProfile.setEnabled(false);
    }

    public void setComponentsEnabled(boolean isEnabled) {
        txtPersonAge.setEnabled(isEnabled);
        txtPersonName.setEnabled(isEnabled);
    }

    public void populateForm() {
        txtPersonAge.setText(String.valueOf(person.getAge()));
        txtPersonName.setText(person.getPersonName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPersonName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPersonAge = new javax.swing.JTextField();
        btnSavePersonProfile = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setText("<<back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 225, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("View Person");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 33, -1, -1));

        jLabel2.setText("Person name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 76, -1, -1));
        add(txtPersonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 73, 92, -1));

        jLabel3.setText("Person Age");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 119, -1, -1));
        add(txtPersonAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 116, 92, -1));

        btnSavePersonProfile.setText("Save");
        btnSavePersonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePersonProfileActionPerformed(evt);
            }
        });
        add(btnSavePersonProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 167, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 167, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        //This helps layout manager pointing to the next layout
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSavePersonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePersonProfileActionPerformed
        // TODO add your handling code here:
        String personName = txtPersonName.getText();

        int age = -1;
        try {
            age = Integer.parseInt(txtPersonAge.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter return value ");
            return;
        }
        person.setPersonName(personName);
        person.setAge(age);
        JOptionPane.showMessageDialog(null, "Person information updated Successfully!!!");
    }//GEN-LAST:event_btnSavePersonProfileActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        setComponentsEnabled(true);
        btnSavePersonProfile.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed
    public void refreshTable() {
        int index = userProcessContainer.getComponentCount() - 1;
        ManagePersonJPanel panel = (ManagePersonJPanel) userProcessContainer.getComponent(index);
        panel.populateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSavePersonProfile;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPersonAge;
    private javax.swing.JTextField txtPersonName;
    // End of variables declaration//GEN-END:variables
}
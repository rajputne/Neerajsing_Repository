/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Person;
import Business.PersonDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class CreatePersonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePersonJPanel
     */
    JPanel userProcessContainer;
    PersonDirectory personDirectory;

    public CreatePersonJPanel(JPanel upc, PersonDirectory pd) {
        userProcessContainer = upc;
        personDirectory = pd;

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPersonName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPersonAge = new javax.swing.JTextField();
        btnCreatePersonProfile = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Create Person");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 33, -1, -1));

        jLabel2.setText("Person name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 76, -1, -1));
        add(txtPersonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 73, 80, -1));

        jLabel3.setText("Person Age");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 119, -1, -1));
        add(txtPersonAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 116, 80, -1));

        btnCreatePersonProfile.setText("Create");
        btnCreatePersonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePersonProfileActionPerformed(evt);
            }
        });
        add(btnCreatePersonProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 167, -1, -1));

        btnBack.setText("<<back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 225, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatePersonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePersonProfileActionPerformed
        // TODO add your handling code here:
        String personName = txtPersonName.getText();
        int age = -1;
        try {
            age = Integer.parseInt(txtPersonAge.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter return value ");
            return;
        }
        boolean personNameAlreadyPresent = false;

        for (Person p : personDirectory.getPersonList()) {
            if (personName.equals(p.getPersonName())) {
                personNameAlreadyPresent = true;
            } else {
                personNameAlreadyPresent = false;
            }
            
        }
        if (personNameAlreadyPresent) {
            JOptionPane.showMessageDialog(null, "Person already present");
        } else {
            Person person = personDirectory.createPerson();
            person.setPersonName(personName);
            person.setAge(age);
            JOptionPane.showMessageDialog(null, "Person information stored Successfully!!!");
        }
    }//GEN-LAST:event_btnCreatePersonProfileActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        //This helps layout manager pointing to the next layout
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreatePersonProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPersonAge;
    private javax.swing.JTextField txtPersonName;
    // End of variables declaration//GEN-END:variables
}

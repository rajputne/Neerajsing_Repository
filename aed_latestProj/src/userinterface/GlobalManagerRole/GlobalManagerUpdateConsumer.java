/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GlobalManagerRole;

import Business.EcoSystem;
import Business.Employee.Consumer.Consumer;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.GlobalEnergy.GlobalManagerOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.Utils.MyStringVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author neera
 */
public class GlobalManagerUpdateConsumer extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private GlobalManagerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem busines;
    private Consumer consumer;

    /**
     * Creates new form GlobalManagerUpdateConsumer
     */
    public GlobalManagerUpdateConsumer(JPanel userProcessContainer, UserAccount account, GlobalManagerOrganization organization, Enterprise enterprise, EcoSystem busines, Consumer consumer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.busines = busines;
        this.consumer = consumer;
        populateTextBox();
    }

    public void populateTextBox() {
        txtName.setText(consumer.getName());
        txtAreaAddress.setText(consumer.getAddress());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaAddress = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 366, 131, -1));

        txtAreaAddress.setColumns(20);
        txtAreaAddress.setRows(5);
        jScrollPane1.setViewportView(txtAreaAddress);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 182, 230, -1));

        jLabel2.setText("Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 143, -1, -1));

        btnBack.setText("<<back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 366, -1, -1));

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 140, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Update Consumer to the System");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 33, -1, -1));

        jLabel5.setText("Address:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 182, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        MyStringVerifier stringVerify = new MyStringVerifier();

        if (stringVerify.verify(txtName));
        {
            String name = txtName.getText();
            String address = txtAreaAddress.getText();

            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Addess is must have field");
                return;
            }

            consumer.setName(name);

            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (org instanceof ConsumerOrganization) {
                    for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                        if (emp instanceof Consumer) {
                            if (!checkAdress(address)) {
                                consumer.setAddress(address);
                                org.getEmployeeDirectory().updateConsumer(consumer);
                                //org.getUserAccountDirectory().updateUserAccount(userAccount);
                                JOptionPane.showMessageDialog(null, "The Consumer is updated");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Address match !! cant update");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        GlobalManagerWorkAreaJPanel dwjp = (GlobalManagerWorkAreaJPanel) component;
        dwjp.populateConsumerTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    public boolean checkAdress(String address) {
        boolean flag = false;
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ConsumerOrganization) {
                //Adding Consumer to the Employee Directory
                for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                    //org.getEmployeeDirectory().createConsumer(name, address);
                    //Creating Consumer Account
                    if (emp instanceof Consumer) {
                        if (address.equals(((Consumer) emp).getAddress())) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                    }
                }
            }
        }
        return flag;
    }
    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
        if (txtName.getText().length() >= 20) {
            txtName.setText(txtName.getText().substring(0, 19));
        }
    }//GEN-LAST:event_txtNameKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaAddress;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

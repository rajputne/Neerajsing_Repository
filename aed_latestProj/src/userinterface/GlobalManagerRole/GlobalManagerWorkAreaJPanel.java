/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GlobalManagerRole;

import Business.EcoSystem;
import Business.Employee.Consumer.Consumer;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.GlobalEnergy.GlobalManagerOrganization;
import Business.Organization.LocalEnergy.LocalManagerEnergyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ConsumerRequests.RequestsFromConsumer;
import Business.WorkQueue.GlobalManagerToLocalManager.SetConsumerWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class GlobalManagerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private GlobalManagerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    Consumer consumer;
    SetConsumerWorkRequest setConsumerWorkrequest;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public GlobalManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, GlobalManagerOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        valueLabel.setText(enterprise.getName());
        consumer = new Consumer();
        setConsumerWorkrequest = new SetConsumerWorkRequest();
        populateRequestTable();

        populateConsumerTable();
    }

    public void populateConsumerTable() {
        DefaultTableModel model = (DefaultTableModel) consumerTable.getModel();

        model.setRowCount(0);
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ConsumerOrganization) {
                for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                    //Object should be passed
                    if (emp instanceof Consumer) {
                        {
                            //consumer = ((Consumer) emp);
                            Object[] row = new Object[2];
                            row[0] = ((Consumer) emp);
                            row[1] = ((Consumer) emp).getAddress();
                            model.addRow(row);

                        }
                    }

                }
            }
        }

    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];

            row[0] = ((SetConsumerWorkRequest) request).getConsumer();
            row[1] = ((SetConsumerWorkRequest) request).getConsumer().getAddress();
            row[2] = request.getMessage();
            row[3] = request.getSender();
            row[4] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[5] = request.getStatus();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        consumerTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnAddConsumer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consumerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(consumerTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 113, 720, 138));

        requestTestJButton.setText("Send");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 260, -1, -1));

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 511, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 27, 168, 30));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 27, 158, 26));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Send Consumer to the Local Organizations");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 307, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 260, -1, -1));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Message", "Sender", "Reciever", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(3).setHeaderValue("Sender");
            workRequestJTable.getColumnModel().getColumn(4).setHeaderValue("Reciever");
            workRequestJTable.getColumnModel().getColumn(5).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(5).setHeaderValue("Status");
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 345, 720, 138));

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 260, -1, -1));

        btnAddConsumer.setText("Add");
        btnAddConsumer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddConsumerActionPerformed(evt);
            }
        });
        add(btnAddConsumer, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 260, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Consumer Management Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 75, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        int selectedRow = consumerTable.getSelectedRow();
        setConsumerWorkrequest = new SetConsumerWorkRequest();
        if (selectedRow < 0) {
            return;
        }
        Consumer selectedConsumer = (Consumer) consumerTable.getValueAt(selectedRow, 0);

        if (checkIfConsumerIsAlreadySent(selectedConsumer)) {
            JOptionPane.showMessageDialog(null, "Consumer found in the Work queue");
        } else {
            consumerAddRequest(selectedConsumer, setConsumerWorkrequest);
            JOptionPane.showMessageDialog(null, "Consumer not found in the work queues");
        }
        populateRequestTable();

    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private boolean checkIfConsumerIsAlreadySent(Consumer selectedConsumer) {
        Boolean isConsumerPresentInTheLocalManagerWorkQueue = false;
        Organization org = null;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getEnterpriseType() == Enterprise.EnterpriseType.LocalEnergy) {
                    {
                        for (Organization organiz : e.getOrganizationDirectory().getOrganizationList()) {
                            if (organiz instanceof LocalManagerEnergyOrganization) {
                                org = organiz;
                                for (WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                                    if (wr instanceof SetConsumerWorkRequest) {
                                        //Consumer Found here
                                        if (selectedConsumer == ((SetConsumerWorkRequest) wr).getConsumer()) {
                                            ((SetConsumerWorkRequest) wr).setConsumer(selectedConsumer);
                                            JOptionPane.showMessageDialog(null, "Updating Details of New Consumer in the work request!");
                                            isConsumerPresentInTheLocalManagerWorkQueue = true;
                                        } else {
                                            isConsumerPresentInTheLocalManagerWorkQueue = false;
                                        }
                                    }

                                }

                            }
                        }
                    }
                }
            }

        }
        return isConsumerPresentInTheLocalManagerWorkQueue;

    }

    private void RemoveConsumerFromWorkQueue1(Consumer selectedConsumer) {
        Boolean flag = false;
        Organization org = null;
        WorkRequest workReq = null;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getEnterpriseType() == Enterprise.EnterpriseType.LocalEnergy) {
                    {
                        for (Organization organiz : e.getOrganizationDirectory().getOrganizationList()) {
                            if (organiz instanceof LocalManagerEnergyOrganization) {
                                org = organiz;

                                for (WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                                    if (wr instanceof RequestsFromConsumer) {
                                        //Consumer Found here
                                        if (selectedConsumer == ((RequestsFromConsumer) wr).getConsumer()) {
                                            workReq = wr;
                                            flag = true;
                                            JOptionPane.showMessageDialog(null, "His request for local Energy deleted");
                                        }

                                    }
                                }
                                if (flag = true) {
                                    org.getWorkQueue().getWorkRequestList().remove(workReq);
                                    userAccount.getWorkQueue().getWorkRequestList().remove(workReq);
                                    JOptionPane.showMessageDialog(null, "Removing consumer from work queue!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Consumer not found in work queue!");
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    private void RemoveConsumerFromWorkQueue(Consumer selectedConsumer) {
        Boolean flag = false;
        Organization org = null;
        WorkRequest workReq = null;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getEnterpriseType() == Enterprise.EnterpriseType.LocalEnergy) {
                    {
                        for (Organization organiz : e.getOrganizationDirectory().getOrganizationList()) {
                            if (organiz instanceof LocalManagerEnergyOrganization) {
                                org = organiz;

                                for (WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                                    if (wr instanceof SetConsumerWorkRequest) {
                                        //Consumer Found here
                                        if (selectedConsumer == ((SetConsumerWorkRequest) wr).getConsumer()) {
                                            workReq = wr;
                                            flag = true;
                                        }

                                    }
                                }
                                if (flag = true) {
                                    org.getWorkQueue().getWorkRequestList().remove(workReq);
                                    userAccount.getWorkQueue().getWorkRequestList().remove(workReq);
                                    JOptionPane.showMessageDialog(null, "Removing consumer from work queue!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Consumer not found in work queue!");
                                }
                            }
                        }
                    }
                }
            }

        }

    }
    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();
        populateConsumerTable();

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    public void consumerAddRequest(Consumer consumer, SetConsumerWorkRequest request) {

        request.setMessage("Please Add the consumer to Local Area");
        request.setSender(userAccount);
        request.setStatus("Sent");
        //request.setUserAccountOfConsumer(userAccount);
        request.setRequestDate(new Date());

        request.setConsumer(consumer);

        Organization org = null;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getEnterpriseType() == Enterprise.EnterpriseType.LocalEnergy) {
                    {
                        for (Organization organiz : e.getOrganizationDirectory().getOrganizationList()) {
                            if (organiz instanceof LocalManagerEnergyOrganization) {
                                org = organiz;
                                org.getWorkQueue().getWorkRequestList().add(request);
                                JOptionPane.showMessageDialog(null, "Sending to Local Energy");
                            }
                        }
                    }
                }
            }

        }
        userAccount.getWorkQueue().getWorkRequestList().add(request);
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = consumerTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
        Consumer selectedConsumer = (Consumer) consumerTable.getValueAt(selectedRow, 0);

        GlobalManagerUpdateConsumer globalManagerUpdateConsumer = new GlobalManagerUpdateConsumer(userProcessContainer, userAccount, organization, enterprise, business, selectedConsumer);
        userProcessContainer.add("globalManagerUpdateConsumer", globalManagerUpdateConsumer);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddConsumerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddConsumerActionPerformed
        // TODO add your handling code here:

        GlobalManagerAddConsumer globalManagerUpdateConsumer = new GlobalManagerAddConsumer(userProcessContainer, userAccount, organization, enterprise, business, consumer, setConsumerWorkrequest);
        userProcessContainer.add("globalManagerUpdateConsumer", globalManagerUpdateConsumer);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnAddConsumerActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = consumerTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
        Consumer selectedConsumer = (Consumer) consumerTable.getValueAt(selectedRow, 0);
        UserAccount removeUserAccount = null;
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ConsumerOrganization) {

                org.getEmployeeDirectory().removeConsumer(selectedConsumer);
                RemoveConsumerFromWorkQueue(selectedConsumer);
                RemoveConsumerFromWorkQueue1(selectedConsumer);
                for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                    if (ua.getEmployee().equals((Employee) selectedConsumer)) {
                        removeUserAccount = ua;
                    }
                }
                org.getUserAccountDirectory().getUserAccountList().remove(removeUserAccount);

            }
        }

        populateConsumerTable();
        populateRequestTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddConsumer;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable consumerTable;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ConsumerRole;

import Business.EcoSystem;
import Business.Employee.Consumer.Consumer;
import Business.Enterprise.Enterprise;
import Business.LocalEnergy.CommunitySensor;
import Business.Network.Network;
import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.LocalEnergy.LocalManagerEnergyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ConsumerRequests.CommunitySensorForConsumer;
import Business.WorkQueue.ConsumerRequests.RequestsFromConsumer;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author neera
 */
public class ConsumerWorkAreaPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ConsumerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private CommunitySensor commSensor;
    private Consumer consumer;

    /**
     * Creates new form ConsumerWorkAreaPanel
     */
    public ConsumerWorkAreaPanel(JPanel userProcessContainer, UserAccount account, ConsumerOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        commSensor = new CommunitySensor();
        consumer = new Consumer();
        populateRequestTable();
        ExtractWorkRequest();
        getMySelf();
        populateRequestTable();
        populateCommunitySensor();

    }

    public void ExtractWorkRequest() {
        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof CommunitySensorForConsumer) {
                commSensor = ((CommunitySensorForConsumer) wr).getCommunitySensor();
                int numberOfBatteries = commSensor.getLocalEnergy().getLocalAreabattery().getLocalbatteryList().size();
                System.out.print(numberOfBatteries);
            }
        }
    }

    //Initializes the Consumer 
    public void getMySelf() {
        consumer = (Consumer) userAccount.getEmployee();
        System.out.println(consumer.getName());

    }

    public void getMySelfFromTheAdmin(Consumer co) {

        System.out.println(co.getAddress());
        System.out.println(co.getConsumerId());
        System.out.println(co.getSensor().getUniqueSensorId());
        //String message = consumer.getSensor().smartSwitch(commSensor);
        //System.out.println(message);
    }

    public void populateCommunitySensor() {
        DefaultTableModel model = (DefaultTableModel) communitySensorTable.getModel();
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof CommunitySensorForConsumer) {
                Object[] row = new Object[4];
                row[0] = request;

                row[1] = request.getStatus();

                //String result = request.getTestResult();
                row[2] = request.getSender();
                model.addRow(row);
            }
        }
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof RequestsFromConsumer) {
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getReceiver();
                row[2] = request.getStatus();

                //String result = request.getTestResult();
                row[3] = request.getSender();

                model.addRow(row);
            }
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

        jLabel1 = new javax.swing.JLabel();
        btnViewMonthlyBill = new javax.swing.JButton();
        btnGlobalEnergyConsumption = new javax.swing.JButton();
        btnCallLocalMaintainence = new javax.swing.JButton();
        btnCallGlobal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnRequestLocalEnergy = new javax.swing.JButton();
        btnConnectDevices = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        communitySensorTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnSelectComunitySensor = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Consumer Work Area Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        btnViewMonthlyBill.setText("View My Monthly Bill");
        btnViewMonthlyBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMonthlyBillActionPerformed(evt);
            }
        });
        add(btnViewMonthlyBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 660, 191, -1));

        btnGlobalEnergyConsumption.setText("Check Global Energy Consumption");
        btnGlobalEnergyConsumption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGlobalEnergyConsumptionActionPerformed(evt);
            }
        });
        add(btnGlobalEnergyConsumption, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, -1, -1));

        btnCallLocalMaintainence.setText("Call Local Maintainence");
        btnCallLocalMaintainence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallLocalMaintainenceActionPerformed(evt);
            }
        });
        add(btnCallLocalMaintainence, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 590, 210, -1));

        btnCallGlobal.setText("Call Global Maintainence");
        btnCallGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallGlobalActionPerformed(evt);
            }
        });
        add(btnCallGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 590, -1, -1));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Receiver", "Status", "Sender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 133, 721, 93));

        btnRequestLocalEnergy.setText("Request Local Energy");
        btnRequestLocalEnergy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestLocalEnergyActionPerformed(evt);
            }
        });
        add(btnRequestLocalEnergy, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 249, -1, -1));

        btnConnectDevices.setText("Connect to Energy");
        btnConnectDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectDevicesActionPerformed(evt);
            }
        });
        add(btnConnectDevices, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, 60));

        communitySensorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(communitySensorTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 334, 743, 108));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Request to Local Managers Table");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 93, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Community Sensor alloted to you Table");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 296, -1, -1));

        btnSelect.setText("Select for udating your details");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 249, 258, -1));

        btnSelectComunitySensor.setText("Select Community Sensor");
        btnSelectComunitySensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectComunitySensorActionPerformed(evt);
            }
        });
        add(btnSelectComunitySensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 460, 333, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGlobalEnergyConsumptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGlobalEnergyConsumptionActionPerformed
        // TODO add your handling code here:
        GlobalEnergyConsumptionJPanel globalEnergyConsumptionJPanel = new GlobalEnergyConsumptionJPanel(userProcessContainer, consumer, organization, enterprise, business);
        userProcessContainer.add("consumerAddDevice", globalEnergyConsumptionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnGlobalEnergyConsumptionActionPerformed

    private void btnRequestLocalEnergyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestLocalEnergyActionPerformed
        // TODO add your handling code here:

        RequestsFromConsumer request = new RequestsFromConsumer();
        request.setConsumer(consumer);
        request.setSender(userAccount);
        request.setMessage("Please Connect me to Community Sensor");
        Organization org = null;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getEnterpriseType() == Enterprise.EnterpriseType.LocalEnergy) {
                    e.getWorkQueue().getWorkRequestList().add(request);
                }
                for (Organization organiz : e.getOrganizationDirectory().getOrganizationList()) {
                    if (organiz instanceof LocalManagerEnergyOrganization) {
                        org = organiz;
                        org.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        JOptionPane.showMessageDialog(null, "Request for Local Energy Sent");
                    }
                }
            }
        }
        populateRequestTable();
    }//GEN-LAST:event_btnRequestLocalEnergyActionPerformed

    private void btnConnectDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectDevicesActionPerformed
        // TODO add your handling code here:
        ConsumerConnectToElectricty consumerAddDevice = new ConsumerConnectToElectricty(userProcessContainer, consumer, organization, enterprise, business, commSensor);
        userProcessContainer.add("consumerAddDevice", consumerAddDevice);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnConnectDevicesActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
        RequestsFromConsumer request = (RequestsFromConsumer) workRequestJTable.getValueAt(selectedRow, 0);
        consumer = request.getConsumer();
        // getMySelfFromTheAdmin(consumer);
        JOptionPane.showMessageDialog(null, "Your Local Area Code is " + consumer.getLocalAreaCode());
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnSelectComunitySensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectComunitySensorActionPerformed
        // TODO add your handling code here:
        int selectedRow = communitySensorTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
        CommunitySensorForConsumer request = (CommunitySensorForConsumer) communitySensorTable.getValueAt(selectedRow, 0);

        commSensor = request.getCommunitySensor();
        request.setStatus("Recived by" + consumer.getName());

        JOptionPane.showMessageDialog(null, "The community sensor has battery number" + commSensor.getLocalEnergy().getLocalAreabattery().getLocalbatteryList().size());
    }//GEN-LAST:event_btnSelectComunitySensorActionPerformed

    private void btnViewMonthlyBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMonthlyBillActionPerformed
        // TODO add your handling code here:
        ViewCurrentMonthBillJPanel viewCurrentMonthBill = new ViewCurrentMonthBillJPanel(userProcessContainer, userAccount, consumer, organization, enterprise, business);
        userProcessContainer.add("viewCurrentMonthBill", viewCurrentMonthBill);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewMonthlyBillActionPerformed

    private void btnCallLocalMaintainenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallLocalMaintainenceActionPerformed
        // TODO add your handling code here:
        LocalMaintainenceWorkRequestJPanel localMaintainenceWorkRequestJPanel = new LocalMaintainenceWorkRequestJPanel(userProcessContainer, userAccount, consumer, organization, enterprise, business);
        userProcessContainer.add("localMaintainenceWorkRequestJPanel", localMaintainenceWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCallLocalMaintainenceActionPerformed

    private void btnCallGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallGlobalActionPerformed
        // TODO add your handling code here:
        GlobalMaintainenceWorkRequest globalMaintainenceWorkRequest = new GlobalMaintainenceWorkRequest(userProcessContainer, userAccount, consumer, organization, enterprise, business);
        userProcessContainer.add("globalMaintainenceWorkRequest", globalMaintainenceWorkRequest);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCallGlobalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCallGlobal;
    private javax.swing.JButton btnCallLocalMaintainence;
    private javax.swing.JButton btnConnectDevices;
    private javax.swing.JButton btnGlobalEnergyConsumption;
    private javax.swing.JButton btnRequestLocalEnergy;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSelectComunitySensor;
    private javax.swing.JButton btnViewMonthlyBill;
    private javax.swing.JTable communitySensorTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
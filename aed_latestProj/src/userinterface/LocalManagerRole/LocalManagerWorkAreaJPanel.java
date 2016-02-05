/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LocalManagerRole;

import Business.Employee.Consumer.Battery;
import Business.LocalEnergy.CommunitySensor;
import Business.Employee.Consumer.ConsumerBattery;
import Business.EcoSystem;
import Business.Employee.Consumer.Sensor;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.LocalEnergy.LocalAreaOrganization;
import Business.Organization.LocalEnergy.LocalManagerEnergyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ConsumerRequests.RequestsFromConsumer;
import Business.WorkQueue.GlobalManagerToLocalManager.SetConsumerWorkRequest;
import Business.WorkQueue.LocalOrganizationToLocalManager.LocalOrganizationToLocalManagerSetLocalEnergyWR;
import Business.WorkQueue.ConsumerRequests.CommunitySensorForConsumer;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class LocalManagerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private LocalManagerEnergyOrganization LocalOrganization;
    LocalOrganizationToLocalManagerSetLocalEnergyWR setLocalEnergyToCommSensor;
    private UserAccount userAccountOfConsumer;
    private CommunitySensor communitySensor;
    private SetConsumerWorkRequest setConsumerWorkRequest;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public LocalManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization Organization, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;

        this.LocalOrganization = (LocalManagerEnergyOrganization) Organization;
        userAccountOfConsumer = new UserAccount();
        setConsumerWorkRequest = new SetConsumerWorkRequest();
        setLocalEnergyToCommSensor = new LocalOrganizationToLocalManagerSetLocalEnergyWR();
        communitySensor = LocalOrganization.getCommunitySensor();

        populateConsumerTable();
        populateWorkRequestForLocalEnergy();
        populateWorkRequestComingFromConsumer();
        populateWorkGoingToFromConsumer();
    }

    public void populateWorkRequestComingFromConsumer() {
        DefaultTableModel model = (DefaultTableModel) consumerRequesttbl.getModel();

        model.setRowCount(0);

        for (WorkRequest request : LocalOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof RequestsFromConsumer) {
                Object[] row = new Object[5];
                row[0] = request;

                row[1] = ((RequestsFromConsumer) request).getConsumer().getName();
                row[2] = request.getSender();

                row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[4] = request.getStatus();

                model.addRow(row);
            }

        }

    }

    public void populateWorkGoingToFromConsumer() {
        DefaultTableModel model = (DefaultTableModel) consumerRequesttbl1.getModel();

        model.setRowCount(0);

        for (WorkRequest request : LocalOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof RequestsFromConsumer) {
                Object[] row = new Object[6];
                row[0] = request;
                row[1] = ((RequestsFromConsumer) request).getConsumer().getName();
                row[2] = ((RequestsFromConsumer) request).getConsumer().getAddress();
                row[3] = request.getSender();

                row[4] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[5] = request.getStatus();

                model.addRow(row);
            }

        }

    }

    public void populateWorkRequestForLocalEnergy() {
        DefaultTableModel model = (DefaultTableModel) LocalOrganiztionRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : LocalOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof LocalOrganizationToLocalManagerSetLocalEnergyWR) {
                Object[] row = new Object[5];

                row[0] = ((LocalOrganizationToLocalManagerSetLocalEnergyWR) request).getLocalEnergy().getLocalAreabattery().getLocalbatteryList().size();
                row[1] = request;
                row[2] = request.getSender();
                row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[4] = request.getStatus();

                model.addRow(row);
            }
        }
    }

    public void populateConsumerTable() {
        DefaultTableModel model = (DefaultTableModel) consumerListWorkRequestFromGlobal.getModel();

        model.setRowCount(0);

        for (WorkRequest request : LocalOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof SetConsumerWorkRequest) {
                Object[] row = new Object[8];
                row[0] = ((SetConsumerWorkRequest) request);
                row[1] = ((SetConsumerWorkRequest) request).getConsumer();
                row[2] = request;
                row[3] = request.getSender();
                row[4] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[5] = request.getStatus();
                row[6] = ((SetConsumerWorkRequest) request).getConsumer().getLocalAreaCode();
                row[7] = ((SetConsumerWorkRequest) request).getConsumer().getConsumerId();

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

        jScrollPane1 = new javax.swing.JScrollPane();
        LocalOrganiztionRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAssignConsumerToCommunitySensor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        consumerRequesttbl = new javax.swing.JTable();
        btnAssign2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        consumerListWorkRequestFromGlobal = new javax.swing.JTable();
        btnProcessConsumer = new javax.swing.JButton();
        btnGetUserDetails = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        consumerRequesttbl1 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LocalOrganiztionRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Battery", "Message", "Sender", "Reciever", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(LocalOrganiztionRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 940, 96));

        assignJButton.setText("Assign Battery to community");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 250, 250, 30));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Step3 Select the Consumer whom you want to assign local parameters");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        btnAssignConsumerToCommunitySensor.setText("Assign sensor to user");
        btnAssignConsumerToCommunitySensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignConsumerToCommunitySensorActionPerformed(evt);
            }
        });
        add(btnAssignConsumerToCommunitySensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 440, 250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Step 2. Choose Local Area Battery for a consumer");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        consumerRequesttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Consumer Name", "Sender", "Reciever", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(consumerRequesttbl);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 940, 96));

        btnAssign2.setText("Inform User");
        btnAssign2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssign2ActionPerformed(evt);
            }
        });
        add(btnAssign2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 610, 240, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Local Manager Work Area Panel");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        consumerListWorkRequestFromGlobal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Message", "Sender", "Reciever", "Status", "Local Code", "Consumer Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(consumerListWorkRequestFromGlobal);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 940, 96));

        btnProcessConsumer.setText("Process Consumer");
        btnProcessConsumer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessConsumerActionPerformed(evt);
            }
        });
        add(btnProcessConsumer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, 250, 30));

        btnGetUserDetails.setText("Get User Details");
        btnGetUserDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetUserDetailsActionPerformed(evt);
            }
        });
        add(btnGetUserDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 250, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Step 1: Select the consumer whom you want to assign local Energy");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Step 4 Inform the Consumer");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        consumerRequesttbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Name", "Address", "Sender", "Reciever", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(consumerRequesttbl1);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 940, 96));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = LocalOrganiztionRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }

        LocalOrganizationToLocalManagerSetLocalEnergyWR setLocalEnergyToCommSensor = (LocalOrganizationToLocalManagerSetLocalEnergyWR) LocalOrganiztionRequestJTable.getValueAt(selectedRow, 1);
        int numberOfBatteries = setLocalEnergyToCommSensor.getLocalEnergy().getLocalAreabattery().getLocalbatteryList().size();
        ArrayList<Battery> tempBatteryList = new ArrayList<>();
        for (Battery battery : setLocalEnergyToCommSensor.getLocalEnergy().getLocalAreabattery().getLocalbatteryList()) {
            //battery = setLocalEnergyToCommSensor.getLocalEnergy().getLocalAreabattery().addLocalBattery();
            battery.setBatteryVolts(CommunitySensor.MAX_VOLTAGE);
            tempBatteryList.add(battery);
        }
        setLocalEnergyToCommSensor.getLocalEnergy().getLocalAreabattery().setLocalbatteryList(tempBatteryList);
        communitySensor.setLocalEnergy(setLocalEnergyToCommSensor.getLocalEnergy());
        setLocalEnergyToCommSensor.setStatus("Complete ");
        setLocalEnergyToCommSensor.setReceiver(userAccount);
        setLocalEnergyToCommSensor.setMessage("I am using this battery");
        setLocalEnergyToCommSensor.setStatus("In use");
        //Send it back to the Local Organization
        JOptionPane.showMessageDialog(null, "The Community sensor is set and number of batteries" + numberOfBatteries);
        populateConsumerTable();
        populateWorkRequestForLocalEnergy();

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateConsumerTable();
        populateWorkRequestForLocalEnergy();
        populateWorkRequestComingFromConsumer();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void btnAssignConsumerToCommunitySensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignConsumerToCommunitySensorActionPerformed
        // TODO add your handling code here:
        Boolean isUserAccountPresent = false;
        int selectedRow = consumerListWorkRequestFromGlobal.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }

        setConsumerWorkRequest = (SetConsumerWorkRequest) consumerListWorkRequestFromGlobal.getValueAt(selectedRow, 0);
        setConsumerWorkRequest.getConsumer().setSensor(new Sensor());
        //Assign him battery
        ConsumerBattery b = new ConsumerBattery();
        b.setBatteryVolts(CommunitySensor.MAX_VOLTAGE);
        setConsumerWorkRequest.getConsumer().getSensor().setBattery(b);
        //Setting Battery

        //To Assign Work Request
        CommunitySensorForConsumer setCommunitySensorForConsumer = new CommunitySensorForConsumer();
        setCommunitySensorForConsumer.setCommunitySensor(communitySensor);

        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organiz : e.getOrganizationDirectory().getOrganizationList()) {
                    if (organiz instanceof ConsumerOrganization) {
                        //Sending to all the consumers Not required
                        // org.getWorkQueue().getWorkRequestList().add(setLocalEnergyToCommSensor);

                        for (UserAccount u : organiz.getUserAccountDirectory().getUserAccountList()) {
                            if (u.equals(userAccountOfConsumer)) {
                                isUserAccountPresent = true;
                                setCommunitySensorForConsumer.setMessage("Select this Sensor");
                                setCommunitySensorForConsumer.setSender(userAccount);
                                setCommunitySensorForConsumer.setStatus("Complete");
                                u.getWorkQueue().getWorkRequestList().add(setCommunitySensorForConsumer);
                                JOptionPane.showMessageDialog(null, "Alloting consumer local Energy:" + u.getEmployee());
                            } else {
                                isUserAccountPresent = false;
                            }
                        }
                    }
                }
            }
        }
        if (!isUserAccountPresent) {
            JOptionPane.showMessageDialog(null, "Make sure the user from Table 1 is selected and then Process/Assign him sensor");
        }


    }//GEN-LAST:event_btnAssignConsumerToCommunitySensorActionPerformed

    private void btnAssign2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssign2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = consumerRequesttbl1.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        RequestsFromConsumer request = (RequestsFromConsumer) consumerRequesttbl1.getValueAt(selectedRow, 0);
        userAccountOfConsumer = request.getSender();

        request.setConsumer(setConsumerWorkRequest.getConsumer());
        request.setReceiver(userAccount);
        request.setStatus("Enjoy Free energy");
        request.setMessage("Select to get energy");

        JOptionPane.showMessageDialog(null, "The user selected is " + userAccountOfConsumer.getEmployee().getName());
        populateWorkGoingToFromConsumer();
    }//GEN-LAST:event_btnAssign2ActionPerformed

    private void btnProcessConsumerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessConsumerActionPerformed
        // TODO add your handling code here:

        int selectedRow = consumerListWorkRequestFromGlobal.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        setConsumerWorkRequest = (SetConsumerWorkRequest) consumerListWorkRequestFromGlobal.getValueAt(selectedRow, 2);

        LocalManagerSettingConsumerParameters localManagerSettingConsumerParameters = new LocalManagerSettingConsumerParameters(userProcessContainer, userAccount, setConsumerWorkRequest, setConsumerWorkRequest.getConsumer(), (LocalManagerEnergyOrganization) LocalOrganization, business);
        userProcessContainer.add("localManagerSettingConsumerParameters", localManagerSettingConsumerParameters);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProcessConsumerActionPerformed

    private void btnGetUserDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetUserDetailsActionPerformed
        // TODO add your handling code here:

        int selectedRow = consumerRequesttbl.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        RequestsFromConsumer request = (RequestsFromConsumer) consumerRequesttbl.getValueAt(selectedRow, 0);
        userAccountOfConsumer = request.getSender();
        request.setStatus("Processing");
        request.setReceiver(userAccount);
        JOptionPane.showMessageDialog(null, "The user selected is " + userAccountOfConsumer.getEmployee().getName());
        populateWorkRequestComingFromConsumer();
    }//GEN-LAST:event_btnGetUserDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LocalOrganiztionRequestJTable;
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton btnAssign2;
    private javax.swing.JButton btnAssignConsumerToCommunitySensor;
    private javax.swing.JButton btnGetUserDetails;
    private javax.swing.JButton btnProcessConsumer;
    private javax.swing.JTable consumerListWorkRequestFromGlobal;
    private javax.swing.JTable consumerRequesttbl;
    private javax.swing.JTable consumerRequesttbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton refreshJButton;
    // End of variables declaration//GEN-END:variables
}

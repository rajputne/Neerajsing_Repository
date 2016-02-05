/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Patient;
import Business.PatientDirectory;
import Business.PersonDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neerajsing Rajput
 */
public class ManagePatientJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;

    PatientDirectory patientDirectory;

    PersonDirectory personDirectory;

    /**
     * Creates new form ManagePatientJPanel
     */
    public ManagePatientJPanel(JPanel upc, PatientDirectory pd, PersonDirectory perDir) {
        initComponents();
        userProcessContainer = upc;
        patientDirectory = pd;
        personDirectory = perDir;
        populateTable();
    }

    public void populateTable() {
        //Make table Empty
        DefaultTableModel dtm = (DefaultTableModel) tblPatient.getModel();
        int rowCount = tblPatient.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (Patient p : patientDirectory.getPatientList()) {
            Object row[] = new Object[3];
            row[0] = p;
            row[1] = p.getDoctorName();
            row[2] = p.getPharmacy();
            dtm.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Manage Patient");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 32, -1, -1));

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient ID", "Doctor Name", "Pharmacy"
            }
        ));
        jScrollPane1.setViewportView(tblPatient);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 375, 97));

        btnBack.setText("<<back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 245, -1, -1));

        btnView.setText("View Report");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 182, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        //This helps layout manager pointing to the next layout
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatient.getSelectedRow();
        if (selectedRow >= 0) {
            Patient patient = (Patient) tblPatient.getValueAt(selectedRow, 0);
            SearchPatientResultJPanel panel = new SearchPatientResultJPanel(userProcessContainer, patient,personDirectory);
            userProcessContainer.add("SearchPatientResultJPanel", panel);
            CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Please select row first");
        }
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatient;
    // End of variables declaration//GEN-END:variables
}

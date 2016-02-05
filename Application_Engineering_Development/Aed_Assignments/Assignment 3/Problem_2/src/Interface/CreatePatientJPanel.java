/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Patient;
import Business.Person;
import Business.PersonDirectory;
import Business.VitalSign;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Neerajsing Rajput
 */
public class CreatePatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePatientJPanel
     */
    private JPanel userProcessContainer;
    
    Person person;
    PersonDirectory personDirectory;
    
    public CreatePatientJPanel(JPanel upc, Person p, PersonDirectory pd) {
        initComponents();
        userProcessContainer = upc;
        person = p;
        personDirectory = pd;
        
        CheckPatientAlreadyPresent(p);
        btnAddVitalSigns.setEnabled(false);
    }
    
    public CreatePatientJPanel(JPanel upc, Person p) {
        initComponents();
        userProcessContainer = upc;
        person = p;
        
        CheckPatient(p);
    }
    
    public void CheckPatient(Person p) {
        try {
            
            Patient patient = p.getPatient();
            txtPatientID.setText(patient.getDoctorName());
            txtDoctorName.setText(patient.getDoctorName());
            txtPharmacy.setText(patient.getPharmacy());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "New Patient Creation. Press ok");
        }
    }
    
    public void CheckPatientAlreadyPresent(Person p) {
        try {
            p = personDirectory.searchPerson(p.getPersonName());
            Patient patient = p.getPatient();
            txtPatientID.setText(patient.getDoctorName());
            txtDoctorName.setText(patient.getDoctorName());
            txtPharmacy.setText(patient.getPharmacy());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "New Patient Creation. Press ok");
            return;
        }
    }
    
    public boolean IsIntegerValueOfTextField(JTextField textFiled, String textfield) {
        Boolean isValidated;
        try {
            int intvalue = Integer.parseInt(textFiled.getText());
            if ((intvalue == 0) || (intvalue < 0)) {
                isValidated = false;
                JOptionPane.showMessageDialog(null, "Zero or negative value entered which is not allowed");
            } else {
                isValidated = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter number in " + textfield);
            isValidated = false;
        }
        return isValidated;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddVitalSigns = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        txtHeartRate = new javax.swing.JTextField();
        txtPharmacy = new javax.swing.JTextField();
        txtBloodPressure = new javax.swing.JTextField();
        txtWeights = new javax.swing.JTextField();
        txtRespiratoryRate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCreatePatient = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPatientID = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddVitalSigns.setText("Add Vital Signs");
        btnAddVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVitalSignsActionPerformed(evt);
            }
        });
        add(btnAddVitalSigns, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 361, -1, -1));

        jLabel6.setText("Respiratory Rate");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 212, -1, -1));

        jLabel4.setText("Doctor Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 95, -1, -1));

        jLabel8.setText("Heart Rate");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 250, -1, -1));

        jLabel5.setText("Pharmacy");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 133, -1, -1));

        jLabel9.setText("Blood Pressure");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 288, -1, -1));

        jLabel10.setText("Weight(lbs)");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 326, -1, -1));
        add(txtDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 92, 146, -1));
        add(txtHeartRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 192, -1));
        add(txtPharmacy, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 130, 146, -1));
        add(txtBloodPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 192, -1));
        add(txtWeights, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 192, -1));
        add(txtRespiratoryRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 192, -1));

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel7.setText("Create Patient");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 11, -1, -1));

        btnCreatePatient.setText("Create Patient");
        btnCreatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePatientActionPerformed(evt);
            }
        });
        add(btnCreatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 168, -1, -1));

        jLabel1.setText("Patient id");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 57, -1, -1));
        add(txtPatientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 54, 146, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVitalSignsActionPerformed
        // TODO add your handling code here:
        //5. Add Vitalsigns

        int respiratoryRate;
        boolean isRespiratoryRateNumber = IsIntegerValueOfTextField(txtRespiratoryRate, "Respiratory rate");
        int heartRate;
        boolean isHeartRateNumber = IsIntegerValueOfTextField(txtHeartRate, "Heart Rate");
        int bloodPressure;
        boolean isBloodPressureNumber = IsIntegerValueOfTextField(txtBloodPressure, "Blooad Pressure");
        int weight;
        boolean isWeightNumber = IsIntegerValueOfTextField(txtWeights, "Weight");
        //Date timeStamp = new Date();
        if (isRespiratoryRateNumber && isHeartRateNumber && isBloodPressureNumber && isWeightNumber) {
            
            respiratoryRate = Integer.parseInt(txtRespiratoryRate.getText());
            heartRate = Integer.parseInt(txtHeartRate.getText());
            bloodPressure = Integer.parseInt(txtBloodPressure.getText());
            weight = Integer.parseInt(txtWeights.getText());
            String second, minute, hour;
            GregorianCalendar date = new GregorianCalendar();
            second = String.valueOf(date.get(Calendar.SECOND));
            minute = String.valueOf(date.get(Calendar.MINUTE));
            hour = String.valueOf(date.get(Calendar.HOUR));
            String timeStamp = hour + ":" + minute + ":" + second;
            //6. Add to object

            VitalSign vs = person.getPatient().getVitalSignHistory().addVitalSign();
            vs.setRespiratoryRate(respiratoryRate);
            vs.setDate(timeStamp);
            vs.setWeightInPounds(weight);
            vs.setBloodPressure(bloodPressure);
            vs.setHeartRate(heartRate);
            //7. Show Message
            JOptionPane.showMessageDialog(null, "Vital Sign has been successfully recorded", "Infomation", JOptionPane.INFORMATION_MESSAGE);
            //8. Make Fields empty
            txtRespiratoryRate.setText("");
            txtWeights.setText("");
            txtHeartRate.setText("");
            txtBloodPressure.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Vital Sign has not been recorded", "Infomation", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddVitalSignsActionPerformed

    private void btnCreatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePatientActionPerformed
        // TODO add your handling code here:

        String patientID = txtPatientID.getText();
        String doctorName = txtDoctorName.getText();
        String pharmacy = txtPharmacy.getText();
        //2. Add to object
        if (patientID.isEmpty()||doctorName.isEmpty() || pharmacy.isEmpty()) {
            btnAddVitalSigns.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Some patient field is empty please fill that");
        } else {
            Patient patient = person.getPatient();
            patient.setDoctorName(doctorName);
            patient.setPharmacy(pharmacy);
            patient.setPatientID(patientID);
            person.setPatient(patient);

            //4. Make Patient Fields uneditable after correct input
            txtDoctorName.setEditable(false);
            txtPharmacy.setEditable(false);
            txtPatientID.setEditable(false);
            //3. Show Message
            JOptionPane.showMessageDialog(null, "Patient has been successfully recorded", "Infomation", JOptionPane.INFORMATION_MESSAGE);
            btnAddVitalSigns.setEnabled(true);
        }

    }//GEN-LAST:event_btnCreatePatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVitalSigns;
    private javax.swing.JButton btnCreatePatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBloodPressure;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtHeartRate;
    private javax.swing.JTextField txtPatientID;
    private javax.swing.JTextField txtPharmacy;
    private javax.swing.JTextField txtRespiratoryRate;
    private javax.swing.JTextField txtWeights;
    // End of variables declaration//GEN-END:variables
}

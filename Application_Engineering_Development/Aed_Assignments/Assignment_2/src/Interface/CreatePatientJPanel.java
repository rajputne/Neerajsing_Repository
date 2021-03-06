/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Patient;
import Business.VitalSign;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Neerajsing Rajput
 */
public class CreatePatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePatientJPanel
     */
    Patient patient;

    //VitalSignHistory vsh;
    public CreatePatientJPanel(Patient patient) {
        initComponents();
        this.patient = patient;
        setPatientTextField();
    }
    
    public void setPatientTextField() {
        txtPatientName.setText(patient.getPatientName());
        txtPatientID.setText(patient.getPatientID());
        //The reason for zero is that when the object is called constructor is invoked which gets patient info relating to 
        int age = patient.getAge();
        if (age == 0) {
            txtAge.setText("");
        } else {
            txtAge.setText(String.valueOf(age));
        }
        txtDoctorName.setText(patient.getDoctorName());
        txtPharmacy.setText(patient.getPharmacy());
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtDoctorName = new javax.swing.JTextField();
        txtPharmacy = new javax.swing.JTextField();
        txtPatientID = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCreatePatient = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHeartRate = new javax.swing.JTextField();
        txtBloodPressure = new javax.swing.JTextField();
        txtWeights = new javax.swing.JTextField();
        txtRespiratoryRate = new javax.swing.JTextField();
        lblErrorMessage = new javax.swing.JLabel();

        jLabel1.setText("Patient Name");

        jLabel2.setText("Patient ID");

        jLabel3.setText("Age");

        jLabel4.setText("Doctor Name");

        jLabel5.setText("Pharmacy");

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel7.setText("Create Patient");

        btnCreatePatient.setText("Create Patient");
        btnCreatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePatientActionPerformed(evt);
            }
        });

        jButton1.setText("Add Vital Signs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Respiratory Rate");

        jLabel8.setText("Heart Rate");

        jLabel9.setText("Blood Pressure");

        jLabel10.setText("Weight(lbs)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnCreatePatient))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(33, 33, 33)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(15, 15, 15)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtBloodPressure, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                        .addComponent(txtHeartRate)
                                        .addComponent(txtRespiratoryRate)
                                        .addComponent(txtWeights)))))
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblErrorMessage)
                        .addGap(280, 280, 280))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreatePatient)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRespiratoryRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtWeights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(lblErrorMessage)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePatientActionPerformed
        // TODO add your handling code here:
        //1. Set Text

        String patientName = txtPatientName.getText();
        String patientId = txtPatientID.getText();
        //int age = 0;

        String doctorName = txtDoctorName.getText();
        String pharmacy = txtPharmacy.getText();
        //2. Add to object
        if (IsIntegerValueOfTextField(txtAge, "Age")) {
            int age = Integer.parseInt(txtAge.getText());
            patient.setAge(age);
            patient.setDoctorName(doctorName);
            patient.setPharmacy(pharmacy);
            patient.setPatientName(patientName);
            patient.setPatientID(patientId);
            //3. Show Message
            JOptionPane.showMessageDialog(null, "Patient has been successfully recorded", "Infomation", JOptionPane.INFORMATION_MESSAGE);
            //4. Make Patient Fields uneditable after correct input
            txtPatientName.setEditable(false);
            txtPatientID.setEditable(false);
            txtAge.setEditable(false);
            txtDoctorName.setEditable(false);
            txtPharmacy.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Patient record is not registered", "Infomation", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCreatePatientActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            VitalSign vs = patient.getVitalSignHistory().addVitalSign();
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
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePatient;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodPressure;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtHeartRate;
    private javax.swing.JTextField txtPatientID;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtPharmacy;
    private javax.swing.JTextField txtRespiratoryRate;
    private javax.swing.JTextField txtWeights;
    // End of variables declaration//GEN-END:variables
}

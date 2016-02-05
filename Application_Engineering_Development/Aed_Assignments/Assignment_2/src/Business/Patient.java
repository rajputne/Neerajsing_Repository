/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Neerajsing Rajput
 */
public class Patient {

    private String patientName;
    private String patientID;
    private int age;
    private String doctorName;
    private String pharmacy;
    private VitalSignHistory vitalSignHistory;

    //This is the most important part where patient is linked with vitalsignHistory using 1 to 1 relationship

    public Patient() {
        vitalSignHistory = new VitalSignHistory();
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientID() {
        return patientID;
    }

    public int getAge() {
        return age;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }
}

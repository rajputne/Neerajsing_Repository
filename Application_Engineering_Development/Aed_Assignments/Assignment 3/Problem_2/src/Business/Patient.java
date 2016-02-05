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

    private String patientID;
   
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

    

    public String getPatientID() {
        return patientID;
    }

   

    public String getDoctorName() {
        return doctorName;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }
    
    @Override
    public String toString() {
        return patientID;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class PatientDirectory {
    private ArrayList<Patient> patientList;
   // private Patient patient;
    //
    public PatientDirectory() {
        patientList = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    
     

    public Patient createPatient() {
        Patient patient = new Patient();
        patientList.add(patient);
        return patient;
    }

    
    public void deletePatient(Patient patient) {
        patientList.remove(patient);
    }

    public Patient searchPatient(String patientID) {
        for (Patient patient : patientList) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "PatientDirectory";
    }
}

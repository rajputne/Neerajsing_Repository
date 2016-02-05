/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class Donor extends Employee {

    private String bloodType;
    public BloodSummaryHistory bsh;

    public BloodSummaryHistory getBsh() {
        return bsh;
    }

    public void setBsh(BloodSummaryHistory bsh) {
        this.bsh = bsh;
    }

    public String getBloodType() {
        return bloodType;
    }

    public Donor() {
        bsh=new BloodSummaryHistory();
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }


}

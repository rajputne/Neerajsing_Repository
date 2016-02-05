/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class BloodSummaryHistory {

    private ArrayList<BloodSummary> BloodSummaryList;

    public BloodSummaryHistory() {
        BloodSummaryList = new ArrayList<>();
    }

    public ArrayList<BloodSummary> getBloodSummaryList() {
        return BloodSummaryList;
    }

    public void setBloodSummaryList(ArrayList<BloodSummary> BloodSummaryList) {
        this.BloodSummaryList = BloodSummaryList;
    }

    public BloodSummary addBloodSummary(BloodSummary vs) {

        BloodSummaryList.add(vs);
        return vs;
    }

    public void deleteBloodSummaryList(BloodSummary vitalSign) {
        BloodSummaryList.remove(vitalSign);
    }

    @Override
    public String toString() {
        return "BloodSummaryList";
    }

}

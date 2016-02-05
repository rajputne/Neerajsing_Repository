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
public class DrugCatalog {
    
    private ArrayList<Drug> DrugList;

    public ArrayList<Drug> getDrugList() {
        return DrugList;
    }

    public void setDrugList(ArrayList<Drug> DrugList) {
        this.DrugList = DrugList;
    }
   
    public DrugCatalog() {
        DrugList = new ArrayList<Drug>();
    }

    public Drug createDrug() {
        Drug drug = new Drug();
        DrugList.add(drug);
        return drug;
    }

    
    public void deleteDrug(Drug drug) {
        DrugList.remove(drug);
    }

    public Drug searchDrug(String drugName) {
        for (Drug drug : DrugList) {
            if (drug.getDrugName().equals(drugName)) {
                return drug;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DrugCatalog";
    }
    
}

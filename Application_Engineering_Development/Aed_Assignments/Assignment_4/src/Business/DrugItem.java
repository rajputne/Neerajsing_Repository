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
public class DrugItem {

    private int quantity;
    private Drug drug;
    private String supplyAlert;

    public String getSupplyAlert() {
        return supplyAlert;
    }

    public void setSupplyAlert(String supplyAlert) {
        this.supplyAlert = supplyAlert;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return drug.getDrugName();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

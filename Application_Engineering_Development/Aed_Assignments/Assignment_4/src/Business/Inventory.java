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
public class Inventory {

    private static int count = 0;
    private int drugNum;
    private ArrayList<DrugItem> drugItemList;

    public ArrayList<DrugItem> getDrugItemList() {
        return drugItemList;
    }

    public void setDrugItemList(ArrayList<DrugItem> drugItemList) {
        this.drugItemList = drugItemList;
    }

    public Inventory() {
        drugItemList = new ArrayList<>();
        ++count;
        drugNum = count;
    }

    public void removeDrugItem(DrugItem orderItem) {
        drugItemList.remove(orderItem);
    }

    public DrugItem addOrderItem(Drug drug, int quantity) {
        DrugItem orederItem = new DrugItem();
        drugItemList.add(orederItem);
        orederItem.setDrug(drug);
        orederItem.setQuantity(quantity);
        return orederItem;
    }

    public DrugItem searchOrderItemByProduct(Drug drug) {
        for (DrugItem orderItem : drugItemList) {
            if (orderItem.getDrug() == drug) {
                return orderItem;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neerajsing Rajput
 */
public class SalesDirectory {

    ArrayList<Sales> salesList = new ArrayList<Sales>();

    public ArrayList<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(ArrayList<Sales> salesList) {
        this.salesList = salesList;
    }

    public Sales addSalesPerson() {
        Sales s = new Sales();
        salesList.add(s);
        return s;
    }

    public void removeProduct(Sales p) {
        salesList.remove(p);
    }

    public Sales searchSales(String name) {
        for (Sales sales : salesList) {
            if (sales.getSalesName() == name) {
                return sales;
            }
        }
        return null;
    }

}

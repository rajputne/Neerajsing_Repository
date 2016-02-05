/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Neerajsing Rajput
 */
public class Drug {

    private static int DrugCount = 0;
    private String DrugName;
    private int Price;

    private int modelNumber;
    private int AvailNum;

    public int getAvailNum() {
        return AvailNum;
    }

    public void setAvailNum(int AvailNum) {
        this.AvailNum = AvailNum;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    private String MfgDate;
    private String ExpiryDate;

    public Drug() {

        DrugCount++;
        modelNumber = DrugCount;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String DrugName) {
        this.DrugName = DrugName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getMfgDate() {
        return MfgDate;
    }

    public void setMfgDate(String MfgDate) {
        this.MfgDate = MfgDate;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    

    @Override
    public String toString() {
        return DrugName;
    }

}

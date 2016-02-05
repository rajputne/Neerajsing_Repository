/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.Billing;

import Business.WorkQueue.WorkRequest;

/**
 *
 * @author neera
 */
public class BillValueToConsumer extends WorkRequest {

    private double billValue;
    private int consumptionValue;

    public double getBillValue() {
        return billValue;
    }

    public int getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(int consumptionValue) {
        this.consumptionValue = consumptionValue;
    }

    public void setBillValue(double billValue) {
        this.billValue = billValue;
    }

}

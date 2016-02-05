/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee.Consumer;

/**
 *
 * @author Neerajsing Rajput
 */
public class Battery implements Comparable {

    private int batteryVolts;

    public Battery() {

    }

    public int getBatteryVolts() {
        return batteryVolts;
    }

    public void setBatteryVolts(int batteryVolts) {
        this.batteryVolts = batteryVolts;
    }

    @Override
    public int compareTo(Object t) {
        int compareQuantity = ((Battery) t).getBatteryVolts();

        //ascending order
        return this.getBatteryVolts() - compareQuantity;
    }

}

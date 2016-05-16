package com.smartenergy.spring.pojo.transientclass;

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

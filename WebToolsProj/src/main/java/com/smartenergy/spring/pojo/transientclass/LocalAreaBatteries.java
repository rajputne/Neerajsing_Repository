package com.smartenergy.spring.pojo.transientclass;

import java.util.ArrayList;

public class LocalAreaBatteries {
	
private int numberOfBatteries;
    
    public int getNumberOfBatteries() {
        return numberOfBatteries;
    }

    public void setNumberOfBatteries(int numberOfBatteries) {
        this.numberOfBatteries = numberOfBatteries;
    }

    ArrayList<Battery> localbatteryList;

    public LocalAreaBatteries() {
        localbatteryList = new ArrayList();
    }

    public void setLocalbatteryList(ArrayList<Battery> localbatteryList) {
        this.localbatteryList = localbatteryList;
    }

    public ArrayList<Battery> getLocalbatteryList() {
        return localbatteryList;
    }

    public Battery addLocalBattery() {
        Battery localBattery = new Battery();
        localbatteryList.add(localBattery);
        return localBattery;
    }

    public int getLocalEnergyVoltage() {
        int sum = 0;
        for(Battery b:getLocalbatteryList())
        {
        sum+=b.getBatteryVolts();
        }
        return sum;
    }

}

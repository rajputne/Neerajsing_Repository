/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.LocalEnergy;

import Business.Employee.Consumer.Battery;
import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
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
        localbatteryList = new ArrayList<>();
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

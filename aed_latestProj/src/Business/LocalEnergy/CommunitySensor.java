/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.LocalEnergy;

import Business.Employee.Consumer.Battery;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Neerajsing Rajput
 */
public class CommunitySensor {

    private LocalEnergy localEnergy;
    public static final int MIN_VOLTAGE = 306;
    public static final int MAX_VOLTAGE = 336;
    public static final int MIN_TEMPERETURE = 25;
    public static final int MIN_WIND_SPEED = 8;
    private Map<Date, Integer> localEnergyBatteryList;

    public Map<Date, Integer> getLocalEnergyBatteryList() {
        return localEnergyBatteryList;
    }

    public void setLocalEnergyBatteryList(Map<Date, Integer> localEnergyBatteryList) {
        this.localEnergyBatteryList = localEnergyBatteryList;
    }

    public LocalEnergy getLocalEnergy() {
        return localEnergy;
    }

    public void setLocalEnergy(LocalEnergy localEnergy) {
        this.localEnergy = localEnergy;
    }

    public CommunitySensor() {
        localEnergy = new LocalEnergy();
        localEnergyBatteryList = new HashMap<>();
    }

    //Check all the batteries in array should be recharged 
    public LocalEnergy rechargeLocalBattery() {
        LocalEnergy localEnergy = getLocalEnergy();
       //Iterate over local batteries
        for (Battery localBattery : localEnergy.getLocalAreabattery().getLocalbatteryList()) {
            if (localBattery.getBatteryVolts() <= MIN_VOLTAGE && localBattery.getBatteryVolts() > 0) {
                if (localEnergy.getTempereture() <= MIN_TEMPERETURE && localEnergy.getWindVelocity() <= MIN_WIND_SPEED) {
                    return localEnergy;

                } else if (localEnergy.getTempereture() > MIN_TEMPERETURE || localEnergy.getWindVelocity() > MIN_WIND_SPEED) {
                    int localEnergyVolts = localBattery.getBatteryVolts();

                    if (localEnergyVolts > MAX_VOLTAGE) {
                        return localEnergy;
                    } else //If the weather condition are good the battery will be fully charged
                    {
                        if (localBattery.getBatteryVolts() < MAX_VOLTAGE) {
                            int rechargeThreshHold = MAX_VOLTAGE - localEnergyVolts;
                            localBattery.setBatteryVolts(localEnergyVolts + rechargeThreshHold);
                        } else {
                            return localEnergy;
                        }
                    }
                }
            } else {
                //localBattery.setBatteryVolts(0);
                return localEnergy;
            }

        }
        return localEnergy;
    }
}

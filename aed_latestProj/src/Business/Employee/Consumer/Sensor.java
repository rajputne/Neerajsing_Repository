/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee.Consumer;

import Business.LocalEnergy.LocalEnergy;
import Business.LocalEnergy.CommunitySensor;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Neerajsing Rajput
 */
public class Sensor implements Comparable {

    private ConsumerBattery battery;
    private String uniqueSensorId;
    private int meter;
    //Since Prof Bugrara mentioned that datapoints have to be captured My Datapoints
    private Map<Date, Integer> globalConsumptionList;
    private Map<Date, Integer> localConsumptionList;
    private Map<Date, String> messageHistory;

    public Sensor() {
        battery = new ConsumerBattery();
        messageHistory = new HashMap<>();
        globalConsumptionList = new HashMap<>();
        localConsumptionList = new HashMap<>();
    }

    public String getUniqueSensorId() {
        return uniqueSensorId;
    }

    public void setUniqueSensorId(String uniqueSensorId) {
        this.uniqueSensorId = uniqueSensorId;
    }

    public ConsumerBattery getBattery() {
        return battery;
    }

    public void setBattery(ConsumerBattery battery) {
        this.battery = battery;
    }

    public Map<Date, String> getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(Map<Date, String> messageHistory) {
        this.messageHistory = messageHistory;
    }

    public Map<Date, Integer> getGlobalConsumptionList() {
        return globalConsumptionList;
    }

    public void setGlobalConsumptionList(Map<Date, Integer> globalConsumptionList) {
        this.globalConsumptionList = globalConsumptionList;
    }

    public Map<Date, Integer> getLocalConsumptionList() {
        return localConsumptionList;
    }

    public void setLocalConsumptionList(Map<Date, Integer> localConsumptionList) {
        this.localConsumptionList = localConsumptionList;
    }

    public String smartSwitch(CommunitySensor cs) {
        //First check the charge in the LocalArea and then perform the operation
        String Message = "";
        LocalEnergy le = cs.rechargeLocalBattery();
        ConsumerBattery b = getBattery();
        //To See weather the conumption is done or not
        int consumptionByAllDevices = b.getTotalConsumptionByAllDevices();
        int voltageInConsumerBatteryRemaining = 0;
        int batteryInConsumer = b.getBatteryVolts();
        if (batteryInConsumer > CommunitySensor.MIN_VOLTAGE) {
            voltageInConsumerBatteryRemaining = b.calculateVoltageInConsumerBattery();
            Message = "Consumer battery has voltage remaining->" + voltageInConsumerBatteryRemaining + " Volts. Device consumption is-> " + consumptionByAllDevices + " Volts";
            return Message;
        }

        //When it goes to global the battery volt is reduced which should not happen 
        //Check whether the Consumer Battery has power to support its device 
        Collections.sort(le.getLocalAreabattery().getLocalbatteryList());

        if (voltageInConsumerBatteryRemaining < CommunitySensor.MIN_VOLTAGE && b.getBatteryVolts() > 0) {

            //Take From the Local Energy Bank First
            for (Battery localAreaBattery : le.getLocalAreabattery().getLocalbatteryList()) {
                //Check the all local Area battery should be above 306 voltage
                //Find the Maximum value in this localAreaBattery arrayList and store that 
                //in a variable then apply the below check

                Battery maxBattery = le.getLocalAreabattery().getLocalbatteryList().get(le.getLocalAreabattery().getLocalbatteryList().size() - 1);
                if (maxBattery.getBatteryVolts() > CommunitySensor.MIN_VOLTAGE) {

                    if (localAreaBattery.getBatteryVolts() > 0) {
                        //Check whether the local Battery is the maxBattery Battery
                        if (maxBattery.getBatteryVolts() == localAreaBattery.getBatteryVolts()) {

                            //Recharge consumer battery if it gets too low we dont want to go below 306
                            if (b.getBatteryVolts() < CommunitySensor.MIN_VOLTAGE) {
                                int threshold = CommunitySensor.MAX_VOLTAGE - b.getBatteryVolts();
                                b.setBatteryVolts(threshold + b.getBatteryVolts());
                                //Discharge Local Battery
                                localAreaBattery.setBatteryVolts(maxBattery.getBatteryVolts() - threshold);

                            } else {
                                b.setBatteryVolts(consumptionByAllDevices + b.getBatteryVolts());
                                //Discharge Local Battery
                                localAreaBattery.setBatteryVolts(maxBattery.getBatteryVolts() - consumptionByAllDevices);

                            }
                            Date date = new Date();

                            localConsumptionList.put(date, consumptionByAllDevices);
                            cs.getLocalEnergyBatteryList().put(new Date(), localAreaBattery.getBatteryVolts());
                            Message = "The Local Energy is switch On and the consmption made by you ->" + consumptionByAllDevices + " Volts. Battery remaining->" + b.getBatteryVolts() + " Volts";

                            return Message;
                        }
                    }
                } else //Plan is to check the consumer battery once again to see if the volatage is still der
                {
                    if (b.getBatteryVolts() > CommunitySensor.MIN_VOLTAGE) {
                        b.setBatteryVolts(b.getBatteryVolts() - b.getTotalConsumptionByAllDevices());
                        Message = "Voltage taken from Consumer Battery->" + b.getBatteryVolts() + " Volts";
                        return Message;
                    } else {
                        meter = b.getTotalPowerConsumed();
                        Date date = new Date();
                        globalConsumptionList.put(date, meter);
                        //Set this to Minimum charged range
                        Message = "The Global Energy is switch On Meter Power ->" + meter + "KWatts. The Consumer Battery" + b.getBatteryVolts() + " Volts";
                        return Message;
                    }
                }
            }
        } else {
            //Get voltage from the consumer battery
            int abc = b.getBatteryVolts() - consumptionByAllDevices;
            if (abc < CommunitySensor.MIN_VOLTAGE) {
                if (abc < 0) {
                    meter = b.getTotalPowerConsumed();
                    Date date = new Date();
                    globalConsumptionList.put(date, meter);
                    //Set this to Minimum charged range
                    Message = "The battery has reached negative value. Please call Local Maintanence. The Global Energy is switch On and the consmption made by you is -->" + meter + "KWatts";
                    return Message;
                }
                meter = b.getTotalPowerConsumed();
                Date date = new Date();

                globalConsumptionList.put(date, meter);
                //Call the localArea 
                Message = "Since the charge cannot go below 306 check hence global consumption happening. Meter->" + meter + " KWatts";
                //messageHistory.put(new Date(), Message);
                return Message;
            } else {
                b.setBatteryVolts(abc);
                Message = "No need to charge the battery since you already had requierd power from your battery. Consumer Battery Volts is" + b.getBatteryVolts() + " Volts";
                messageHistory.put(new Date(), Message);
                return Message;
            }
        }
        if (voltageInConsumerBatteryRemaining == 0) {
            meter = b.getTotalPowerConsumed();
            Date date = new Date();

            
            globalConsumptionList.put(date, meter);
            //Call the localArea 
            Message = "Not authorized to Community Sensor. Hence you are using global network energy" + meter + " KWatts";
        } else {
            Message = "Something really went wrong. Call Local Maintainence";
        }

        // messageHistory.put(new Date(), Message);
        return Message;
    }

    public int sum_Of_Power_Consumption() {
        int sum = 0;
        for (Integer i : getGlobalConsumptionList().values()) {
            sum += i;
        }
        return sum;
    }

    public int sum_Of_LocalVoltage() {
        int sum = 0;
        for (Integer i : getLocalConsumptionList().values()) {
            sum += i;
        }
        return sum;
    }

    @Override
    public int compareTo(Object t) {
        int compareQuantity = ((Sensor) t).sum_Of_Power_Consumption();

        //ascending order
        return this.sum_Of_Power_Consumption() - compareQuantity; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return uniqueSensorId;
    }
}

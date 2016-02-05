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
public class ConsumerBattery extends Battery {

    private Devices devices;

    public ConsumerBattery() {
        devices = new Devices();
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    public int getTotalConsumptionByAllDevices() {
        int sum = 0;
        for (Device d : getDevices().getDeviceList()) {
            sum += d.getDeviceConsumptionEquivalentInVoltage();
        }
        return sum;
    }

    public int getTotalPowerConsumed() {
        int sum = 0;
        for (Device d : devices.getDeviceList()) {
            sum += d.getPower();
        }
        return sum;
    }

    public void setConsumptionToZero() {
        for (Device d : devices.getDeviceList()) {
            d.setDeviceConsumptionEquivalentInVoltage(0);
        }
    }

    public int getVoltageOfAllTheDevices() {
        int sum = 0;
        for (Device d : devices.getDeviceList()) {
            sum += d.getPower() / d.getCurrent();

        }
        return sum;

    }

    public int calculateVoltageInConsumerBattery() {
        int volts = 0;
        volts = getBatteryVolts() - getTotalConsumptionByAllDevices();
        setBatteryVolts(volts);
        return volts;
    }

}

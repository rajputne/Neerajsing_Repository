package com.smartenergy.spring.pojo.transientclass;

public class Device {
	 private String deviceName;
	    private int deviceConsumptionEquivalentInVoltage;
	    //Variable for Global energy

	    private int power;
	    private int current;

	    public int getCurrent() {
	        return current;
	    }

	    public void getCurrent(int current) {
	        this.current = current;
	    }

	    public int getPower() {
	        return power;
	    }

	    public void setPower(int power) {
	        this.power = power;
	    }

	    public String getDeviceName() {
	        return deviceName;
	    }

	    public void setDeviceName(String deviceName) {
	        this.deviceName = deviceName;
	    }

	    public int getDeviceConsumptionEquivalentInVoltage() {
	        return deviceConsumptionEquivalentInVoltage;
	    }

	    public void setDeviceConsumptionEquivalentInVoltage(int deviceConsumptionEquivalentInVoltage) {
	        this.deviceConsumptionEquivalentInVoltage = deviceConsumptionEquivalentInVoltage;
	    }

	    @Override
	    public String toString() {

	        return deviceName;
	    }

}

package com.smartenergy.spring.pojo.transientclass;

public class LocalEnergy extends Weather {
	private LocalAreaBatteries localAreabattery;
	   
    public LocalEnergy() {
        localAreabattery = new LocalAreaBatteries();
    }

    public LocalAreaBatteries getLocalAreabattery() {
        return localAreabattery;
    }

    public void setLocalAreabattery(LocalAreaBatteries localAreabattery) {
        this.localAreabattery = localAreabattery;
    }

}

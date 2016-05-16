package com.smartenergy.spring.pojo.transientclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Devices {
	
	private ArrayList<Device> deviceList;


   
    public Devices() {
        deviceList = new ArrayList();
    }

    public ArrayList<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(ArrayList<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public Device addDevice(Device device) {

        getDeviceList().add(device);
        return device;
    }

    public void removeDevice(Device device) {
        getDeviceList().remove(device);
    }
    

}

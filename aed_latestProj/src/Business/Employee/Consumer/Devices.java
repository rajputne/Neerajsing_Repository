/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee.Consumer;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class Devices {

    private ArrayList<Device> deviceList;

    public Devices() {
        deviceList = new ArrayList<>();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee.Consumer;

import Business.Employee.Employee;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author Neerajsing Rajput
 */
public class Consumer extends Employee {

    private String consumerId;
    private String address;
    private int LocalAreaCode;
    private Sensor sensor;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocalAreaCode() {
        return LocalAreaCode;
    }

    public void setLocalAreaCode(int LocalAreaCode) {
        this.LocalAreaCode = LocalAreaCode;
    }

    public String getConsumerId() {

        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Consumer() {
        sensor = new Sensor();
    }

    @Override
    public String toString() {
        return name;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.ConsumerRequests;

import Business.Employee.Consumer.ConsumerBattery;
import Business.Employee.Consumer.Sensor;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author neera
 */
public class RequestToLocalMaintainence extends WorkRequest {

    public Sensor sensor;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public RequestToLocalMaintainence() {
        sensor = new Sensor();
    }

    @Override
    public String toString() {
        return message;
    }

}

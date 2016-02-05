/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Neerajsing Rajput
 */
public class VitalSign {

    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private int weightInPounds;
    private String date;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setWeightInPounds(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public int getWeightInPounds() {
        return weightInPounds;
    }

    @Override
    public String toString() {
        return this.date;
    }
}

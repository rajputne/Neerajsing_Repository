/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.LocalEnergy;

/**
 *
 * @author Neerajsing Rajput
 */
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

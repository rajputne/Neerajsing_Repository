/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.LocalOrganizationToLocalManager;

import Business.LocalEnergy.LocalEnergy;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author neera
 */
public class LocalOrganizationToLocalManagerSetLocalEnergyWR extends WorkRequest {

    LocalEnergy localEnergy;

    public LocalEnergy getLocalEnergy() {
        return localEnergy;
    }

    public void setLocalEnergy(LocalEnergy localEnergy) {
        this.localEnergy = localEnergy;
    }

    public LocalOrganizationToLocalManagerSetLocalEnergyWR() {
        localEnergy = new LocalEnergy();
    }

    @Override
    public String toString() {
        return message;
    }

}

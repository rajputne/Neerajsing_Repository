/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.ConsumerRequests;

import Business.LocalEnergy.CommunitySensor;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author neera
 */
public class CommunitySensorForConsumer extends WorkRequest {

    CommunitySensor communitySensor;

    public CommunitySensor getCommunitySensor() {
        return communitySensor;
    }

    public void setCommunitySensor(CommunitySensor communitySensor) {
        this.communitySensor = communitySensor;
    }

    public CommunitySensorForConsumer() {
        communitySensor = new CommunitySensor();
    }

    @Override
    public String toString() {
        return message;
    }
}

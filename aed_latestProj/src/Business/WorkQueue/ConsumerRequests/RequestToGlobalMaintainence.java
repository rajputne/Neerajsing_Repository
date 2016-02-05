/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.ConsumerRequests;

import Business.WorkQueue.WorkRequest;

/**
 *
 * @author neera
 */
public class RequestToGlobalMaintainence extends WorkRequest {

    @Override
    public String toString() {
        return message;
    }
}

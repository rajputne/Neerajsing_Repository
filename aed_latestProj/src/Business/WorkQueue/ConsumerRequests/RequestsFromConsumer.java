/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.ConsumerRequests;

import Business.Employee.Consumer.Consumer;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author neera
 */
public class RequestsFromConsumer extends WorkRequest {

    private String consumerRequests;
    private Consumer consumer;

    public String getConsumerRequests() {
        return consumerRequests;
    }

    public void setConsumerRequests(String consumerRequests) {
        this.consumerRequests = consumerRequests;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public RequestsFromConsumer() {
        consumer = new Consumer();
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return message;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue.GlobalManagerToLocalManager;

import Business.Employee.Consumer.Consumer;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author raunak
 */
public class SetConsumerWorkRequest extends WorkRequest {

    private Consumer consumer;

    private UserAccount userAccountOfConsumer;

    public UserAccount getUserAccountOfConsumer() {
        return userAccountOfConsumer;
    }

    public void setUserAccountOfConsumer(UserAccount userAccountOfConsumer) {
        this.userAccountOfConsumer = userAccountOfConsumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public SetConsumerWorkRequest() {
        consumer = new Consumer();
    }

    @Override
    public String toString() {
        return consumer.getName();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class Customers {

    private ArrayList<Customer> customerList;

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customers() {
        customerList = new ArrayList<Customer>();
    }

    public Customer addCustomer() {
        Customer customer = new Customer();
        customerList.add(customer);
        return customer;
    }
    
    public Customer searchCustomer(String customerName) {
        for (Customer c : customerList) {
            if (c.getCustomerName().equals(customerName)) {
                return c;
            }
        }
        return null;
    }

}

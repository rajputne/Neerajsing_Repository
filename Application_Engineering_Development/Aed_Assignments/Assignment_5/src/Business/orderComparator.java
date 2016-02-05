/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Comparator;

/**
 *
 * @author Neerajsing Rajput
 */
public class orderComparator implements Comparator<Order> {
    @Override
    public int compare(Order e1, Order e2) {
        return e1.getOrderTotal().compareTo(e2.getOrderTotal());
    }   
}

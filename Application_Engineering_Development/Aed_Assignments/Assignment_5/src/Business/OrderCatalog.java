/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author zongzesheng
 */
public class OrderCatalog {

    private ArrayList<Order> orderList;

    public OrderCatalog() {
        orderList = new ArrayList<Order>();
    }

    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}

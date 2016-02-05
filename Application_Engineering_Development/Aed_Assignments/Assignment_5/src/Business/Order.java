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
public class Order implements Comparable<Order> {

    private static int count = 0;
    private ArrayList<OrderItem> orderItemList;
    private int orderNum;
    private String SalesPersonName;
    private int OrderTotal;
    private String CustomerName;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    

    public void setOrderTotal(int OrderTotal) {
        this.OrderTotal = OrderTotal;
    }

    public String getSalesPersonName() {
        return SalesPersonName;
    }

    @Override
    public int compareTo(Order o) {
        if (this.OrderTotal > o.getOrderTotal()) {
            return -1;
        } else if (this.OrderTotal < o.getOrderTotal()) {
            return 1;
        } else {
            return 0;
        }
    }

    public Integer getOrderTotal() {
        int sum = 0;
        for (OrderItem orderItem : orderItemList) {
            sum += orderItem.getQuantity();
        }
        return sum;
    }

    public void setSalesPersonName(String SalesPersonName) {
        this.SalesPersonName = SalesPersonName;
    }


    public Order() {
        super();
        orderItemList = new ArrayList<OrderItem>();
        ++count;
        orderNum = count;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

    public OrderItem addOrderItem(Product product, int quantity, int price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setSalesPrice(price);
        orderItemList.add(orderItem);
        return orderItem;
    }

    public OrderItem searchOrderItemByProduct(Product product) {
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getProduct() == product) {
                return orderItem;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Neerajsing Rajput
 */
public class Sales {

    private String salesName;
    private double commision;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getCommision() {
        commision = 0;
        for (OrderItem oi : getOrder().getOrderItemList()) {
            commision += oi.calculateCommission();
        }
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    public Sales() {
        order = new Order();
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    @Override
    public String toString() {
        return salesName;
    }
}

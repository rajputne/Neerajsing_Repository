/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author zongzesheng
 */
public class OrderItem {

    private Product product;
    private int quantity;
    private int salesPrice;

    private double targetPriceOfIndivual;

    public double getTargetPriceOfIndivual() {
        int sPrice = getProduct().getHighestPrice();
        int lowestPrice = getProduct().getLowestPrice();
        int difference = sPrice - lowestPrice;
        double medianOfDifference = difference / 2;
        targetPriceOfIndivual = lowestPrice + medianOfDifference;
        return targetPriceOfIndivual;
    }

    public double getTargetPriceOfOverallItem() {
        return getTargetPriceOfIndivual() * getQuantity();
    }

    public int getTotalAmount() {
        return quantity * salesPrice;
    }

    public double calculateCommission() {
        return getTotalAmount() - getTargetPriceOfOverallItem();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return product.getProdName();
    }
}

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
public class Business {

    private SupplierDirectory supplierDirectory;
    private Customers customerDirectory;
    private SalesDirectory salesDirectory;
    private OrderCatalog orderCatalog;

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    public Business() {
        supplierDirectory = new SupplierDirectory();
        customerDirectory = new Customers();
        salesDirectory = new SalesDirectory();
        orderCatalog=new OrderCatalog();

    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public Customers getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(Customers customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public SalesDirectory getSalesDirectory() {
        return salesDirectory;
    }

    public void setSalesDirectory(SalesDirectory salesDirectory) {
        this.salesDirectory = salesDirectory;
    }
}

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
public class Initiliazation {

    public static Business Initialization() {

        Business business = new Business();
        Customers customers = new Customers();
        Customer customer = customers.addCustomer();
        customer.setCustomerName("Vishnu");
        Customer customer2 = customers.addCustomer();
        customer2.setCustomerName("Bramha");
        business.setCustomerDirectory(customers);
        Customer customer3 = customers.addCustomer();
        customer3.setCustomerName("Shiva");
        Customer customer4 = customers.addCustomer();
        customer4.setCustomerName("Hanuman");
        business.setCustomerDirectory(customers);

        SalesDirectory sales = new SalesDirectory();
        Sales sale = sales.addSalesPerson();
        sale.setSalesName("Javed Bhai");
        Sales sale2 = sales.addSalesPerson();
        sale2.setSalesName("Naved");
        business.setSalesDirectory(sales);
        Sales sale3 = sales.addSalesPerson();
        sale3.setSalesName("Gafoor");
        Sales sale4 = sales.addSalesPerson();
        sale4.setSalesName("Ibrahim");

        ProductCatalog productCatalog = new ProductCatalog();

        Product p = productCatalog.addProduct();
        p.setProdName("Xerox1");
        p.setHighestPrice(10);
        p.setAvailNum(1000);
        p.setLowestPrice(7);

        Order order = new Order();
        OrderItem oi = order.addOrderItem(p, 10, 10);
        customer.setOrder(order);
        sale.setOrder(order);
        Product p2 = productCatalog.addProduct();
        p2.setProdName("Xerox2");
        p2.setHighestPrice(50);
        p2.setAvailNum(5000);
        p2.setLowestPrice(47);
        //This is for Sorting 
        Order order2 = new Order();
        OrderItem oii = order2.addOrderItem(p2, 48, 49);
        customer2.setOrder(order2);
        sale2.setOrder(order2);

        Order order3 = new Order();
        OrderItem oiii = order3.addOrderItem(p2, 5, 47);
        customer3.setOrder(order3);
        sale3.setOrder(order3);

        SupplierDirectory suppliers = new SupplierDirectory();
        Supplier supplier = suppliers.addSupplier();
        supplier.setSupplyName("Cannon");
        supplier.setProductCatalog(productCatalog);
        Supplier supplier2 = suppliers.addSupplier();
        supplier2.setSupplyName("HP");

        business.setSupplierDirectory(suppliers);

        return business;

    }

}

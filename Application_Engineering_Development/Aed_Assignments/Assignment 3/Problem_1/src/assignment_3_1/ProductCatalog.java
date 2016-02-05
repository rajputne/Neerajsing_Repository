/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3_1;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class ProductCatalog {

    private Product product;
    private ArrayList<Product> productCatalog;
    private Supplier supplier;

    public ProductCatalog() {
        this.productCatalog = new ArrayList<>();
    }

    public ArrayList<Product> getProduct() {
        return productCatalog;
    }

    public void setProductCatalog(ArrayList<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public Product addProduct() {
        Product product = new Product();
        productCatalog.add(product);
        return product;
    }

    public void deleteProduct(Product product) {
        productCatalog.remove(product);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abhishekashwathnarayanvenkat
 */
public class ProductCatalog {

    private List<Product> productCatalog;

    Map<Product, Integer> map;

    public List<Product> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(List<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public Map<Product, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Product, Integer> map) {
        this.map = map;
    }

    public ProductCatalog() {
        this.map = new HashMap<Product, Integer>();
        productCatalog = new ArrayList<Product>();
    }

    public List<Product> getProductcatalog() {
        return productCatalog;
    }

    public Product addProduct() {
        Product p = new Product();
        productCatalog.add(p);
        return p;
    }

    public void removeProduct(Product p) {
        productCatalog.remove(p);
    }

    public Product searchProduct(int id) {
        for (Product product : productCatalog) {
            if (product.getModelNumber() == id) {
                return product;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author neera
 */
public class Cart {

    ArrayList<Product> cart;

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public void addToCart(Product p) {
        cart.add(p);
    }

    public void removeToCart(Product p) {
        cart.remove(p);
    }

    public Cart() {
        cart = new ArrayList<>();
    }

}

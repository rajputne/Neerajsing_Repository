/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class Stores {
     public ArrayList<Store> storeList;

    public ArrayList<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(ArrayList<Store> storeList) {
        this.storeList = storeList;
    }

    

    public Stores() {
        storeList = new ArrayList<>();
    }    
    
    public Store createStore() {
        Store store = new Store();
        storeList.add(store);
        return store;
    }

    public void storeList(Store store) {
        storeList.remove(store);
    }

    public Store searchStore(String storeLocation) {
        for (Store store : storeList) {
            if (store.getStoreLocation().equals(storeLocation)) {
                return store;
            }
        }
        return null;
    }
}

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
public class SupplierDirectory {

    private ArrayList<Supplier> supplierDirectory;
    
    public SupplierDirectory() {
        this.supplierDirectory = new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(ArrayList<Supplier> supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public Supplier addSupplier() {
        Supplier supplier = new Supplier();
        supplierDirectory.add(supplier);
        return supplier;
    }

    public void deleteSupplier(Supplier supplier) {
        supplierDirectory.remove(supplier);
    }
}

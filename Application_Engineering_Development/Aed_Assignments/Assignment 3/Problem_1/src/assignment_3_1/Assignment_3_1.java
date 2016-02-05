/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3_1;

import java.util.Scanner;

/**
 *
 * @author Neerajsing Rajput
 */
public class Assignment_3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Creating Supply Directory
        SupplierDirectory sd = new SupplierDirectory();

        //Making supply objects
        System.out.println("----Press the serial number to view product catalog of the following suppliers---");
        setTheSupplier(sd, "Dell");
        setTheSupplier(sd, "HP");
        setTheSupplier(sd, "Toshiba");
        setTheSupplier(sd, "Apple");
        setTheSupplier(sd, "Lenovo");

        int serialNumber = 0;
        for (Supplier s : sd.getSupplierDirectory()) {
            serialNumber++;
            System.out.println(String.valueOf(serialNumber) + ":" + s.getSupplierName());

        }

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                ProductCatalog DellCatalog = getCatalog(sd, choice);
                setProductAllAttributes(DellCatalog, "Dell Laptop", 250, 10);
                setProductAllAttributes(DellCatalog, "Dell Mouse", 25, 11);
                setProductAllAttributes(DellCatalog, "Dell Keyboard", 20, 12);
                setProductAllAttributes(DellCatalog, "Dell WiFi", 100, 13);
                setProductAllAttributes(DellCatalog, "Dell Hard Disk", 125, 14);
                setProductAllAttributes(DellCatalog, "Dell Camera", 50, 15);
                setProductAllAttributes(DellCatalog, "Dell Battery", 35, 16);
                setProductAllAttributes(DellCatalog, "Dell USB Cable", 10, 17);
                setProductAllAttributes(DellCatalog, "Dell USB", 5, 18);
                setProductAllAttributes(DellCatalog, "Dell Router", 75, 19);

                break;
            case 2:

                ProductCatalog HPCatalog = getCatalog(sd, choice);

                setProductAllAttributes(HPCatalog, "HP Laptop", 250, 20);
                setProductAllAttributes(HPCatalog, "HP Mouse", 25, 21);
                setProductAllAttributes(HPCatalog, "HP Keyboard", 20, 22);
                setProductAllAttributes(HPCatalog, "HP WiFi", 100, 23);
                setProductAllAttributes(HPCatalog, "HP Hard Disk", 125, 24);
                setProductAllAttributes(HPCatalog, "HP Camera", 50, 25);
                setProductAllAttributes(HPCatalog, "HP Battery", 35, 26);
                setProductAllAttributes(HPCatalog, "HP USB Cable", 10, 27);
                setProductAllAttributes(HPCatalog, "HP USB", 5, 28);
                setProductAllAttributes(HPCatalog, "HP Router", 75, 29);

                break;
            case 3:
                ProductCatalog ToshibaCatalog = getCatalog(sd, choice);

                setProductAllAttributes(ToshibaCatalog, "Toshiba Laptop", 250, 30);
                setProductAllAttributes(ToshibaCatalog, "Toshiba Mouse", 25, 31);
                setProductAllAttributes(ToshibaCatalog, "Toshiba Keyboard", 20, 32);
                setProductAllAttributes(ToshibaCatalog, "Toshiba WiFi", 100, 33);
                setProductAllAttributes(ToshibaCatalog, "Toshiba Hard Disk", 125, 34);
                setProductAllAttributes(ToshibaCatalog, "Toshiba Camera", 50, 35);
                setProductAllAttributes(ToshibaCatalog, "Toshiba Battery", 35, 36);
                setProductAllAttributes(ToshibaCatalog, "Toshiba USB Cable", 10, 37);
                setProductAllAttributes(ToshibaCatalog, "Toshiba USB", 5, 38);
                setProductAllAttributes(ToshibaCatalog, "Toshiba Router", 75, 39);

                break;
            case 4:
                ProductCatalog AppleCatalog = getCatalog(sd, choice);

                setProductAllAttributes(AppleCatalog, "Apple Laptop", 250, 40);
                setProductAllAttributes(AppleCatalog, "Apple Mouse", 25, 41);
                setProductAllAttributes(AppleCatalog, "Apple Keyboard", 20, 42);
                setProductAllAttributes(AppleCatalog, "Apple WiFi", 100, 43);
                setProductAllAttributes(AppleCatalog, "Apple Hard Disk", 125, 44);
                setProductAllAttributes(AppleCatalog, "Apple Camera", 50, 45);
                setProductAllAttributes(AppleCatalog, "Apple Battery", 35, 46);
                setProductAllAttributes(AppleCatalog, "Apple USB Cable", 10, 47);
                setProductAllAttributes(AppleCatalog, "Apple USB", 5, 48);
                setProductAllAttributes(AppleCatalog, "Apple Router", 75, 49);

                break;

            case 5:
                ProductCatalog LenovoCatalog = getCatalog(sd, choice);

                setProductAllAttributes(LenovoCatalog, "Lenovo Laptop", 250, 50);
                setProductAllAttributes(LenovoCatalog, "Lenovo Mouse", 25, 51);
                setProductAllAttributes(LenovoCatalog, "Lenovo Keyboard", 20, 52);
                setProductAllAttributes(LenovoCatalog, "Lenovo WiFi", 100, 53);
                setProductAllAttributes(LenovoCatalog, "Lenovo Hard Disk", 125, 54);
                setProductAllAttributes(LenovoCatalog, "Lenovo Camera", 50, 55);
                setProductAllAttributes(LenovoCatalog, "Lenovo Battery", 35, 56);
                setProductAllAttributes(LenovoCatalog, "Lenovo USB Cable", 10, 57);
                setProductAllAttributes(LenovoCatalog, "Lenovo USB", 5, 58);
                setProductAllAttributes(LenovoCatalog, "Lenovo Router", 75, 59);
                break;

            default:
                System.out.println("Serial number not valid");
                break;

        }
        PrintProducts(sd, choice);

    }

    public static Supplier setTheSupplier(SupplierDirectory supplierDirectory, String supplierName) {
        Supplier supplier = supplierDirectory.addSupplier();
        supplier.setSupplierName(supplierName);
        return supplier;
    }

    public static Product setProductAllAttributes(ProductCatalog pc, String productName, int price, int id) {
        Product product = pc.addProduct();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProduct_id(id);
        return product;
    }

    public static ProductCatalog getCatalog(SupplierDirectory sd, int choice) {
        ProductCatalog pc = sd.getSupplierDirectory().get(choice - 1).getProductCatalog();
        String productCatalogName = sd.getSupplierDirectory().get(choice - 1).getSupplierName();
        System.out.println("You selected Supplier: " + productCatalogName);
        return pc;
    }

    public static void PrintProducts(SupplierDirectory sd, int choice) {
        for (Product p : sd.getSupplierDirectory().get(choice - 1).getProductCatalog().getProduct()) {
            System.out.println("Name--> " + p.getProductName() + "------ Price--> " + p.getPrice() + "usd ----Product id--> " + p.getProduct_id());
        }
    }

}

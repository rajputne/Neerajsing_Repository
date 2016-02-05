/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Neerajsing Rajput
 */
public class Initialization {

    public static CVS Initialization() {
        CVS cvsAdmin = new CVS();
        PharmaDirectory pharmaDir = new PharmaDirectory();
        Pharma pharma1 = pharmaDir.createPharma();
        Pharma pharma2 = pharmaDir.createPharma();
        pharma1.setPharmaName("Glaxo");
        pharma2.setPharmaName("HindustanLever");
        cvsAdmin.setPharmaDirectory(pharmaDir);
        DrugCatalog drugCatalog1 = new DrugCatalog();
        Drug d1 = drugCatalog1.createDrug();
        d1.setAvailNum(500);
        d1.setDrugName("Crocin");
        d1.setPrice(15);
        Date d = new Date();
        String stringformatDate = new SimpleDateFormat("yyyy/MM/dd").format(d);
        d1.setExpiryDate(stringformatDate);
        d1.setMfgDate(stringformatDate);
        Drug d2 = drugCatalog1.createDrug();
        d2.setAvailNum(1000);
        d2.setDrugName("Metacin");
        d2.setPrice(45);
        d2.setExpiryDate(stringformatDate);
        d2.setMfgDate(stringformatDate);
        pharma1.setDrugCatalog(drugCatalog1);

        DrugCatalog drugCatalog2 = new DrugCatalog();
        Drug d11 = drugCatalog2.createDrug();
        d11.setAvailNum(1500);
        d11.setDrugName("Combiflam");
        d11.setPrice(150);
        d11.setExpiryDate(stringformatDate);
        d11.setMfgDate(stringformatDate);
        Drug d22 = drugCatalog2.createDrug();
        d22.setAvailNum(2000);
        d22.setDrugName("LMX500");
        d22.setPrice(45);
        d22.setExpiryDate(stringformatDate);
        d22.setMfgDate(stringformatDate);
        pharma2.setDrugCatalog(drugCatalog2);

        Store store = cvsAdmin.getStores().createStore();
        store.setStoreLocation("Symphony");
        Store store2 = cvsAdmin.getStores().createStore();
        store2.setStoreLocation("Hay Market");
        return cvsAdmin;
    }
}

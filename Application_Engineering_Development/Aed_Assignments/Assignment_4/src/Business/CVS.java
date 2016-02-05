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
public class CVS {

    private Stores stores;
    private PharmaDirectory pharmaDirectory;

    public PharmaDirectory getPharmaDirectory() {
        return pharmaDirectory;
    }

    public void setPharmaDirectory(PharmaDirectory pharmaDirectory) {
        this.pharmaDirectory = pharmaDirectory;
    }

    public CVS() {
        stores = new Stores();
        pharmaDirectory = new PharmaDirectory();
    }

    public Stores getStores() {
        return stores;
    }

    public void setStores(Stores stores) {
        this.stores = stores;
    }
}

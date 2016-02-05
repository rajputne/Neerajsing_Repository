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
public class PharmaDirectory {

    private ArrayList<Pharma> PharmaList;

    public ArrayList<Pharma> getPharmaList() {
        return PharmaList;
    }

    public void setPharmaList(ArrayList<Pharma> PharmaList) {
        this.PharmaList = PharmaList;
    }

    public PharmaDirectory() {
        PharmaList = new ArrayList<>();
    }

    public Pharma createPharma() {
        Pharma pharma = new Pharma();
        PharmaList.add(pharma);
        return pharma;
    }

    public void deletePharma(Pharma pharma) {
        PharmaList.remove(pharma);
    }

    public Pharma searchPharma(String pharmaName) {
        for (Pharma pharma : PharmaList) {
            if (pharma.getPharmaName().equals(pharmaName)) {
                return pharma;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "PharmaDirectory";
    }
}

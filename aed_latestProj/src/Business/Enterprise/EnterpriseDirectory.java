/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.LocalEnterprise.LocalEnterprise;
import Business.Enterprise.GlobalEnterprise.GlobalEnterprise;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.GlobalEnergy) {
            enterprise = new GlobalEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.LocalEnergy) {
            enterprise = new LocalEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }

    public void DeleteEnterprise(Enterprise enterprise) {
       
        enterpriseList.remove(enterprise);
    }

}

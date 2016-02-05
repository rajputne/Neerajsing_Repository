/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.LocalEnterprise;

import Business.Enterprise.Enterprise;
import Business.Role.GlobalEnterprise.GlobaEnterpriselAdminRole;
import Business.Role.LocalEnterpriseRole.LocalEnterpriseAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class LocalEnterprise extends Enterprise {

    
    public LocalEnterprise(String name, EnterpriseType type) {
        super(name, type.LocalEnergy);

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LocalEnterpriseAdminRole());
        return roles;
    }

}

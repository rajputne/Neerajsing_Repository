/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.GlobalEnergy;

import Business.Organization.Organization;
import Business.Role.GlobalEnterprise.GlobalOrganizations.GlobalAreaManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class GlobalManagerOrganization extends Organization {

    public GlobalManagerOrganization() {
        super(Organization.GlobalType.GlobalManager.getValue());
    }

    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GlobalAreaManagerRole());
        return roles;
    }

}

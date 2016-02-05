/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.LocalEnergy;

import Business.Organization.Organization;
import Business.Role.LocalEnterpriseRole.LocalOrganizationRole.LocalMaintainenceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class LocalAreaEnergyMaintainenceOrganization extends Organization {
    
    public LocalAreaEnergyMaintainenceOrganization() {
        super(Organization.LocalType.LocalMaintainence.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LocalMaintainenceRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}

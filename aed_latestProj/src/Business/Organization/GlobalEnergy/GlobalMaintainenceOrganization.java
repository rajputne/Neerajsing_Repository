/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.GlobalEnergy;

import Business.Organization.Organization;
import Business.Role.GlobalEnterprise.GlobalOrganizations.GlobalMaintainenceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class GlobalMaintainenceOrganization extends Organization {

    public GlobalMaintainenceOrganization() {
        super(Organization.GlobalType.GlobalMaintainence.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GlobalMaintainenceRole());
        return roles;//To change body of generated methods, choose Tools | Templates.
    }
    
}

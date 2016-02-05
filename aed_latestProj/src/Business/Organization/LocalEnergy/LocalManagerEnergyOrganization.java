/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.LocalEnergy;

import Business.LocalEnergy.CommunitySensor;
import Business.Organization.Organization;
import Business.Role.LocalEnterpriseRole.LocalOrganizationRole.LocalAreaManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class LocalManagerEnergyOrganization extends Organization {

    CommunitySensor communitySensor;

    public CommunitySensor getCommunitySensor() {
        return communitySensor;
    }

    public void setCommunitySensor(CommunitySensor communitySensor) {
        this.communitySensor = communitySensor;
    }
    
    

    public LocalManagerEnergyOrganization() {
        super(Organization.LocalType.LocalAreaAdmin.getValue());
        communitySensor=new CommunitySensor();
    }

  
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LocalAreaManagerRole());
        return roles;
    }
    
}

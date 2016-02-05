/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.LocalEnergy;


import Business.Organization.Organization;
import Business.Role.LocalEnterpriseRole.LocalOrganizationRole.LocalEnergyOrganizationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class LocalAreaOrganization extends Organization{
    
    
    private int LocalAreaCode;

    public int getLocalAreaCode() {
        return LocalAreaCode;
    }

    public void setLocalAreaCode(int LocalAreaCode) {
        this.LocalAreaCode = LocalAreaCode;
    }

   
    
    
    public LocalAreaOrganization(String name) {
        super(name);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LocalEnergyOrganizationRole());
        return roles;
    }
}

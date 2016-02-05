/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.GlobalEnergy;




import Business.Organization.Organization;
import Business.Role.ConsumerRole.ConsumerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author neera
 */
public class ConsumerOrganization extends Organization {

    
    public ConsumerOrganization(String name) {
        super(name);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ConsumerRole());
        return roles;
    }
    
    
}

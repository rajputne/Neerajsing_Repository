/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.GlobalEnterprise;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.GlobalEnterprise.GAWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class GlobaEnterpriselAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GAWorkAreaJPanel(userProcessContainer,enterprise,business);
    }

    

    
    
}

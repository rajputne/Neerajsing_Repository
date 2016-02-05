/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.LocalEnterpriseRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.LocalEnterprise.LocalAWorkAreaJPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class LocalEnterpriseAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LocalAWorkAreaJPanel(userProcessContainer, enterprise,business); //To change body of generated methods, choose Tools | Templates.
    }

}

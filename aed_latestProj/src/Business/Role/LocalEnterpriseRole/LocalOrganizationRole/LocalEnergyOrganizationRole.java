/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.LocalEnterpriseRole.LocalOrganizationRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LocalEnterprise.LocalEnterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.LocalEnterprise.LocalOrganization.LocalAWorkAreaJPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class LocalEnergyOrganizationRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LocalAWorkAreaJPanel(userProcessContainer, (LocalEnterprise) enterprise, account, business);//To change body of generated methods, choose Tools | Templates.
    }

}

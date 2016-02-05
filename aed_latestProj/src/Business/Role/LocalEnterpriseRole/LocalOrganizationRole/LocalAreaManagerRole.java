/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.LocalEnterpriseRole.LocalOrganizationRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.LocalEnergy.CommunitySensor;
import Business.Organization.LocalEnergy.LocalAreaOrganization;
import Business.Organization.LocalEnergy.LocalManagerEnergyOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LocalManagerRole.LocalManagerWorkAreaJPanel;

/**
 *
 * @author neera
 */
public class LocalAreaManagerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LocalManagerWorkAreaJPanel(userProcessContainer, account, organization, business); //To change body of generated methods, choose Tools | Templates.
    }

}

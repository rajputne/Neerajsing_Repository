/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.GlobalEnterprise.GlobalOrganizations;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.GlobalEnergy.GlobalManagerOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import userinterface.GlobalManagerRole.GlobalManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class GlobalAreaManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GlobalManagerWorkAreaJPanel(userProcessContainer, account, (GlobalManagerOrganization)organization, enterprise,business);
    }
    
    
}

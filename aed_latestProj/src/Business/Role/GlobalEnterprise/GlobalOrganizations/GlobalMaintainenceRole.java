/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.GlobalEnterprise.GlobalOrganizations;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.GlobalMaintainenceRole.GlobalMaintainenceWorkAreaJPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class GlobalMaintainenceRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GlobalMaintainenceWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business); //To change body of generated methods, choose Tools | Templates.
    }
    
}

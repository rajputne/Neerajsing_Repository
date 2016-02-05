/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ReciptionistRole.ReciptionistWorkAreaPanel;

/**
 *
 * @author Neerajsing Rajput
 */
public class ReciptionistRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel pnl, UserAccount ua, Organization o, Enterprise e, EcoSystem es) {
        //throw new UnsupportedOperationException("Not supported yet."); 

        return new ReciptionistWorkAreaPanel(pnl, ua, o, e, es);
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return RoleType.Receptionist.getValue();
    }
}

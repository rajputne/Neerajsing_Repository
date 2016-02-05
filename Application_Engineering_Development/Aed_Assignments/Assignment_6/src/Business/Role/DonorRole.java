/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Donor.Donor;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JPanel;
import userinterface.DonorRole.ViewDonorHistory;

/**
 *
 * @author Neerajsing Rajput
 */
public class DonorRole extends Role {

    public DonorRole() {
        donor = new Donor();
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    private Donor donor;

    @Override
    public JPanel createWorkArea(JPanel pnl, UserAccount ua, Organization o, Enterprise e, EcoSystem es) {
        return new ViewDonorHistory(pnl, ua, o, e, es);
    }

    @Override

    public String toString() {
        return RoleType.Donor.getValue();
    }

}

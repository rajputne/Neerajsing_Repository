/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.GlobalEnergy.GlobalMaintainenceOrganization;
import Business.Organization.GlobalEnergy.GlobalBillingOrganization;
import Business.Organization.LocalEnergy.LocalAreaOrganization;
import Business.Organization.GlobalEnergy.GlobalManagerOrganization;
import Business.Organization.LocalEnergy.LocalManagerEnergyOrganization;
import Business.Organization.LocalEnergy.LocalAreaEnergyMaintainenceOrganization;

import Business.Organization.Organization.LocalOrganizationType;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createLocalOrganization(LocalOrganizationType type, int code) {
        Organization organization = null;
        if (type.getValue().equals(LocalOrganizationType.Local.getValue())) {
            organization = new LocalAreaOrganization(LocalOrganizationType.Local.getValue());
            LocalAreaOrganization organizationLocal = (LocalAreaOrganization) organization;
            organizationLocal.setLocalAreaCode(code);
            organizationList.add(organizationLocal);
        }

        return organization;
    }

    public Organization createGlobalEnergyOrganization(Organization.GlobalType type) {
        Organization organization = null;
        //Not using this for time being concentrating on other stuff

        boolean isOrganizationOfConsumerOrganizationExist = false;
        boolean isOrganizationGlobalMaintainenceExist = false;
        boolean isOrganizationGlobalManagaerExist = false;
        boolean isOrganizatonBillingOrganizationExist = false;

        for (Organization o : organizationList) {
            if (o instanceof GlobalBillingOrganization) {
                isOrganizatonBillingOrganizationExist = true;
                break;
            } else {
                isOrganizatonBillingOrganizationExist = false;
            }
        }

        for (Organization o : organizationList) {
            if (o instanceof GlobalManagerOrganization) {
                isOrganizationGlobalManagaerExist = true;
                break;
            } else {
                isOrganizationGlobalManagaerExist = false;
            }
        }
        for (Organization o : organizationList) {
            if (o instanceof GlobalMaintainenceOrganization) {
                isOrganizationGlobalMaintainenceExist = true;
                break;
            } else {
                isOrganizationGlobalMaintainenceExist = false;
            }
        }

        for (Organization o : organizationList) {
            if (o instanceof ConsumerOrganization) {
                isOrganizationOfConsumerOrganizationExist = true;
                break;
            } else {
                isOrganizationOfConsumerOrganizationExist = false;
            }
        }
        if (type.getValue().equals(Organization.GlobalType.GlobalMaintainence.getValue())) {
            if (!isOrganizationGlobalMaintainenceExist) {
                organization = new GlobalMaintainenceOrganization();
                organizationList.add((GlobalMaintainenceOrganization) organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Global Maintainence Organization");
            }
        } else if (type.getValue().equals(Organization.GlobalType.GlobalManager.getValue())) {
            if (!isOrganizationGlobalManagaerExist) {
                organization = new GlobalManagerOrganization();
                organizationList.add((GlobalManagerOrganization) organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Global Manager Organization");
            }
        } else if (type.getValue().equals(Organization.GlobalType.Consumer.getValue())) {
            if (!isOrganizationOfConsumerOrganizationExist) {
                organization = new ConsumerOrganization(Organization.GlobalType.Consumer.getValue());
                organizationList.add((ConsumerOrganization) organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Consumer Organization");
            }
        } else if (!isOrganizatonBillingOrganizationExist) {
            organization = new GlobalBillingOrganization(Organization.GlobalType.BillingOrganization.getValue());
            organizationList.add((GlobalBillingOrganization) organization);
        } else {
            JOptionPane.showMessageDialog(null, "You can add only one Billing Organization");

        }

        return organization;
    }

    public Organization createLocalEnergyOrganization(Organization.LocalType type) {
        Organization organization = null;

        if (type.getValue().equals(Organization.LocalType.LocalAreaAdmin.getValue())) {
            organization = new LocalManagerEnergyOrganization();
            organizationList.add((LocalManagerEnergyOrganization) organization);
        } else if (type.getValue().equals(Organization.LocalType.LocalMaintainence.getValue())) {
            organization = new LocalAreaEnergyMaintainenceOrganization();
            organizationList.add((LocalAreaEnergyMaintainenceOrganization) organization);
        }

        return organization;
    }

    public void DeleteOrganization(Organization org) {
        organizationList.remove(org);
    }

}

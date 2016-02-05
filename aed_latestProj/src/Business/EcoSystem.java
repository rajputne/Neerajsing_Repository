package Business;

import Business.Employee.Consumer.Consumer;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {

            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public double CountOfAllConsumer(Enterprise ent) {
        double count = 0.0;
        for (Organization o : ent.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof ConsumerOrganization) {
                for (Employee e : o.getEmployeeDirectory().getEmployeeList()) {
                    if (e instanceof Consumer) {

                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean checkIfNetworkisUnique(String networkName) {

        for (Network n : this.networkList) {
            if (n.getName().equals(networkName)) {
                return true;

            }

        }
        return false;

    }

    public void DeleteNetwork(Network n) {
        networkList.remove(n);
    }

    public double sumOfAllConsumerPower(Enterprise ent) {
        double sum = 0.0;
        for (Organization o : ent.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof ConsumerOrganization) {
                for (Employee e : o.getEmployeeDirectory().getEmployeeList()) {
                    if (e instanceof Consumer) {

                        sum += ((Consumer) e).getSensor().sum_Of_Power_Consumption();
                    }
                }
            }
        }
        return sum;
    }

    public double avgOfAllConsumerPower(Enterprise ent) {
        double avg = sumOfAllConsumerPower(ent) / CountOfAllConsumer(ent);
        return avg;
    }

    public double sumOfAllConsumerVoltage(Enterprise ent) {
        double sum = 0.0;
        for (Organization o : ent.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof ConsumerOrganization) {
                for (Employee e : o.getEmployeeDirectory().getEmployeeList()) {
                    if (e instanceof Consumer) {
                        sum += ((Consumer) e).getSensor().sum_Of_LocalVoltage();
                    }
                }
            }
        }
        return sum;
    }

    public double avgOfAllConsumerVoltage(Enterprise ent) {
        double avg = 0.0;
        avg = sumOfAllConsumerVoltage(ent) / CountOfAllConsumer(ent);
        return avg;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    //
    public boolean checkIfUsernameIsUnique(String username) {

        for (UserAccount ua : this.getUserAccountDirectory().getUserAccountList()) {
            // System.out.println("EcoSystem" + ua.getUsername());
            if (ua.getUsername().equals(username)) {
                return false;
            }
            for (Network n : this.getNetworkList()) {
                for (Enterprise ent : n.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount ucc : ent.getUserAccountDirectory().getUserAccountList()) {
                        //           System.out.println("Enterprise-->" + ucc.getUsername());
                        if (ucc.getUsername().equals(username)) {
                            return false;
                        }
                        for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount accOrg : org.getUserAccountDirectory().getUserAccountList()) {
                                //                 System.out.println("Organization-->" + accOrg.getUsername());
                                if (accOrg.getUsername().equals(username)) {
                                    return false;
                                }
                            }

                        }
                    }

                }
            }

        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.GlobalEnterprise;

import Business.Employee.Consumer.Consumer;
import Business.Employee.Consumer.Sensor;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.GlobalEnergy.ConsumerOrganization;
import Business.Organization.Organization;
import Business.Role.GlobalEnterprise.GlobaEnterpriselAdminRole;
import Business.Role.Role;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Neerajsing Rajput
 */
public class GlobalEnterprise extends Enterprise {

    private static final double chargePerWattHour = 0.011;

    public GlobalEnterprise(String name, EnterpriseType type) {
        super(name, type.GlobalEnergy);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GlobaEnterpriselAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }

    public double generateConsumerMonthlyBill(Consumer consumer) {
        int sum = 0;

        for (Organization org : getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ConsumerOrganization) {
                for (Employee c : org.getEmployeeDirectory().getEmployeeList()) {
                    if (c instanceof Consumer) {
                        if (c.equals(consumer)) {
                            sum += calculateEnergyOfCurrentMonth(((Consumer) c).getSensor());
                        }
                    }
                }
            }
        }
        double chargePerMonth = sum * chargePerWattHour;
        return chargePerMonth;
    }

    

    

    public int calculateDayDifference(Date fromDate, Date toDate) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateFrom = format.format(fromDate);
        String dateTo = format.format(toDate);
        Date d1 = null;
        Date d22 = null;
        int daysInBetween = 0;
        try {
            d1 = format.parse(dateFrom);
            d22 = format.parse(dateTo);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d22);
            daysInBetween = Days.daysBetween(dt1, dt2).getDays();
            //System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
            //System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
            //System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return daysInBetween;

    }

    public int calculateEnergyOfCurrentMonth(Sensor s) {
        //Remove this After Usage
        int month = month = new GregorianCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
        int sum = 0;
        switch (month) {
            case 31:
                for (int i = 0; i < 31; i++) {
                    sum = s.sum_Of_Power_Consumption();
                }
                break;
            case 30:
                for (int i = 0; i < 31; i++) {
                    sum = s.sum_Of_Power_Consumption();
                }
                break;
            case 29:
                for (int i = 0; i < 29; i++) {
                    sum = s.sum_Of_Power_Consumption();
                }
                break;
            case 28:
                for (int i = 0; i < 29; i++) {
                    sum = s.sum_Of_Power_Consumption();
                }
                break;
            default:
                break;
        }
        return sum;
    }
    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Neerajsing Rajput
 */
public class Employee {

    private String firstName;

    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private String streetAddress;
    private String town;
    private String zipCode;
    private String occupation;
    private String emailAddress;
    private String areaCode;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getTown() {
        return town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*Returns the string format of Employee */
    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", dateOfBirth=" + dateOfBirth + ", streetAddress=" + streetAddress + ", town=" + town + ", zipCode=" + zipCode + ", occupation=" + occupation + ", emailAddress=" + emailAddress + ", areaCode=" + areaCode + ", phoneNumber=" + phoneNumber + '}';
    }

}

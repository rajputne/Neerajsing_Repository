/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Neerajsing Rajput
 */
public class PersonDirectory {
    private ArrayList<Person> personList;
    
    //
    public PersonDirectory() {
        personList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
     

    public Person createPerson() {
        Person person = new Person();
        personList.add(person);
        return person;
    }

    
    public void deletePerson(Person person) {
        personList.remove(person);
    }

    public Person searchPerson(String personName) {
        for (Person person : personList) {
            if (person.getPersonName().equals(personName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "PersonDirectory";
    }
    
}

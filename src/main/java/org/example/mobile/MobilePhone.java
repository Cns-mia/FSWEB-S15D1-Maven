package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this(myNumber, new ArrayList<>());
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts == null ? new ArrayList<>() : new ArrayList<>(myContacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (contact == null || findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index < 0 || newContact == null) {
            return false;
        }
        int sameName = findContact(newContact.getName());
        if (sameName >= 0 && sameName != index) {
            return false;
        }
        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index < 0) {
            return false;
        }
        myContacts.remove(index);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        return index >= 0 ? myContacts.get(index) : null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}

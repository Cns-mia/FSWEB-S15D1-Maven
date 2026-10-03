package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

public class Main {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("11111111");
        phone.addNewContact(Contact.createContact("Bob", "31415926"));
        phone.addNewContact(Contact.createContact("Alice", "16180339"));
        phone.addNewContact(Contact.createContact("Tom", "11235813"));
        phone.addNewContact(Contact.createContact("Jane", "23571113"));
        phone.printContact();

        Grocery.startGrocery();
    }
}

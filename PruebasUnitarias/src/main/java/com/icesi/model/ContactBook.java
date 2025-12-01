package com.icesi.model;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    //Atributes (Global variables)
    private static final String PHONE_REGEX = "^[0-9]{7,15}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    //Relationships
    private ArrayList<Contact> contacts;

    //Methods
    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getContacts(){
        return  this.contacts;
    }

    public boolean add(String name, String email, String phone){
        if (name == null || name.isBlank()) return false;

        if (!email.matches(EMAIL_REGEX)) return false;

        if (!phone.matches(PHONE_REGEX)) return false;

        if (search(email) != null) return false;

        this.contacts.add(new Contact(name, email, phone));
        return true;
    }

    public Contact search(String email){
        for (Contact c: this.contacts){
            if (c.getEmail().equals(email)){
                return c;
            }
        }
        return null;
    }

    public Contact remove(String email){
        Contact contact = search(email);
        if (contact != null) {
            this.contacts.remove(contact);
        }
        return contact;
    }
}

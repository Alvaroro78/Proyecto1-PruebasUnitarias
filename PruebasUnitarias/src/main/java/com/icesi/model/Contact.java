package com.icesi.model;

public class Contact {
    //Atributes
    private String name;
    private String email;
    private String phone;

    //Relationships (none)

    //Methods

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

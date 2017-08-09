package com.company;

public class Contact {

    private String name;
    private String phoneNumber;

    //Constructor...
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters...
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Factory method (Design Patterns)...
    public static Contact createContact(String name, String phoneNumber){

        return new Contact(name, phoneNumber);

    }
}

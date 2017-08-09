package com.company;

import java.util.Scanner;

public class Main {

    //Creating a scanner
    private static Scanner scanner = new Scanner(System.in);
    //Creating an instance for MobilePhone class
    private static MobilePhone mobilePhone = new MobilePhone("012938");

    public static void main(String[] args) {

        //
        boolean quit = false;
        startPhone();
        printAction();

        //Stating all actions in list printActions()
        while (!quit) {

            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){

                case 0:
                    System.out.println("\nShutting down!");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;

            }
        }
    }

    //Scanning 2 Strings and adding to new contact in Contact class
    private  static void addNewContact(){

        System.out.print("Enter new contact: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();
        //Scanning and calling the createContact method in Contact class and passing the strings
        Contact newContact = Contact.createContact(name, number);
        if(mobilePhone.addNewContact(newContact)){

            System.out.println("New contact added: " + name + "\n" + "Phone number: " + number);

        } else{

            System.out.println("Cannot add " + name + " already exists!");

        }

    }

    //Scanning and updating a contact in Contact class if exists
    private static void updateContact(){

        System.out.println("Enter a contact name: ");
        String name = scanner.nextLine();
        //Checking if contact exists
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){

            System.out.println("No contact was found.");
            return;

        } else{

            //A call to create new contact
            System.out.print("Enter new contact name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine();
            Contact contact = Contact.createContact(newName, newPhone);
            if(mobilePhone.updateContact(existingContactRecord, contact)){

                System.out.println("Successfully updated contact!");

            } else{

                System.out.println("Error updating contact!");

            }

        }

    }

    private static void deleteContact() {

        System.out.println("Enter a contact name: ");
        String name = scanner.nextLine();
        //Checking if contact exists via method
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {

            System.out.println("No contact was found.");
            return;

        }
        //Calling the removeContact method
        if(mobilePhone.removeContact(existingContactRecord)){

            System.out.println("Contact was deleted!");

        }else{

            System.out.println("Error deleting contact!");

        }
    }

    private static void queryContact() {

        System.out.println("Enter a contact name: ");
        String name = scanner.nextLine();
        //Checking if contact exists via method
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {

            System.out.println("No contact was found.");
            return;

        }
        System.out.println("Name: " + existingContactRecord.getName() + "\n Phone Number: " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone(){

        System.out.println("Starting phone...");

    }

    private static void printAction(){

        System.out.println("\nAvailable Actions:\n press");
        System.out.println("0 - Shut down\n" +
                           "1 - Print contacts\n" +
                           "2 - Add a new contact\n" +
                           "3 - Update existing contact\n" +
                           "4 - Delete existing contact\n" +
                           "5 - Check if contact exists\n" +
                           "6 - Print action list" );
        System.out.println("Choose an actions from the list above: ");


    }



}


/**
 * Name: Eric Truong
 * Date: November 13, 2019
 * Description: Read in a file of contacts and be able to modify it or search through it
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args){

        LinkedList list = new LinkedList();
        Contact newPerson;

        try{
            Scanner read = new Scanner(new File("contacts.txt"));

            do{

                String line = read.nextLine();
                String [] tokens = line.split(",");

                if(tokens.length > 2){
                    String last = tokens[0];
                    String first = tokens[1];
                    String phone = tokens[2];
                    String address = tokens[3];
                    String city = tokens[4];
                    String zip = tokens[5];
                    newPerson = new Contact(last, first, phone, address, city, zip);
                }
                else{

                    String last = tokens[0];
                    String first = tokens[1];
                    newPerson = new Contact(last, first);
                }

                list.add(newPerson);


            }
            while (read.hasNext());

            read.close();

            }

        catch(FileNotFoundException fnf){

            System.out.println("File not found");
        }

        int choice = 0;

        while(choice != 6){

            System.out.println("Menu: \n" +
                    "1. Add a contact \n" +
                    "2. Remove a contact \n" +
                    "3. Search \n" +
                    "4. Update \n" +
                    "5. Display \n" +
                    "6. Quit \n" +
                    "Choose an option: ");
            choice = CheckInput.getIntRange(1, 6);

            if(choice == 1){

                System.out.print("Person's last name? ");
                String last = CheckInput.getString();
                System.out.print("Person's first name? ");
                String first = CheckInput.getString();
                System.out.print("Person's phone number? ");
                String phone = CheckInput.getString();
                System.out.print("Person's address? ");
                String address = CheckInput.getString();
                System.out.print("Person's city? ");
                String city = CheckInput.getString();
                System.out.print("Person's zipcode? ");
                String zip = CheckInput.getString();
                Contact newAddition = new Contact (last, first, phone, address, city, zip);
                list.add(newAddition);
            }

            if(choice == 2){

                System.out.print("How would you like to remove? \n" +
                        "1. By full name \n" +
                        "2. By index \n" +
                        "Choose an option: ");
                choice = CheckInput.getIntRange(1, 2);

                if(choice == 1){

                    System.out.print("What is the person's last name? ");
                    String last = CheckInput.getString();
                    System.out.print("What is the person's first name? ");
                    String first = CheckInput.getString();
                    list.remove(last, first);
                }

                if(choice == 2){

                    System.out.println(list);
                    System.out.print("Who would you like to remove? ");
                    choice = CheckInput.getIntRange(1, list.size());
                    list.remove(choice - 1);
                }
            }

            if(choice == 3){

                System.out.println("How would you like to search? \n" +
                        "1. By last name \n" +
                        "2. By zip code \n" +
                        "Choose an option: ");
                choice = CheckInput.getIntRange(1, 2);

                if(choice == 1){

                    System.out.print("What is the person's last name? ");
                    String last = CheckInput.getString();

                    ArrayList <Contact> possibilities = list.searchName(last);

                    for(int i = 0; i < possibilities.size(); i++){
                        System.out.println(possibilities.get(i));
                    }
                }

                if(choice == 2){

                    System.out.print("What is the person's zip code? ");
                    String zip = CheckInput.getString();

                    ArrayList <Contact> possibilities = list.searchZip(zip);

                    for(int i = 0; i < possibilities.size(); i++){
                        System.out.println(possibilities.get(i));
                    }
                }
            }

            if(choice == 4){
                Contact search = null;
                System.out.println("What is the person's lastname? ");
                String last = CheckInput.getString();
                System.out.println("What is the person's first name? ");
                String first = CheckInput.getString();
                search = list.searchName(last, first);
                if(search != null){
                    System.out.print("What field do you want to update? \n" +
                            "1. Last name \n" +
                            "2. First name \n" +
                            "3. Phone \n" +
                            "4. Address \n" +
                            "5. City \n" +
                            "6. Zip code");

                    choice = CheckInput.getIntRange(1, 4);

                    if(choice == 1){

                        System.out.print("What is the last name you would like to change to? ");
                        String lastName = CheckInput.getString();
                        search.setLastName(lastName);
                    }

                    if(choice == 2){

                        System.out.print("What is the first name you would like to change to? ");
                        String firstName = CheckInput.getString();
                        search.setFirstName(firstName);
                    }

                    if(choice == 3){

                        System.out.print("What is the number you would like to change to? ");
                        String number = CheckInput.getString();
                        search.setPhone(number);
                    }

                    if(choice == 4){

                        System.out.print("What is the address you would like to change to? ");
                        String address = CheckInput.getString();
                        search.setAddress(address);
                    }

                    if(choice == 5){

                        System.out.print("What is the city you would like to change to? ");
                        String city = CheckInput.getString();
                        search.setCity(city);
                    }

                    if(choice == 6){

                        System.out.print("What is the zip code you would like to change to? ");
                        String zip = CheckInput.getString();
                        search.setZipCode(zip);
                    }
                }
            }
            if(choice == 5){

                System.out.print(list);
            }
        }

        try{

            PrintWriter write = new PrintWriter("contacts.txt");
            write.print(list.toFile());

            write.close();

        }

        catch(FileNotFoundException fnf){
            System.out.println("File not found");
        }

        System.out.println("Goodbye!");
    }
}

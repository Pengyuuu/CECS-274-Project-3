/**
 * Name: Eric Truong
 * Date: November 13, 2019
 * Description: Create a linked list to put contacts in
 */

import java.util.ArrayList;
import java.io.*;

public class LinkedList {

    /**
     * Makes contacts into nodes
     */
    private static class Node {

        /**
         * Contact is the data
         */
        private Contact data;

        /**
         * Next node in the list
         */
        private Node next;

        /**
         * Puts a contact in the list
         *
         * @param c a contact
         */
        public Node(Contact c) {
            data = c;
            next = null;
        }

        /**
         * Puts a contact at a certain position
         *
         * @param c a contact
         * @param n the position
         */
        public Node(Contact c, Node n) {
            data = c;
            next = n;
        }

        /**
         * Puts data in a string
         *
         * @return returns data in a string
         */
        @Override
        public String toString() {
            return data + "";
        }
    }

    /**
     * Create the first node
     */
    private Node first;

    /**
     * Creates the end node
     */
    private Node last;

    /**
     * Creates the linked list
     */
    public LinkedList() {
        first = null;
        last = null;
    }

    /**
     * check if the list is empty
     *
     * @return return true or false if it's empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Adds a contact into the list
     *
     * @param c a contact
     */
    public void add(Contact c) {
        if (first == null) {
            first = new Node(c);
            last = first;
        } else {
            Node n = new Node(c);
            last.next = n;
            last = n;
        }
    }

    /**
     * Return the contact at a certain node
     *
     * @param i specified node
     * @return contact at node
     */
    public Contact get(int i) {
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for (int j = 0; j < i; j++) {
            n = n.next;
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return n.data;
    }

    /**
     * Set the contact into a specified node
     *
     * @param i specified node
     * @param c a contact
     */
    public void set(int i, Contact c) {
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for (int j = 0; j < i; j++) {
            n = n.next;
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        n.data = c;
    }

    /**
     * Gets the size of the linkedlist
     *
     * @return return size of linkedlist
     */
    public int size() {
        int count = 0;
        Node n = first;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * Convert the data into a string
     *
     * @return returns data as a string
     */
    @Override
    public String toString() {
        bubbleSort();
        String str = "";
        Node n = first;
        int counter = 1;
        while (n != null) {
            str += counter+". "+ n.data + "\n";
            n = n.next;
            counter++;
        }
        return str;
    }

    /**
     * Adding a new node
     *
     * @param i position to make the new node
     * @param c a contact
     */
    public void add(int i, Contact c) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            first = new Node(c, first);
            if (last == null) {
                last = first;
            }
        } else {
            Node n = first;
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
            for (int j = 1; j < i; j++) {
                n = n.next;
                if (n == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            n.next = new Node(c, n.next);
            if (n.next.next == null) {
                last = n.next;
            }
        }
    }

    /**
     * Removes node at a specified index
     * @param i specified index
     * @return  contact being removed
     */
    public Contact remove(int i) {
        Contact rem;
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            rem = first.data;
            first = first.next;
            if(first == null){
                last = null;
            }
        }
        else{
            Node n = first;
            for(int j = 1; j < i; j++){
                n = n.next;
                if(n == null){
                    throw new IndexOutOfBoundsException();
                }
            }
            if(n.next == null){
                throw new IndexOutOfBoundsException();
            }
            rem = n.next.data;
            n.next = n.next.next;
            if(n.next == null){
                last = n;
            }
        }
        return rem;
    }


    /**
     *Removes a contact by searching for it's first and last name
     * @param x last name
     * @param y first name
     * @return  returns true if removed, false otherwise
     */
    public boolean remove(String x, String y) {
        Contact rem = null;
        Contact person = searchName(x, y);
        if (first != null) {
            if (person.equals(first.data)) {
                first = first.next;
                if (first == null) {
                    last = null;
                }
                return true;
            } else {
                Node n = first;
                while (n.next != null && !n.next.data.equals(person)) {
                    n = n.next;
                }
                if (n.next != null) {
                    n.next = n.next.next;
                    if (n.next == null) {
                        last = n;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Find a contact and remove it
     *
     * @param x desired contact
     * @return returns if the contact has been removed, false otherwise
     */
    public boolean remove(Contact x) {
        if (first != null) {
            if (x.equals(first.data)) {
                first = first.next;
                if (first == null) {
                    last = null;
                }
                return true;
            } else {
                Node n = first;
                while (n.next != null && !n.next.data.equals(x)) {
                    n = n.next;
                }
                if (n.next != null) {
                    n.next = n.next.next;
                    if (n.next == null) {
                        last = n;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Searches for a contact using first and last name
     * @param x last name
     * @param y first name
     * @return  returns contact if found
     */
    public Contact searchName(String x, String y) {
        Contact person = null;
        Contact select = new Contact(x, y);

        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        Node n = first;
        while (n != null) {
            if (select.equals(n.data)) {
                person = n.data;
            }
            n = n.next;
        }
        return person;
    }

    /**
     * Searches for contacts with similar names and puts them all in an array list
     * @param x name of contact
     * @return  array list of all contacts with similar names
     */
    public ArrayList<Contact> searchName(String x) {
        ArrayList<Contact> list = new ArrayList<Contact>();
        Node n = first;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }
        while (n != null) {
            if (x.equals(n.data.getLastName())) {
                list.add(n.data);

            }
            n = n.next;
        }
        return list;
    }

    /**
     * Searches for contacts with similar zip codes and puts them all in an array list
     * @param x zip code
     * @return  array list of all contacts with similar names
     */
    public ArrayList<Contact> searchZip(String x) {
        ArrayList<Contact> list = new ArrayList<Contact>();
        Node n = first;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }
        while (n != null) {
            if (x.equals(n.data.getZipCode())) {
                list.add(n.data);
            }
            n = n.next;
        }
        return list;
    }

    /**
     * Sorts the list of contacts by last name
     */
    public void bubbleSort() {
        boolean swapped = false;

        do {
            Node n = first;
            swapped = false;
            while (n.next != null) {

                Contact first = n.data;
                Contact second = n.next.data;

                if (first.compareTo(second) > 0) {
                    Contact swap = second;
                    n.data = swap;
                    n.next.data = first;
                    swapped = true;
                }

                n = n.next;
            }
        }
        while (swapped);
    }

    /**
     * Prints the list in a readable string to be printed on the file
     * @return  readable string to be printed on the file
     */
    public String toFile(){
        String str = "";
        Node n = first;
        while (n != null) {
            str = str + n.data + "\n";
            n = n.next;
        }
        return str;
    }

}




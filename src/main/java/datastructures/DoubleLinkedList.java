package datastructures;

import java.util.List;

public class DoubleLinkedList<T> {
    // inner private class
    private class Node {
        T data;
        Node prev;
        Node next;

        // Consider additional fields if needed for contact information
        public Node(T data) {
            this.data = data;
            Node next = null;
            Node prev = null;        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList()  {
        // TODO: Constructor logic (initialize, reset)
        head = null;
        tail = null;
        size = 0;
    }

    private void mergeEmailAddresses(Node existingNode, Contact newContact) {
        Contact existingContact = (Contact) existingNode.data;
        for (String email : newContact.getEmailAddresses()) {
            if (!existingContact.getEmailAddresses().contains(email)) {
                existingContact.addEmail(email);
            }
        }
    }

    public void addContact(T data) {
        if (!(data instanceof Contact)) {
            return; // Handle non-Contact data
        }

        Contact newContact = (Contact) data;
        Node newNode = new Node(data);

        // Case 1: Empty List
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        // Check for existing contact and merge emails if found
        Node current = head;
        Node previous = null;
        while (current != null) {
            // if (current.data instanceof Contact && current.data.equals(newContact)) {
            if (current.data.equals(newContact)) {
                Node finalCurrent = current;
                mergeEmailAddresses(current, newContact);
                return;
            }
            if (((Comparable<T>) current.data).compareTo(newNode.data) > 0) {
                break; // Found the insertion point
            }
            previous = current;
            current = current.next;
        }

        boolean insertBefore = true;
        if (current == null) {
            insertBefore = false;
        }
        insertNode(newNode, current, insertBefore);

        size++;
    }


    // TODO: separate out the code above to insert Node into a separate method from addContact()
    private void insertNode(Node newNode, Node current, boolean insertBefore) {
        // Insert the newNode before 'current'
        if (insertBefore) {
            if (current == head) {
                // Insert at the beginning
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                // Insert in the middle
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        } else {
            // Insert at the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean deleteContact(String lastName, String firstName) {
        boolean contactFound = false;
        Node current = head;
        while (current != null) {
            Contact newContact = (Contact) current.data;
            if (newContact.getFirstName().equals(firstName) && newContact.getLastName().equals(lastName)) {
                if (current == head) {
                    head = head.next;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                contactFound = true;
            }
            current = current.next;
        }
        return contactFound; // Contact not found
    }

    public boolean deleteEmailFromContact(String lastName, String firstName, String email) {
        boolean contactFound = false;
        Node current = head;
        while (current != null) {
            Contact newContact = (Contact) current.data;
            if (newContact.getFirstName().equals(firstName) && newContact.getLastName().equals(lastName)) {
                List<String> emails = newContact.getEmailAddresses();
                if(emails.indexOf(email) != -1) {

                    newContact.removeEmail(email);
                    contactFound = true;
                }
            }
            current = current.next;
        }
        return contactFound; // Contact not found
    }

    public int getNumberOfContacts() {
        return size;
    }

    public List<String> getEmailAddressesForContact(String lastName, String firstName) {
        if (head == null) {
            return null; // List is empty, return null or an empty list
        }

        Node current = head;
        while (current != null) {
            Contact newContact = (Contact) current.data;
            if (newContact.getFirstName().equals(firstName) && newContact.getLastName().equals(lastName)) {
                return newContact.getEmailAddresses();
            }
            current = current.next;
        }
        return null; // Contact not found, return null or an empty list
    }

    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Data found in the list
            }
            current = current.next;
        }
        return false; // Data not found
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public void mergeLists(DoubleLinkedList<T> otherList) {
        if (otherList == null || otherList.isEmpty()) {
            return; // Nothing to merge if the other list is empty or null
        }
        // TODO
        Node current = otherList.getHead();
        while(current != null) {
            addContact(current.data);
            current = current.next;
        }
    }

    public void printList() {
        // TODO
        Node current = head;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    public Node getHead() {
        return head;
    }


    // Additional methods as needed for handling duplicates
}
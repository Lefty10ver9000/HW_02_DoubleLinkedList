package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    private DoubleLinkedList<Contact> list;
    private Contact p1;
    private Contact p2;
    private Contact p3;

    @BeforeEach
    void setup() {
        list = new DoubleLinkedList<>();
        p1 = new Contact("Worthey", "William");
        p2 = new Contact("Scaggs", "Dawson");
        p3 = new Contact("Worthey", "Jacob");
    }

    @Test
    public void add() {
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        list.printList();
    }

    @Test
    public void deleteContact() {
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        list.printList();
        assertEquals(true, list.deleteContact("Worthey", "William"));
        list.printList();
    }

    @Test
    public void add1() {
        list.addContact(p2);
        list.addContact(p2);
        list.addContact(p1);
        list.printList();
    }

    @Test
    public void addEmail() {
        p1.addEmail("lefty10ver9000@gmail.com");
        p2.addEmail("samueldscaggs@gmail.com");
        p3.addEmail("jacobaworthey@gmail.com");
        p1.addEmail("lefty10ver9000@gmail.com");
        p1.addEmail("wbw64076@uga.edu");
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        list.printList();
    }

    @Test
    public void remove() {
        p1.addEmail("lefty10ver9000@gmail.com");
        p2.addEmail("samueldscaggs@gmail.com");
        p3.addEmail("jacobaworthey@gmail.com");
        p1.addEmail("lefty10ver9000@gmail.com");
        p1.addEmail("wbw64076@uga.edu");
        assertEquals(true, p1.removeEmail("lefty10ver9000@gmail.com"));
        p3.removeEmail("jacobaworthey@gmail.com");
        assertEquals(false, p2.removeEmail("fakenamethatisntanemail@edu"));
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        list.printList();
    }

    @Test
    public void delete() {
        p1.addEmail("lefty10ver9000@gmail.com");
        p2.addEmail("samueldscaggs@gmail.com");
        p3.addEmail("jacobaworthey@gmail.com");
        p1.addEmail("lefty10ver9000@gmail.com");
        p1.addEmail("wbw64076@uga.edu");
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        assertEquals(true, list.deleteEmailFromContact("Worthey", "William", "lefty10ver9000@gmail.com"));
        p3.removeEmail("jacobaworthey@gmail.com");
        assertEquals(false, list.deleteEmailFromContact("Worthey", "William", "thisdoesn;texceist"));

        list.printList();
    }

    @Test
    public void getEmail() {
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        p1.addEmail("lefty10ver9000@gmail.com");
        p2.addEmail("samueldscaggs@gmail.com");
        p3.addEmail("jacobaworthey@gmail.com");
        p1.addEmail("lefty10ver9000@gmail.com");
        p1.addEmail("wbw64076@uga.edu");
        System.out.println(list.getEmailAddressesForContact("Worthey", "William"));
        assertEquals(null, list.getEmailAddressesForContact("Not", "Real"));
        list.printList();
    }

    @Test
    public void mergeList() {
        list.addContact(p1);
        list.addContact(p2);
        list.addContact(p3);
        p1.addEmail("lefty10ver9000@gmail.com");
        p2.addEmail("samueldscaggs@gmail.com");
        p3.addEmail("jacobaworthey@gmail.com");
        p1.addEmail("lefty10ver9000@gmail.com");
        p1.addEmail("wbw64076@uga.edu");
        System.out.println("List 1:");
        list.printList();

        DoubleLinkedList<Contact> merge = new DoubleLinkedList<>();
        Contact p4 = new Contact("Hartfield", "Dylan");
        Contact p5 = new Contact("Jackson", "Lamar");
        Contact p6 = new Contact("Worthey", "William");

        merge.addContact(p4);
        merge.addContact(p5);
        merge.addContact(p6);
        p6.addEmail("lefty10ver9000@gmail.com");
        p4.addEmail("dhart@gmail.com");
        p5.addEmail("lamarthegoat@yahoo.com");

        System.out.println("List 2:");
        merge.printList();

        list.mergeLists(merge);
        System.out.println("Merged List 1:");
        list.printList();

    }




}
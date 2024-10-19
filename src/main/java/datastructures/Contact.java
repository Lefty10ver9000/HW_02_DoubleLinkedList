package datastructures;

//import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Comparable<Contact> {
    private String lastName;
    private final String firstName;
    private final List<String> emailAddresses;

    public Contact(String lastName,
                   String firstName ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddresses = new ArrayList<>();
    }

    // avoid adding duplicate email addresses
    public void addEmail(String email) {

        // TODO: Implement this method to add an email to the list, avoiding duplicates
        //      check and  see if email addresses contains the email if not add it
        //          where The 'add' is an ArrayList method
        while (true) {
            if (emailAddresses.contains(email)) {
                break;
            } else {
                emailAddresses.add(email);
                break;
            }
        }
    }

    public boolean removeEmail(String email) {

        // TODO: Implement this method to remove an email from the list
        //      Returns true if the list contained the specified email
        if (!(emailAddresses.contains(email))) {
            return false;
        } else {
            emailAddresses.remove(email);
        }
        return true;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter
    public String getFirstName() {
        return firstName;
    }
    // public void setFirstName(String firstName) { this.firstName = firstName; }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses.clear();
        if (emailAddresses != null) {
            for (String email : emailAddresses) {
                addEmail(email);
            }
        }
    }

    @Override
    public int compareTo(Contact other) {
        int lastNameComp = this.lastName.compareTo(other.lastName);
        if (lastNameComp != 0) {
            return lastNameComp;
        }
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return lastName.equals(contact.lastName) &&
                firstName.equals(contact.firstName);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAddresses=" + emailAddresses +
                '}';
    }
}

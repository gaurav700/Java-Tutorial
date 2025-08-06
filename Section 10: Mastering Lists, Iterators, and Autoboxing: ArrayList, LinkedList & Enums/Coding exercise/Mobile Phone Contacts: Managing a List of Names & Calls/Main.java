import java.util.ArrayList;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }
}

class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            return false;
        }
        this.myContacts.remove(foundPosition);
        return true;
    }

    public int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String name){
        for(int i = 0; i < this.myContacts.size(); i++){
            if(this.myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        int index = findContact(name);
        if(index >= 0)
            return this.myContacts.get(index);
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            System.out.println((i+1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }   
    }
}

public class Main {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("123-456-7890");

        Contact contact1 = Contact.createContact("Alice", "555-1234");
        Contact contact2 = Contact.createContact("Bob", "555-5678");

        phone.addNewContact(contact1);
        phone.addNewContact(contact2);

        phone.printContacts();

        Contact newContactForBob = Contact.createContact("Bob", "555-9999");
        phone.updateContact(contact2, newContactForBob);

        phone.printContacts();

        phone.removeContact(contact1);
        phone.printContacts();
    }
}

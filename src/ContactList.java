import java.util.ArrayList;
import java.util.List;

class ContactList {
  List<Contact> contacts;

  ContactList() {
    contacts = new ArrayList<>();
  }

  public void addContact(Contact newContact) {
    contacts.add(newContact);
  }

  public void printAllContacts() {
    int size = contacts.size();
    if (size == 0) {
      System.out.println("no entry.");
      return;
    }
    for (int i = 0; i < size; i++) {
      System.out.println(String.format("%d: %s", i, contacts.get(i)));
    }
  }
}

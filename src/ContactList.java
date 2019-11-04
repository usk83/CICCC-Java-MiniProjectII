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
}

import java.lang.IndexOutOfBoundsException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

class ContactList {
  List<Contact> contacts;

  ContactList() {
    contacts = new ArrayList<>();
  }

  public int printAllContacts() {
    int size = contacts.size();
    if (size == 0) {
      System.out.println("no entry.");
    } else {
      for (int i = 0; i < size; i++) {
        System.out.println(String.format("%d: %s", i, contacts.get(i)));
      }
    }
    return size;
  }

  public void addContact(Contact newContact) {
    contacts.add(newContact);
  }

  public Contact removeContact(String indexString) throws NumberFormatException {
    int index;
    try {
      index = Integer.valueOf(indexString);
    } catch (NumberFormatException e) {
      throw e;
    }
    return removeContact(index);
  }

  public Contact removeContact(int index) {
    if (index < 0 || index >= contacts.size()) {
      return null;
    }
    return contacts.remove(index);
  }

  public Contact getContact(String indexString)
      throws NumberFormatException, IndexOutOfBoundsException {
    int index;
    try {
      index = Integer.valueOf(indexString);
    } catch (NumberFormatException e) {
      throw e;
    }
    return getContact(index);
  }

  public Contact getContact(int index) throws IndexOutOfBoundsException {
    try {
      return contacts.get(index);
    } catch (IndexOutOfBoundsException e) {
      throw e;
    }
  }
}

import java.lang.IndexOutOfBoundsException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class ContactList {
  List<Contact> contacts;
  Set<List<String>> uniqueEntries;

  ContactList() {
    contacts = new ArrayList<>();
    uniqueEntries = new HashSet<List<String>>();
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

  private List<String> convertToEntry(Contact contact) {
    return new ArrayList<>(){{
      add(contact.getName());
      add(contact.getPhoneNumberMobile());
    }};
  }

  private boolean checkIfDuplicated(Contact contact) {
    return uniqueEntries.contains(convertToEntry(contact));
  }

  private boolean addEntry(Contact contact) {
    return uniqueEntries.add(convertToEntry(contact));
  }

  private boolean removeEntry(Contact contact) {
    return uniqueEntries.remove(convertToEntry(contact));
  }

  public boolean addContact(Contact newContact) {
    if (!addEntry(newContact)) {
      return false;
    }
    return contacts.add(newContact);
  }

  public Contact removeContact(String indexString)
      throws NumberFormatException, IndexOutOfBoundsException {
    int index;
    try {
      index = Integer.valueOf(indexString);
    } catch (NumberFormatException e) {
      throw e;
    }
    return removeContact(index);
  }

  public Contact removeContact(int index) throws IndexOutOfBoundsException {
    Contact removedContact;
    try {
      removedContact = contacts.remove(index);
    } catch (NumberFormatException e) {
      throw e;
    }
    removeEntry(removedContact);
    return removedContact;
  }

  public Contact updateContact(int index, Contact newContact) throws IndexOutOfBoundsException {
    Contact updatedContact;
    try {
      updatedContact = contacts.get(index);
    } catch (IndexOutOfBoundsException e) {
      throw e;
    }

    boolean same = updatedContact.getName().equals(newContact.getName())
      && updatedContact.getPhoneNumberMobile().equals(newContact.getPhoneNumberMobile());

    if (!same && checkIfDuplicated(newContact)) {
      return null;
    }

    try {
      updatedContact = contacts.set(index, newContact);
    } catch (IndexOutOfBoundsException e) {
      throw e;
    }

    if (!same) {
      addEntry(newContact);
      removeEntry(updatedContact);
    }

    return updatedContact;
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

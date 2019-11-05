import java.lang.IllegalStateException;
import java.lang.NumberFormatException;
import java.util.regex.Pattern;

public class Driver {
  private static final Pattern REGEX_PATTER_PHONE_NUMBER
    = Pattern.compile("^(\\+\\d{1,2} ?)?\\(?\\d{2,4}\\)?[ -]?\\d{3,4}-?\\d{3,4}$");
  private static final String MENU = ""
      + "+≡≡≡  Contact  App  ≡≡≡+\n"
      + "| 1. List all Contacts |\n"
      + "| 2. Add new Contact   |\n"
      + "| 3. Remove Contact    |\n"
      + "| 4. Update Contact    |\n"
      + "| 5. Quit              |\n"
      + "+======================+";
  private static final String ASK_OPTION = "Enter your option: ";

  public static void main(String[] args) {
    ContactList contactList = new ContactList();
    boolean quitRequested = false;
    while(!quitRequested) {
      System.out.println(MENU);
      String userInput = "";
      try {
        userInput = InputCollector.getUserInput(ASK_OPTION);
      } catch (IllegalStateException e) {
        System.err.println("Something went wrong.");
        System.exit(-1);
      }
      switch (Command.parse(userInput)) {
        case LIST: {
          contactList.printAllContacts();
          break;
        }
        case NEW: {
          boolean added = false;
          try {
            added = contactList.addContact(new Contact(
              InputCollector.getUserInput("Enter name: ", true),
              InputCollector.getUserInput("Enter mobile: ", true, REGEX_PATTER_PHONE_NUMBER),
              InputCollector.getUserInput("Enter work: ", REGEX_PATTER_PHONE_NUMBER),
              InputCollector.getUserInput("Enter home: ", REGEX_PATTER_PHONE_NUMBER),
              InputCollector.getUserInput("Enter city: ")
            ));
          } catch (IllegalStateException e) {
            System.err.println("Something went wrong.");
            System.exit(-1);
          }
          if (added) {
            System.out.println("Successfully added a new contact!");
          } else {
            System.err.println("Cannot add to ContactList. The contact is duplicated.");
          }
          break;
        }
        case REMOVE: {
          if (contactList.printAllContacts() == 0) {
            continue;
          }
          String index = "";
          try {
            index = InputCollector.getUserInput("Enter the index of the contact to remove: \n");
          } catch (IllegalStateException e) {
            System.err.println("Something went wrong.");
            System.exit(-1);
          }
          if (index.isEmpty()) {
            continue;
          }
          Contact removedContact;
          try {
            removedContact = contactList.removeContact(index);
          } catch (NumberFormatException e) {
            System.err.println("Invalid Input.");
            continue;
          } catch (IllegalStateException e) {
            System.err.println("Specified entry is not found.");
            continue;
          }
          System.out.println("Successfully removed " + removedContact.getName());
          break;
        }
        case UPDATE: {
          if (contactList.printAllContacts() == 0) {
            continue;
          }
          String index = "";
          try {
            index = InputCollector.getUserInput("Enter the index of the contact to update: \n");
          } catch (IllegalStateException e) {
            System.err.println("Something went wrong.");
            System.exit(-1);
          }
          if (index.isEmpty()) {
            continue;
          }

          int indexNumber;
          try {
            indexNumber = Integer.valueOf(index);
          } catch (NumberFormatException e) {
            System.err.println("Invalid Input.");
            continue;
          }

          try {
            contactList.getContact(indexNumber);
          } catch (IndexOutOfBoundsException e) {
            System.err.println("Specified entry is not found.");
            continue;
          }

          Contact newContact = new Contact(
            InputCollector.getUserInput("Enter name: ", true),
            InputCollector.getUserInput("Enter mobile: ", true, REGEX_PATTER_PHONE_NUMBER),
            InputCollector.getUserInput("Enter work: ", REGEX_PATTER_PHONE_NUMBER),
            InputCollector.getUserInput("Enter home: ", REGEX_PATTER_PHONE_NUMBER),
            InputCollector.getUserInput("Enter city: ")
          );
          Contact updaredContact = contactList.updateContact(indexNumber, newContact);
          if (updaredContact != null) {
            System.out.printf("Successfully updated %s to %s\n", updaredContact, newContact);
          } else {
            System.err.println("Cannot update. The contact is duplicated.");
          }
          break;
        }
        case QUIT: {
          quitRequested = true;
          break;
        }
        case INVALID: {
          System.err.println("Invalid Input. Enter number between 1 and 5.");
          break;
        }
      }
    }
    System.out.println("Bye!");
  }
}

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public class Driver {
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
      Command com;
      try {
        String userInput = InputCollector.getUserInput(ASK_OPTION);
        com = Command.parse(userInput);
      }
      catch (NoSuchElementException e) {
        System.err.println("Cannot read input.");
        continue;
      }
      catch (IllegalStateException e) {
        System.err.println("");
        break;
      }

      switch (com) {
        case QUIT:
          quitRequested = true;
          break;
      }
    }
    System.out.println("Bye!");
  }
}

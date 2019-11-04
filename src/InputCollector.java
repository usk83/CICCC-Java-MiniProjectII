import java.lang.IllegalStateException;
import java.util.Scanner;
import java.util.NoSuchElementException;

class InputCollector {
  private static final Scanner STDIN_SCANNER = new Scanner(System.in);
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RESET = "\u001B[0m";

  static String getUserInput(String prompt) throws IllegalStateException {
    return getUserInput(prompt, false);
  }

  static String getUserInput(String prompt, boolean required) throws IllegalStateException {
    return getUserInput(prompt, required, "You must enter this field.");
  }

  static String getUserInput(String prompt, boolean required, String errMsg)
      throws IllegalStateException {
    String input;

    while (true) {
      System.out.print(prompt);
      System.out.print(ANSI_GREEN);
      try {
        input = STDIN_SCANNER.nextLine();
      }
      catch (NoSuchElementException e) {
        System.out.print(ANSI_RESET);
        System.err.println("Cannot read input. Try again.");
        continue;
      }
      catch (IllegalStateException e) {
        throw e;
      }
      finally {
        System.out.print(ANSI_RESET);
      }

      if (required && input.isEmpty()) {
        System.err.println(errMsg);
        continue;
      }
      break;
    }

    return input;
  }
}

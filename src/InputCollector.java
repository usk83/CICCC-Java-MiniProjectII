import java.lang.IllegalStateException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

class InputCollector {
  private static final Scanner STDIN_SCANNER = new Scanner(System.in);
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String DEAFULT_ERR_MSG = "You must enter this field.";
  private static final String REGEX_ERR_MSG = "Your input was invalid. Try again.";

  static String getUserInput(String prompt) throws IllegalStateException {
    return getUserInput(prompt, false);
  }

  static String getUserInput(String prompt, Pattern p) throws IllegalStateException {
    return getUserInput(prompt, false, "", p);
  }

  static String getUserInput(String prompt, boolean required) throws IllegalStateException {
    return getUserInput(prompt, required, "", null);
  }

  static String getUserInput(String prompt, boolean required, Pattern p) throws IllegalStateException {
    return getUserInput(prompt, required, "", p);
  }

  static String getUserInput(String prompt, boolean required, String errMsg) {
    return getUserInput(prompt, required, errMsg, null);
  }

  static String getUserInput(String prompt, boolean required, String errMsg, Pattern p)
      throws IllegalStateException {
    String input;

    while (true) {
      System.out.print(prompt);
      System.out.print(ANSI_GREEN);
      try {
        input = STDIN_SCANNER.nextLine();
      } catch (NoSuchElementException e) {
        System.out.print(ANSI_RESET);
        System.err.println("Cannot read input. Try again.");
        continue;
      } catch (IllegalStateException e) {
        throw e;
      }
      finally {
        System.out.print(ANSI_RESET);
      }

      if (required && input.isEmpty()) {
        if (!errMsg.isEmpty()) {
          System.err.println(errMsg);
        } else {
          System.err.println(DEAFULT_ERR_MSG);
        }
        continue;
      }
      if (required || !input.isEmpty()) {
        if (p != null && !p.matcher(input).matches()) {
          System.err.println(REGEX_ERR_MSG);
          continue;
        }
      }
      break;
    }

    return input;
  }
}

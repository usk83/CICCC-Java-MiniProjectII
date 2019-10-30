import java.lang.IllegalStateException;
import java.util.Scanner;
import java.util.NoSuchElementException;

class InputCollector {
  private static final Scanner STDIN_SCANNER = new Scanner(System.in);
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RESET = "\u001B[0m";

  static String getUserInput(String prompt)
      throws NoSuchElementException, IllegalStateException {
    System.out.print(prompt);
    System.out.print(ANSI_GREEN);
    String input = STDIN_SCANNER.nextLine();
    System.out.print(ANSI_RESET);
    return input;
  }
}

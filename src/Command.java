enum Command {
  LIST,
  NEW,
  REMOVE,
  UPDATE,
  QUIT,
  INVALID;

  static Command parse(String str) {
    // JEP 361: Switch Expressions (Standard)
    // https://openjdk.java.net/jeps/361
    // return switch (str.toLowerCase()) {
    //   case "1", "l", "list" -> LIST;
    //   case "2", "n", "new" -> NEW;
    //   case "3", "r", "remove" -> REMOVE;
    //   case "4", "u", "update" -> UPDATE;
    //   case "5", "q", "quit" -> QUIT;
    //   default -> INVALID;
    // };
    switch (str.toLowerCase()) {
      case "1":
      case "l":
      case "list":
        return LIST;
      case "2":
      case "n":
      case "new":
        return NEW;
      case "3":
      case "r":
      case "remove":
        return REMOVE;
      case "4":
      case "u":
      case "update":
        return UPDATE;
      case "5":
      case "q":
      case "quit":
        return QUIT;
      default:
        return INVALID;
    }
  }
}

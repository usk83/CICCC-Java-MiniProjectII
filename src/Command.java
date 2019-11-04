enum Command {
  LIST,
  NEW,
  REMOVE,
  QUIT,
  INVALID;

  static Command parse(String str) {
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
      case "5":
      case "q":
      case "quit":
        return QUIT;
    }
    return INVALID;
  }
}

enum Command {
  LIST,
  NEW,
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
      case "5":
      case "q":
      case "quit":
        return QUIT;
    }
    return INVALID;
  }
}

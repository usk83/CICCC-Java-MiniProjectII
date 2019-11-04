enum Command {
  QUIT,
  INVALID;

  static Command parse(String str) {
    switch (str.toLowerCase()) {
      case "5":
      case "q":
      case "quit":
        return QUIT;
    }
    return INVALID;
  }
}

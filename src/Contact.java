class Contact {
  private String name;
  private String phoneNumberMobile;
  private String phoneNumberWork;
  private String phoneNumberHome;
  private String city;

  Contact(String name, String phoneNumberMobile) {
    this.name = name;
    this.phoneNumberMobile = phoneNumberMobile;
  }

  Contact(
      String name,
      String phoneNumberMobile,
      String phoneNumberWork,
      String phoneNumberHome,
      String city) {
    this(name, phoneNumberMobile);
    this.phoneNumberWork = phoneNumberWork;
    this.phoneNumberHome = phoneNumberHome;
    this.city = city;
  }
}

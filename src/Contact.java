import java.lang.StringBuilder;

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

  public String getName() {
    return name;
  }

  public String getPhoneNumberMobile() {
    return phoneNumberMobile;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('<');
    sb.append(name);
    sb.append("> ");
    sb.append("(mobile=");
    sb.append(phoneNumberMobile);
    if (!phoneNumberWork.isEmpty()) {
      sb.append(", work=");
      sb.append(phoneNumberWork);
    }
    if (!phoneNumberHome.isEmpty()) {
      sb.append(", home=");
      sb.append(phoneNumberHome);
    }
    if (!city.isEmpty()) {
      sb.append(", city=");
      sb.append(city);
    }
    sb.append(")");
    return sb.toString();
  }
}

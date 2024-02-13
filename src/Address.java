public class Address {
  // 1. encapsulating
    private String streetNumber;
   private String streetName;
   private String additionalAddressLine;
   private String zeepCode;
   private String state;

   // 2. con - to set() the instance variable to the objects
    public Address(String streetNumber, String streetName, String additionalAddressLine, String zeepCode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalAddressLine = additionalAddressLine;
        this.zeepCode = zeepCode;
        this.state = state;
    }

    // 3. get() to read information
    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAdditionalAddressLine() {
        return additionalAddressLine;
    }

    public String getZeepCode() {
        return zeepCode;
    }

    public String getState() {
        return state;
    }
}

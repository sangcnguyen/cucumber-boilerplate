package model;

public class Customer {
    public String firstName;
    public String lastName;
    public String emailAddress;
    public Address address;
    public String phoneNumber;

    public class Address {
        public String streetAddress;
        public String city;
        public String postCode;
        public String state;
        public String country;
    }
}

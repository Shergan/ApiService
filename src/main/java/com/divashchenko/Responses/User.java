package com.divashchenko.Responses;

public class User {
    public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    public class Geo {
        private double lat;
        private double lng;
    }

    public class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;

}

package com.company;

import com.company.Address;

import java.util.List;
import java.util.UUID;

public class Customer {
    /*Type name;
     primitive or non-primitive (obj class)
     more than one address - Collection Interface is preferable Polymorphism

     */

    private UUID id; // create the random id
    private String userName;
    private String email;
    private List<Address> address;

    // con 1 - overloading in the same class
    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
    // con 2
    public Customer(UUID id, String userName, String email, List<Address> address) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    // get()

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddress() {
        return address;
    }
}




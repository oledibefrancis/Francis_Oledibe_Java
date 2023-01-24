package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;

    private final List<AccountRecord> charges = new ArrayList<>();

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {

        int balance = 0;
        for (AccountRecord c : charges){
                balance+=c.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }


    @Override
    public String toString() {

        return  "Id: " + id + ", Name: " + name + ", Balance: " + getBalance();

    }

    public void display(){
        System.out.println(toString());
    }

}

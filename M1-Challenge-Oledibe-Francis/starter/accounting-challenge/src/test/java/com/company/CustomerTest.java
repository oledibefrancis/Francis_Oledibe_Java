package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class CustomerTest {

    //This function test that the getBalance Function calculates the accurate figure
    @Test
    public void shouldCalculateBalance(){
        Customer customer = new Customer();
        List<Customer> customerList = new ArrayList<>();
        AccountRecord accountRecord = new AccountRecord();
        AccountRecord accountRecord2 = new AccountRecord();

        //mock a customer
        customer.setId(1);
        customer.setName("Prog Lang");
        customerList.add(customer);

        accountRecord.setCharge(2000);
        accountRecord.setChargeDate("01-03-2022");

        accountRecord2.setCharge(1000);
        accountRecord2.setChargeDate("01-25-2022");


        customer.getCharges().add(accountRecord);
        customer.getCharges().add(accountRecord2);
        System.out.println(customer.getBalance());
        assertEquals(3000, customerList.get(0).getBalance());
    }


    @Test
    public void testToString(){
        //This function test my toString function
        Customer customer = new Customer();
        List<Customer> customerList = new ArrayList<>();
        AccountRecord accountRecord = new AccountRecord();
        AccountRecord accountRecord2 = new AccountRecord();

        //mocking a customer
        customer.setId(1);
        customer.setName("Programming Lang");
        customerList.add(customer);

        accountRecord.setCharge(2000);
        accountRecord.setChargeDate("01-03-2022");

        accountRecord2.setCharge(1000);
        accountRecord2.setChargeDate("01-25-2022");


        customer.getCharges().add(accountRecord);
        customer.getCharges().add(accountRecord2);

        String expected ="Id: 1, Name: Programming Lang, Balance: 3000";
        assertEquals(expected,customer.toString());
    }

    @Test
    public void toStringShouldContainId(){
        // This function tests that the to string function returns an ID

        Customer customer = new Customer();
        List<Customer> customerList = new ArrayList<>();
        AccountRecord accountRecord = new AccountRecord();
        AccountRecord accountRecord2 = new AccountRecord();

        //mocking a customer
        customer.setId(1);
        customer.setName("Programming Lang");
        customerList.add(customer);

        accountRecord.setCharge(2000);
        accountRecord.setChargeDate("01-03-2022");

        accountRecord2.setCharge(1000);
        accountRecord2.setChargeDate("01-25-2022");


        customer.getCharges().add(accountRecord);
        customer.getCharges().add(accountRecord2);

        String toString = customer.toString();
        assertTrue(toString.contains("Id:"));

    }

    @Test
    public void toStringShouldBeOfTypeString(){
        //this function test that the to string function is of type string

        Customer customer = new Customer();
        List<Customer> customerList = new ArrayList<>();
        AccountRecord accountRecord = new AccountRecord();
        AccountRecord accountRecord2 = new AccountRecord();

        //mocking a customer
        customer.setId(1);
        customer.setName("Programming Lang");
        customerList.add(customer);

        accountRecord.setCharge(2000);
        accountRecord.setChargeDate("01-03-2022");

        accountRecord2.setCharge(1000);
        accountRecord2.setChargeDate("01-25-2022");


        customer.getCharges().add(accountRecord);
        customer.getCharges().add(accountRecord2);

        String myString = customer.toString();
        assertTrue(myString instanceof String);

    }
}
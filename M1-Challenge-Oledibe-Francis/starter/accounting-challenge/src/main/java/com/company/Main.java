package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Main {

    private static final List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}
    );

    public static void main(String[] args) {
        // Created an empty Hashmap that maps. => String : Name -> List
        HashMap<String, List> customerMap = new HashMap<>();
        List<Customer> customerList = new ArrayList<>();

        // Iterate through customerData,
        for (String[] customer : customerData) {
            // In this loop I am mapping the customer name to a list of the customer data
            if (customerMap.containsKey(customer[1])) {

                List<String> customerInfo = new ArrayList<>();
                customerInfo.add(customer[0]);
                customerInfo.add(customer[2]);
                customerInfo.add(customer[3]);

                customerMap.get(customer[1]).add(customerInfo);
            } else {
                customerMap.put(customer[1], new ArrayList());

                List<String> customerInfo = new ArrayList<>();
                customerInfo.add(customer[0]);
                customerInfo.add(customer[2]);
                customerInfo.add(customer[3]);

                customerMap.get(customer[1]).add(customerInfo);
            }
        }

        // Iterating through my newly created hashmap
        for (Map.Entry<String, List> set :
                customerMap.entrySet()) {

            //Create a new customer object do the following
            // 1) set the name, 2) set the ID
            Customer newCustomer = new Customer();
            newCustomer.setName(set.getKey());
            ArrayList<String> mylist = (ArrayList<String>) set.getValue().get(0);
            String id = mylist.get(0);
            newCustomer.setId(Integer.parseInt(id));

            // 3) Create a new Account record object and add it to the customer my charges list
            ArrayList<ArrayList<String>> customerDetails = (ArrayList<ArrayList<String>>) set.getValue();
            for (List<String> elem : customerDetails) {
                AccountRecord newAccountRecord = new AccountRecord();
                newAccountRecord.setCharge(Integer.parseInt(elem.get(1)));
                newAccountRecord.setChargeDate(elem.get(2));

                //add it to the customer my charges list
                newCustomer.getCharges().add(newAccountRecord);
            }

            // Add my new customer object to the customer list
            customerList.add(newCustomer);
        }

        System.out.println("Positive accounts:");
        for (Customer customer : customerList) {
            if (customer.getBalance() > 0)
                customer.display();
        }
        System.out.println("Negative accounts:");
        for (Customer customer : customerList) {
            if (customer.getBalance() < 0)
                customer.display();
        }
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String[]> customerData = Arrays.asList(
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

    public static boolean customerExists(List<Customer> customers, int id){
        int counter = 0;
        if(customers.size() > 0){
            for(Customer customer: customers){
                if (id == customer.getId()){
                    counter++;
                }
            }
        }

        if(counter>0){return true;}else{return false;}
    }

    public static void addAccountRecord(List<Customer> customers, AccountRecord accountRecord, int id){
        int index =0;
        for(Customer customer1: customers){
            if(customer1.getId() == id){
                index = customers.indexOf(customer1);
            }
        }
        //Using the index, get the appropriate customer from the list of
        // customers and add the account record
        customers.get(index).getCharges().add(accountRecord);
    }

    public static void main(String[] args) {
        //initialize a list of customers
        List<Customer> customers  = new ArrayList<>();
        //initialize a list each to store positive and negative accounts
        List<Customer> positiveAccounts = new ArrayList<>(), negativeAccounts = new ArrayList<>();

        //Pick each string array (which represents an account record)
        for (String[] customer_data: customerData) {
            //If ID doesn't already exist, create a new customer
            if (!customerExists(customers, Integer.parseInt(customer_data[0]))) {
                //Create a new customer and Set ID and name
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(customer_data[0]));
                customer.setName(customer_data[1]);
                //Add the new customer to the list of customers
                customers.add(customer);
            }
            //Set charge and charge date for each string array
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(Integer.parseInt(customer_data[2]));
            accountRecord.setChargeDate(customer_data[3]);

            //Adding the account record to an already existing customer
            addAccountRecord(customers,accountRecord,Integer.parseInt(customer_data[0]));
        }

        //Populating the positiveAccounts and negativeAccounts lists
        for(Customer customer1: customers){
            if (customer1.getBalance() > 0){
                positiveAccounts.add(customer1);
            }
            else{
                negativeAccounts.add(customer1);
            }
        }

        System.out.println("***Details of All Accounts***\n" + customers);
        System.out.println("\n\nPositive accounts:\n" + positiveAccounts);
        System.out.println("\n\nNegative accounts:\n" + negativeAccounts);
    }
}
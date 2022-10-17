package com.company.customerdata.repository;

import com.company.customerdata.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void addGetDeleteCustomer(){
        Customer customer = new Customer();
        customer.setLastName("Asamoah");
        customer.setFirstName("Frank");
        customer.setEmail("asamoahfrank@2u.com");
        customer.setCompany("2U Inc");
        customer.setPhone("342-777-8888");
        customer.setAddress1("22 Norview Avenue");
        customer.setAddress2("22 Norchester St");
        customer.setCity("Virginia Beach");
        customer.setState("VA");
        customer.setPostalCode("29905");
        customer.setCountry("United States");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getCustomerId());
        assertEquals(customer1.get(), customer);

        customerRepository.deleteById(customer.getCustomerId());
        customer1 = customerRepository.findById(customer.getCustomerId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setLastName("Asamoah");
        customer.setFirstName("Frank");
        customer.setEmail("asamoahfrank@2u.com");
        customer.setCompany("2U Inc");
        customer.setPhone("342-777-8888");
        customer.setAddress1("22 Norview Avenue");
        customer.setAddress2("22 Norchester St");
        customer.setCity("Virginia Beach");
        customer.setState("VA");
        customer.setPostalCode("29905");
        customer.setCountry("United States");

        customer = customerRepository.save(customer);

        //Update some fields in the record
        customer.setCity("Dover");
        customer.setState("NJ");
        customer.setPostalCode("44305");
        customerRepository.save(customer);

        //Load updated data from database and compare to local variable customer
        Optional<Customer> customer1 = customerRepository.findById(customer.getCustomerId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getCustomersByState(){
        //Create and save a customer record
        Customer customer = new Customer();
        customer.setLastName("Asamoah");
        customer.setFirstName("Frank");
        customer.setEmail("asamoahfrank@2u.com");
        customer.setCompany("2U Inc");
        customer.setPhone("342-777-8888");
        customer.setAddress1("22 Norview Avenue");
        customer.setAddress2("22 Norchester St");
        customer.setCity("Virginia Beach");
        customer.setState("VA");
        customer.setPostalCode("29905");
        customer.setCountry("United States");
        customerRepository.save(customer);

        //Create and save another customer record (ensure state for both customers are the same)
        customer = new Customer();
        customer.setLastName("Blake");
        customer.setFirstName("Godfred");
        customer.setEmail("bgodfred@hotmail.com");
        customer.setCompany("2U Inc");
        customer.setPhone("342-777-8888");
        customer.setAddress1("22 Norview Avenue");
        customer.setAddress2("22 Norchester St");
        customer.setCity("Virginia Beach");
        customer.setState("VA");
        customer.setPostalCode("29905");
        customer.setCountry("United States");
        customerRepository.save(customer);

        //Create and save another customer record (ensure state is different from first two customers)
        customer = new Customer();
        customer.setLastName("Lilies");
        customer.setFirstName("Majestic");
        customer.setEmail("lmajestic@hotmail.com");
        customer.setCompany("2U Inc");
        customer.setPhone("342-777-8888");
        customer.setAddress1("22 Norview Avenue");
        customer.setAddress2("22 Norchester St");
        customer.setCity("Virginia Beach");
        customer.setState("NC");
        customer.setPostalCode("29905");
        customer.setCountry("United States");
        customerRepository.save(customer);

        //Test the findByState() method
        List<Customer> customerList = customerRepository.findByState("VA");
        assertEquals(customerList.size(),2);
    }
}
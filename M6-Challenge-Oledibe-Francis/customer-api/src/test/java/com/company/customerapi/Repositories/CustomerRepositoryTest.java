package com.company.customerapi.Repositories;

import com.company.customerapi.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setup() throws Exception {

        //shows that my database is in a consistent state
        customerRepository.deleteAll();
    }

    @Test
    public void shouldCreateNewCustomer() {

        //Arrange.....
        Customer customer = new Customer();
        customer.setFirstName("Francis");
        customer.setLastName("Oledibe");
        customer.setEmail("francis@2U.com");
        customer.setPhone("000-657-2345");
        customer.setCompany("2U");
        customer.setAddress1("1234,Daisy Bates,");
        customer.setAddress2("New York city, newYork");
        customer.setCity("Lagos");
        customer.setState("New York");
        customer.setPostalCode("10383");
        customer.setCountry("United State");

        //Act....
        customer = customerRepository.save(customer);

        //Assert.....
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer() {

        //Arrange.....
        Customer customer = new Customer();
        customer.setFirstName("Francis");
        customer.setLastName("Oledibe");
        customer.setEmail("francis@2U.com");
        customer.setPhone("000-657-2345");
        customer.setCompany("2U");
        customer.setAddress1("1234,Daisy Bates,");
        customer.setAddress2("New York city, newYork");
        customer.setCity("Lagos");
        customer.setState("New York");
        customer.setPostalCode("10383");
        customer.setCountry("United State");

        //Act....
        customerRepository.save(customer);

        customer.setCompany("Uber");
        customer.setState("California");

        customerRepository.save(customer);

        //Assert
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);

    }

    @Test
    public void shouldDeleteCustomer() {
        //Arrange.....

        Customer customer = new Customer();
        customer.setFirstName("Francis");
        customer.setLastName("Oledibe");
        customer.setEmail("francis@2U.com");
        customer.setPhone("000-657-2345");
        customer.setCompany("2U");
        customer.setAddress1("1234,Daisy Bates,");
        customer.setAddress2("New York city, newYork");
        customer.setCity("Lagos");
        customer.setState("New York");
        customer.setPostalCode("10383");
        customer.setCountry("United State");

        customerRepository.save(customer);

        //Act....
        customerRepository.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertFalse(customer1.isPresent());


    }

    @Test
    public void shouldFindCustomerById() {
        //Arrange.....
        Customer customer = new Customer();
        customer.setFirstName("Francis");
        customer.setLastName("Oledibe");
        customer.setEmail("francis@2U.com");
        customer.setPhone("000-657-2345");
        customer.setCompany("2U");
        customer.setAddress1("1234,Daisy Bates,");
        customer.setAddress2("New York city, newYork");
        customer.setCity("Lagos");
        customer.setState("New York");
        customer.setPostalCode("10383");
        customer.setCountry("United State");

        //Act....
        customer = customerRepository.save(customer);

        //Assert.....
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldFindCustomersByState() {
        //Arrange.....
        Customer customer = new Customer();
        customer.setFirstName("Francis");
        customer.setLastName("Oledibe");
        customer.setEmail("francis@2U.com");
        customer.setPhone("000-657-2345");
        customer.setCompany("2U");
        customer.setAddress1("1234,Daisy Bates,");
        customer.setAddress2("New York city, newYork");
        customer.setCity("Lagos");
        customer.setState("New York");
        customer.setPostalCode("10383");
        customer.setCountry("United State");

        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("johndoo@2u.com");
        customer1.setPhone("000-657-2345");
        customer1.setCompany("2U");
        customer1.setAddress1("1234,Daisy Bates,");
        customer1.setAddress2("New York city, newYork");
        customer1.setCity("Lagos");
        customer1.setState("New York");
        customer1.setPostalCode("10383");
        customer1.setCountry("United State");


        //Act....
        customerRepository.save(customer);
        customerRepository.save(customer1);

        //Assert.....
        List<Customer> expectedCustomer = customerRepository.findByState(customer1.getState());


        assertEquals(2, expectedCustomer.size());
    }
}

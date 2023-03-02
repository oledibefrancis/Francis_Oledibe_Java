package com.company.customerapi.controllers;

import com.company.customerapi.Repositories.CustomerRepository;
import com.company.customerapi.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerRepository customerRepository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateNewCustomer() throws Exception {

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

        String inputJson = mapper.writeValueAsString(customer);
        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void shouldUpdateNewCustomer() throws Exception {


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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent());

    }

    @Test
    public void shouldDeleteNewCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(1);
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

        mockMvc.perform(delete("/customers/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception {

        Customer customer = new Customer();
        customer.setId(1);
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

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/id/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerByState() throws Exception {

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

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/state/Lagos"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}

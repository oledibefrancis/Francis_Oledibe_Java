package com.company.customerapi.controllers;

import com.company.customerapi.Repositories.CustomerRepository;
import com.company.customerapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/customers/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = repository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/customers/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomerByState(@PathVariable String state) {
        return repository.findByState(state);
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customer;
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable int id) {
        repository.deleteById(id);
    }


}

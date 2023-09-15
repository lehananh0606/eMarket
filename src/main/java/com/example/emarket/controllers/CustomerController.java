package com.example.emarket.controllers;

import com.example.emarket.models.entities.Customer;
import com.example.emarket.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void addNewCustomer(String firstName,
                               String lastName,
                               String address,
                               Integer age,
                               String status
    ) {

        Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .age(age.shortValue())
                .status(status)
                .build();

        customerService.save(customer);
    }

}

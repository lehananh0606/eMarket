package com.example.emarket.controllers;

import com.example.emarket.models.entities.Contract;
import com.example.emarket.services.ApartmentService;
import com.example.emarket.services.ContractService;
import com.example.emarket.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    private final ContractService contractService;
    private final CustomerService customerService;
    private final ApartmentService apartmentService;
    public ContractController(
            ContractService contractService,
            CustomerService customerService,
            ApartmentService apartmentService
    ) {
        this.contractService = contractService;
        this.customerService = customerService;
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @PostMapping
    public void addNewContract(
            String customerId,
            String apartmentId,
            String startDate,
            String endDate
    ) {

        Contract contract = Contract.builder()
                .customerID(customerService.getCustomerById(customerId))
                .apartmentID(apartmentService.getApartmentById(apartmentId))
                .startDate(LocalDate.parse(startDate))
                .endDate(LocalDate.parse(endDate))
                .build();

        contractService.addNewContract(contract);
    }
}

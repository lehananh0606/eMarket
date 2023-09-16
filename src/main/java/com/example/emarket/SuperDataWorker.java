package com.example.emarket;


import com.example.emarket.model.ApartmentDAO;
import com.example.emarket.model.ContractDAO;
import com.example.emarket.model.CustomerDAO;
import com.example.emarket.service.ApartmentService;
import com.example.emarket.service.ContractService;
import com.example.emarket.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SuperDataWorker {
    public static void main(String[] args) {
        // Initialize the Spring Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext(EMarketApplication.class);

        // Get instances of your services and DAOs
        CustomerService customerService = context.getBean(CustomerService.class);
        ApartmentService apartmentService = context.getBean(ApartmentService.class);
        ContractService contractService = context.getBean(ContractService.class);
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
        ApartmentDAO apartmentDAO = context.getBean(ApartmentDAO.class);
        ContractDAO contractDAO = context.getBean(ContractDAO.class);

        // TODO: Implement your data processing logic here
        // For example, load data from files and use services and DAOs to interact with the database.

        // Close the Spring Application Context when done
        ((AnnotationConfigApplicationContext) context).close();
    }
}


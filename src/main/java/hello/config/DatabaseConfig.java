/*
 * Copyright (c) 2015 Charles Lavery <charles.lavery@gmail.com>
 */

package hello.config;

import hello.Customer;
import hello.CustomerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig implements CommandLineRunner{
    private static Log logger = LogFactory.getLog(DatabaseConfig.class);

    @Autowired
    CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Initializing CustomerRepository");

        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        repository.save(new Customer("Chuck", "Lavery"));

        // fetch all customers
        logger.info("Customers found with findAll():");
        for (Customer customer : repository.findAll()) {
            logger.info(customer);
        }
    }
}

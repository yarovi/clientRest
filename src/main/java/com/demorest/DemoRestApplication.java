package com.demorest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demorest.entity.Cliente;
import com.demorest.service.ClienteService;

@SpringBootApplication
public class DemoRestApplication implements CommandLineRunner {

    public static void main(final String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */

    @Autowired
    private ClienteService service;

    @Override
    public void run(final String... args) throws Exception {


        this.service.insert(new Cliente(10, "123456", "Coyyote River", 100d, 50));
        this.service.insert(new Cliente(11, "123456", "Pedro Castillo", 200d, 10));
        this.service.insert(new Cliente(12, "123456", "Carmen Alva", 500d, 98));
    }

}

package com.demorest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demorest.entity.Cliente;
import com.demorest.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente() {

        List<Cliente> lstCliente = new ArrayList<>();
        lstCliente = this.clienteService.getAll();
        return new ResponseEntity<>(lstCliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody final Cliente c) {
        this.clienteService.insert(c);

        return ResponseEntity.ok(c);

    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody final Cliente c) {

        this.clienteService.update(c);
        return ResponseEntity.ok(c);

    }

}

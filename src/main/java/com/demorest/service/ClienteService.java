package com.demorest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demorest.entity.Cliente;
import com.demorest.repository.ClienteRepository;
import com.demorest.utils.ClienteNotFoundException;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    public int insert(final Cliente c) {
        if (c.getCodigo() == 0) {
            throw new ClienteNotFoundException("Mala request intenta de nuevo.");
        }
        return this.clienteRepository.insert(c);
    }

    public Cliente findById(final int l) {
        return this.clienteRepository.findById(l);


    }

    public List<Cliente> getAll() {
        return this.clienteRepository.findAll();
    }

    public int update(final Cliente c) {
        return this.clienteRepository.update(c);
    }

}

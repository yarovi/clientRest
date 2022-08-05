package com.demorest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demorest.entity.Cliente;
import com.demorest.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	
	public int insert(Cliente c) {
		return clienteRepository.insert(c);
	}
	
	public Cliente findById(int l) {
		 return clienteRepository.findById(l);
		
		 
	}
	
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
	public int update(Cliente c) {
		return clienteRepository.update(c);
	}
}

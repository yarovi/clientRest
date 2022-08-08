/*
 * Copyright (c) 2021. Inditex
 */

package com.demorest;

import java.util.ArrayList;
import java.util.List;

import com.demorest.entity.Cliente;
import com.demorest.repository.ClienteRepository;
import com.demorest.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author yrosadov
 */

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {


    @InjectMocks
    ClienteService service;

    @Mock
    ClienteRepository dao;

    @Test
    public void testFindAllEmployees() {
        final List<Cliente> list = new ArrayList<Cliente>();
        final Cliente cl1 = new Cliente(1, "123456", "Coyyote River", 100d, 50);
        final Cliente cl2 = new Cliente(1, "123456", "Pedro Castillo", 200d, 10);
        final Cliente cl3 = new Cliente(1, "123456", "Carmen Alva", 500d, 98);


        list.add(cl1);
        list.add(cl2);
        list.add(cl3);

        when(this.dao.findAll()).thenReturn(list);


        final List<Cliente> clienteLst = this.service.getAll();

        assertEquals(3, clienteLst.size());
        verify(this.dao, times(1)).findAll();
    }

}

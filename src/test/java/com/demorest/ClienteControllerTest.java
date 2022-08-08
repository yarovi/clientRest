/*
 * Copyright (c) 2021. Inditex
 */

package com.demorest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.demorest.controller.ClienteController;
import com.demorest.entity.Cliente;
import com.demorest.service.ClienteService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yrosadov
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @MockBean
    ClienteService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        final Cliente cl = new Cliente(1, "123456", "Coyyote River", 100d, 50);
        final List<Cliente> clientes = Arrays.asList(cl);

        Mockito.when(this.service.getAll()).thenReturn(clientes);

        this.mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", Matchers.hasSize(1)))
            .andExpect(jsonPath("$[0].nombres", Matchers.is("Coyyote River")));
    }

}

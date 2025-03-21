package com.example.controller;

import com.example.model.Probe;
import com.example.model.Command;
import com.example.service.ProbeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
class ProbeControllerTest {

    @Mock
    private ProbeService probeService;

    @InjectMocks
    private ProbeController probeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Initialize mocks manually
        mockMvc = MockMvcBuilders.standaloneSetup(probeController).build();
    }

    @Test
    void testGetStatus() throws Exception {
        Probe mockProbe = new Probe(0, 0, "NORTH");
        // Mock the service call
        when(probeService.getProbeStatus()).thenReturn(mockProbe);

        // Perform the GET request and assert response
        mockMvc.perform(get("/probe/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value(0))
                .andExpect(jsonPath("$.y").value(0))
                .andExpect(jsonPath("$.direction").value("NORTH"));
    }

    @Test
    void testControlProbe() throws Exception {
        Command mockCommand = new Command("MOVE", "NORTH");

        // Mock the service call
        when(probeService.processCommand(mockCommand)).thenReturn("Command processed");

        // Perform the POST request and assert response
        mockMvc.perform(post("/probe/control")
                        .contentType("application/json")
                        .content("{\"action\":\"MOVE\", \"direction\":\"NORTH\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Command processed"));
    }
}
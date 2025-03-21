package com.example.service;

import com.example.model.Command;
import com.example.model.Probe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProbeServiceTest {

    private ProbeService probeService;

    @BeforeEach
    void setUp() {
        probeService = new ProbeService();
    }

    @Test
    void testMoveForward() {
        Command command = new Command("MOVE", "FORWARD");

        probeService.processCommand(command);

        Probe probe = probeService.getProbeStatus();
        assertEquals(0, probe.getX());
        assertEquals(1, probe.getY());
    }

    @Test
    void testTurnLeft() {
        Command command = new Command("TURN", "LEFT");

        probeService.processCommand(command);

        Probe probe = probeService.getProbeStatus();
        assertEquals("WEST", probe.getDirection());
    }

    @Test
    void testMoveBackward() {
        Command command = new Command("MOVE", "BACKWARD");

        probeService.processCommand(command);

        Probe probe = probeService.getProbeStatus();
        assertEquals(0, probe.getX());
        assertEquals(-1, probe.getY());
    }
}
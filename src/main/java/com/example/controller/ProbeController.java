package com.example.controller;

import com.example.model.Probe;
import com.example.model.Command;
import com.example.service.ProbeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probe")
@RequiredArgsConstructor
public class ProbeController {

    private final ProbeService probeService;

    @PostMapping("/control")
    public String controlProbe(@RequestBody Command command) {
        return probeService.processCommand(command);
    }

    @GetMapping("/status")
    public Probe getStatus() {
        return probeService.getProbeStatus();
    }
}

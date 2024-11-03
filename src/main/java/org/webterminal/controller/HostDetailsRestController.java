package org.webterminal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webterminal.dto.HostDetailsDto;
import org.webterminal.service.impl.HostDetailsServiceImpl;

@RestController
@RequestMapping("/api/host-details")
public class HostDetailsRestController {

    private final HostDetailsServiceImpl hostDetailsService;


    public HostDetailsRestController(HostDetailsServiceImpl hostDetailsService) {
        this.hostDetailsService = hostDetailsService;
    }


}

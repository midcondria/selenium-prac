package com.moluArchieve.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriTemplate;

@Slf4j
@Controller
public class AssignController {

    @GetMapping("/molu")
    public MoluResponse useApi() {

        MoluResponse block = WebClient.create()
            .get()
            .uri("https://api-blue-archive.vercel.app/api/characters")
            .retrieve()
            .bodyToMono(MoluResponse.class)
            .block();
        log.info("block = {}", block);
        return block;
    }
}

package com.aptek.pharm.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {


    @GetMapping("/secured")
    String securedPath(){

      return null;
    };
}

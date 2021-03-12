package com.aptek.pharm.controllers;

import com.aptek.pharm.Service.HoaxyService;
import com.aptek.pharm.entity.Hoaxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aptek.pharm.Share.genericResponce;


@RestController
public class HoaxyController {

    @Autowired
    HoaxyService hoaxyService;

    @PostMapping("/api/1.0/hoxes")
    genericResponce saveHoaxy(@RequestBody Hoaxy hoaxy){
        hoaxyService.save(hoaxy);
        return new genericResponce("Hoaxy is saved");

    }

}

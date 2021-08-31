package com.fon.fpis.controller;


import com.fon.fpis.service.NacinPlacanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/nacinPlacanja")
public class NacinPlacanjaController {

    @Autowired
    NacinPlacanjaService nacinPlacanjaService;

    @GetMapping
    public ResponseEntity<?> getAllNaciniPlacanja(){
        return ResponseEntity.ok(nacinPlacanjaService.findAllNaciniPlacanja());
    }
}

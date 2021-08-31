package com.fon.fpis.controller;

import com.fon.fpis.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/proizvod")
public class ProizvodController {

    @Autowired
    ProizvodService proizvodService;

    @GetMapping
    public ResponseEntity<?> getAllProizvod(){
        return ResponseEntity.ok(proizvodService.findAllProizvod());
    }
}

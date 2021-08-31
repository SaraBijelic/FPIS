package com.fon.fpis.controller;

import com.fon.fpis.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/radnik")
public class RadnikController {

    @Autowired
    RadnikService radnikService;

    @GetMapping
    public ResponseEntity<?> getAllRadnik(){
        return ResponseEntity.ok(radnikService.findAllRadnik());
    }
}

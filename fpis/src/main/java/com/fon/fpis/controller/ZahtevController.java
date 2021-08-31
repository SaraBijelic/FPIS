package com.fon.fpis.controller;

import com.fon.fpis.service.ZahtevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/zahtev")
public class ZahtevController {

    @Autowired
    ZahtevService zahtevService;

    @GetMapping
    public ResponseEntity<?> getAllZahtev(){
        return ResponseEntity.ok(zahtevService.findAllZahtev());
    }
}

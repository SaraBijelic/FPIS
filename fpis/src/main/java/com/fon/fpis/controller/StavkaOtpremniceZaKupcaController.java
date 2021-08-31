package com.fon.fpis.controller;

import com.fon.fpis.service.StavkaOtpremniceZaKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/stavkaOtpremniceZaKupca")
public class StavkaOtpremniceZaKupcaController {


    @Autowired
    StavkaOtpremniceZaKupcaService stavkaOtpremniceZaKupcaService;

    @GetMapping
    public ResponseEntity<?> getAllStavke(){
        return ResponseEntity.ok(stavkaOtpremniceZaKupcaService.findAllStavkeOtpremnice());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneStavka(@PathVariable Long id){
        return ResponseEntity.ok(stavkaOtpremniceZaKupcaService.findOneStavkaOtpremnice(id));
    }

    @GetMapping("/{idOtpremnice}")
    public ResponseEntity<?> getAllStavkeOtpremnice(@PathVariable Long idOtpremnice){
        return ResponseEntity.ok(stavkaOtpremniceZaKupcaService.findAllStavkeIDOtpremnice(idOtpremnice));
    }
}

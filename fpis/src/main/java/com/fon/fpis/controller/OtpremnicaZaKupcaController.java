package com.fon.fpis.controller;

import com.fon.fpis.service.OtpremnicaZaKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/otpremnicaZaKupca")
public class OtpremnicaZaKupcaController {

    @Autowired
    OtpremnicaZaKupcaService otpremnicaZaKupcaService;

    @GetMapping
    public ResponseEntity<?> getAllOtpremnice(){
        return ResponseEntity.ok(otpremnicaZaKupcaService.findAllOtpremnica());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getOneOtpremnica(@PathVariable java.lang.Long id){
        return ResponseEntity.ok(otpremnicaZaKupcaService.findOneOtpremnica(id));
    }

    @GetMapping("/{datum}")
    public ResponseEntity<?> getAllDatumOtpremnice(@PathVariable Date datum){
        return ResponseEntity.ok(otpremnicaZaKupcaService.findAllOtpremnicaDatum(datum));
    }
}

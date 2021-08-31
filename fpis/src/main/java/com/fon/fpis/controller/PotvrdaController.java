package com.fon.fpis.controller;

import com.fon.fpis.dto.AddUpdatePotvrdaOKvalitetuDTO;
import com.fon.fpis.service.PotvrdaOKvalitetuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/potvrda")
public class PotvrdaController {

    @Autowired
    PotvrdaOKvalitetuService potvrdaOKvalitetuService;

    @GetMapping
    public ResponseEntity<?> getAllPotvrda(){
        return ResponseEntity.ok(potvrdaOKvalitetuService.findAllPotvrdaOKvalitetu());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnePotvrda(@PathVariable Long id){
        return ResponseEntity.ok(potvrdaOKvalitetuService.findPotvrdaOKvalitetu(id));
    }

    @PostMapping
    public ResponseEntity<?> addPotvrda(@RequestBody AddUpdatePotvrdaOKvalitetuDTO potvrdaOKvalitetuDTO){
        return ResponseEntity.ok(potvrdaOKvalitetuService.addPotvrdaOKvalitetu(potvrdaOKvalitetuDTO));
    }

    @PutMapping
    public ResponseEntity<?> updatePotvrda(@RequestBody AddUpdatePotvrdaOKvalitetuDTO potvrdaOKvalitetuDTO){
        return ResponseEntity.ok(potvrdaOKvalitetuService.updatePotvrdaOKvalitetu(potvrdaOKvalitetuDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePotvrda(@PathVariable Long id) {
        return ResponseEntity.ok(potvrdaOKvalitetuService.deletePotvrda(id));
    }
}

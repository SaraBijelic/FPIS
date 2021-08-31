package com.fon.fpis.controller;

import com.fon.fpis.dto.AddUpdateStavkeRacunaListDTO;
import com.fon.fpis.service.StavkaRacunaKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/stavkeRacunKupca")
public class StavkeRacunaKupcaController {

    @Autowired
    StavkaRacunaKupcaService stavkaRacunaKupcaService;

    @PostMapping
    public ResponseEntity<?> addStavkeRacuna(@RequestBody AddUpdateStavkeRacunaListDTO stavkeRacunaDTO){
        return ResponseEntity.ok(stavkaRacunaKupcaService.addStavkeRacuna(stavkeRacunaDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getStavkeRacunaIDRacuna(@PathVariable java.lang.Long id){
        return ResponseEntity.ok(stavkaRacunaKupcaService.findAllStavkeIDRacuna(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllStavkeRacuna(){
        return ResponseEntity.ok(stavkaRacunaKupcaService.findAllStavkeRacuna());
    }
}

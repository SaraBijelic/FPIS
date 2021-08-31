package com.fon.fpis.controller;

import com.fon.fpis.dto.AddUpdatePotvrdaOKvalitetuDTO;
import com.fon.fpis.dto.AddUpdateRacunKupcaDTO;
import com.fon.fpis.service.RacunKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/racunKupca")
public class RacunKupcaController {

    @Autowired
    RacunKupcaService racunKupcaService;

    @GetMapping
    public ResponseEntity<?> getAllRacuni(){
        return ResponseEntity.ok(racunKupcaService.findAllRacunKupca());
    }

    @PostMapping
    public ResponseEntity<?> addRacun(@RequestBody AddUpdateRacunKupcaDTO racunKupcaDTO){
        return ResponseEntity.ok(racunKupcaService.addRacunKupca(racunKupcaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRacunKupca(@PathVariable Long id) {
        return ResponseEntity.ok(racunKupcaService.deleteRacunaKupca(id));
    }

    @PutMapping
    public ResponseEntity<?> updateRacunKupca(@RequestBody AddUpdateRacunKupcaDTO racunKupcaDTO){
        return ResponseEntity.ok(racunKupcaService.updateRacunKupca(racunKupcaDTO));
    }
}

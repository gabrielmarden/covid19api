package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("hospitalization")
public class HospitalizationController {

    @Autowired
    private HospitalizationService service;

    @GetMapping
    public ResponseEntity<?> getAllHospitalization(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHospitalizationById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity saveHospitalization(@RequestBody @Valid Hospitalization hospitalization){
        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalization);
    }

}

package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Doctor;
import br.com.nedramdev.covid19api.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/doctor")
@AllArgsConstructor
public class DoctorController {

    @Autowired
    private final DoctorService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body( service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Doctor doctor){
        return ResponseEntity.ok().body(service.save(doctor));
    }

    @GetMapping("/by-hospital/{id}")
    public ResponseEntity<?> findByHospital(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findByHospital(id));
    }
}

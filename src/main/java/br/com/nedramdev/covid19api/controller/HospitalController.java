package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Hospital;
import br.com.nedramdev.covid19api.service.HospitalService;
import br.com.nedramdev.covid19api.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @GetMapping
    public ResponseEntity<?> getAllHospitals(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHospitalById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Secured(Const.ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<?> saveHospital(@Valid @RequestBody Hospital hospital){
        return ResponseEntity.ok().body(hospital);
    }
}

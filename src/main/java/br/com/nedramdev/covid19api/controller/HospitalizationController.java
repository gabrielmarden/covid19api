package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<?> getAllHospitalization(@RequestParam(required = false) String disease,
                                                   @RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size){
        if(disease==null)
            return ResponseEntity.ok().body(service.findAll(page,size));
        else
            return ResponseEntity.ok().body(service.findByDisease(disease,page,size));
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

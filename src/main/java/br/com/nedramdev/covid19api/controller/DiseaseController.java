package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Disease;
import br.com.nedramdev.covid19api.model.Doctor;
import br.com.nedramdev.covid19api.service.DiseaseService;
import br.com.nedramdev.covid19api.util.Const;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/disease")
@AllArgsConstructor
public class DiseaseController {

    @Autowired
    private final DiseaseService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body( service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Secured(Const.ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Disease disease){
        return ResponseEntity.ok().body(service.save(disease));
    }

}

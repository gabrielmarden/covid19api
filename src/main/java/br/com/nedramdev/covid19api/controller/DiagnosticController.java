package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Diagnostic;
import br.com.nedramdev.covid19api.service.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("diagnostic")
public class DiagnosticController {

    @Autowired
    private DiagnosticService service;

    @GetMapping
    public ResponseEntity<?> getAllDiagnostic(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/hospitalization/{id}")
    public ResponseEntity<?> getDiagnosticByHospitalization(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findByHospitalization(id));
    }

    @PostMapping
    public ResponseEntity<?> saveDiagnostic(@RequestBody @Valid Diagnostic diagnostic){
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnostic);
    }

    @GetMapping("/disease/{diseaseId}")
    public ResponseEntity<?> getDiagnosticByDisease(@PathVariable("diseaseId") Long id){
        return ResponseEntity.ok().body(service.findByDisease(id));
    }
}

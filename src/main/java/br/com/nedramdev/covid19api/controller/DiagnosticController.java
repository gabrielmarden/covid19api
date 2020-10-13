package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Diagnostic;
import br.com.nedramdev.covid19api.service.DiagnosticService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/diagnostic")
public class DiagnosticController {

    @Autowired
    private DiagnosticService service;

    @ApiOperation(value = "find all diagnostics")
    @GetMapping
    public ResponseEntity<List<Diagnostic>> getAllDiagnostic(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @ApiOperation(value = "find diagnostics by hospitalization id")
    @GetMapping("/by-hospitalization/{id}")
    public ResponseEntity<List<Diagnostic>> getDiagnosticByHospitalization(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findByHospitalization(id));
    }

    @ApiOperation(value = "save diagnostic")
    @PostMapping
    public ResponseEntity<Diagnostic> saveDiagnostic(@RequestBody @Valid Diagnostic diagnostic){
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnostic);
    }
    @ApiOperation(value = "find diagnostics by disease id")
    @GetMapping("/by-disease/{diseaseId}")
    public ResponseEntity<List<Diagnostic>> getDiagnosticByDisease(@PathVariable("diseaseId") Long id){
        return ResponseEntity.ok().body(service.findByDisease(id));
    }
}

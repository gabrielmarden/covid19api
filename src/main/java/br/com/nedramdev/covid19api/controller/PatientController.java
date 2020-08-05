package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Patient;
import br.com.nedramdev.covid19api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<?> getPatients(){
        return ResponseEntity.ok().body(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable("id") String id){
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok().body(patient);
    }

    @PostMapping
    public ResponseEntity<?> savePatient(@Valid @RequestBody Patient patient){
        Patient patientSaved = patientService.save(patient);
        return new ResponseEntity<>(patientSaved,HttpStatus.CREATED);
    }
}

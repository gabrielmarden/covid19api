package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.dto.HospitalizationRequest;
import br.com.nedramdev.covid19api.dto.PatientData;
import br.com.nedramdev.covid19api.mapper.PatientMapper;
import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.model.Patient;
import br.com.nedramdev.covid19api.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
@Api(value = "Patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private HospitalizationController hospitalizationController;

    @ApiOperation(value = "find all patients")
    @GetMapping
    public ResponseEntity<List<Patient>> getPatients(){
        return ResponseEntity.ok().body(patientService.findAll());
    }

    @ApiOperation(value = "find patient by CPF")
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") String id){
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok().body(patient);
    }

    @ApiOperation(value = "save patient")
    @PostMapping
    public ResponseEntity<Void> savePatient(@Valid @RequestBody PatientData patient){
        patientService.save(PatientMapper.dtoToPatient(patient));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "find all hospitalization of a patient")
    @GetMapping("/{id}/hospitalization")
    public ResponseEntity<Page<HospitalizationRequest>> getAllHospitalization(@PathVariable String id,
                                                                              @RequestParam(defaultValue = "0") Integer page,
                                                                              @RequestParam(defaultValue = "10") Integer size){
        return hospitalizationController.getAllHospitalizationByPatientId(id,page,size);
    }
}

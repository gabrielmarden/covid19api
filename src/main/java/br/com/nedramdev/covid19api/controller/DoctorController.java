package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Doctor;
import br.com.nedramdev.covid19api.model.Hospital;
import br.com.nedramdev.covid19api.service.DoctorService;
import br.com.nedramdev.covid19api.util.Const;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@AllArgsConstructor
public class DoctorController {

    @Autowired
    private final DoctorService service;

    @ApiOperation(value = "find all doctors")
    @GetMapping
    public ResponseEntity<List<Doctor>> findAll(){
        return ResponseEntity.ok().body( service.findAll());
    }

    @ApiOperation(value = "find doctor by id")
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @ApiOperation(value = "save doctor")
    @Secured(Const.ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor doctor){
        return ResponseEntity.ok().body(service.save(doctor));
    }

    @GetMapping("/by-hospital/{id}")
    public ResponseEntity<List<Doctor>> findByHospital(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findByHospital(id));
    }
}

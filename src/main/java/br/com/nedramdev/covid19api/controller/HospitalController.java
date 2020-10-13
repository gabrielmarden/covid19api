package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Hospital;
import br.com.nedramdev.covid19api.service.HospitalService;
import br.com.nedramdev.covid19api.util.Const;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @ApiOperation(value = "find all hospitals")
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @ApiOperation(value = "find hospital by id")
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @ApiOperation(value = "save hospital")
    @Secured(Const.ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<Hospital> saveHospital(@Valid @RequestBody Hospital hospital){
        return ResponseEntity.ok().body(hospital);
    }
}

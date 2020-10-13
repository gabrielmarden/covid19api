package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Disease;
import br.com.nedramdev.covid19api.service.DiseaseService;
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
@RequestMapping("/api/disease")
@AllArgsConstructor
public class DiseaseController {

    @Autowired
    private final DiseaseService service;

    @ApiOperation(value = "find all diseases")
    @GetMapping
    public ResponseEntity<List<Disease>> findAll(){
        return ResponseEntity.ok().body( service.findAll());
    }

    @ApiOperation(value = "find disease by id")
    @Secured({Const.ROLE_DOCTOR,Const.ROLE_ADMIN})
    @GetMapping("/{id}")
    public ResponseEntity<Disease> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @ApiOperation(value = "save disease")
    @Secured(Const.ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<Disease> save(@Valid @RequestBody Disease disease){
        return ResponseEntity.ok().body(service.save(disease));
    }

}

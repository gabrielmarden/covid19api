package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.City;
import br.com.nedramdev.covid19api.service.CityService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/util/city")
@AllArgsConstructor
public class CityController {

    @Autowired
    private final CityService service;
    @ApiOperation(value = "find city by state/region id")
    @GetMapping("/by-state/{id}")
    public ResponseEntity<List<City>> findByState(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findByState(id));
    }
    @ApiOperation(value = "find city by id")
    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}

package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.State;
import br.com.nedramdev.covid19api.service.StateService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/util/state")
@AllArgsConstructor
public class StateController {

    private final StateService service;

    @ApiOperation(value = "find all states")
    @GetMapping
    public ResponseEntity<List<State>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @ApiOperation(value = "find state by id")
    public ResponseEntity<State> findById(Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}

package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.State;
import br.com.nedramdev.covid19api.service.StateService;
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

    @GetMapping
    public ResponseEntity<List<State>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    public ResponseEntity<State> findById(Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}

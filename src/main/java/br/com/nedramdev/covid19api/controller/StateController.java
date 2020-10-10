package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/util/state")
@AllArgsConstructor
public class StateController {

    private final StateService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    public ResponseEntity<?> findById(Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}

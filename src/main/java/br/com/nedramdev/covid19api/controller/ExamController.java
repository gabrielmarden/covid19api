package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Exam;
import br.com.nedramdev.covid19api.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/exam")
@AllArgsConstructor
public class ExamController {

    @Autowired
    private final ExamService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body( service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Exam exam){
        return ResponseEntity.ok().body(service.save(exam));
    }

}
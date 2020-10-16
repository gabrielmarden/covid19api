package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Exam;
import br.com.nedramdev.covid19api.service.ExamService;
import br.com.nedramdev.covid19api.util.Const;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/exam")
@AllArgsConstructor
public class ExamController {

    @Autowired
    private final ExamService service;

    @GetMapping
    public ResponseEntity<List<Exam>> findAll(){
        return ResponseEntity.ok().body( service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @Secured({Const.ROLE_ADMIN,Const.ROLE_DOCTOR})
    @PostMapping
    public ResponseEntity<Exam> save(@Valid @RequestBody Exam exam){
        return ResponseEntity.ok().body(service.save(exam));
    }

}

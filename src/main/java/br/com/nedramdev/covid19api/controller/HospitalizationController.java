package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.dto.DiagnosticRequest;
import br.com.nedramdev.covid19api.dto.ExamRequest;
import br.com.nedramdev.covid19api.mapper.DiagnosticMapper;
import br.com.nedramdev.covid19api.mapper.EvaluationExamMapper;
import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.service.DiagnosticService;
import br.com.nedramdev.covid19api.service.EvaluationExamService;
import br.com.nedramdev.covid19api.service.HospitalizationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hospitalization")
@AllArgsConstructor
public class HospitalizationController {

    @Autowired
    private final HospitalizationService hospitalizationService;

    @Autowired
    private final EvaluationExamService examService;

    @Autowired
    private final DiagnosticService diagnosticService;

    @GetMapping
    public ResponseEntity<?> getAllHospitalization(@RequestParam(required = false) String disease,
                                                   @RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size){
        System.out.println("No fuck no!");

        if(disease==null)
            return ResponseEntity.ok().body(hospitalizationService.findAll(page,size));
        else
            return ResponseEntity.ok().body(hospitalizationService.findByDisease(disease.toLowerCase(),page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHospitalizationById(@PathVariable Long id){
        return ResponseEntity.ok().body(hospitalizationService.findById(id));
    }

    @PostMapping
    public ResponseEntity saveHospitalization(@RequestBody @Valid Hospitalization hospitalization){
        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalization);
    }

    public ResponseEntity<?> getAllHospitalizationByPatientId(String id,Integer page, Integer size){
        return ResponseEntity.ok().body(hospitalizationService.findByPatient(id,page,size));
    }

    @PostMapping("/exam-request")
    public ResponseEntity<?> requestExam(@RequestBody ExamRequest examRequest){
        examService.save(EvaluationExamMapper.dtoToEvaluationExam(examRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/diagnostic-request")
    public ResponseEntity<?> requestDiagnostic(@RequestBody DiagnosticRequest diagnosticRequest){
        diagnosticService.save(DiagnosticMapper.dtoToDiagnostic(diagnosticRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

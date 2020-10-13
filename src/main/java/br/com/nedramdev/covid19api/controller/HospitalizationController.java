package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.dto.DiagnosticRequest;
import br.com.nedramdev.covid19api.dto.ExamRequest;
import br.com.nedramdev.covid19api.dto.HospitalizationRequest;
import br.com.nedramdev.covid19api.mapper.DiagnosticMapper;
import br.com.nedramdev.covid19api.mapper.EvaluationExamMapper;
import br.com.nedramdev.covid19api.mapper.HospitalizationMapper;
import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.service.DiagnosticService;
import br.com.nedramdev.covid19api.service.EvaluationExamService;
import br.com.nedramdev.covid19api.service.HospitalizationService;
import br.com.nedramdev.covid19api.util.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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

    @ApiOperation(value = "find all hospitalization")
    @Secured({Const.ROLE_ADMIN,Const.ROLE_DOCTOR})
    @GetMapping
    public ResponseEntity<Page<HospitalizationRequest>> getAllHospitalization(@RequestParam(required = false) String disease,
                                                   @RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size){
        Page<Hospitalization> data;
        if(disease==null) {
            data = hospitalizationService.findAll(page, size);
        }else {
            data = hospitalizationService.findByDisease(disease.toLowerCase(), page, size);
        }
        return ResponseEntity.ok()
                .body(new PageImpl<HospitalizationRequest>(
                        data.getContent()
                        .stream()
                        .map(HospitalizationMapper::hospitalizationToDTO)
                                .collect(Collectors.toList()),
                        data.getPageable(),
                        data.getTotalElements()));
    }

    @ApiOperation(value = "find hospitalization by id")
    @Secured({Const.ROLE_DOCTOR})
    @GetMapping("/{id}")
    public ResponseEntity<Hospitalization> getHospitalizationById(@PathVariable Long id){
        return ResponseEntity.ok().body(hospitalizationService.findById(id));
    }

    @ApiOperation(value = "save hospitalization")
    @PostMapping
    public ResponseEntity<Void> saveHospitalization(@RequestBody HospitalizationRequest hospitalization){
        hospitalizationService.save(HospitalizationMapper.dtoToHospitalization(hospitalization));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "find all hospitalization by patient id")
    public ResponseEntity<Page<HospitalizationRequest>> getAllHospitalizationByPatientId(String id,Integer page, Integer size){
        Page<Hospitalization> data = hospitalizationService.findByPatient(id,page,size);
        Page<HospitalizationRequest> response = new PageImpl<>(data
                .getContent()
                .stream()
                .map(HospitalizationMapper::hospitalizationToDTO)
                    .collect(Collectors.toList()),
                data.getPageable(),
                data.getTotalElements());
        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "request a new exam/evaluation")
    @Secured(Const.ROLE_DOCTOR)
    @PostMapping("/exam-request")
    public ResponseEntity<Void> requestExam(@RequestBody ExamRequest examRequest){
        examService.save(EvaluationExamMapper.dtoToEvaluationExam(examRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "request a new diagnostic")
    @Secured(Const.ROLE_DOCTOR)
    @PostMapping("/diagnostic-request")
    public ResponseEntity<Void> requestDiagnostic(@RequestBody DiagnosticRequest diagnosticRequest){
        diagnosticService.save(DiagnosticMapper.dtoToDiagnostic(diagnosticRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

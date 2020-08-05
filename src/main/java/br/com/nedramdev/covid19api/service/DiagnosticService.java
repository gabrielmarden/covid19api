package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.model.Diagnostic;
import br.com.nedramdev.covid19api.repository.DiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticService {

    @Autowired
    private DiagnosticRepository repository;

    public List<Diagnostic> findByHospitalization(Long id){
        return repository.findByHospitalization(id);
    }

    public List<Diagnostic> findAll(){
        return repository.findAll();
    }

    public List<Diagnostic> findByDisease(Long diseaseId){
        return repository.findByDisease(diseaseId);
    }

    public Diagnostic save(Diagnostic diagnostic){return repository.save(diagnostic);}
}

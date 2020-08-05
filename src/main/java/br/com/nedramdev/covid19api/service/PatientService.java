package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.Patient;
import br.com.nedramdev.covid19api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient findById(String id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient with id "+id+" not found"));
    }

    public List<Patient> findAll(){
        return repository.findAll();
    }

    public Patient save(Patient patient){
        return repository.save(patient);
    }
}

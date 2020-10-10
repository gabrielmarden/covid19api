package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.Doctor;
import br.com.nedramdev.covid19api.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    @Autowired
    private final DoctorRepository repository;

    public Doctor findById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor with id "+id+" not found!"));
    }

    public List<Doctor> findAll(){
        return repository.findAll();
    }

    public Doctor save(Doctor doctor){
        return repository.save(doctor);
    }

    public List<Doctor> findByHospital(Long id){
        return repository.findByHospitalId(id);
    }
}

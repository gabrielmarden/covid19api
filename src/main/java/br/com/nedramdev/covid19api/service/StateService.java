package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.State;
import br.com.nedramdev.covid19api.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public State findById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("State with id "+id+"not found"));
    }

    public List<State> findAll(){
        return repository.findAll();
    }


}

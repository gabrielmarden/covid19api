package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.City;
import br.com.nedramdev.covid19api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public City findCityById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("City with id "+id+"not found!"));
    }

    public List<City> findAll(){
        return repository.findAll();
    }

    public City save(City city){
        return repository.save(city);
    }

}

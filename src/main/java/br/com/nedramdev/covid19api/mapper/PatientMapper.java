package br.com.nedramdev.covid19api.mapper;

import br.com.nedramdev.covid19api.dto.PatientData;
import br.com.nedramdev.covid19api.model.Address;
import br.com.nedramdev.covid19api.model.City;
import br.com.nedramdev.covid19api.model.Comorbidity;
import br.com.nedramdev.covid19api.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {

    public static Patient dtoToPatient(PatientData dto){
        Patient patient = new Patient();
        Address address = new Address();
        City city = new City();
        List<Comorbidity> comorbidities = new ArrayList<>();

        patient.setName(dto.getName());
        patient.setCpf(dto.getCpf());
        patient.setSex(dto.getSex());
        patient.setBirthDate(dto.getBirthDate());
        patient.setPhones(dto.getPhones());

        address.setNeighborhood(dto.getAddressNeighborhood());
        address.setNumber(dto.getAddressNumber());
        address.setComplement(dto.getAddressComplement());
        address.setStreet(dto.getAddressStreet());

        city.setId(dto.getCityId());
        address.setCity(city);

        dto.getComorbiditiesId().forEach(id->{
            Comorbidity c = new Comorbidity();
            c.setId(id);
            comorbidities.add(c);
        });

        patient.setComorbidities(comorbidities);
        patient.setAddress(address);

        return patient;
    }



}

package br.com.nedramdev.covid19api.mapper;

import br.com.nedramdev.covid19api.dto.HospitalizationRequest;
import br.com.nedramdev.covid19api.model.Hospital;
import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.model.Patient;

import java.time.LocalDate;

public class HospitalizationMapper {

    public static Hospitalization dtoToHospitalization(HospitalizationRequest dto){

        Hospitalization hospitalization = new Hospitalization();
        Patient patient = new Patient();
        Hospital hospital = new Hospital();

        hospitalization.setEntranceDate(LocalDate.parse(dto.getEntranceDate()));
        hospitalization.setExitDate(LocalDate.parse(dto.getExitDate()));
        hospitalization.setState(dto.getStateDetails());

        patient.setCpf(dto.getPatientCPF());
        hospital.setId(dto.getHospitalId());

        hospitalization.setPatient(patient);
        hospitalization.setHospital(hospital);

        return hospitalization;

    }

    public static HospitalizationRequest hospitalizationToDTO(Hospitalization hospitalization){
        HospitalizationRequest dto = new HospitalizationRequest();

        dto.setId(hospitalization.getId());
        dto.setEntranceDate(hospitalization.getEntranceDate().toString());
        dto.setExitDate(hospitalization.getExitDate()==null?"":hospitalization.getExitDate().toString());
        dto.setStateDetails(hospitalization.getState());
        dto.setHospitalId(hospitalization.getHospital().getId());
        dto.setPatientCPF(hospitalization.getPatient().getCpf());

        return dto;
    }


}

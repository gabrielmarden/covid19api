package br.com.nedramdev.covid19api.mapper;

import br.com.nedramdev.covid19api.dto.DiagnosticRequest;
import br.com.nedramdev.covid19api.model.*;

public class DiagnosticMapper {

    public static Diagnostic dtoToDiagnostic(DiagnosticRequest dto){
        Diagnostic diagnostic = new Diagnostic();
        DiagnosisPk pk = new DiagnosisPk();
        Disease disease = new Disease();
        Hospitalization hospitalization = new Hospitalization();
        Doctor doctor = new Doctor();

        disease.setId(dto.getDiseaseId());
        hospitalization.setId(dto.getHospitalizationId());
        doctor.setCrm(dto.getDoctorCRM());

        pk.setDisease(disease);
        pk.setHospitalization(hospitalization);

        diagnostic.setDate(dto.getDate());
        diagnostic.setStatus(dto.getStatus());
        diagnostic.setId(pk);
        diagnostic.setDoctor(doctor);

        return diagnostic;
    }
}

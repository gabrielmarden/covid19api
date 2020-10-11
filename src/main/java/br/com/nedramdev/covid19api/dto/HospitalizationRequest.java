package br.com.nedramdev.covid19api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalizationRequest {

    private Long id;
    private String entranceDate;
    private String exitDate;
    private String stateDetails;
    private String patientCPF;
    private Long hospitalId;

}

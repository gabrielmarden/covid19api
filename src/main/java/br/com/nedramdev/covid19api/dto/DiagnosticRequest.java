package br.com.nedramdev.covid19api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticRequest {

    private Long hospitalizationId;
    private Long diseaseId;
    private String status;
    private LocalDate date;
    private Long doctorCRM;
}

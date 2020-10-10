package br.com.nedramdev.covid19api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientData {

    private String cpf;
    private String name;
    private String sex;
    private LocalDate birthDate;
    private List<String> phones;
    private String addressStreet;
    private Integer addressNumber;
    private String addressNeighborhood;
    private String addressComplement;
    private Long cityId;
    private List<Long> comorbiditiesId;

}

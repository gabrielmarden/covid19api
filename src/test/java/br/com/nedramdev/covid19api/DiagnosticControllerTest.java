package br.com.nedramdev.covid19api;

import br.com.nedramdev.covid19api.controller.DiagnosticController;
import br.com.nedramdev.covid19api.model.Diagnostic;
import br.com.nedramdev.covid19api.model.Disease;
import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.model.Patient;
import br.com.nedramdev.covid19api.service.DiagnosticService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DiagnosticController.class)
public class DiagnosticControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DiagnosticService service;

    @Test
    public void shouldResponseStatus200OKWhenGetDiagnosticsByDisease() throws Exception{
        Patient patient = new Patient("05041113349","Marden","MASC",LocalDate.now());
        Hospitalization hospitalization = new Hospitalization(1L, LocalDate.now(),LocalDate.now(),"INTERNADO",patient,null);
        Disease disease = new Disease(1L,"COVID19");
        List<Diagnostic> diagnostics = Arrays.asList(new Diagnostic(hospitalization,disease,"CONFIRMADO",LocalDate.now()));

        BDDMockito.given(service.findByHospitalization(1L)).willReturn(diagnostics);

        MvcResult result = mvc.perform(get("/diagnostic/hospitalization/{id}",1L))
                .andExpect(status().isOk())
                .andReturn();
        List<Diagnostic> list = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Diagnostic>>() {});

        assertEquals("COVID19",list.get(0).getId().getDisease().getName());
        assertEquals(1,list.size());
    }

}

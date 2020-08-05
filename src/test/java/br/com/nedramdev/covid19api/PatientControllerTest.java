package br.com.nedramdev.covid19api;

import br.com.nedramdev.covid19api.controller.PatientController;
import br.com.nedramdev.covid19api.dao.ErrorDAO;
import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.Patient;
import br.com.nedramdev.covid19api.service.PatientService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({PatientController.class})
public class PatientControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PatientService service;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void shouldResponseStatus200OKWhenGetPatients() throws Exception{
        BDDMockito.when(service.findAll()).thenReturn(Collections.emptyList());

        MvcResult result = mvc.perform(get("/patient"))
                .andExpect(status().isOk())
                .andReturn();

        List<Patient> list = mapper.readValue(result.getResponse().getContentAsString(),new TypeReference<List<Patient>>(){});

        assertEquals(0,list.size());
    }

    @Test
    public void shouldResponseStatus200OKWhenPatientExists() throws Exception{
        Patient patient = new Patient("020021311","marden","masculino", LocalDate.now());

        BDDMockito.when(service.findById("020021311")).thenReturn(patient);

        MvcResult result = mvc.perform(get("/patient/{id}",200021311L))
                        .andExpect(status().isOk())
                    .andReturn();

        Patient patientResult = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Patient>(){});

        assertEquals(200021311L,patientResult.getCpf());

    }

    @Test
    public void shouldResponseStatus404NotFoundWhenPatientDoesNotExist() throws Exception{

        BDDMockito.when(service.findById("1")).thenThrow(new ResourceNotFoundException("Patient with id 1 not found"));

        MvcResult result = mvc.perform(get("/patient/1"))
                .andExpect(status().isNotFound())
                .andReturn();
        ErrorDAO errorDAO = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ErrorDAO>() {});

        assertEquals(errorDAO.getMsg(),"Patient with id 1 not found");
    }

    @Test
    public void shouldReturnStatus201CreatedWhenSavePatient() throws Exception{
        Patient patient = new Patient("200312345","marden","masculino",LocalDate.now());

        BDDMockito.when(service.save(any(Patient.class))).thenReturn(patient);

        MvcResult result = mvc.perform(post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(patient)))
                .andExpect(status().isCreated())
                .andReturn();
        String patientString = result.getResponse().getContentAsString();
        Patient patientSaved = mapper.readValue(patientString, new TypeReference<Patient>() {});

        assertEquals(patientSaved.getName(),"marden");
    }

    @Test
    public void shouldReturnStatus400BadRequestWhenSavePatientWithInvalidInput() throws Exception{
        Patient patient = new Patient(null,"joao","masculino",LocalDate.now());

        mvc.perform(post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(patient)))
           .andExpect(status().isBadRequest());
    }

}

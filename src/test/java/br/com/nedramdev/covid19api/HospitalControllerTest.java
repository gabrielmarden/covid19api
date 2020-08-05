package br.com.nedramdev.covid19api;

import br.com.nedramdev.covid19api.controller.HospitalController;
import br.com.nedramdev.covid19api.dao.ErrorDAO;
import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.Hospital;
import br.com.nedramdev.covid19api.service.HospitalService;
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

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalController.class)
public class HospitalControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private HospitalService service;

    @Test
    public void shouldReturnStatus200OKWhenGetHospitals() throws Exception{
        BDDMockito.when(service.findAll()).thenReturn(Collections.emptyList());

        MvcResult result = mvc.perform(get("/hospital"))
                .andExpect(status().isOk())
                .andReturn();

        List<Hospital> hospitals = mapper.readValue(result
                .getResponse()
                .getContentAsString(),
                new TypeReference<List<Hospital>>() {});

        assertEquals(0,hospitals.size());

    }

    @Test
    public void shouldReturnStatus200OkWhenGetHospitalById() throws Exception{
        BDDMockito.when(service.findById(1L)).thenReturn(new Hospital(1L,"Santa Casa"));

        MvcResult result = mvc.perform(get("/hospital/{id}",1L))
                            .andExpect(status().isOk())
                            .andReturn();
        Hospital hospital = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Hospital>() {});

        assertEquals(1L,hospital.getId());
        assertEquals("Santa Casa",hospital.getName());
    }

    @Test
    public void shouldReturnStatus404NotFoundWhenGetHospitalByAnInvalidId() throws Exception{
        BDDMockito.when(service.findById(any(Long.class))).thenThrow(new ResourceNotFoundException("Not Found"));

        MvcResult result = mvc.perform(get("/hospital/{id}",1L))
                .andExpect(status().isNotFound())
                .andReturn();
        ErrorDAO error = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ErrorDAO>() {});

        assertEquals("Not Found",error.getMsg());
    }

    @Test
    public void shouldReturnStatus201CreatedWhenSaveHospital() throws Exception{
        Hospital hospital = new Hospital(1L,"Santa Casa");
        BDDMockito.when(service.save(any(Hospital.class))).thenReturn(hospital);

        MvcResult result = mvc.perform(post("/hospital")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(hospital)))
                .andExpect(status().isCreated())
                .andReturn();

        Hospital hospitalSaved = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Hospital>() {});

        assertEquals("Santa Casa",hospitalSaved.getName());
    }

    @Test
    public void shouldReturnStatus400BadRequestWhenSaveHospitalWithInvalidInputs() throws Exception{
        Hospital hospital = new Hospital(null,"Santa Casa");

        mvc.perform(post("/hospital")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(hospital)))
                .andExpect(status().isBadRequest());
    }

}

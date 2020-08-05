package br.com.nedramdev.covid19api;

import br.com.nedramdev.covid19api.controller.DiagnosticController;
import br.com.nedramdev.covid19api.service.DiagnosticService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DiagnosticController.class)
public class DiagnosticControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DiagnosticService service;



}

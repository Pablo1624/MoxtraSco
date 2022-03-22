package com.example.moxtra.controller;

import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.service.MoxtraServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Moxtra controller tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class MoxtraControllerTests {

    /**
     * The Moxtra controller.
     */
    @InjectMocks
    private MoxtraController moxtraController;

    /**
     * The Moxtra service.
     */
    @Mock
    private MoxtraServiceI moxtraService;

    /**
     * The Mock mvc.
     */
    private MockMvc mockMvc;

    /**
     * The constant mapper.
     */
    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * The constant podam.
     */
    private static PodamFactory podam = new PodamFactoryImpl();

    /**
     * Init.
     */
    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(moxtraController).build();
    }

    /**
     * Gets moxtra auth test ok.
     *
     * @throws Exception the exception
     */
    @Test
    public void getMoxtraAuthTestOK() throws Exception {
        // dummy objects, input con todos los parametros nulos
        MoxtraAuthRequestDTO request = podam.manufacturePojo(MoxtraAuthRequestDTO.class);
        MoxtraAuthResponseDTO response = podam.manufacturePojo(MoxtraAuthResponseDTO.class);
        // mock
        when(moxtraService.getMoxtraAuth(Mockito.any())).thenReturn(response);

        // stubbing no es necesario, deberia dar error
        this.mockMvc.perform(post("/v1/moxtra/oauth/token").contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8").content(mapper.writeValueAsBytes(request)).header("Authorization", "token"))
                .andDo(print()).andExpect(status().isOk()); // assert

        // verify
        verify(moxtraService, times(1)).getMoxtraAuth(Mockito.any());
    }
}

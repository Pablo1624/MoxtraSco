package com.example.moxtra.service;

import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.service.impl.RestTemplateImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateTests {

    @InjectMocks
    private RestTemplateImpl restTemplateImpl;

    @Mock
    private RestTemplate restTemplate;

    private static PodamFactory podam = new PodamFactoryImpl();

    @Test
    public void getMoxtraAuthTestOK(){
        MoxtraAuthRequestDTO request = podam.manufacturePojo(MoxtraAuthRequestDTO.class);
        MoxtraAuthResponseDTO response = podam.manufacturePojo(MoxtraAuthResponseDTO.class);
        when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(), ArgumentMatchers.any(ParameterizedTypeReference.class)))
                .thenReturn(new ResponseEntity<MoxtraAuthResponseDTO>(response, HttpStatus.OK));

        MoxtraAuthResponseDTO result = restTemplateImpl.getMoxtraAuth(request);
        assertEquals(result, response);
    }
}

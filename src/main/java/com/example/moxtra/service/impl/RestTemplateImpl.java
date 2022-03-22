package com.example.moxtra.service.impl;

import com.example.moxtra.model.ListRelationShipResponseDTO;
import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.service.RestTemplateI;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * The type Rest template.
 */
@Slf4j
@Service
public class RestTemplateImpl implements RestTemplateI {

    /**
     * The Rest template.
     */
    private RestTemplate restTemplate;

    /**
     * Instantiates a new Rest template.
     *
     * @param restTemplate the rest template
     */
    public RestTemplateImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * Gets moxtra auth.
     *
     * @param request the request
     * @return the moxtra auth
     */
    @Override
    public MoxtraAuthResponseDTO getMoxtraAuth(MoxtraAuthRequestDTO request) {
        // Montamos la entrada
        MoxtraAuthResponseDTO response = null;

        // Generamos las cabeceras
        HttpHeaders headers = getHeaderWithOutToken();
        HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);
        String url = "https://scotia.moxtra.com/v1/core/oauth/token";
        Boolean asd = true;
        try {
            ResponseEntity<MoxtraAuthResponseDTO> call = restTemplate.exchange(url, HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<MoxtraAuthResponseDTO>() {
                    });
            if (HttpStatus.OK == call.getStatusCode() && asd) {
                // Validamos el resultado
                response = call.getBody();
            }
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            /*throw new BadRequestException(BadRequestException.class
                    .getSimpleName(),
                    "No se puede realizar la simulación.");
            new ResponseEntity<>("Error en la entrada", null, HttpStatus.BAD_REQUEST);*/
        }
        // Imprimimos en consola el resultado
        log.info("Response triadLimitsAndScores:", Json.pretty(response));
        return response;
    }

    /**
     * Gets moxtra auth.
     *
     * @param token the token
     * @return the moxtra auth
     */
    @Override
    public ListRelationShipResponseDTO getMoxtraRelationShip(String token) {
        // Montamos la entrada
        ListRelationShipResponseDTO response = null;

        // Generamos las cabeceras
        HttpHeaders headers = getHeaderWithToken(token);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        String url = "https://scotia.moxtra.com/v1/me/relationship";

        try {
            ResponseEntity<ListRelationShipResponseDTO> call = restTemplate.exchange(url, HttpMethod.GET,
                    requestEntity,
                    new ParameterizedTypeReference<ListRelationShipResponseDTO>() {
                    });
            if (HttpStatus.OK == call.getStatusCode()) {
                // Validamos el resultado
                response = call.getBody();
            }
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            /*throw new BadRequestException(BadRequestException.class
                    .getSimpleName(),
                    "No se puede realizar la simulación.");
            new ResponseEntity<>("Error en la entrada", null, HttpStatus.BAD_REQUEST);*/
        }
        // Imprimimos en consola el resultado
        log.info("Response triadLimitsAndScores:", Json.pretty(response));
        return response;
    }

    /**
     * Gets header with out token.
     *
     * @return the header with out token
     */
    private HttpHeaders getHeaderWithOutToken() {
        // Seteamos la cabeceras
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }

    /**
     * Gets header with token.
     *
     * @param token the token
     * @return the header with token
     */
    private HttpHeaders getHeaderWithToken(String token) {
        // Seteamos la cabeceras
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", token);
        return headers;
    }

}

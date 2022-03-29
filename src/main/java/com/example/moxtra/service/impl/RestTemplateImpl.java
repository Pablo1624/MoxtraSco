package com.example.moxtra.service.impl;

import com.example.moxtra.model.*;
import com.example.moxtra.service.RestTemplateI;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
     * The Moxtra url base.
     */
    @Value(value = "${rest-template.moxtra.base-url}")
    private String moxtraUrlBase;

    /**
     * The Moxtra auth.
     */
    @Value(value = "${rest-template.moxtra.paths.auth}")
    private String moxtraAuth;

    /**
     * The Moxtra relationship.
     */
    @Value(value = "${rest-template.moxtra.paths.relationship}")
    private String moxtraRelationship;

    /**
     * Instantiates a new Rest template.
     *
     * @param restTemplate the rest template
     */
    public RestTemplateImpl(RestTemplate restTemplate) {
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

        MoxtraAuthResponseDTO response = null;

        HttpHeaders headers = getHeaderWithOutToken();
        HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);
        String url = moxtraUrlBase.concat(moxtraAuth);
        try {
            ResponseEntity<MoxtraAuthResponseDTO> call = restTemplate.exchange(url, HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<MoxtraAuthResponseDTO>() {
                    });
            if (HttpStatus.OK == call.getStatusCode()) {
                response = call.getBody();
            }
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
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

        ListRelationShipResponseDTO response = null;

        HttpHeaders headers = getHeaderWithToken(token);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        String url = moxtraUrlBase.concat(moxtraRelationship);

        try {
            ResponseEntity<ListRelationShipResponseDTO> call = restTemplate.exchange(url, HttpMethod.GET,
                    requestEntity,
                    new ParameterizedTypeReference<ListRelationShipResponseDTO>() {
                    });
            if (HttpStatus.OK == call.getStatusCode()) {
                response = call.getBody();
            }
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        log.info("Response triadLimitsAndScores:", Json.pretty(response));
        return response;
    }

    @Override
    public void schedule(String token, ScheduleRequestDTO request) {

        MoxtraAuthResponseDTO response = null;

        HttpHeaders headers = getHeaderWithToken(token);
        HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);
        String url = "https://scotia.moxtra.com/v1/meets/schedule";
        try {
            ResponseEntity<ScheduleResponseDTO> call = restTemplate.exchange(url, HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<ScheduleResponseDTO>() {
                    });
            log.info(Json.pretty(call));
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /**
     * Gets header with out token.
     *
     * @return the header with out token
     */
    private HttpHeaders getHeaderWithOutToken() {
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
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", token);
        return headers;
    }

}

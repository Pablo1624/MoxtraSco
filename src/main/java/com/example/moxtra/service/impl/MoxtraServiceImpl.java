package com.example.moxtra.service.impl;

import com.example.moxtra.model.ListRelationShipResponseDTO;
import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.service.MoxtraServiceI;
import com.example.moxtra.service.RestTemplateI;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * The type Moxtra service.
 */
@Slf4j
@Service
public class MoxtraServiceImpl implements MoxtraServiceI {

    /**
     * The Rest template i.
     */
    private RestTemplateI restTemplateI;

    /**
     * Instantiates a new Moxtra service.
     *
     * @param restTemplateI the rest template i
     */
    public MoxtraServiceImpl(RestTemplateI restTemplateI){
        this.restTemplateI = restTemplateI;
    }

    /**
     * Gets moxtra auth.
     *
     * @param request the request
     * @return the moxtra auth
     */
    @Override
    public MoxtraAuthResponseDTO getMoxtraAuth(MoxtraAuthRequestDTO request) {
        MoxtraAuthResponseDTO response = restTemplateI.getMoxtraAuth(request);
        log.info("Response: ", Json.pretty(response));
        return response;
    }

    /**
     * Gets moxtra relation ship.
     *
     * @param token the token
     * @return the moxtra relation ship
     */
    public ListRelationShipResponseDTO getMoxtraRelationShip(String token) {
        ListRelationShipResponseDTO response = restTemplateI.getMoxtraRelationShip(token);
        log.info("Response: ", Json.pretty(response));
        return response;
    }

}

package com.example.moxtra.service;

import com.example.moxtra.model.ListRelationShipResponseDTO;
import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.model.ScheduleRequestDTO;

/**
 * The interface Rest template.
 */
public interface RestTemplateI {

    /**
     * Gets moxtra auth.
     *
     * @param request the request
     * @return the moxtra auth
     */
    public MoxtraAuthResponseDTO getMoxtraAuth(MoxtraAuthRequestDTO request);

    /**
     * Gets moxtra relation ship.
     *
     * @param token the token
     * @return the moxtra relation ship
     */
    public ListRelationShipResponseDTO getMoxtraRelationShip(String token);

    void schedule(String token, ScheduleRequestDTO request);
}

package com.example.moxtra.service;

import com.example.moxtra.model.ListRelationShipResponseDTO;
import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;

/**
 * The interface Moxtra service i.
 */
public interface MoxtraServiceI {

    /**
     * Gets moxtra auth.
     *
     * @param request the request
     * @return the moxtra auth
     */
    public MoxtraAuthResponseDTO getMoxtraAuth(MoxtraAuthRequestDTO request);

    /**
     * Gets moxtra interviews.
     *
     * @param token the token
     * @return the moxtra interviews
     */
    public ListRelationShipResponseDTO getMoxtraRelationShip(String token);
}

package com.example.moxtra.controller;

import com.example.moxtra.model.ListRelationShipResponseDTO;
import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.model.ScheduleRequestDTO;
import com.example.moxtra.service.MoxtraServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * The type Moxtra controller.
 */
@RestController
@RequestMapping("/v1/moxtra")
public class MoxtraController {

    /**
     * The Moxtra service.
     */
    private MoxtraServiceI moxtraService;

    /**
     * Instantiates a new Moxtra controller.
     *
     * @param moxtraService the moxtra service
     */
    public MoxtraController(MoxtraServiceI moxtraService){
        this.moxtraService = moxtraService;
    }

    /**
     * Gets moxtra any.
     *
     * @param request the request
     * @return the moxtra any
     */
    @PostMapping(value = "/oauth/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MoxtraAuthResponseDTO getMoxtraAuth(@RequestBody MoxtraAuthRequestDTO request) {
        return moxtraService.getMoxtraAuth(request);
    }

    /**
     * Gets moxtra any.
     *
     * @param token the token
     * @return the moxtra any
     */
    @GetMapping(value = "/me/relationship", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListRelationShipResponseDTO getMoxtraAny(@RequestHeader(value = "Authorization") String token) {
        return moxtraService.getMoxtraRelationShip(token);
    }

    @PostMapping(value = "/meet/schedule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void schedule(@RequestHeader(value = "Authorization") String token, @RequestBody ScheduleRequestDTO request) {
        moxtraService.schedule(token, request);
    }

}

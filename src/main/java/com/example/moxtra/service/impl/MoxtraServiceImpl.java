package com.example.moxtra.service.impl;

import com.example.moxtra.entities.RelationShipEntity;
import com.example.moxtra.mapper.MapperI;
import com.example.moxtra.model.ListRelationShipResponseDTO;
import com.example.moxtra.model.MoxtraAuthRequestDTO;
import com.example.moxtra.model.MoxtraAuthResponseDTO;
import com.example.moxtra.model.ScheduleRequestDTO;
import com.example.moxtra.repositories.RelationShipRespository;
import com.example.moxtra.service.MoxtraServiceI;
import com.example.moxtra.service.RestTemplateI;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * The Mapper.
     */
    private MapperI mapper;
    /**
     * The Relation ship respository.
     */
    private RelationShipRespository relationShipRespository;

    /**
     * Instantiates a new Moxtra service.
     *
     * @param restTemplateI           the rest template i
     * @param mapper                  the mapper
     * @param relationShipRespository the relation ship respository
     */
    public MoxtraServiceImpl(RestTemplateI restTemplateI, MapperI mapper, RelationShipRespository relationShipRespository){
        this.restTemplateI = restTemplateI;
        this.mapper = mapper;
        this.relationShipRespository = relationShipRespository;
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
        List<RelationShipEntity> listRelationShipEntity = mapper.relationShipDTOListToRelationShipEntityList(response.getData());
        relationShipRespository.saveAll(listRelationShipEntity);
        return response;
    }

    /**
     * Schedule.
     *
     * @param token   the token
     * @param request the request
     */
    public void schedule(String token, ScheduleRequestDTO request) {
        restTemplateI.schedule(token, request);

    }

}

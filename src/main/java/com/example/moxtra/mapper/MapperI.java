package com.example.moxtra.mapper;

import com.example.moxtra.entities.RelationShipEntity;
import com.example.moxtra.model.RelationShipDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Mapper i.
 */
@Mapper(componentModel = "spring")
public interface MapperI {

//    MapperI INSTANCE = Mappers.getMapper( MapperI.class );

    /**
     * Relation ship dto list to relation ship entity list list.
     *
     * @param relationShip the relation ship
     * @return the list
     */
    List<RelationShipEntity> relationShipDTOListToRelationShipEntityList(List<RelationShipDTO> relationShip);

}

package com.example.moxtra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type List relation ship response dto.
 */
@Getter
@Setter
@NoArgsConstructor
public class ListRelationShipResponseDTO {

    /**
     * The Code.
     */
    private String code;

    /**
     * The Data.
     */
    private List<RelationShipDTO> data;
}

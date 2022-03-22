package com.example.moxtra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Channel dto.
 */
@Getter
@Setter
@NoArgsConstructor
public class ChannelDTO {

    /**
     * The Type.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * The Binder id.
     */
    @JsonProperty(value = "binder_id")
    private String binder_id;
}

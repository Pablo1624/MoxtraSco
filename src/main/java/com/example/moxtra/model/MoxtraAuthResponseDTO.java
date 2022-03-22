package com.example.moxtra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Moxtra auth response dto.
 */
@Getter
@Setter
@NoArgsConstructor
public class MoxtraAuthResponseDTO {

    /**
     * The Access token.
     */
    @JsonProperty(value = "access_token")
    private String accessToken;

    /**
     * The Expires in.
     */
    @JsonProperty(value = "expires_in")
    private Integer expiresIn;
}

package com.example.moxtra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Moxtra auth request dto.
 */
@Getter
@Setter
@NoArgsConstructor
public class MoxtraAuthRequestDTO {

    /**
     * The Client id.
     */
    @JsonProperty(value = "client_id")
    private String clientId;

    /**
     * The Client secret.
     */
    @JsonProperty(value = "client_secret")
    private String clientSecret;

    /**
     * The Org id.
     */
    @JsonProperty(value = "org_id")
    private String orgId;

    /**
     * The Email.
     */
    @JsonProperty(value = "email")
    private String email;
}

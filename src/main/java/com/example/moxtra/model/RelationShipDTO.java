package com.example.moxtra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Relation ship dto.
 */
@Getter
@Setter
@NoArgsConstructor
public class RelationShipDTO {

    /**
     * The Unique id.
     */
    @JsonProperty(value = "unique_id")
    private String uniqueId;

    /**
     * The First name.
     */
    @JsonProperty(value = "first_name")
    private String firstName;

    /**
     * The Last name.
     */
    @JsonProperty(value = "last_name")
    private String lastName;

    /**
     * The Email.
     */
    @JsonProperty(value = "email")
    private String email;

    /**
     * The Phone number.
     */
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    /**
     * The User id.
     */
    @JsonProperty(value = "user_id")
    private String userId;

    /**
     * The Name.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The Is disabled.
     */
    @JsonProperty(value = "is_disabled")
    private Boolean isDisabled;

    /**
     * The Timezone.
     */
    @JsonProperty(value = "timezone")
    private String timezone;

    /**
     * The Title.
     */
    @JsonProperty(value = "title")
    private String title;

    /**
     * The Binder id.
     */
    @JsonProperty(value = "binder_id")
    private String binderId;

    /**
     * The Status.
     */
    @JsonProperty(value = "status")
    private String status;

    /**
     * The Relation id.
     */
    @JsonProperty(value = "relation_id")
    private Integer relationId;

    /**
     * The Channels.
     */
    @JsonProperty(value = "channels")
    private List<ChannelDTO> channels;

}

package com.example.moxtra.entities;

import com.example.moxtra.model.ChannelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The type Relation ship entity.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "relation_ship")
public class RelationShipEntity {

    /**
     * The Unique id.
     */
    @Id
    @Column(name = "unique_id", nullable = false)
    private Long uniqueId;

    /**
     * The First name.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * The Last name.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The Email.
     */
    @Column(name = "email")
    private String email;

    /**
     * The Phone number.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * The User id.
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * The Name.
     */
    @Column(name = "name")
    private String name;

    /**
     * The Is disabled.
     */
    @Column(name = "is_disabled")
    private Boolean isDisabled;

    /**
     * The Timezone.
     */
    @Column(name = "timezone")
    private String timezone;

    /**
     * The Title.
     */
    @Column(name = "title")
    private String title;

    /**
     * The Binder id.
     */
    @Column(name = "binder_id")
    private String binderId;

    /**
     * The Status.
     */
    @Column(name = "status")
    private String status;

    /**
     * The Relation id.
     */
    @Column(name = "relation_id")
    private Integer relationId;


}

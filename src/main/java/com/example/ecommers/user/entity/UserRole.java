package com.example.ecommers.user.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Entity
@Data
public class UserRole {

    @EmbeddedId
    private UserRoleId  id;

    @ManyToOne()
    @MapsId("userId")
    private User user;

    @MapsId("roleId")
    @ManyToOne()
    private Role role;

}

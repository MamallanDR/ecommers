package com.example.ecommers.user.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class RolePermission {

    @EmbeddedId()
    private RolePermissionId id;

    @ManyToOne
    @MapsId("roleId")
    private Role role;

    @ManyToOne()
    @MapsId("permissionId")
    private Permission permission;

}

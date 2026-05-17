package com.example.ecommers.user.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class RolePermissionId implements Serializable {

    private long roleId;
    private long permissionId;
}

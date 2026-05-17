package com.example.ecommers.user.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Role {


    @Id()
    @GeneratedValue()
    private long id;

    private String name;

    @OneToMany(mappedBy = "role")
   private List<UserRole> userRoles;

    @OneToMany(mappedBy = "role")
    private  List<RolePermission> rolePermissions;
}

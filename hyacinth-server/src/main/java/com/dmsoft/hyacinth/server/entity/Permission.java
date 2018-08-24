package com.dmsoft.hyacinth.server.entity;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "t_permission")
public class Permission {
    @Id
    private Long id;
    private String name;
    private String permission;
    private String url;

    @ManyToMany
    @JoinTable(name = "t_role_permission", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

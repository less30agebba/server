package com.taoleg.servercore.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chq on 2017/10/26.
 */
@Data
@Entity
@Table(name = "admin_role")
public class AdminRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String role;
    private String description;
    private Integer status;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "admin_user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns ={@JoinColumn(name = "user_id") })
    private List<AdminUserEntity> adminUserEntities;

    @Override
    public String toString() {
        return "";
    }
}

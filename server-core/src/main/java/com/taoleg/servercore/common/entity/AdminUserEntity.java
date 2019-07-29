package com.taoleg.servercore.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by heyingcai on 2017/8/31.
 */
@Data
@Entity
@Table(name = "admin_user")
public class AdminUserEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String username;
    private String realname;
    private String password;
    private String email;
    private String phone;
    private Integer sex;
    private Integer status;
    @Column(name = "create_time")
    private LocalDateTime createTime;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "admin_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns ={@JoinColumn(name = "role_id") })
    private List<AdminRoleEntity> adminRoleEntities;

    @Override
    public String toString() {
        return "";
    }
}

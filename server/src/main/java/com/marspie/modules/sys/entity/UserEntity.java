package com.marspie.modules.sys.entity;

import com.marspie.framework.common.entity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-09 17:26
 **/
@Entity
public class UserEntity extends BaseEntity<UserEntity> {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

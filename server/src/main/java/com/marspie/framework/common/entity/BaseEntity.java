package com.marspie.framework.common.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author alex.yao
 * @create 2018-01-09 16:12
 **/
@MappedSuperclass
public class BaseEntity <T> implements Serializable {

    /**
     * primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public Boolean deleted = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @Column(updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @PrePersist
    public void initDefaultData() {
        this.createTime = new Date();
        this.modifyTime = new Date();
    }
    @PreUpdate
    public void initUpdateDefaultData() {
        this.createTime = new Date();
    }

    @Override
    public String toString() {
        return JSON.toJSON(this).toString();
    }
}

package com.marspie.framework.common.entity;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}

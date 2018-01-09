package com.marspie.framework.common.services;

import com.marspie.framework.common.entity.BaseEntity;
import com.marspie.framework.common.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-09 16:12
 **/
public abstract class BaseServices<D extends BaseRepository, T extends BaseEntity<T>> {

    @Autowired
    protected D dao;
}

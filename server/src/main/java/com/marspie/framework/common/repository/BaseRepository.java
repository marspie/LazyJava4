package com.marspie.framework.common.repository;

import com.marspie.framework.common.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author alex.yao
 * @create 2018-01-09 16:12
 **/
public interface BaseRepository<T extends BaseEntity<T>, ID extends Serializable> extends JpaRepository<T, ID> {

}

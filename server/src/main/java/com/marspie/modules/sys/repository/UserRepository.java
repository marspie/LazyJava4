package com.marspie.modules.sys.repository;

import com.marspie.framework.common.repository.BaseRepository;
import com.marspie.modules.sys.entity.UserEntity;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-09 17:28
 **/
public interface UserRepository extends BaseRepository<UserEntity, Long>{

    UserEntity findByUsername(String username);
}

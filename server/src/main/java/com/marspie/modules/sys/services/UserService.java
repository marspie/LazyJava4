package com.marspie.modules.sys.services;

import com.marspie.framework.common.services.BaseServices;
import com.marspie.modules.sys.entity.UserEntity;
import com.marspie.modules.sys.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-10 10:00
 **/
@Service
@Transactional
public class UserService extends BaseServices<UserRepository, UserEntity> implements UserDetailsService  {

    public List<UserEntity> findAll() {
        return dao.findAll();
    }

    public void  save(UserEntity user) {
        dao.save(user);
    }

    public UserEntity findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity myUser = dao.findByUsername(username);
        if(myUser == null){
            throw new UsernameNotFoundException(username);
        }
        //TODO:: add user role
        return new org.springframework.security.core.userdetails.User(myUser.getUsername(), myUser.getPassword(), emptyList());
    }
}

package com.marspie.modules.sys.controller;

import com.marspie.framework.common.controller.BaseController;
import com.marspie.modules.sys.entity.UserEntity;
import com.marspie.modules.sys.services.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-09 17:20
 **/
@RestController
@RequestMapping("/signup")
public class SignupController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping
    public void signUp(@RequestBody UserEntity user) throws Exception {
        UserEntity user1 = userService.findByUsername(user.getUsername());
        if(null != user1){
            throw new Exception("用户已经存在~");
        }
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
        userService.save(user);
    }
}

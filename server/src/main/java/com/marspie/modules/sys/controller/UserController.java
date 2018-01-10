package com.marspie.modules.sys.controller;

import com.marspie.framework.common.controller.BaseController;
import com.marspie.modules.sys.entity.UserEntity;
import com.marspie.modules.sys.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-09 17:20
 **/
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/save")
    public void save(@RequestBody UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @GetMapping("list")
    public List<UserEntity> get() {
        return userService.findAll();
    }
}

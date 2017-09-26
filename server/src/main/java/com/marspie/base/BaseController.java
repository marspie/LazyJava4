package com.marspie.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class BaseController {

    //简单的后台接口，用于测试
    @RequestMapping("/info")
    public Object info(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("info","hello hello hello");
        return map;
    }
}

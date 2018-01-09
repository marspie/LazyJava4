package com.marspie.framework.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex.yao
 * @create 2018-01-01 16:12
 **/
@RestController
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}

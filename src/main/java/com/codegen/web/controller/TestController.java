package com.codegen.web.controller;

import com.codegen.common.web.CommonContrller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-31 11:52
 **/
@Controller
public class TestController extends CommonContrller {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @RequestMapping("/")
    public String list() {
        return "test2";
    }
}

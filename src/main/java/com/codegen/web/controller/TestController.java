package com.codegen.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-31 11:52
 **/
@Controller
public class TestController {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @RequestMapping("/")
    public String test(Model model) {
        logger.info("test......");
        return "test";
    }
}

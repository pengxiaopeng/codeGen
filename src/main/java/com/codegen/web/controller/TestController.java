package com.codegen.web.controller;

import com.codegen.common.web.CommonContrller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-31 11:52
 **/
@Controller
public class TestController extends CommonContrller {
    protected final Log logger = LogFactory.getLog(this.getClass());
   /* @RequestMapping("/")
    public String list(Authority authority, Model model, Integer page, Integer pageMax, HttpServletRequest request, HttpServletResponse response) {
        page = page == null ? 1 : page;
        pageMax = pageMax == null ? 10 : pageMax;
        model.addAttribute("page", authorityService.findPage(page, pageMax, authority));
        model.addAttribute("authority", authority);
        return "authority/list";
    }*/
}

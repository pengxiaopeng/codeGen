package com.codegen.web.controller;

import com.codegen.common.config.Constants;
import com.codegen.common.web.CommonContrller;
import com.codegen.modules.model.Admin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-06-05 13:39
 **/
@Controller
@RequestMapping("/admin/user")
public class UserController extends CommonContrller {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @RequestMapping("list")
    public String list(Admin admin, Model model, Integer page, Integer pageMax, HttpServletRequest request, HttpServletResponse response) {
        page = page == null ? 1 : page;
        pageMax = pageMax == null ? 10 : pageMax;
        model.addAttribute("page", adminService.findPage(page, pageMax, admin));
        model.addAttribute("admin", admin);
        return "user/list";
    }
    @RequestMapping(value = "addView")
    public String addView(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "user/add";
    }


    @RequestMapping(value = "add")
    public String add(Model model, Admin admin, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (admin != null) {
            admin.setCreateDate(new Date());
            admin.setModifyDate(new Date());
            adminService.save(admin);
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, Constants.SUCCESS_ICON);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "editView")
    public String editView(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            model.addAttribute("admin", adminService.selectByPrimaryKey(id));
            return "user/edit";
        }

        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "id不能为空");
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, Constants.FAIL_ICON);
        return "redirect:/admin/user/list";

    }

    @RequestMapping(value = "edit")
    public String edit(Model model, Admin admin, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "修改失败";
        String icon = Constants.FAIL_ICON;
        if (admin != null) {
            admin.setModifyDate(new Date());
            adminService.updateByPrimaryKeySelective(admin);
            message = "修改成功";
            icon = Constants.SUCCESS_ICON;
        }

        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, message);
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, icon);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "delete")
    public String delete(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "删除成功";
        String icon = Constants.SUCCESS_ICON;
        if (id != null) {
            if(id == 1) {
                message = "超级管理员不能删除";
                icon = Constants.FAIL_ICON;
            } else {
                adminService.deleteByPrimaryKey(id);
            }
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, message);
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, icon);
        return "redirect:/admin/user/list";
    }
}

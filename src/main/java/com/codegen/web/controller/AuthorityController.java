package com.codegen.web.controller;

import com.codegen.common.config.Constants;
import com.codegen.common.web.CommonContrller;
import com.codegen.modules.model.Authority;
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
@RequestMapping("/admin/authority")
public class AuthorityController extends CommonContrller {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping("list")
    public String list(Authority authority, Model model, Integer page, Integer pageMax, HttpServletRequest request, HttpServletResponse response) {
        page = page == null ? 1 : page;
        pageMax = pageMax == null ? 10 : pageMax;
        model.addAttribute("page", authorityService.findPage(page, pageMax, authority));
        model.addAttribute("authority", authority);
        return "authority/list";
    }

    @RequestMapping(value = "addView")
    public String addView(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "authority/add";
    }


    @RequestMapping(value = "add")
    public String add(Model model, Authority authority, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (authority != null) {
            authority.setCreateDate(new Date());
            authority.setModifyDate(new Date());
            authorityService.save(authority);
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, Constants.SUCCESS_ICON);
        return "redirect:/admin/authority/list";
    }

    @RequestMapping(value = "editView")
    public String editView(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            model.addAttribute("authority", authorityService.selectByPrimaryKey(id));
            return "authority/edit";
        }

        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "id不能为空");
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, Constants.FAIL_ICON);
        return "redirect:/admin/authority/list";

    }

    @RequestMapping(value = "edit")
    public String edit(Model model, Authority authority, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "修改失败";
        String icon = Constants.FAIL_ICON;
        if (authority != null) {
            authority.setModifyDate(new Date());
            authorityService.updateByPrimaryKeySelective(authority);
            message = "修改成功";
            icon = Constants.SUCCESS_ICON;
        }
        if (authority != null && authority.getId() == null) {
            message = "id不能为空！";
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, message);
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, icon);
        return "redirect:/admin/authority/list";
    }

    @RequestMapping(value = "delete")
    public String delete(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "删除成功";
        String icon = Constants.SUCCESS_ICON;
        if (id != null) {
            authorityService.deleteByPrimaryKey(id);
        } else {
            message = "删除失败，id不能为空";
            icon = Constants.FAIL_ICON;
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, message);
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, icon);
        return "redirect:/admin/authority/list";
    }
}

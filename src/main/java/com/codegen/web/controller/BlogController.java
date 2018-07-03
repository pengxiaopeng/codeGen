package com.codegen.web.controller;

import com.codegen.common.config.Constants;
import com.codegen.common.web.CommonContrller;
import com.codegen.modules.model.Blog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/admin/blog")
public class BlogController  extends CommonContrller {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping("list")
    public String list(Blog blog, Model model, Integer page, Integer pageMax, HttpServletRequest request, HttpServletResponse response) {
        page = page == null ? 1 : page;
        pageMax = pageMax == null ? 10 : pageMax;
        model.addAttribute("page", blogService.findPage(page, pageMax, blog));
        model.addAttribute("blog", blog);
        return "blog/list";
    }

    @RequestMapping(value = "addView")
    public String addView(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "blog/add";
    }


    @RequestMapping(value = "add")
    public String add(Model model, Blog blog, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (blog != null) {
            blog.setCreateDate(new Date());
            blog.setModifyDate(new Date());
            blogService.save(blog);
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, Constants.SUCCESS_ICON);
        return "redirect:/admin/blog/list";
    }

    @RequestMapping(value = "editView")
    public String editView(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            model.addAttribute("blog", authorityService.selectByPrimaryKey(id));
            return "blog/edit";
        }

        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "id不能为空");
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, Constants.FAIL_ICON);
        return "redirect:/admin/blog/list";

    }

    @RequestMapping(value = "edit")
    public String edit(Model model, Blog blog, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "修改失败";
        String icon = Constants.FAIL_ICON;
        if (blog != null) {
            blog.setModifyDate(new Date());
            blogService.updateByPrimaryKeySelective(blog);
            message = "修改成功";
            icon = Constants.SUCCESS_ICON;
        }
        if (blog != null && blog.getId() == null) {
            message = "id不能为空！";
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, message);
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, icon);
        return "redirect:/admin/blog/list";
    }

    @RequestMapping(value = "delete")
    public String delete(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "删除成功";
        String icon = Constants.SUCCESS_ICON;
        if (id != null) {
            blogService.deleteByPrimaryKey(id);
        } else {
            message = "删除失败，id不能为空";
            icon = Constants.FAIL_ICON;
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, message);
        redirectAttributes.addFlashAttribute(Constants.ICON_NAME, icon);
        return "redirect:/admin/blog/list";
    }
    @RequestMapping(value = "view")
    public String view(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            Blog blog = blogService.selectByPrimaryKey(id);

            model.addAttribute("blog", blog);
            return "blog/view";
        }
        redirectAttributes.addFlashAttribute("message", "id不能为空");
        redirectAttributes.addFlashAttribute("icon", Constants.FAIL_ICON);
        return "redirect:/admin/blog/list";
    }
}

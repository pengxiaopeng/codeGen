package com.codegen.web.controller;

import com.codegen.common.config.Constants;
import com.codegen.common.web.CommonContrller;
import com.codegen.modules.model.DataDictionary;
import com.codegen.modules.model.DataType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION 数字字典
 * @create 2018-04-30 20:23
 **/
@Controller
@RequestMapping("/admin/dataType")
public class DataTypeController extends CommonContrller {
    @RequestMapping(value = "list")
    public String list(DataType dataType, Model model, Integer page, Integer pageMax, HttpServletRequest request, HttpServletResponse response) {
        page = page == null ? 1 : page;
        pageMax = pageMax == null ? 10 : pageMax;
        model.addAttribute("page", dataTypeService.findPage(page, pageMax, dataType));
        model.addAttribute("dataType", dataType);
        return "dataType/list";
    }

    @RequestMapping(value = "addView")
    public String addView(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "dataType/add";
    }


    @RequestMapping(value = "add")
    public String add(Model model, DataType dataType, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if(dataType != null) {
            Date now = new Date();
            dataType.setCreateDate(now);
            dataType.setModifyDate(now);
            dataTypeService.save(dataType);
            List<DataDictionary> list = dataType.getDataDictionaries();
            if (list != null && !list.isEmpty()) {
                for (DataDictionary dataDictionary : list) {
                    dataDictionary.setCreateDate(now);
                    dataDictionary.setModifyDate(now);
                    dataDictionary.setSort(dataType.getSort());
                    dataDictionary.setType(dataType.getCode());
                    DataDictionary d = dataDictionaryService.save(dataDictionary);
                }
            }
        }
        redirectAttributes.addFlashAttribute("message", "添加成功");
        redirectAttributes.addFlashAttribute("icon", Constants.SUCCESS_ICON);
        return "redirect:/admin/dataType/list";
    }

    @RequestMapping(value = "editView")
    public String editView(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            DataType dataType = dataTypeService.selectByPrimaryKey(id);
            DataDictionary dataDictionary = new DataDictionary();
            dataDictionary.setType(dataType.getCode());
            List<DataDictionary> list = dataDictionaryService.findList(dataDictionary);
            if (list != null && !list.isEmpty()) {
                dataType.setDataDictionaries(list);
            }
            model.addAttribute("dataType", dataType);
            return "dataType/edit";
        }

        redirectAttributes.addFlashAttribute("message", "id不能为空");
        redirectAttributes.addFlashAttribute("icon", Constants.FAIL_ICON);
        return "redirect:/admin/dataType/list";

    }

    @RequestMapping(value = "edit")
    public String edit(Model model, DataType dataType, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String message = "修改失败";
        String icon = Constants.FAIL_ICON;

        if(dataType != null) {
            dataType.setModifyDate(new Date());
            dataTypeService.updateByPrimaryKeySelective(dataType);
            List<DataDictionary> list = dataType.getDataDictionaries();
            if (list != null && !list.isEmpty()) {
                for (DataDictionary dataDictionary : list) {
                    dataDictionary.setSort(dataType.getSort());
                    dataDictionary.setType(dataType.getCode());
                    dataDictionary.setModifyDate(new Date());
                    dataDictionaryService.updateByPrimaryKeySelective(dataDictionary);
                }
            }
            message = "修改成功";
            icon = Constants.SUCCESS_ICON;
        }

        redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute("icon", icon);
        return "redirect:/admin/dataType/list";
    }

    @RequestMapping(value = "delete")
    public String delete(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            DataType dataType = dataTypeService.selectByPrimaryKey(id);
            DataDictionary dataDictionary = new DataDictionary();
            dataDictionary.setType(dataType.getCode());
            List<DataDictionary> list = dataDictionaryService.findList(dataDictionary);
            for (DataDictionary dictionary : list) {
                dataDictionaryService.deleteByPrimaryKey(dictionary.getId());
            }
            dataTypeService.deleteByPrimaryKey(id);
        }
        redirectAttributes.addFlashAttribute("message", "删除成功");
        redirectAttributes.addFlashAttribute("icon", Constants.SUCCESS_ICON);
        return "redirect:/admin/dataType/list";
    }
    @RequestMapping(value = "view")
    public String view(Model model, Long id, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (id != null) {
            DataType dataType = dataTypeService.selectByPrimaryKey(id);
            DataDictionary dataDictionary = new DataDictionary();
            dataDictionary.setType(dataType.getCode());
            List<DataDictionary> list = dataDictionaryService.findList(dataDictionary);
            if (list != null && !list.isEmpty()) {
                dataType.setDataDictionaries(list);
            }
            model.addAttribute("dataType", dataType);
            return "dataType/view";
        }
        redirectAttributes.addFlashAttribute("message", "id不能为空");
        redirectAttributes.addFlashAttribute("icon", Constants.FAIL_ICON);
        return "redirect:/admin/dataType/list";
    }
}

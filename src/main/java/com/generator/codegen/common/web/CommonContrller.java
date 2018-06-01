package com.generator.codegen.common.web;

import com.generator.codegen.modules.model.Authority;
import com.generator.codegen.modules.model.Menu;
import com.generator.codegen.modules.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-04-13 16:00
 **/
@Component
public class CommonContrller {
    @Autowired
    public MenuService menuService;
    @Autowired
    public AuthorityService authorityService;
    @Autowired
    public DataDictionaryService dataDictionaryService;
    @Autowired
    public DataTypeService dataTypeService;
    @Autowired
    public RoleService roleService;
    @Autowired
    public RoleAuthorityService roleAuthorityService;
    @Autowired
    public OrgService orgService;

    public String getPageStr(Model model, String pageAddress) {
        model.addAttribute("authorityList", getAuthorityList());
        return pageAddress;
    }

    /**
     * @param menuId   指定 id 选中
     * @param menuType 1 侧边栏菜单  2 顶部菜单
     * @return
     */
    private List<Menu> getMenuList(String menuId, String menuType) {
        if (StringUtils.isNotBlank(menuId) && StringUtils.isNotBlank(menuType)) {
            Menu menu = new Menu();
            menu.setMenuType(menuType);
            menu.setIsRoot("1");
            List<Menu> list = menuService.findList(menu);
            if (list != null && !list.isEmpty()) {
                for (Menu menu1 : list) {
                    if (StringUtils.equals(menu1.getId(), menuId)) {
                        menu1.setIsChoose("1");
                    }
                    Menu menu2 = new Menu();
                    menu2.setParentId(menu1.getId());
                    List<Menu> menus = menuService.findList(menu2);
                    for (Menu menu3 : menus) {
                        if (StringUtils.equals(menu3.getId(), menuId)) {
                            menu3.setIsChoose("1");
                        }
                    }
                    menu1.setChildMenuList(menus);
                }
            }
            return list;
        }
        return null;
    }
    /**
     * 获取菜单列表
     * @return
     */
    public List<Authority> getAuthorityList() {
        List<Authority> parentList = getParentAuthorityList();
        if (parentList != null && !parentList.isEmpty()) {
            for (Authority authority1 : parentList) {
                authority1.setChildAuthorityList(authorityService.findList(new Authority(authority1.getId())));
            }
        }
        return parentList;
    }

    /**
     * 获取父级菜单
     * @return
     */
    public List<Authority> getParentAuthorityList() {
        return authorityService.findList(new Authority(0L));
    }
}

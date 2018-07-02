package com.codegen.common.web;

import com.codegen.modules.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-04-13 16:00
 **/
@Component
public class CommonContrller {
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
    @Autowired
    public AdminService adminService;
    @Autowired
    private BlogService blogService;
}

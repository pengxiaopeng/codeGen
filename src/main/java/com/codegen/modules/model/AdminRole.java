package com.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;

import java.util.Date;

/**
* tableName：bid_admin_role
*/
public class AdminRole extends BaseModel {

    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //角色id（和bid_role关联）
    private Long roles;
    //用户id（和bid_admin表关联）
    private Long admins;
    // 创建时间
    private Date createDate;
    //更新时间
    private Date modifyDate;
    // 创建人id
    private Long createUserId;
    // 修改人id
    private Long modifyUserId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoles() {
        return roles;
    }

    public void setRoles(Long roles) {
        this.roles = roles;
    }

    public Long getAdmins() {
        return admins;
    }

    public void setAdmins(Long admins) {
        this.admins = admins;
    }
}
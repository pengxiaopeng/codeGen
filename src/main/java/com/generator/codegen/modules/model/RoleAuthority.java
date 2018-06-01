package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_role_authority
*/
public class RoleAuthority extends BaseModel {

    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //角色id（和bid_role表关联）
    private Long role;
    //权限id（和bid_authority关联）
    private Long authorities;
    //创建时间
    private Date createDate;
    //更新时间
    private Date modifyDate;
    
    private Long createUserId;
    
    private Long modifyUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Long getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Long authorities) {
        this.authorities = authorities;
    }

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
}
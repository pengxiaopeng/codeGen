package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_org
*/
public class Org extends BaseModel {

    private static final long serialVersionUID = 1L;

    //id：自增长
    private Long id;
   // 组织结构名称
    private String name;
   // 组织结构描述
    private String description;
   // 父节点ID
    private Long parentId;
   // 排序字段（小的排在前面）
    private Integer levelCode;
   // 组织机构类型（0-平台，1-其他）
    private Integer orgType;
   // 是否顶层组织：1是 0否
    private String isOrg;
   // 所属顶级组织ID
    private Long topUserOrgId;
   // 创建时间
    private Date createDate;
   // 更新时间
    private Date modifyDate;
   // 是否是系统内置角色（1-是，0-否。默认0）
    private Boolean isSystem;
    
    private Long createUserId;
    
    private Long modifyUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public String getIsOrg() {
        return isOrg;
    }

    public void setIsOrg(String isOrg) {
        this.isOrg = isOrg;
    }

    public Long getTopUserOrgId() {
        return topUserOrgId;
    }

    public void setTopUserOrgId(Long topUserOrgId) {
        this.topUserOrgId = topUserOrgId;
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

    public Boolean getSystem() {
        return isSystem;
    }

    public void setSystem(Boolean system) {
        isSystem = system;
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
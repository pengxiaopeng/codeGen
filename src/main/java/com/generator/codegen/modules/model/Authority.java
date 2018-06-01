package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;

import java.util.Date;
import java.util.List;

/**
* tableName：bid_authority
*/
public class Authority extends BaseModel {

    private static final long serialVersionUID = 1L;

    //权限id
    private Long id;
    //父节点id
    private Long parentId;
    //排序字段（小的排在前面）
    private Integer levelCode;
    //权限名称
    private String name;
    //节点类型（0-菜单节点。1-功能节点）
    private Integer position;
    //权限别名（用于shiro权限控制）
    private String authorities;
    //节点对应的url地址
    private String url;
    //节点对应的图标样式
    private String itemIcon;
   // 创建时间
    private Date createDate;
    //更新时间
    private Date modifyDate;
   // 创建人id
    private Long createUserId;
   // 修改人id
    private Long modifyUserId;
   // 节点业务类型（0：其他；1：待办；2：我的应用）
    private Integer bizType;
    private List<Authority> childAuthorityList;

    public Authority(){}
    public Authority(Long parentId){
        this.parentId = parentId;
    }

    public List<Authority> getChildAuthorityList() {
        return childAuthorityList;
    }

    public void setChildAuthorityList(List<Authority> childAuthorityList) {
        this.childAuthorityList = childAuthorityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
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

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }
}
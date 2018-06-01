package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;

import java.util.Date;

/**
* tableName：bid_activiti_type
*/
public class ActivitiType extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private Long Id;
   // 类别名称
    private String name;
   // 类别编码
    private String code;
   // bean类名
    private String beanName;
   // 动态属性
    private String dynAttribute;
    
    private Date createDate;
    
    private Date modifyDate;
   // 是否启用（1或true-启用，0或false-不启用）
    private Boolean isEnabled;
    
    private Long createUserId;
    
    private Long modifyUserId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getDynAttribute() {
        return dynAttribute;
    }

    public void setDynAttribute(String dynAttribute) {
        this.dynAttribute = dynAttribute;
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

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
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
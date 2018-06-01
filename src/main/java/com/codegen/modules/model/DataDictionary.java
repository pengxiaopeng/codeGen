package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_data_dictionary
*/
public class DataDictionary extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private Long id;
    //code值
    private String code;
    //描述
    private String descpt;
    //排序（值小的排在前面，从1开始）
    private Integer sort;
    //类型
    private String type;
    //创建人id
    private Long createUserId;
    //创建时间
    private Date createDate;
    //最后修改人id
    private Long modifyUserId;
    //最后修改时间
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescpt() {
        return descpt;
    }

    public void setDescpt(String descpt) {
        this.descpt = descpt;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
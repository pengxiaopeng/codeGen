package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;

import java.util.Date;
import java.util.List;

/**
* tableName：bid_data_type
*/
public class DataType extends BaseModel {

    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //code值（对应bid_data_dictionary表中的type值）
    private String code;
    //描述（对应bid_data_dictionary表中的type值的描述）
    private String descpt;
    //排序（值小的排在前面，从1开始）
    private Integer sort;
   // 创建人id
    private Long createUserId;
   // 创建时间
    private Date createDate;
    //最后修改人id
    private Long modifyUserId;
   // 最后修改时间
    private Date modifyDate;
    private List<DataDictionary> dataDictionaries;

    public List<DataDictionary> getDataDictionaries() {
        return dataDictionaries;
    }

    public void setDataDictionaries(List<DataDictionary> dataDictionaries) {
        this.dataDictionaries = dataDictionaries;
    }

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
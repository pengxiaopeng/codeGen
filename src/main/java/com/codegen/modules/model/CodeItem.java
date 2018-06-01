package com.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_code_item
*/
public class CodeItem extends BaseModel {

    private static final long serialVersionUID = 1L;

    //代码明细ID
    private Long id;
    //代码ID
    private Long codeId;
    //代码值名称
    private String valueName;
    //代码值
    private String codeValue;
    //排序
    private Integer orderNum;
    //备注
    private String REMARK;
   // 创建人id
    private Long createUserId;
    //创建时间
    private Date createDate;
   // 最后修改人id
    private Long modifyUserId;
    //最后修改时间
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
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
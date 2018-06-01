package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_sequence
*/
public class Sequence extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private Long id;
    
    private Date createDate;
    
    private Date modifyDate;
    
    private Long createUserId;
    
    private Long modifyUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
package com.generator.codegen.modules.model;

import com.generator.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_email_receivers
*/
public class EmailReceivers extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private Long bidEmail;
    
    private String receivers;
    
    private String receiversName;
    
    private Long id;
    
    private Date createDate;
    
    private Long createUserId;
    
    private Date modifyDate;
    
    private Long modifyUserId;

    public Long getBidEmail() {
        return bidEmail;
    }

    public void setBidEmail(Long bidEmail) {
        this.bidEmail = bidEmail;
    }

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
        this.receivers = receivers;
    }

    public String getReceiversName() {
        return receiversName;
    }

    public void setReceiversName(String receiversName) {
        this.receiversName = receiversName;
    }

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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
}
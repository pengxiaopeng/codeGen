package manageSystem.modules.model;

import manageSystem.common.model.BaseModel;

import java.util.Date;

/**
* tableName：bid_code
*/
public class Code extends BaseModel {

    private static final long serialVersionUID = 1L;

   // 基础代码ID
    private Long id;
    private String codeName; // 基础代码名称
    private String remark; // 备注
    private Long orgId; // 顶级组织ID
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

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
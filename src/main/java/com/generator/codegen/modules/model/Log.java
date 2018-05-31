package manageSystem.modules.model;

import manageSystem.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_log
*/
public class Log extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private Long id;
    
    private String content;
    
    private String ip;
    
    private String operation;
    
    private String operator;
    
    private String parameter;
    //所属模块
    private String module;
    //所属组织
    private String userTopOrgName;
    //所属部门
    private String userOrgName;
    
    private Long createUserId;
    
    private Long modifyUserId;
    
    private Date createDate;
    
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUserTopOrgName() {
        return userTopOrgName;
    }

    public void setUserTopOrgName(String userTopOrgName) {
        this.userTopOrgName = userTopOrgName;
    }

    public String getUserOrgName() {
        return userOrgName;
    }

    public void setUserOrgName(String userOrgName) {
        this.userOrgName = userOrgName;
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
}
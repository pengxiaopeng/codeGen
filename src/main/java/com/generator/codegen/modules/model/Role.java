package manageSystem.modules.model;

import manageSystem.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_role
*/
public class Role extends BaseModel {

    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //角色名称
    private String name;
    //角色描述
    private String description;
    //是否是系统内置角色（1-是，0-否。默认0）
    private Integer isSystem;
    //角色类型（0-平台，1-其他）
    private Integer roleType;
    // 是否是用户自定义的角色（1-是。0-否）
    private Integer isCustom;
    //所属的顶级组织id（即：此角色是由此组织创建的）
    private Long topUserOrgId;
    //对高校和企业角色而言。每个高校或企业注册时的帐号就是管理员帐号（1-是，0-不是）
    private Integer isCustomAdmin;
   // 创建时间
    private Date createDate;
    //更新时间
    private Date modifyDate;
    
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

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Integer isCustom) {
        this.isCustom = isCustom;
    }

    public Long getTopUserOrgId() {
        return topUserOrgId;
    }

    public void setTopUserOrgId(Long topUserOrgId) {
        this.topUserOrgId = topUserOrgId;
    }

    public Integer getIsCustomAdmin() {
        return isCustomAdmin;
    }

    public void setIsCustomAdmin(Integer isCustomAdmin) {
        this.isCustomAdmin = isCustomAdmin;
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
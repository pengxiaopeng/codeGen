package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;
import java.util.Date;

/**
* tableName：bid_college_info
*/
public class CollegeInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //高校ID
    private Long collegeId;
    //高校名称
    private String collegeName;
    //高校LOGO文件路径
    private String logoPath;
    //所属省
    private String inProvince;
   // 所属地市
    private String inCity;
    //备注
    private String REMARK;
   // 高校地址
    private String collegeAdd;
   // 甲方法定代表人
    private String juridicalPerson;
   // 银行名称
    private String bankName;
   // 银行用户名
    private String bankUserName;
    //银行账号
    private String bankAccount;
    //项目部署地址
    private String projectUrl;
   // 部署方式：0通用 1独立，如果是独立部署，则需要做数据交换
    private Integer deploymentType;
    
    private Long createUserId;
   // 创建时间
    private Date createDate;
   // 最后更新时间
    private Date modifyDate;
    
    private Long modifyUserId;
    
    private String logo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getInProvince() {
        return inProvince;
    }

    public void setInProvince(String inProvince) {
        this.inProvince = inProvince;
    }

    public String getInCity() {
        return inCity;
    }

    public void setInCity(String inCity) {
        this.inCity = inCity;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getCollegeAdd() {
        return collegeAdd;
    }

    public void setCollegeAdd(String collegeAdd) {
        this.collegeAdd = collegeAdd;
    }

    public String getJuridicalPerson() {
        return juridicalPerson;
    }

    public void setJuridicalPerson(String juridicalPerson) {
        this.juridicalPerson = juridicalPerson;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public Integer getDeploymentType() {
        return deploymentType;
    }

    public void setDeploymentType(Integer deploymentType) {
        this.deploymentType = deploymentType;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
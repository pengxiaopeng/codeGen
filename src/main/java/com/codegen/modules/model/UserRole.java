package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;

import java.util.Date;

/**
* tableName：ms_user_role
*/
public class UserRole extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private String id;
    
    private String userId;
    
    private String roleId;
    
    private Date createtime;
    
    private Date updatetime;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId= userId;
    }
    public String getRoleId(){
        return roleId;
    }
    public void setRoleId(String roleId){
        this.roleId= roleId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
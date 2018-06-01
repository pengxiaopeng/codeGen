package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;

import java.util.Date;

/**
* tableName：ms_dict
*/
public class Dict extends BaseModel {

    private static final long serialVersionUID = 1L;

    
    private String id;
    
    private String label;
    
    private String value;
    
    private String type;
    
    private String sort;
    
    private Date createtime;
    
    private Date updatetime;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label= label;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value= value;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type= type;
    }
    public String getSort(){
        return sort;
    }
    public void setSort(String sort){
        this.sort= sort;
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
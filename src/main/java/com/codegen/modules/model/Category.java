package com.codegen.modules.model;


import com.generator.codegen.common.model.BaseModel;

import java.util.Date;

/**
* tableName：tbd_price_compare_type
*/
public class Category extends BaseModel {

    private static final long serialVersionUID = 1L;

    /***/
    private String id;
    /**分类的图片url*/
    private String img;
    /**分类的名字*/
    private String name;
    /**创建日期*/
    private Date createDate;
    /**修改日期*/
    private Date updateDate;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img= img;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Date createDate){
        this.createDate= createDate;
    }
    public Date getUpdateDate(){
        return updateDate;
    }
    public void setUpdateDate(Date updateDate){
        this.updateDate= updateDate;
    }
}
package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;
import com.codegen.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-07-02 9:34
 **/
public class Blog extends BaseModel {
    private Long id;
    private String content;
    private String label;
    private String type;
    private String author;
    private String title;
    private java.util.Date modifydate;
    private java.util.Date createdate;
    private Long modifyuserid;
    private Long createuserid;
    private List<String> types;

    public List<String> getTypes() {
        if ((types == null || types.isEmpty()) && StringUtils.isNotBlank(type)) {
            types = Arrays.asList(type.split(","));
            return types;
        }
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setModifydate(java.util.Date modifydate) {
        this.modifydate = modifydate;
    }

    public java.util.Date getModifydate() {
        return this.modifydate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setModifyuserid(Long modifyuserid) {
        this.modifyuserid = modifyuserid;
    }

    public Long getModifyuserid() {
        return this.modifyuserid;
    }

    public void setCreateuserid(Long createuserid) {
        this.createuserid = createuserid;
    }

    public Long getCreateuserid() {
        return this.createuserid;
    }

}

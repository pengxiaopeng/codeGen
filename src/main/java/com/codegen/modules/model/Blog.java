package com.codegen.modules.model;

import com.codegen.common.model.BaseModel;
import com.codegen.utils.StringUtils;

import java.util.Arrays;
import java.util.Date;
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
    private java.util.Date modifyDate;
    private java.util.Date createDate;
    private Long modifyUserId;
    private Long createUserId;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}

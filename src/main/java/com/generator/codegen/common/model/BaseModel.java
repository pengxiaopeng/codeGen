package com.generator.codegen.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class BaseModel implements Serializable {
    protected static final long serialVersionUID = 1L;
    private Integer count;
    private Date dateStart;
    private Date dateEnd;
    private Object[] ids;
    private LinkedHashMap<String, Object[]> idsMap;
    private LinkedHashMap<String, String> orderByMap;

    public BaseModel() {
    }

    public LinkedHashMap<String, String> getOrderByMap() {
        return this.orderByMap;
    }

    public void setOrderByMap(LinkedHashMap<String, String> orderByMap) {
        this.orderByMap = orderByMap;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Object[] getIds() {
        return this.ids;
    }

    public void setIds(Object[] ids) {
        this.ids = ids;
    }

    public LinkedHashMap<String, Object[]> getIdsMap() {
        return this.idsMap;
    }

    public void setIdsMap(LinkedHashMap<String, Object[]> idsMap) {
        this.idsMap = idsMap;
    }
}

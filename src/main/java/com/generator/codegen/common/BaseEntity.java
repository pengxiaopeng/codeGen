package com.generator.codegen.common;

import java.io.Serializable;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-29 15:16
 **/
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

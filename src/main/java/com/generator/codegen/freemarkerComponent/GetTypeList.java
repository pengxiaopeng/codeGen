package com.generator.codegen.freemarkerComponent;

import com.generator.codegen.annotation.FreemarkerComponent;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-31 11:41
 **/
@FreemarkerComponent("getTypeList")
public class GetTypeList implements TemplateMethodModelEx {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        return list;
    }
}

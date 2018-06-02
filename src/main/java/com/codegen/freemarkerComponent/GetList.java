package com.codegen.freemarkerComponent;

import com.codegen.annotation.FreemarkerComponent;
import com.codegen.common.web.CommonContrller;
import com.codegen.modules.model.Authority;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION 获取菜单列表
 * @create 2018-06-02 7:34
 **/
@FreemarkerComponent("getListFrom")
public class GetList extends CommonContrller implements TemplateMethodModelEx {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        String name = (String) arguments.get(0);
        try {
            Method method = GetList.class.getMethod("get" + firstLetterUpper(name) + "List");
            return method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException |IllegalArgumentException | InvocationTargetException e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return "";
    }

    public static String firstLetterUpper(String str) {
        if (str == null)
            return null;
        char[] charArray = str.toCharArray();
        if (charArray.length > 0) {
            charArray[0] = Character.toUpperCase(charArray[0]);
        }
        return new String(charArray);
    }

    /**
     * 获取菜单列表
     *
     * @return
     */
    public List<Authority> getAuthorityList() {
        List<Authority> parentList = getParentAuthorityList();
        if (parentList != null && !parentList.isEmpty()) {
            for (Authority authority1 : parentList) {
                authority1.setChildAuthorityList(authorityService.findList(new Authority(authority1.getId())));
            }
        }
        return parentList;
    }

    /**
     * 获取父级菜单
     *
     * @return
     */
    public List<Authority> getParentAuthorityList() {
        return authorityService.findList(new Authority(0L));
    }
}

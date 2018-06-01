package com.codegen.common.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.generator.codegen.common.base.Page;
import com.generator.codegen.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
@Service
public class BaseRestService<T, ID> {

    private final String restFulUrl = "http://restful.dragonpass.com.cn/";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    protected RestTemplate simpleRestTemplate;


    public T getById(ID id, ModulesEnum modules, Class<T> tClass) {
        String url = restFulUrl + modules + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/get/" + id.toString();
        try {
            return simpleRestTemplate.getForObject(url, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<T> findList(T t, ModulesEnum modules, Class<T> tClass) {
        String url = restFulUrl + modules.toString() + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/findList";
        try {
            JSONObject json = null;
            if (t != null) {
                json = JSONObject.parseObject(JSONObject.toJSONString(t));
            } else {
                json = new JSONObject();
            }
            JSONArray array = simpleRestTemplate.postForEntity(url, json, JSONArray.class).getBody();
            List<T> list = new ArrayList<>();
            if (array == null || array.size() == 0) {
                return list;
            }
            list = JSONObject.parseArray(array.toString(), tClass);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }


    public Page<T> findPage(Integer page, Integer pageSize, T t, ModulesEnum modules, Class<T> tClass) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        String url = restFulUrl + modules.toString() + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/findPage/" + page + "/" + pageSize;
        try {
            JSONObject json = null;
            if (t != null) {
                json = JSONObject.parseObject(JSONObject.toJSONString(t));
            } else {
                json = new JSONObject();
            }
            Page<T> pageResult = simpleRestTemplate.postForObject(url, json, Page.class);
            List resultList = pageResult.getResult();
            List ObjList = Lists.newArrayList();
            for (Object obj : resultList) {
                String objStr = JSONObject.toJSONString(obj);
                ObjList.add(JSONObject.parseObject(objStr, tClass));
            }
            pageResult.setResult(ObjList);
            return pageResult;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    public T get(T t, ModulesEnum modules, Class<T> tClass) {
        Page<T> page = findPage(1, 1, t, modules, tClass);
        if (page == null || page.getTotal() == 0) {
            return null;
        }
        return page.getResult().get(0);
    }

    public T save(T t, ModulesEnum modules, Class<T> tClass) {
        String url = restFulUrl + modules.toString() + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/save";
        try {
            JSONObject json = null;
            if (t != null) {
                json = JSONObject.parseObject(JSONObject.toJSONString(t));
            } else {
                json = new JSONObject();
            }
            return simpleRestTemplate.postForObject(url, json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    public int updateByPrimaryKey(T t, ModulesEnum modules, Class<T> tClass) {
        String url = restFulUrl + modules.toString() + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/updateByPrimaryKey";
        return update(t, url);
    }

    public int updateByPrimaryKeySelective(T t, ModulesEnum modules, Class<T> tClass) {
        String url = restFulUrl + modules.toString() + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/updateByPrimaryKeySelective";
        return update(t, url);
    }

    private int update(T t, String url) {
        try {
            if (t == null) {
                return 0;
            }
            return simpleRestTemplate.postForObject(url, t, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return 0;
    }

    public int deleteByPrimaryKey(ID id, ModulesEnum modules, Class<T> tClass) {
        String url = restFulUrl + modules.toString() + "/" + toFirstToLowerCase(tClass.getSimpleName()) + "/delete/" + id.toString();
        try {
            HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(new JSONObject());
            return simpleRestTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Integer.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return 0;
    }

    private String toFirstToLowerCase(String name) {
        if (StringUtils.isEmpty(name)) {
            return name;
        }
        String first = name.substring(0, 1);
        return first.toLowerCase() + name.substring(1);
    }

    public enum ModulesEnum {
        user, dragon, publics, products, share, order, weixin, equity, invoice, voucher, cashCoupon, schedule, account, activity, flight
    }
}

<#--输入框模板-->
<#macro inputElement style="" name="" value="" label="" type="text" placeholder="" verify="" maxlength="200">
    <div class="layui-inline" style="${style!""}">
        <label class="layui-form-label">${label!""}</label>
        <div class="layui-input-inline">
            <input type="${text!""}" name="${name!""}" value="${value!""}" placeholder="${placeholder!""}"
                  <#if verify!="">lay-verify="${verify}"</#if>
                   maxlength="${maxlength!"200"}"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
</#macro>

<#--搜索按钮模板-->
<#macro searchButton style="margin-top: 10px;">
    <div class="layui-inline" style="${style!""}">
        <button class="btn btn-success" lay-submit=""><i class="fa fa-search"></i>搜索</button>
    </div>
</#macro>

<#--表单按钮：提交、返回-->
<#macro submitAndBackBtn>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="btn btn-success" lay-submit lay-filter="formDemo">提交</button>
            <button type="button" onClick="javascript :history.back(-1);" class="layui-btn layui-btn-primary">返回
            </button>
        </div>
    </div>
</#macro>

<#--下拉选择框-->
<#macro selectModel selectValue="" label="" verify="" name="" list=[] valueName="id" optionName="name">
    <div class="layui-inline">
        <label class="layui-form-label">${label!""}</label>
        <div class="layui-input-inline">
            <select name="${name!""}" <#if verify!="">lay-verify="${verify}"</#if> lay-search>
                <option value="">请选择${label!""}</option>
                <#if  list?? && (list?size>0)>
                    <#list list as item>
                        <option value="${item[valueName]}"
                            <#if selectValue!="" && selectValue == item[valueName]?c>
                                selected="${selectValue}"
                            </#if>>${item[optionName]}
                        </option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>
</#macro>

<#--radio 选择-->
<#macro radioModel label="" name="" list=[]>
    <div class="layui-inline">
        <label class="layui-form-label">${label!""}</label>
        <div class="layui-inline">
        <#if  list?? && (list?size>0)>
            <#list list as item>
                <input type="radio" name="${name!""}" value="${item.value!''}" title="${item.title!''}"
                       <#if item.checked?? && item.checked != "">checked="${item.checked}"</#if>>
            </#list>
        </#if>
        </div>
    </div>
</#macro>

<#--checkbox 选择-->
<#macro checkBoxModel label="" name="" list=[]>
    <div class="layui-inline">
        <label class="layui-form-label">${label!""}</label>
        <div class="layui-inline">
        <#if  list?? && (list?size>0)>
            <#list list as item>
                <input type="checkbox" name="${name!""}" value="${item.value!''}" title="${item.title!''}"
                       <#if item.checked?? && item.checked != "">checked="${item.checked}"</#if>>
            </#list>
        </#if>
        </div>
    </div>
</#macro>
<#macro viewModel label="" value="" >
<div class="layui-inline">
    <label class="layui-form-label">${label!""}</label>
    <div class="layui-form-mid">${value!""}</div>
</div>
</#macro>
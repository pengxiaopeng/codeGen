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
            <button class="layui-btn layui-btn-primary" type="button" onClick="javascript :history.back(-1);" >返回</button>
        </div>
    </div>
</#macro>

<#--编辑（默认）按钮及返回-->
<#macro someBtnAndBackBtn btnName="编辑" href="">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <a class="btn btn-success" href="${href!""}" >${btnName!""}</a>
            <a class="layui-btn layui-btn-primary" onClick="javascript :history.back(-1);" >返回</a>
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

<#--table-->
<#macro tableModel headItmeList=[] list=[] bodyItmeList=[] needIndex="N">
    <table id="table" class="table table-bordered table-hover">
        <thead>
        <tr>
            <#list headItmeList as head>
                <th>${head}</th>
            </#list>
        </tr>
        </thead>
        </head
        <tbody>
            <#list list as item>
            <tr>
                <input type='hidden' id='id' value=${item.id}>
                <#if needIndex == "Y">
                     <td>${item?counter}</td>
                </#if>

                <#list bodyItmeList as body>
                   <td>
                       <#assign bodyStr='${body}' >
                       <#assign templateSource = r''+bodyStr>
                       <#assign inlineTemplate = templateSource?interpret>
                       <@inlineTemplate />
                   </td>
                </#list>
            </tr>
            </#list>
        </tbody>
    </table>
</#macro>

<#--list中的table-->
<#macro listTableModel headItmeList=[] list=[] bodyItmeList=[] needIndex="N">
    <section class="content">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                    <@tableModel headItmeList=headItmeList bodyItmeList=bodyItmeList list=list needIndex=needIndex/>
                    </div>
                <#include "page.ftl">
                </div>
            </div>
        </div>
    </section>
</#macro>
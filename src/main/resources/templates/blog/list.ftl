<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>文章管理</title>
    <#include "../include/cssResource.ftl">
    <#import "../include/formElements.ftl" as formElementsTemplate>
    <#import "../include/navbar.ftl" as navbarTemplate>
    <style>
        .label{
            display: inline;
            padding: .2em .6em .3em;
            font-size: 75%;
            font-weight: bold;
            line-height: 1;
            text-align: center;
            white-space: nowrap;
            vertical-align: baseline;
            border-radius: .25em;
        }
    </style>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <@navbarTemplate.navbar json={"list":[
        {"url":"/admin/blog/list","class":"active","title":"文章列表"},
        {"url":"/admin/blog/addView","title":"添加文章"}
    ]}
    />

    <#include "../include/sideBarMenu.ftl">

    <div class="content-wrapper">
        <form id="list" class="layui-form" action="/admin/blog/list">
            <div class="layui-form-item">
                <@formElementsTemplate.inputElement style="margin-top: 10px;" name="title" value="${blog.title!''}" label="标题" placeholder="请输入标题" />

                <@formElementsTemplate.inputElement style="margin-top: 10px;" name="author" value="${blog.author!''}" label="作者" placeholder="请输入描述" />

                <@formElementsTemplate.searchButton />
            </div>

            <#assign headItmeList=["标题","作者","类型","创建时间","修改时间","操作"]>
            <#assign bodyItmeList=["${r'<a class=\"btn btn-link\" href=\"/admin/blog/view?id=${item.id}\">${item.title}</a>'}","${r'${item.author}'}",
            "${r'<#if item.types?? && (item.types?size>0)><#list item.types as i><span class=\"label label-success\">${i}</span>  </#list></#if>'}",
            "${r'${item.createDate?datetime}'}","${r'${item.modifyDate?datetime}'}",
            "${r'<a class=\"btn btn-success btn-sm\" href=\"/admin/blog/editView?id=${item.id}\">修改</a>
                               <a class=\"btn  btn-success btn-sm\" onclick=\"deleteById(this);\">删除</a>'}"]>

            <@formElementsTemplate.listTableModel headItmeList=headItmeList bodyItmeList=bodyItmeList list=page.result/>
        </form>
    </div>
    <#include "../include/sidebarControl.ftl">
</div>
<#include "../include/jsResource.ftl">
<script type="text/javascript">
    function deleteById(_this) {
        layer.confirm('确认删除该记录?', {icon: 3, title: '提示'}, function (index) {
            var id = $(_this).closest("tr").find("input[id='id']").val();
            window.location.href = "/admin/blog/delete?id=" + id;
        });
    }

</script>
</body>
</html>
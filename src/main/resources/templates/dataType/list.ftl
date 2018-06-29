<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>权限管理</title>
    <#include "../include/cssResource.ftl">
    <#import "../include/formElements.ftl" as formElementsTemplate>
    <#import "../include/navbar.ftl" as navbarTemplate>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <@navbarTemplate.navbar json={"list":[
        {"url":"/admin/dataType/list","class":"active","title":"数字字典列表"},
        {"url":"/admin/dataType/addView","title":"添加数字字典"}
    ]}
    />

    <#include "../include/sideBarMenu.ftl">

    <div class="content-wrapper">
        <form id="list" class="layui-form" action="/admin/dataType/list">
            <div class="layui-form-item">
                <@formElementsTemplate.inputElement style="margin-top: 10px;" name="code" value="${dataType.code!''}" label="code" placeholder="请输入code" />

                <@formElementsTemplate.inputElement style="margin-top: 10px;" name="descpt" value="${dataType.descpt!''}" label="url" placeholder="请输入描述" />

                <@formElementsTemplate.searchButton />
            </div>

            <#assign headItmeList=["code","描述","创建时间","修改时间","操作"]>
            <#assign bodyItmeList=["${r'<a class=\"btn btn-link\" href=\"/admin/dataType/view?id=${item.id}\">${item.code}</a>'}","${r'${item.descpt}'}",
            "${r'${item.createDate?datetime}'}","${r'${item.modifyDate?datetime}'}",
            "${r'<a class=\"btn btn-success btn-sm\" href=\"/admin/dataType/editView?id=${item.id}\">修改</a>
                               <a class=\"btn  btn-success btn-sm\" onclick=\"deleteById(this);\">删除</a>'}"]>

            <#--<#include "../include/table.ftl">-->
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
            window.location.href = "/admin/dataType/delete?id=" + id;
        });
    }

</script>
</body>
</html>
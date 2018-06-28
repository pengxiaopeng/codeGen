<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户管理</title>
    <#include "../include/cssResource.ftl">
    <#import "../include/formElements.ftl" as formElementsTemplate>
    <#import "../include/navbar.ftl" as navbarTemplate>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <@navbarTemplate.navbar json={"list":[
        {"url":"/admin/user/list","class":"active","title":"用户列表"},
        {"url":"/admin/user/addView","title":"添加用户"}
    ]}
    />

    <#include "../include/sideBarMenu.ftl">

    <div class="content-wrapper">
        <form id="list" class="layui-form" action="/admin/authority/list">
            <div class="layui-form-item">
                <@formElementsTemplate.inputElement style="margin-top: 10px;" name="name" value="${authority.name!''}" label="名字" placeholder="请输入名字" />

                <@formElementsTemplate.inputElement style="margin-top: 10px;" name="url" value="${authority.url!''}" label="url" placeholder="请输入url" />

                <@formElementsTemplate.searchButton />
            </div>

            <#assign headItmeList=["用户名","昵称","email","是否启用","是否锁定","创建时间","修改时间","操作"]>

            <#assign bodyItmeList=["${r'${item.userName}'}","${r'${item.nickName}'}","${r'${item.email}'}",
            "${r'${(item.isEnabled==1)?then(\"启用 \",\"未启用\")}'}","${r'${(item.isLocked==1)?then(\"锁定 \",\"未锁定\")}'}",
            "${r'${item.createDate?datetime}'}","${r'${item.modifyDate?datetime}'}",
            "${r'<a class=\"btn btn-success btn-sm\" href=\"/admin/user/editView?id=${item.id}\">修改</a>
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
            window.location.href = "/admin/user/delete?id=" + id;
        });
    }
</script>
</body>
</html>
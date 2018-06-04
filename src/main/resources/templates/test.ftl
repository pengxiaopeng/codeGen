<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
    <#include "include/cssResource.ftl">

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <#include "include/navbar.ftl">
    <@navbar json={"list":[
        {"url":"/admin/authority/list","class":"active","title":"菜单列表"},
        {"url":"/admin/authority/addView","class":"","title":"添加菜单"}
    ]}
    />

    <#include "include/sideBarMenu.ftl">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <form id="list" class="layui-form">
            <div class="layui-form-item">
                <div class="layui-inline" style="margin-top: 10px;">
                    <label class="layui-form-label">名字</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="name" value="${authority.name!""}" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" style="margin-top: 10px;">
                    <label class="layui-form-label">url</label>
                    <div class="layui-input-inline">
                        <input type="text" name="url" value="${authority.url!""}" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" style="margin-top: 10px;">
                    <button class="btn btn-success" lay-submit=""><i class="fa fa-search"></i>搜索</button>
                </div>
            </div>
            <#assign headItmeList=["名字","url","parentId","节点类型","权限别名","创建时间","修改时间","操作"]>
            <#assign bodyItmeList=["name","url","parentId","positionDesc","name","createDateDesc","modifyDateDesc","buttonStr"]>
            <#assign operateButtonStr = "<a class='btn btn-success btn-sm' onclick='editById(this);'>修改</a>
                               <a class='btn  btn-success btn-sm' onclick='deleteById(this);'>删除</a>">
            <#include "include/table.ftl">
        </form>
    </div>
    <#include "include/sidebarControl.ftl">
</div>
<#include "include/jsResource.ftl">
<script type="text/javascript">
    function deleteById(_this) {
        layer.confirm('确认删除该记录?', {icon: 3, title: '提示'}, function (index) {
            var id = $(_this).closest("tr").find("input[name='id']").attr("name");
            window.location.href = "/admin/authority/delete?id=" + id;
        });
    }

    function editById(_this) {
        var id = $(_this).closest("tr").find("input[name='id']").attr("name");
        window.location.href = "/admin/authority/edit?id=" + id;
    }
</script>
</body>
</html>
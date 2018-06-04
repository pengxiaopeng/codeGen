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
    <@navbar json={"name":"mouse", "price":50}>
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
        <ul class="nav nav-pills">
            <li class="nav-item ">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fa fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/admin/authority/list" class="nav-link active">菜单列表</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/admin/authority/addView" class="nav-link">添加菜单</a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#"><i
                        class="fa fa-th-large"></i></a>
            </li>
        </ul>
    </nav>

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
            <#include "include/table.ftl">
        </form>
    </div>
    <#include "include/sidebarControl.ftl">
</div>
<#include "include/jsResource.ftl">
<script type="text/javascript">
    function deleteById(_this) {
        layer.confirm('确认删除该记录?', {icon: 3, title: '提示'}, function (index) {
            var id = $(_this).attr("name");
            window.location.href = "/admin/authority/delete?id=" + id;
        });
    }
    function editById(_this) {

    }
</script>
</body>
</html>
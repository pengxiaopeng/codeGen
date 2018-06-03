<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
    <#include "include/cssResource.ftl">

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
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
    <!-- Main Sidebar Container -->
    <aside class="main-sidebar elevation-4 sidebar-dark-primary">
        <!-- Brand Logo -->
        <a href="../index3.html" class="brand-link">
            <span class="brand-text font-weight-light">管理系统</span>
        </a>

        <!-- Sidebar -->
        <#include "include/sideBarMenu.ftl">
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <form id="list" class="layui-form">
            <input type="hidden" name="page">
            <input type="hidden" name="pageMax">
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
            <section class="content">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>名字</th>
                                        <th>url</th>
                                        <th>parentId</th>
                                        <th>节点类型</th>
                                        <th>权限别名</th>
                                        <th>创建时间</th>
                                        <th>修改时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list page.result as item>
                                    <tr>
                                        <td >${item.name}</td>
                                        <td >${item.url}</td>
                                        <td >${item.url}</td>
                                        <td >${(item.position==1)?string('功能节点','菜单节点')}</td>
                                        <td >${item.authorities}</td>
                                        <td >${item.createDate?datetime}</td>
                                        <td >${item.modifyDate?datetime}</td>
                                        <td>
                                            <#--<div sec:authorize="hasAuthority('admin:authority')">-->
                                                <a class="btn btn-success btn-sm"
                                                   href="/admin/authority/editView?id='+${item.id}">修改
                                                </a>
                                                <a class="btn  btn-success btn-sm" onclick='deleteById(this);'
                                                   name=${item.id}">删除
                                                </a>
                                            <#--</div>-->
                                        </td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                            <#include "include/page.ftl">
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </section>
            <!-- /.content -->
        </form>
    </div>
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
</div>
<#include "include/jsResource.ftl">
<script type="text/javascript">
        layui.use(['form', 'layedit', 'laydate', 'element', 'laypage', 'table', 'layer'], function () {
            var form = layui.form
                    , layer = layui.layer
                    , layedit = layui.layedit
                    , element = layui.element
                    , laypage = layui.laypage
                    , layer = layui.layer
                    , laydate = layui.laydate
                    , table = layui.table;
            laypage.render({
                elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
                count: $("#total").val(), //数据总数，从服务端得到
                curr: $("#pageNum").val(),
                limit: $("#pageSize").val(),
                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
                jump: function (obj, first) {
                    //obj包含了当前分页的所有参数，比如：
                    //console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                    //console.log(obj.limit); //得到每页显示的条数

                    //首次不执行
                    if (!first) {
                        $("#list").find("input[name='page']").val(obj.curr);
                        $("#list").find("input[name='pageMax']").val(obj.limit);
                        $("#list").submit();
                    }
                }
            });
        });
    function deleteById(_this) {
        layer.confirm('确认删除该记录?', {icon: 3, title: '提示'}, function (index) {
            var id = $(_this).attr("name");
            window.location.href = "/admin/authority/delete?id=" + id;
        });
    }
</script>

</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <title>添加菜单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <#include "../include/cssResource.ftl">
    <#import "../include/formElements.ftl" as formElements>

    <style type="text/css">
        form label {
            width: 7rem !important;
        }
    </style>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->

    <#include "../include/navbar.ftl">
    <@navbar json={"list":[
    {"url":"/admin/authority/list","class":"","title":"菜单列表"},
    {"url":"/admin/authority/addView","class":"active","title":"添加菜单"}
    ]}/>

    <#include "../include/sideBarMenu.ftl">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- general form elements -->
                        <div class="card card-success">
                            <div class="card-header">
                                <h3 class="card-title">添加菜单</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form class="layui-form" action="/admin/authority/add">
                                <div class="card-body">
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="name" label="名字" placeholder="请输入名字" />
                                        <@formElements.inputElement name="url" label="名字" placeholder="请输入url" verify="required" />
                                    </div>
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="authorities" label="权限别名" placeholder="请输入权限别名" verify="required"/>
                                        <@formElements.inputElement name="itemIcon" label="icon" placeholder="请输入icon的css 类名" verify="required"/>
                                    </div>
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">父节点</label>
                                            <div class="layui-input-inline">
                                                <select name="parentId" lay-verify="" lay-search>
                                                    <option value="0">请选择</option>
                                                    <option th:each="root : ${parentAuthorityList}"
                                                            th:value="${root.id}"
                                                            th:text="${root.name}">1
                                                    </option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <label class="layui-form-label">菜单类型</label>
                                            <div class="layui-inline">
                                                <input type="radio" name="position" value="1" title="功能节点" checked="">
                                                <input type="radio" name="position" value="0" title="菜单节点">
                                            </div>
                                        </div>
                                    </div>

                                    <@formElements.submitAndBackBtn />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
</div>
<footer th:insert="fragments/jsResource :: jsResource"></footer>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>添加用户</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <#include "../include/cssResource.ftl">
    <#import "../include/formElements.ftl" as formElements>
    <#import "../include/navbar.ftl" as navbarTemplate>
    <style type="text/css">
        form label {
            width: 7rem !important;
        }
    </style>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->

    <@navbarTemplate.navbar json={"list":[
    {"url":"/admin/user/list","title":"用户列表"},
    {"url":"/admin/user/addView","class":"active","title":"添加用户"}
    ]}
    />

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
                                <h3 class="card-title">添加用户</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form class="layui-form" action="/admin/user/add">
                                <div class="card-body">
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="username" label="用户名" placeholder="请输入用户名" verify="required" />
                                        <@formElements.inputElement name="nickName" label="昵称" placeholder="请输入昵称"  />
                                    </div>
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="email" label="邮箱" placeholder="请输入邮箱"  />
                                        <@formElements.inputElement name="password" type="password" label="密码" placeholder="请输入密码" verify="required"/>
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
    <#include "../include/sidebarControl.ftl">
</div>
<#include "../include/jsResource.ftl">
</body>
</html>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>查看文章</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <#include "../include/cssResource.ftl">
    <#import "../include/formElements.ftl" as formElementsTemplate>
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
    {"url":"/admin/blog/list","title":"文章列表"},
    {"url":"/admin/blog/addView","class":"active","title":"添加文章"}
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
                                <h3 class="card-title">查看文章</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <div class="card-body">
                                <div class="layui-form-item">
                                    <@formElementsTemplate.viewModel label="类型" value="${blog.type}"/>
                                    <@formElementsTemplate.viewModel label="标题"  value="${blog.title}"/>
                                    <@formElementsTemplate.viewModel label="作者"  value="${blog.author}"/>
                                </div>
                                <div class="col-md-6">
                                    <div class="card">
                                       <div>${blog.content}</div>
                                    </div>
                                </div>
                                <@formElementsTemplate.someBtnAndBackBtn href="/admin/blog/editView?id="+blog.id />
                            </div>
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

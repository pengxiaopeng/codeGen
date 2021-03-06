<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>查看数字字典</title>
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
    {"url":"/admin/dataType/list","title":"数字字典列表"},
    {"url":"/admin/dataType/addView","class":"active","title":"查看数字字典"}
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
                                <h3 class="card-title">查看字典类型</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <div class="card-body">
                                <div class="layui-form-item">
                                    <@formElementsTemplate.viewModel label="code" value="${dataType.code}"/>
                                    <@formElementsTemplate.viewModel label="描述"  value="${dataType.descpt}"/>
                                    <@formElementsTemplate.viewModel label="排序"  value="${dataType.sort}"/>
                                </div>
                                <div class="col-md-6">
                                    <div class="card">
                                        <div class="card-header">
                                            <h3 class="card-title">字典列表：</h3>
                                        </div>
                                        <div class="card-body">
                                                <#assign headItmeList=["#","code","描述"]>
                                                <#assign bodyItmeList=["${r'${item.code}'}","${r'${item.descpt}'}"]>
                                                <#assign list = dataType.dataDictionaries>
                                                <@formElementsTemplate.tableModel headItmeList=headItmeList bodyItmeList=bodyItmeList list=list needIndex="Y"/>
                                        </div>
                                    </div>
                                </div>
                                <@formElementsTemplate.someBtnAndBackBtn href="/admin/dataType/editView?id="+dataType.id />
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

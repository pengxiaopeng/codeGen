<!DOCTYPE html>
<html>
<head>
    <title>添加文章</title>
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
                                <h3 class="card-title">添加字典类型</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form class="layui-form" action="/admin/blog/add">
                                <div class="card-body">
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="type" label="类型" placeholder="请输入类型，逗号隔开" verify="required"/>
                                        <@formElements.inputElement name="title" label="标题" placeholder="请输入标题" verify="required" />
                                    </div>
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="author" label="作者" placeholder="请输入作者" verify="required"/>
                                    </div>
                                    <textarea id="editor" placeholder="Balabala" ></textarea>

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
<div style="display: none;" id="dataTypeModel">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">code</label>
            <div class="layui-input-inline">
                <input type="text" name="dataDictionaries[0].code" lay-verify="required"
                       placeholder="请输入code" autocomplete="off" class="layui-input"
                       maxlength="30">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-inline">
                <input type="text" name="dataDictionaries[0].descpt" lay-verify="required"
                       placeholder="请输入描述" autocomplete="off" class="layui-input"
                       maxlength="30">
            </div>
        </div>
        <div style="cursor: pointer; display: inline;" onclick="deleteDataType(this)"><i class="layui-icon" style="font-size: 30px; color: #28a745;">&#xe640;</i>
        </div>
    </div>
</div>
<script type="text/javascript">
    function addDataType() {

        var $model = $("#dataTypeModel").children().clone(true);

        $("#dataTypeList").append($model);

        initDataTypeListIndex();
    }

    function deleteDataType(_this) {
        $(_this).parent().remove();
        initDataTypeListIndex();
    }

    function initDataTypeListIndex() {
        $("#dataTypeList").find(".layui-form-item").each(function (index, value) {
            $(this).find("input").each(function (index2, value2) {
                $(this).attr("name", "dataDictionaries[" + index + "]." + $(this).attr("name").split(".")[1]);
            });
        });
    }
</script>
<#include "../include/jsResource.ftl">
</body>
</html>

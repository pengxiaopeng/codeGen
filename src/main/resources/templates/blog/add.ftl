<!DOCTYPE html>
<html>
<head>
    <title>添加文章</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <#include "../include/cssResource.ftl">
    <#include "../include/simditorResource.ftl">
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
                                <h3 class="card-title">添加文章</h3>
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
                                    <textarea id="editor" placeholder="请输入文章" ></textarea>
                                    <input type="hidden" name="content" id = "content"/>
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

<script type="text/javascript">
    $(document).ready(function () {
        var editor = new Simditor({
            textarea: $('#editor')
        });

        layui.use(['form', 'layedit', 'laydate', 'element', 'laypage', 'table', 'layer'], function () {
            var form = layui.form;
            form.on('submit(formDemo)', function(data){
                var content = editor.getValue();
                if(content == '' || content == 'undefined') {
                    return false; //阻止表单跳转。
                }
                $("#content").val(content);
                return true;
            });
        })
    });
</script>
<#include "../include/jsResource.ftl">
</body>
</html>

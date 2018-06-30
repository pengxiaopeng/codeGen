<!DOCTYPE html>
<html>
<head>
    <title>编辑用户</title>
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
    {"url":"/admin/user/addView","class":"active","title":"编辑用户"}
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
                                <h3 class="card-title">编辑用户</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form class="layui-form" action="/admin/user/edit">
                                <input type="hidden" name="id" value="${admin.id}"/>
                                <div class="card-body">
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="username" label="用户名" placeholder="请输入用户名" value="${admin.username}" verify="required" />
                                        <@formElements.inputElement name="nickName" label="昵称" placeholder="请输入昵称" value="${admin.nickName}"  />
                                    </div>
                                    <div class="layui-form-item">
                                        <@formElements.inputElement name="email" label="邮箱" placeholder="请输入邮箱" value="${admin.email}" />
                                        <@formElements.inputElement name="password" label="密码" type="password" value="${admin.password}" placeholder="请输入密码" verify="required"/>
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
<script type="text/javascript">
    $("input[name='username']").change(function () {
        var that = $(this);
        unique(that);
    });
    $("input[name='username']").keyup(function () {
        var that = $(this);
        unique(that);
    });
    function unique(that) {
        $.ajax({
            type : "POST",
            data:{"username":that.val(),"id":$("input[name='id']").val()},
            url:"/admin/user/unique",
            success:function(data){
                var label = that.parent().find("label");
                if(data == '0') {
                    label.css("display","block");
                } else {
                    label.css("display","none");
                }
            }
        });
    }
    layui.use(['form', 'layedit', 'laydate', 'element', 'laypage', 'table', 'layer'], function () {
        var form = layui.form;
        form.on('submit(formDemo)', function(data){
            var display = $("input[name='username']").parent().find("label").css("display");
            console.log(display);
            if(display != 'none') {
                return false;
            }
            return true; //阻止表单跳转。
        });
    })

</script>
<#include "../include/jsResource.ftl">
</body>
</html>

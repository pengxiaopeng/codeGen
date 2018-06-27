<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>查看数字字典</title>
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
                            <form class="layui-form" action="/admin/dataType/edit">
                                <div class="card-body">
                                    <div class="layui-form-item">
                                        <@formElements.viewModel label="code" value="${dataType.code}"/>
                                        <@formElements.viewModel label="描述"  value="${dataType.descpt}"/>
                                        <@formElements.viewModel label="排序"  value="${dataType.sort}"/>

                                    </div>
                                    <div class="col-md-6">
                                        <div class="card">
                                            <div class="card-header">
                                                <h3 class="card-title">字典列表：</h3>
                                            </div>
                                            <div class="card-body">
                                                <table id="example2" class="table table-bordered table-hover"
                                                       th:if="${not #lists.isEmpty(dataType.dataDictionaries)}">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10px">#</th>
                                                        <th>code</th>
                                                        <th>描述</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr th:each="item,index : ${dataType.dataDictionaries}">
                                                        <td th:text="${index.index}"></td>
                                                        <td th:text="${item.code}"></td>
                                                        <td th:text="${item.descpt}">""</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>


                                    <div id="dataTypeList"
                                         style="padding: 1rem; margin-bottom: 1rem; border: 1px solid #28a745;">
                                        <label class="layui-form-label">字典列表：</label>
                                        <div style="cursor: pointer" onclick="addDataType(this)"><i class="layui-icon"
                                                                                                    style="font-size: 30px; color: #28a745;">&#xe61f;</i>
                                        </div>
                                        <#list dataType.dataDictionaries as dataDict>
                                            <div class="layui-form-item">
                                                <input type="hidden" name="dataDictionaries[0].id" value="${dataDict.id}">
                                                <@formElements.inputElement name="dataDictionaries[0].code" label="code" placeholder="请输入code" verify="required" value="${dataDict.code}"/>
                                                <@formElements.inputElement name="dataDictionaries[0].descpt" label="描述" placeholder="请输入描述" verify="required" value="${dataDict.descpt}"/>
                                                <#if !dataDict?is_first>
                                                <div style="cursor: pointer; display: inline;" onclick="deleteDataType(this)">
                                                    <i class="layui-icon" style="font-size: 30px; color: #28a745;">&#xe640;</i>
                                                </div>
                                                </#if>
                                            </div>
                                        </#list>
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
    $(document).ready(function () {
        initDataTypeListIndex();
    });
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

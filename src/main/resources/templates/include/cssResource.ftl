<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:fragment="cssResource">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/common.css" rel="stylesheet"
          media="screen"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/dist/css/adminlte.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="/AdminLTE-3.0.0-alpha/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link href="/layui/css/layui.css" rel="stylesheet"
          media="screen"/>
    <link href="/layui/css/global.css" rel="stylesheet"
          media="screen"/>
    <script src="/layui/layui.js"></script>
    <script src="/AdminLTE-3.0.0-alpha/plugins/jquery/jquery.min.js"></script>
    <script type="text/javascript">
        //Demo
        layui.use(['form', 'layedit', 'laydate', 'element', 'laypage', 'table', 'layer'], function () {
            var form = layui.form
                    , layer = layui.layer
                    , layedit = layui.layedit
                    , element = layui.element
                    , laypage = layui.laypage
                    , layer = layui.layer
                    , laydate = layui.laydate
                    , table = layui.table;

            // 通知
            var message = "${message!''}";
            var icon = "${icon!''}";
            if (message != null && message != '' && message != 'undefinded') {
                layer.msg(message, {
                    icon: icon,
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            }
        });
    </script>
</head>
</html>



<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>login</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/dist/css/adminlte.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="/static/css/ionicons.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <b>管理系统</b>
    </div>
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">登录</p>
            <form action="/login" method="post">
                <#if RequestParameters['error']??>
                    <p style="color:red;">密码错误</p>
                </#if>
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="用户名" name="username">
                </div>
                <div class="form-group has-feedback">
                    <input type="password" name="password" class="form-control" placeholder="密码">
                </div>
                <div class="row">
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="/static/AdminLTE-3.0.0-alpha/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/static/AdminLTE-3.0.0-alpha/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- iCheck -->
<script src="/static/AdminLTE-3.0.0-alpha/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass   : 'iradio_square-blue',
            increaseArea : '20%' // optional
        })
    })
</script>
</body>
</html>

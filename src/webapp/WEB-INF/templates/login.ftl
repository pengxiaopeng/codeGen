<!DOCTYPE html>
<html>

<head>
    <title>Hello Spring Boot!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="../../static/layui/css/layui.css" * rel="stylesheet"
          media="screen"/>
    <link href="../../static/css/login.css" rel="stylesheet"
          media="screen"/>
</head>
<body>
<!-- Header -->
<div class="layui-layout layui-layout-admin">
    <div class="layui-body layui-tab-content site-demo site-demo-body">
        <p th:if="${param.logout}" class="bg-warning">已注销</p>
        <p th:if="${param.error}" class="bg-danger">密码错误</p>
        <form class="layui-form" action="/login" method="post">
            <div class="layadmin-user-login-main">
                <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                               for="LAY-user-login-username"></label>
                        <input type="text" name="username" id="LAY-user-login-username" lay-verify="required"
                               placeholder="用户名" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                               for="LAY-user-login-password"></label>
                        <input type="password" name="password" id="LAY-user-login-password" lay-verify="required"
                               placeholder="密码" class="layui-input">
                    </div>
                    <!--<div class="layui-form-item" style="margin-bottom: 20px;">
                        <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>记住密码</span><i
                                class="layui-icon"></i></div>
                        <a lay-href="/user/forget" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
                    </div>-->
                    <div class="layui-form-item">
                        <button class="layui-btn layui-btn-fluid" lay-submit="" type="submit">登 入
                        </button>
                    </div>
                    <!--<div class="layui-trans layui-form-item layadmin-user-login-other">
                        <label>社交账号登入</label>
                        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
                        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
                        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>
                        <a lay-href="/user/reg" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
                    </div>-->
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>

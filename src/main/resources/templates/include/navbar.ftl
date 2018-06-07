<#macro navbar json>
    <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
        <ul class="nav nav-pills">
            <li class="nav-item ">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fa fa-bars"></i></a>
            </li>
            <#list json.list as item>
                <li class="nav-item d-none d-sm-inline-block">
                    <a href="${item.url}" class="nav-link ${item.class!''}">${item.title}</a>
                </li>
            </#list>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell-o"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <div class="dropdown-divider"></div>
                    <a href="/logout" class="dropdown-item">
                        <i class="fa fa-envelope mr-2"></i> 退出登录
                    </a>
                    <a href="/logout" class="dropdown-item">
                        <i class="fa fa-users mr-2"></i> 切换账号
                    </a>
                    <div class="dropdown-divider"></div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#"><i
                        class="fa fa-th-large"></i></a>
            </li>
        </ul>
    </nav>
</#macro>
<aside class="main-sidebar elevation-4 sidebar-dark-primary">
    <!-- Brand Logo -->
    <a href="../index3.html" class="brand-link">
        <span class="brand-text font-weight-light">管理系统</span>
    </a>
    <div class="sidebar" id="sidebar">
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                data-accordion="false">
        <#list getListFrom("authority") as authority>
            <li class="nav-item">
                <a href="${(authority.parentId == 0)?string('#',authority.url)}" class="nav-link">
                    <i class="fa fa-tree nav-icon"></i>
                    <p>${authority.name}<i class="right fa fa-angle-left"></i></p>
                </a>
                <#assign childAuthorityList = authority.childAuthorityList>
                <#if  childAuthorityList?? && (childAuthorityList?size > 0)>
                    <ul class="nav nav-treeview">
                        <#list childAuthorityList as childAuthority>
                            <li class="nav-item">
                                <a href="${(childAuthority.parentId == 0)?string('#',childAuthority.url)}"
                                   class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>${childAuthority.name}</p>
                                </a>
                            </li>
                        </#list>
                    </ul>
                </#if>
            </li>
        </#list>
            </ul>
        </nav>
    </div>
</aside>
<script type="text/javascript">
    // 选中的菜单 进行高亮显示
    var pathname = window.location.pathname;
    var pathname2 = pathname.substring(0, pathname.lastIndexOf("/"));
    if(pathname2 != "") {
        $('#sidebar a').each(function (index) {
            if ($(this).attr('href').startsWith(pathname2)) {
                $(this).addClass('active');
                var $ul = $(this).parent().parent();
                if ($ul.hasClass("nav-treeview")) {
                    $ul.prev().addClass('active');
                    $ul.parent().addClass('menu-open');
                }
            }
        });
    }
</script>
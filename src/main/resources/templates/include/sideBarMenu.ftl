<div class="sidebar" id="sidebar">
    <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
            data-accordion="false">
        <#list getListFrom(authority) as authority>
            <li class="nav-item">
                <a href="${authority.parentId == 0 ? '#' : authority.url}" class="nav-link">
                    <i class="fa fa-tree nav-icon"></i>
                    <p>${r'${authority.name}'} <i class="right fa fa-angle-left"></i></p>
                </a>
                <#assign childAuthorityList = authority.childAuthorityList>
                <#if  childAuthorityList?? && (childAuthorityList?size > 0)>
                    <ul class="nav nav-treeview">
                        <#list childAuthorityList as childAuthority>
                            <li class="nav-item">
                                <a href="${childAuthority.parentId == 0 ? '#' : childAuthority.url}" class="nav-link">
                                    <i class="fa fa-circle-o nav-icon"></i>
                                    <p>${authority.name}</p>
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
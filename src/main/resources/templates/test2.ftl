<!DOCTYPE html>
<html >
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
    <#include "include/cssResource.ftl">
</head>
<body class="hold-transition sidebar-mini">
<@security.authorize access="hasAuthority('admin:authority')">
    <p>admin:authority</p>
</@security.authorize>
<@security.authorize access="hasAuthority('admidsan:autdsadhority')">
    <p>admidsan:autdsadhority</p>
</@security.authorize>
<textarea id="editor" placeholder="Balabala" autofocus></textarea>
<#include "include/simditorResource.ftl">
<script type="text/javascript">
    var editor = new Simditor({
        textarea: $('#editor')
        //optional options
    });
</script>
</body>
</html>
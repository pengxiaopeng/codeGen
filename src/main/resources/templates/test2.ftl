<!DOCTYPE html>
<html >
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
</head>
<body class="hold-transition sidebar-mini">
<@security.authorize access="hasAuthority('admin:authority')">
    <p>admin:authority</p>
</@security.authorize>
<@security.authorize access="hasAuthority('admidsan:autdsadhority')">
    <p>admidsan:autdsadhority</p>
</@security.authorize>
</body>
</html>
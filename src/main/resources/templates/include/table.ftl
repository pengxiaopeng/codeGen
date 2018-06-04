<#assign templateSource = r"
<#list page.result as item>
    <tr>
    <#list bodyItmeList as body>
       <td>${item[body]}</td>
    </#list>
    </tr>
</#list>">

<#assign inlineTemplate = templateSource?interpret>
<@inlineTemplate />





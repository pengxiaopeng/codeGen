<#assign templateSource = r"
<tbody>
<#list page.result as item>
    <tr>
    <input type='hidden' id='id' value=${item.id}>
    <#list bodyItmeList as body>
       <td>${item[body]}</td>
    </#list>
    </tr>
</#list>
</tbody>">

<#assign inlineTemplate = templateSource?interpret>

<@inlineTemplate />





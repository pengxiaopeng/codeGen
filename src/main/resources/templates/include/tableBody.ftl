<#assign templateSource = r"
<tbody>
<#list page.result as item>
    <tr>
    <input type='hidden' name='id' value=${item.id}>
    <#list bodyItmeList as body>
       <td>
       <#if body?has_next>
            ${item[body]}
       <#else>
           ${operateButtonStr}
       </#if>
       </td>
    </#list>
    </tr>
</#list>
</tbody>">

<#assign inlineTemplate = templateSource?interpret>

<@inlineTemplate />




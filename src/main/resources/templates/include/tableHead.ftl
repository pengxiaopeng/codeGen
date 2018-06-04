<#assign templateSource = r"
<thead>
    <tr>
        <#list headItmeList as head>
           <th>${head}</th>
        </#list>
    </tr>
</head">

<#assign inlineTemplate = templateSource?interpret>

<@inlineTemplate />





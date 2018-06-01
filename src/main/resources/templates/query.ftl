<?xml version="1.0" encoding="utf-8"?>
<dynamic-hibernate-statement>
	<!-- 获取列表 -->
	<sql-query name="${className}_getList">  
	    <![CDATA[ 
			select * from ${tableName} where 1=1
			<#list columns as column>
			<#assign 
				arg1="<#if ${column.propertyName}??>"
				arg2="and ${column.columnName}"
				arg3="${"
				arg4="}"
				arg5="</#if>">
				${arg1}
	     			${arg2} = '${arg3}${column.propertyName}${arg4}'
	     		${arg5}
			</#list>
	    ]]>
	</sql-query>
	
	<!-- 统计数目 -->
	<sql-query name="${className}_getNum">  
    <![CDATA[ 
		select count(0) from ${tableName} where 1=1
		<#list columns as column>
		<#assign 
			arg1="<#if ${column.propertyName}??>"
			arg2="and ${column.columnName}"
			arg3="${"
			arg4="}"
			arg5="</#if>">
			${arg1}
     			${arg2} = '${arg3}${column.propertyName}${arg4}'
     		${arg5}
		</#list>	
    ]]>
	</sql-query>
</dynamic-hibernate-statement>  
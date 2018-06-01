<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper columnNamespace="${packageName+"dao."+className+"Dao"}">
    <resultMap id="BaseResultMap" type="${packageName+"model."+className}">
    <#list columns as cls>
        <#if cls_index=0>
        <id column="${cls.columnName?upper_case}" property="${cls.columnName}" jdbcType="${cls.jdbcType}"/>
        <#else>
        <result column="${cls.columnName?upper_case}" property="${cls.columnName}" jdbcType="${cls.jdbcType}"/>
        </#if>
    </#list>
    </resultMap>

    <sql id="Base_Column_List">
    <#list columns as cls>
	<#if cls_index=columns?size-1>
        ${"T."+cls.columnName?upper_case}
    <#else>
        ${"T."+cls.columnName?upper_case+","}
    </#if>
    </#list>
    </sql>

    <sql id="whereSql">
<#list columns as cls>
    <#if cls.columnName != 'id'>
        <if test="${cls.columnName} != null">
        <#if cls.jdbcType == 'VARCHAR'>
            and ${cls.columnName?upper_case} like ${r'CONCAT("%",#{'}${cls.columnName}${r'},"%")'}
        <#else>
            and ${cls.columnName?upper_case} = ${r'#{'}${cls.columnName}${r'}'}
        </#if>
        </if>
    </#if>
</#list>
        <if test="idsMap != null">
            <foreach collection="idsMap.keys" item="key" separator=",">
                and ${r'${key}'} in
                <foreach item="item" collection="idsMap[key]" open="(" separator="," close=")">
                ${r'#{item}'}
                </foreach>
            </foreach>
        </if>
    </sql>

    <sql id="orderSql">
        <choose>
            <when test="orderByMap != null">
                order by
                <foreach collection="orderByMap.keys" item="key" separator=",">
                ${r'${key}'} ${r'${orderByMap[key]}'}
                </foreach>
            </when>
        </choose>
    </sql>

    <select id="selectByPrimaryKey" parameterType="java.<#assign idColumn=columns[0]/><#if idColumn.type="Long">lang.Long<#elseif idColumn.type="String">lang.String</#if>" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName?upper_case} T
        where ${"T."+idColumn.columnName?upper_case} = #${"{"+idColumn.columnName+",jdbcType="+idColumn.jdbcType+"}"}
    </select>

    <select id="findList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName?upper_case} T
        <where>
            <include refid="whereSql"/>
        </where>
        <include refid="orderSql"/>
    </select>

    <select id="findAll" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName?upper_case} T
    </select>

    <delete id="deleteByPrimaryKey" parameterType="java.<#assign idColumn=columns[0]/><#if idColumn.type="Long">lang.Long<#elseif idColumn.type="String">lang.String</#if>">
        delete from ${tableName?upper_case}
    <#assign idColumn=columns[0]/>
        where ${idColumn.columnName?upper_case} = #${"{"+idColumn.columnName+",jdbcType="+idColumn.jdbcType+"}"}
    </delete>

    <insert id="insert" parameterType="${packageName+"model."+className}" useGeneratedKeys="true" keyProperty="id">
            insert into ${tableName?upper_case} (
<#list columns as cls>
    <#if cls.columnName != 'id'>
        <#if cls_index=columns?size-1>
            ${cls.columnName?upper_case}
        <#else>
            ${cls.columnName?upper_case+","}
        </#if>
    </#if>
</#list>
            )
            values (
<#list columns as cls>
    <#if cls.columnName != 'id'>
        <#if cls_index=columns?size-1>
            ${"#{"+cls.columnName+", jdbcType="+cls.jdbcType+"}"}
        <#else>
            ${"#{"+cls.columnName+", jdbcType="+cls.jdbcType+"},"}
        </#if>
    </#if>
</#list>
            )
    </insert>
    <insert id="insertSelective" parameterType="${packageName+"model."+className}" useGeneratedKeys="true" keyProperty="id">
        insert into ${tableName?upper_case}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list columns as cls>
            <#if cls.columnName != 'id'>
            <if test="${cls.columnName} != null">
                ${cls.columnName?upper_case+","}
            </if>
            </#if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list columns as cls>
            <#if cls.columnName != 'id'>
            <if test="${cls.columnName} != null">
                ${"#{"+cls.columnName+", jdbcType="+cls.jdbcType+"},"}
            </if>
            </#if>
        </#list>
        </trim>
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="${packageName+"model."+className}">
        update ${tableName?upper_case}
        <set>
        <#assign subColumnList=columns[1..]/>
        <#list subColumnList as cls>
            <if test="${cls.columnName} != null">
                ${cls.columnName?upper_case}= ${"#{"+cls.columnName+", jdbcType="+cls.jdbcType+"},"}
            </if>
        </#list>
        </set>
    <#assign idColumn=columns[0]/>
        where ${idColumn.columnName?upper_case} = #${"{"+idColumn.columnName+",jdbcType="+idColumn.jdbcType+"}"}
    </update>

    <update id="updateByPrimaryKey" parameterType="${packageName+"model."+className}">
        update ${tableName?upper_case}
        set
    <#assign subColumnList=columns[1..]/>
    <#list subColumnList as cls>
        <#if cls_index=subColumnList?size-1>
            ${cls.columnName?upper_case}= ${"#{"+cls.columnName+", jdbcType="+cls.jdbcType+"}"}
        <#else>
            ${cls.columnName?upper_case}= ${"#{"+cls.columnName+", jdbcType="+cls.jdbcType+"},"}
        </#if>
    </#list>
    <#assign idColumn=columns[0]/>
        where ${idColumn.columnName?upper_case} = #${"{"+idColumn.columnName+",jdbcType="+idColumn.jdbcType+"}"}
    </update>
</mapper>
<#macro searchElement style="" name="" value="" label="" type="text" placeholder="" verify="">
<div class="layui-inline" style="${style!""}">
    <label class="layui-form-label">${label}</label>
    <div class="layui-input-inline">
        <input type="${text!""}" name="${name!""}" value="${value!""}" placeholder="${placeholder!""}"
              <#if verify!="">lay-verify="${verify}"</#if> autocomplete="off" class="layui-input">
    </div>
</div>
</#macro>

<#macro searchButton style="margin-top: 10px;">
<div class="layui-inline" style="${style!""}">
    <button class="btn btn-success" lay-submit=""><i class="fa fa-search"></i>搜索</button>
</div>
</#macro>
<#--输入框模板-->
<#macro inputElement style="" name="" value="" label="" type="text" placeholder="" verify="" maxlength="">
<div class="layui-inline" style="${style!""}">
    <label class="layui-form-label">${label}</label>
    <div class="layui-input-inline">
        <input type="${text!""}" name="${name!""}" value="${value!""}" placeholder="${placeholder!""}"
              <#if verify!="">lay-verify="${verify}"</#if>
               maxlength="${maxlength!"200"}"
               autocomplete="off" class="layui-input">
    </div>
</div>
</#macro>

<#--搜索按钮模板-->
<#macro searchButton style="margin-top: 10px;">
<div class="layui-inline" style="${style!""}">
    <button class="btn btn-success" lay-submit=""><i class="fa fa-search"></i>搜索</button>
</div>
</#macro>

<#--表单按钮：提交、返回-->
<#macro submitAndBackBtn>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="btn btn-success" lay-submit lay-filter="formDemo">提交</button>
            <button type="button" onClick="javascript :history.back(-1);" class="layui-btn layui-btn-primary">返回</button>
        </div>
    </div>
</#macro>
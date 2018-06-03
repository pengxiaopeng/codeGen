<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <#include "include/headResource.ftl">

</head>
<body>
<#include "include/sideBarMenu.ftl">
<#include "include/jsResource.ftl">
<script type="javascript">
    $(function () {
        $('#example2').DataTable({
            "paging": false,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "autoWidth": false,
            "info": false,
        });
    });
    function deleteById(_this) {
        layer.confirm('确认删除该记录?', {icon: 3, title: '提示'}, function (index) {
            var id = $(_this).attr("name");
            window.location.href = "/admin/authority/delete?id=" + id;
        });
    }
</script>
<script type="javascript">
    //Demo
    layui.use(['form', 'layedit', 'laydate', 'element', 'laypage', 'table', 'layer'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , element = layui.element
                , laypage = layui.laypage
                , layer = layui.layer
                , laydate = layui.laydate
                , table = layui.table;

        // 分页
        var page = [[${page}]];
        if (page != null && page != '' && page != 'undefinded') {
            //console.log([[${page.pageSize}]]);
            //转换静态表格
            table.init('list', {
                height: 315 //设置高度
                , limit: [[${page.pageSize}]] //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
                //支持所有基础参数
            });
            laypage.render({
                elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
                count: [[${page.total}]], //数据总数，从服务端得到
                curr: [[${page.pageNum}]],
                limit: [[${page.pageSize}]],
                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
                jump: function (obj, first) {
                    //obj包含了当前分页的所有参数，比如：
                    //console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                    //console.log(obj.limit); //得到每页显示的条数

                    //首次不执行
                    if (!first) {
                        $("#list").find("input[name='page']").val(obj.curr);
                        $("#list").find("input[name='pageMax']").val(obj.limit);
                        $("#list").submit();
                    }
                }
            });
        }
    });

</script>
</body>
</html>
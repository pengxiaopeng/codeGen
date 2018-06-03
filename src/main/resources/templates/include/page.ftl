<div class="page-margin" id="page"></div>
<input type="hidden" id="total" value="${page.total}">
<input type="hidden" id="pageNum" value="${page.pageNum}">
<input type="hidden" id="pageSize" value="${page.pageSize}">
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element', 'laypage', 'table', 'layer'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , element = layui.element
                , laypage = layui.laypage
                , layer = layui.layer
                , laydate = layui.laydate
                , table = layui.table;
        laypage.render({
            elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
            count: $("#total").val(), //数据总数，从服务端得到
            curr: $("#pageNum").val(),
            limit: $("#pageSize").val(),
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
    });
</script>
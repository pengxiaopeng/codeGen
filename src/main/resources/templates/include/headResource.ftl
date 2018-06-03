
    <link href="/css/core.css" type="text/css"/>
    <link href="/layui/css/layui.css" type="text/css"
          media="screen"/>
    <link href="/layui/css/global.css" type="text/css"
          media="screen"/>
    <link href="/css/common.css" type="text/css"
          media="screen"/>
    <script src="/AdminLTE-3.0.0-alpha/plugins/jquery/jquery.min.js" type="javascript"></script>
    <script src="/layui/layui.js" type="javascript"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js" type="javascript"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js" type="javascript"></script>
    <![endif]-->
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

            // 通知
            var message = "${message!''}";
            var icon = "${icon!''}";
            if (message != null && message != '' && message != 'undefinded') {
                layer.msg(message, {
                    icon: icon,
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            }
        });
    </script>




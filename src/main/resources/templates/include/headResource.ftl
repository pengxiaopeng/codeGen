
    <link href="/static/css/core.css" rel="stylesheet" media="screen"/>
    <link href="/static/layui/css/layui.css" rel="stylesheet"
          media="screen"/>
    <link href="/static/layui/css/global.css" rel="stylesheet"
          media="screen"/>
    <link href="/static/css/common.css" rel="stylesheet"
          media="screen"/>
    <script src="/static/AdminLTE-3.0.0-alpha/plugins/jquery/jquery.min.js"></script>
    <script src="/static/layui/layui.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
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




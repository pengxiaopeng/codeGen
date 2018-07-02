<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/common.css" rel="stylesheet"
          media="screen"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/font-awesome/css/fontawesome-all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/dist/css/adminlte.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <#--<link rel="stylesheet" href="/static/AdminLTE-3.0.0-alpha/plugins/bootstrap/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link href="/static/layui/css/layui.css" rel="stylesheet"
          media="screen"/>
    <link href="/static/layui/css/global.css" rel="stylesheet"
          media="screen"/>
    <script src="/static/layui/layui.js"></script>
    <script src="/static/AdminLTE-3.0.0-alpha/plugins/jquery/jquery.min.js"></script>
    <script type="text/javascript">
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



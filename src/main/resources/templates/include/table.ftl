<section class="content">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <!-- /.card-header -->
                <div class="card-body">
                    <table id="table" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                            <#list headItmeList as head>
                                <th>${head}</th>
                            </#list>
                            </tr>
                        </thead>
                        </head
                        <tbody>
                            <#list page.result as item>
                            <tr>
                                <input type='hidden' id='id' value=${item.id}>
                                <#list bodyItmeList as body>
                                   <td>
                                       <#assign bodyStr="${body}" >
                                       <#assign templateSource = r""+bodyStr>
                                       <#assign inlineTemplate = templateSource?interpret>
                                       <@inlineTemplate />
                                   </td>
                                </#list>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <!-- /.card-body -->
                <#include "page.ftl">
            </div>
            <!-- /.card -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->





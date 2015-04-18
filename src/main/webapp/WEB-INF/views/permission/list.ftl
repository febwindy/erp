[@override name="title"]资源列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        资源管理
        <small>资源列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/permission/list"><i class="fa fa-lock"></i> 资源管理</a></li>
        <li class="active">资源列表</li>
    </ol>
</section>

<section class="content margin-lr-10 thumbnail">
    <div class="row">

        [@mc.showAlert /]

        <table class="table table-hover">
            <tr>
                <th>编号</th>
                <th>资源名</th>
                <th>资源描述</th>
                <th>操作</th>
            </tr>
            [#if pagination.data!]
                [#if pagination.data?size > 0]
                    [#list pagination.data as permission]
                        <tr>
                            <td>${permission_index + 1}</td>
                            <td>${permission.resource}</td>
                            <td>${permission.description}</td>
                            <td>
                                <a class="btn btn-success btn-sm" href="/permission/view/${permission.id}">查看</a>
                                <a class="btn btn-info btn-sm" href="/permission/edit/${permission.id}">编辑</a>
                                <a class="btn btn-danger btn-sm" href="/permission/delete/${permission.id}">删除</a>
                            </td>
                        </tr>
                    [/#list]
                [/#if]
            [/#if]
        </table>
    </div>
    [@mc.showPagination '/permission/list' /]
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
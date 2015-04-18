[@override name="title"]角色列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        角色管理
        <small>角色列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/role/list"><i class="fa fa-users"></i> 角色管理</a></li>
        <li class="active">角色列表</li>
    </ol>
</section>

<section class="content margin-lr-10 thumbnail">
    <div class="row">

        [@mc.showAlert /]

        <table class="table table-hover">
            <tr>
                <th>编号</th>
                <th>角色名</th>
                <th>角色描述</th>
                <th>操作</th>
            </tr>
            [#if pagination.data!]
                [#if pagination.data?size > 0]
                    [#list pagination.data as role]
                        <tr>
                            <td>${role_index + 1}</td>
                            <td>${role.role}</td>
                            <td>${role.description}</td>
                            <td>
                                <a class="btn btn-success btn-sm" href="/role/view/${role.id}">查看</a>
                                <a class="btn btn-info btn-sm" href="/role/edit/${role.id}">编辑</a>
                                <a class="btn btn-danger btn-sm" href="/role/delete/${role.id}">删除</a>
                                <a class="btn btn-primary btn-sm" href="/role/authorization/${role.id}">资源授权</a>
                            </td>
                        </tr>
                    [/#list]
                [/#if]
            [/#if]
        </table>
    </div>
    [@mc.showPagination '/role/list' /]
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
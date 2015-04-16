[@override name="title"]用户列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            用户管理
            <small>用户列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/user/list"><i class="fa fa-user"></i> 用户管理</a></li>
            <li class="active">用户列表</li>
        </ol>
    </section>

    <section class="content margin-lr-10">
        <div class="row">
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>用户名</th>
                    <th>真实姓名</th>
                    <th>部门</th>
                    <th>性别</th>
                    <th>联系电话</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                [#if pagination.data!]
                    [#if pagination.data?size > 0]
                        [#list pagination.data as user]
                            <tr>
                                <td>${user_index + 1}</td>
                                <td>${user.username}</td>
                                <td>${user.realName}</td>
                                <td>${user.organization}</td>
                                <td>
                                    [#if user.sex]
                                        男
                                    [#else]
                                        女
                                    [/#if]
                                </td>
                                <td>${user.telephone}</td>
                                <td>${user.createdDate}</td>
                                <td>
                                    <a class="btn btn-success" href="/user/view/${user.id}">查看</a>
                                    <a class="btn btn-danger" href="/user/delete/${user.id}">删除</a>
                                    <a class="btn btn-primary" href="/user/authorization/${user.id}">授权角色</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
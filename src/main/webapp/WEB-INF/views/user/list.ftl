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

    <section class="content margin-lr-10 thumbnail">
        <div class="row">

            [@mc.showAlert /]

            <form class="form-inline" action="/user/list" method="post">
                <div class="form-group">
                    <div class="col-sm-3">
                        <label for="username">用户名:</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control pull-left" id="username" name="username" placeholder="请输入用户名"
                               value="${user.username}">
                    </div>
                    <div class="col-sm-3">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                        </button>
                    </div>
                </div>
            </form>
            <br/>
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
                                    <a class="btn btn-success btn-sm" href="/user/view/${user.id}">查看</a>
                                    <a class="btn btn-info btn-sm" href="/user/edit/${user.id}">编辑</a>
                                    <a class="btn btn-danger btn-sm" href="/user/delete/${user.id}">删除</a>
                                    <a class="btn btn-primary btn-sm" href="/user/authorization/${user.id}">授权角色</a>
                                </td>
                            </tr>
                        [/#list]
                    [/#if]
                [/#if]
            </table>
        </div>
        [@mc.showPagination '/user/list?username=${username}' /]
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
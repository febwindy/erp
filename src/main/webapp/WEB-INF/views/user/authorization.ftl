[@override name="title"]用户角色授权[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        用户管理
        <small>用户角色授权</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/user/list"><i class="fa fa-user"></i> 用户管理</a></li>
        <li class="active">用户角色授权</li>
    </ol>
</section>

<section class="container content">
    <div class="row">
        <form class="form-horizontal" action="/user/authorization/${user.id}" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="username" name="username" readonly
                           required="true" placeholder="请输入用户名" value="${user.username}">
                </div>
            </div>

            <div class="form-group">
                <label for="roles" class="col-sm-3 control-label">角色列表</label>
                <div id="roles" class="col-sm-6">
                    [#list roles as role]
                        [#assign checked = ""/]
                        [#list user.roles as userRole]
                            [#if role.id == userRole.id]
                                [#assign checked = "checked"/]
                            [/#if]
                        [/#list]
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="${role.id}" name="roles" ${checked}/> ${role.description}
                            </label>
                        </div>
                    [/#list]
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="col-sm-offset-8 col-sm-4">
                        <button type="submit" class="btn btn-md btn-success btn-block">授权</button>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="col-sm-4">
                        <a href="/user/list" class="btn btn-md btn-danger btn-block" type="button">返回</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
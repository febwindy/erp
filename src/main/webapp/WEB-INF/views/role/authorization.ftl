[@override name="title"]角色资源授权[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        角色管理
        <small>角色资源授权</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/role/list"><i class="fa fa-users"></i> 角色资源管理</a></li>
        <li class="active">角色资源授权</li>
    </ol>
</section>

<section class="container content">
    <div class="row">
        <form class="form-horizontal" action="/role/authorization/${role.id}" method="post">

            <div class="form-group">
                <label for="role" class="col-sm-2 control-label">角色名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="role" name="role" readonly
                           required="true" placeholder="请输入角色名" value="${role.role}">
                </div>
            </div>

            <div class="form-group">
                <label for="permissions" class="col-sm-2 control-label">资源列表</label>
                <div id="permissions" class="col-sm-9">
                    [#list permissions as permission]
                        [#assign checked = "" /]
                        [#list role.permissions as rolePermission]
                            [#if permission.id == rolePermission.id]
                                [#assign checked = "checked" /]
                            [/#if]
                        [/#list]
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="${permission.id}" name="permissions" ${checked}/>
                                ${permission.resource} - ${permission.description}
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
                        <a href="/role/list" class="btn btn-md btn-danger btn-block" type="button">返回</a>
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
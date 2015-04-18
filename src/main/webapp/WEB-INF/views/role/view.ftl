[@override name="title"]角色查看[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        角色管理
        <small>角色详情</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/role/list"><i class="fa fa-users"></i> 角色管理</a></li>
        <li class="active">角色详情</li>
    </ol>
</section>

<section class="container content">
    <div class="row">
        <div role="form" class="form-horizontal">

            <div class="form-group">
                <label for="role" class="col-sm-2 control-label">角色名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="role" name="role"
                           required="true" placeholder="请输入角色名" readonly value="${role.role}">
                </div>
            </div>

            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">角色描述</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="description" name="description"
                           required="true" placeholder="请输入角色描述" readonly value="${role.description}">
                </div>
            </div>

            [#if role.permissions?size > 0]
                <div class="form-group">
                    <label for="roles" class="col-sm-2 control-label">资源列表</label>
                    <div class="col-sm-9" id="roles">
                        [#list role.permissions as permission]
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="${permission.id}" name="permissions" checked/>
                                    ${permission.resource} - ${permission.description}
                                </label>
                            </div>
                        [/#list]
                    </div>
                </div>
            [/#if]

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="col-sm-offset-8 col-sm-4">
                        <a href="/role/list" class="btn btn-block btn-danger" type="button">返回</a>
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
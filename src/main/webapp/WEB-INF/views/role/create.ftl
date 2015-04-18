[@override name="title"]角色创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            角色管理
            <small>角色创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/role/list"><i class="fa fa-users"></i> 角色管理</a></li>
            <li class="active">角色创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/role/create" method="post">

                [@spring.bind "role.role"/]
                <div class="form-group">
                    <label for="role" class="col-sm-2 control-label">角色名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="role" name="role"
                               required="true" placeholder="请输入角色名" value="${role.role}">
                        [@spring.showErrors "role"/]
                    </div>
                </div>

                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">角色描述</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="description" name="description"
                               required="true" placeholder="请输入角色描述" value="${role.description}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-6">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-block bg-olive">创建</button>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="col-sm-4">
                            <a href="/role/list" class="btn btn-block btn-danger">返回</a>
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
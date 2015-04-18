[@override name="title"]资源创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            资源管理
            <small>资源创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/permission/list"><i class="fa fa-lock"></i> 资源管理</a></li>
            <li class="active">资源创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/permission/create" method="post">

                [@spring.bind "permission.resource"/]
                <div class="form-group">
                    <label for="resource" class="col-sm-3 control-label">资源名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="resource" name="resource"
                               required="true" placeholder="请输入资源名" value="${permission.resource}">
                        [@spring.showErrors "resource"/]
                    </div>
                </div>

                [@spring.bind "permission.description"/]
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">资源描述</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="description" name="description"
                               required="true" placeholder="请输入资源描述" value="${permission.description}">
                        [@spring.showErrors "description"/]
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
                            <a href="/permission/list" class="btn btn-block btn-danger">返回</a>
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
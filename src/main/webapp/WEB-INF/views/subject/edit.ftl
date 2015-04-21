[@override name="title"]课程编辑[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            课程管理
            <small>课程编辑</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/subject/list"><i class="fa fa-table"></i> 课程管理</a></li>
            <li class="active">课程编辑</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/subject/edit/${subject.id}" method="post">

                [@spring.bind "subject.subjectId"/]
                <div class="form-group">
                    <label for="subjectId" class="col-sm-3 control-label">课程号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="subjectId" name="subjectId"
                               required="true" placeholder="请输入课程号" value="${subject.subjectId}">
                        [@spring.showErrors "subjectId"/]
                    </div>
                </div>

                [@spring.bind "subject.subjectName"/]
                <div class="form-group">
                    <label for="subjectName" class="col-sm-3 control-label">课程名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="subjectName" name="subjectName"
                               required="true" placeholder="请输入课程名" value="${subject.subjectName}">
                        [@spring.showErrors "subjectName"/]
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-3 control-label">备注</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="remark" name="remark"
                               placeholder="请输入备注" value="${subject.remark}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-6">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-block bg-olive">编辑</button>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="col-sm-4">
                            <a href="/subject/list" class="btn btn-block btn-danger">返回</a>
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
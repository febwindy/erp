[@override name="title"]教师选课[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        教师管理
        <small>教师选课</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/teacher/list"><i class="fa fa-users"></i> 教师管理</a></li>
        <li class="active">教师选课</li>
    </ol>
</section>

<section class="container content">
    <div class="row">
        <form class="form-horizontal" action="/teacher/select/${teacher.id}" method="post">

            <div class="form-group">
                <label for="teacherName" class="col-sm-2 control-label">教师姓名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="teacherName" name="teacherName" readonly
                           required="true" placeholder="请输入教师姓名" value="${teacher.teacherName}">
                </div>
            </div>

            <div class="form-group">
                <label for="subjects" class="col-sm-2 control-label">课程列表</label>
                <div id="subjects" class="col-sm-9">
                    [#list subjects as subject]
                        [#assign checked = "" /]
                        [#list teacher.subjects as teacherSubject]
                            [#if subject.id == teacherSubject.id]
                                [#assign checked = "checked" /]
                            [/#if]
                        [/#list]
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="${subject.subjectId}" name="subjects" ${checked}/>${subject.subjectName}
                            </label>
                        </div>
                    [/#list]
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="col-sm-offset-8 col-sm-4">
                        <button type="submit" class="btn btn-md btn-success btn-block">选课</button>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="col-sm-4">
                        <a href="/teacher/list" class="btn btn-md btn-danger btn-block" type="button">返回</a>
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
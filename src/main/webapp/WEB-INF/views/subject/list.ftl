[@override name="title"]课程列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        课程管理
        <small>课程列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/subject/list"><i class="fa fa-table"></i> 课程管理</a></li>
        <li class="active">课程列表</li>
    </ol>
</section>

<section class="content margin-lr-10 thumbnail">
    <div class="row">

        [@mc.showAlert /]

        <form class="form-inline" action="/subject/list" method="post">
            <div class="form-group">
                <div class="col-sm-4">
                    <label for="subjectId">课程号:</label>
                </div>
                <div class="col-sm-8">
                    <input type="text" class="form-control pull-left" id="subjectId" name="subjectId" placeholder="请输入课程号"
                           value="${subject.subjectId}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <label for="subjectName">课程名:</label>
                </div>
                <div class="col-sm-8">
                    <input type="text" class="form-control pull-left" id="subjectName" name="subjectName" placeholder="请输入课程名"
                           value="${subject.subjectName}">
                </div>
            </div>
            <div class="form-group">
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
                <th>课程号</th>
                <th>课程名</th>
                <th>创建日期</th>
                <th>更新日期</th>
                <th>操作</th>
            </tr>
            [#if pagination.data!]
                [#if pagination.data?size > 0]
                    [#list pagination.data as subject]
                        <tr>
                            <td>${subject_index + 1}</td>
                            <td>${subject.subjectId}</td>
                            <td>${subject.subjectName}</td>
                            <td>${subject.createdDate}</td>
                            <td>${subject.updatedDate}</td>
                            <td>
                                <a class="btn btn-success btn-sm" href="/subject/view/${subject.id}">查看</a>
                                <a class="btn btn-info btn-sm" href="/subject/edit/${subject.id}">编辑</a>
                                <a class="btn btn-danger btn-sm" href="/subject/delete/${subject.id}">删除</a>
                            </td>
                        </tr>
                    [/#list]
                [/#if]
            [/#if]
        </table>
    </div>
    [@mc.showPagination '/subject/list' /]
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
[@override name="title"]学生列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        学生管理
        <small>学生列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/student/list"><i class="fa fa-sitemap"></i> 学生管理</a></li>
        <li class="active">学生列表</li>
    </ol>
</section>

<section class="content margin-lr-10 thumbnail">
    <div class="row">

        [@mc.showAlert /]

        <form class="form-inline" action="/student/list" method="post">
            <div class="form-group">
                <div class="col-sm-4">
                    <label for="studentId">学号:</label>
                </div>
                <div class="col-sm-8">
                    <input type="text" class="form-control pull-left" id="studentId" name="studentId" placeholder="请输入学号"
                           value="${student.studentId}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <label for="studentName">学生姓名:</label>
                </div>
                <div class="col-sm-8">
                    <input type="text" class="form-control pull-left" id="studentName" name="studentName" placeholder="请输入学生姓名"
                           value="${student.studentName}">
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
                <th>学号</th>
                <th>学生姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>创建日期</th>
                <th>更新日期</th>
                <th>操作</th>
            </tr>
            [#if pagination.data!]
                [#if pagination.data?size > 0]
                    [#list pagination.data as student]
                        <tr>
                            <td>${student_index + 1}</td>
                            <td>${student.studentId}</td>
                            <td>${student.studentName}</td>
                            <td>[#if student.sex]男[#else]女[/#if]</td>
                            <td>${(student.birthDate)?date}</td>
                            <td>${student.createdDate}</td>
                            <td>${student.updatedDate}</td>
                            <td>
                                <a class="btn btn-success btn-sm" href="/student/view/${student.id}">查看</a>
                                <a class="btn btn-info btn-sm" href="/student/edit/${student.id}">编辑</a>
                                <a class="btn btn-danger btn-sm" href="/student/delete/${student.id}">删除</a>
                            </td>
                        </tr>
                    [/#list]
                [/#if]
            [/#if]
        </table>
    </div>
    [@mc.showPagination '/student/list' /]
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
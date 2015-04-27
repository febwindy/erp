[@override name="title"]教师列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        教师管理
        <small>教师列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/teacher/list"><i class="fa fa-sitemap"></i> 教师管理</a></li>
        <li class="active">教师列表</li>
    </ol>
</section>

<section class="content margin-lr-10 thumbnail">
    <div class="row">

        [@mc.showAlert /]

        <form class="form-inline" action="/teacher/list" method="post">
            <div class="form-group">
                <div class="col-sm-4">
                    <label for="teacherId">教师编号:</label>
                </div>
                <div class="col-sm-8">
                    <input type="text" class="form-control pull-left" id="teacherId" name="teacherId" placeholder="请输入教师编号"
                           value="${teacher.teacherId}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <label for="teacherName">教师姓名:</label>
                </div>
                <div class="col-sm-8">
                    <input type="text" class="form-control pull-left" id="teacherName" name="teacherName" placeholder="请输入教师姓名"
                           value="${teacher.teacherName}">
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
                <th>教师编号</th>
                <th>教师姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>创建日期</th>
                <th>更新日期</th>
                <th>操作</th>
            </tr>
            [#if pagination.data!]
                [#if pagination.data?size > 0]
                    [#list pagination.data as teacher]
                        <tr>
                            <td>${teacher_index + 1}</td>
                            <td>${teacher.teacherId}</td>
                            <td>${teacher.teacherName}</td>
                            <td>[#if teacher.sex]男[#else]女[/#if]</td>
                            <td>${(teacher.birthDate)?date}</td>
                            <td>${teacher.createdDate}</td>
                            <td>${teacher.updatedDate}</td>
                            <td>
                                <a class="btn btn-success btn-sm" href="/teacher/view/${teacher.id}">查看</a>
                                <a class="btn btn-info btn-sm" href="/teacher/edit/${teacher.id}">编辑</a>
                                <a class="btn btn-info btn-sm" href="/teacher/select/${teacher.id}">选课</a>
                                <a class="btn btn-danger btn-sm" href="/teacher/delete/${teacher.id}">删除</a>
                            </td>
                        </tr>
                    [/#list]
                [/#if]
            [/#if]
        </table>
    </div>
    [@mc.showPagination '/teacher/list' /]
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
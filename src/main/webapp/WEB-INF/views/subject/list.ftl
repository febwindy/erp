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
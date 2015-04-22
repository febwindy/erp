[@override name="title"]教师创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            教师管理
            <small>教师创建</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/teacher/list"><i class="fa fa-sitemap"></i> 教师管理</a></li>
            <li class="active">教师创建</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/teacher/create" method="post">

                [@spring.bind "teacher.teacherId"/]
                <div class="form-group">
                    <label for="teacherId" class="col-sm-3 control-label">教师编号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="teacherId" name="teacherId"
                               required="true" placeholder="请输入教师编号" value="${teacher.teacherId}">
                        [@spring.showErrors "teacherId"/]
                    </div>
                </div>

                [@spring.bind "teacher.teacherName"/]
                <div class="form-group">
                    <label for="teacherName" class="col-sm-3 control-label">教师姓名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="teacherName" name="teacherName"
                               required="true" placeholder="请输入教师姓名" value="${teacher.teacherName}">
                        [@spring.showErrors "teacherName"/]
                    </div>
                </div>

                [@spring.bind "teacher.sex"/]
                <div class="form-group">
                    <label for="sex" class="col-sm-3 control-label">性别</label>
                    <div class="col-sm-9">
                        <select name="sex" class="form-control" placeholder="性别" required="true">
                            [#assign status=(teacher.sex)?default("")/]
                            <option value="">请选择</option>
                            <option value="0" [@mc.selected status "0" /]>女</option>
                            <option value="1" [@mc.selected status "1" /]>男</option>
                        </select>
                        [@spring.showErrors "sex"/]
                    </div>
                </div>

                [@spring.bind "teacher.birthDate"/]
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">出生日期</label>
                    <div class="col-sm-9">
                        <input type="date" class="form-control" id="birthDate" name="birthDate"
                               required="true" placeholder="请输入学生名" value="${teacher.birthDate}">
                        [@spring.showErrors "birthDate"/]
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-3 control-label">备注</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="remark" name="remark"
                               placeholder="请输入备注" value="${teacher.remark}">
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
                            <a href="/teacher/list" class="btn btn-block btn-danger">返回</a>
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
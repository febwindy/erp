[@override name="title"]学生编辑[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            学生管理
            <small>学生编辑</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/student/list"><i class="fa fa-sitemap"></i> 学生管理</a></li>
            <li class="active">学生编辑</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/student/edit/${student.id}" method="post">

                [@spring.bind "student.studentId"/]
                <div class="form-group">
                    <label for="studentId" class="col-sm-3 control-label">学号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="studentId" name="studentId"
                               required="true" placeholder="请输入学号" value="${student.studentId}">
                        [@spring.showErrors "studentId"/]
                    </div>
                </div>

                [@spring.bind "student.studentName"/]
                <div class="form-group">
                    <label for="studentName" class="col-sm-3 control-label">学生姓名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="studentName" name="studentName"
                               required="true" placeholder="请输入学生名" value="${student.studentName}">
                        [@spring.showErrors "studentName"/]
                    </div>
                </div>

                [@spring.bind "student.sex"/]
                <div class="form-group">
                    <label for="sex" class="col-sm-3 control-label">性别</label>
                    <div class="col-sm-9">
                        <select name="sex" class="form-control" placeholder="性别" required="true">
                            [#assign status=(student.sex)?default("")/]
                            <option value="">请选择</option>
                            <option value="0" [@mc.selected status false /]>女</option>
                            <option value="1" [@mc.selected status true /]>男</option>
                        </select>
                        [@spring.showErrors "sex"/]
                    </div>
                </div>

                [@spring.bind "student.birthDate"/]
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">出生日期</label>
                    <div class="col-sm-9">
                        <input type="date" class="form-control" id="birthDate" name="birthDate"
                               required="true" placeholder="请输入学生名" value="${student.birthDate?date}">
                        [@spring.showErrors "birthDate"/]
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-3 control-label">备注</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="remark" name="remark"
                               placeholder="请输入备注" value="${student.remark}">
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
                            <a href="/student/list" class="btn btn-block btn-danger">返回</a>
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
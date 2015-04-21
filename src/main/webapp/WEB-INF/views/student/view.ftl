[@override name="title"]学生查看[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            学生管理
            <small>学生查看</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/student/list"><i class="fa fa-sitemap"></i> 学生管理</a></li>
            <li class="active">学生查看</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <div role="form" class="form-horizontal">

                <div class="form-group">
                    <label for="studentId" class="col-sm-3 control-label">学号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="studentId" name="studentId" disabled
                               required="true" placeholder="请输入学号" value="${student.studentId}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="studentName" class="col-sm-3 control-label">学生姓名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="studentName" name="studentName" disabled
                               required="true" placeholder="请输入学生名" value="${student.studentName}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="sex" class="col-sm-3 control-label">性别</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="sex" name="sex" disabled
                               required="true" placeholder="请输入性别" value="[#if student.sex]男[#else]女[/#if]">
                    </div>
                </div>

                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">出生日期</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="birthDate" name="birthDate" disabled
                               required="true" placeholder="请输入学生名" value="${student.birthDate?date}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="createdDate" class="col-sm-3 control-label">创建日期</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="createdDate" name="createdDate" disabled
                               placeholder="请输入创建日期" value="${student.createdDate}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="updatedDate" class="col-sm-3 control-label">更新日期</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="updatedDate" name="updatedDate" disabled
                               placeholder="请输入更新日期" value="${student.createdDate}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="operator" class="col-sm-3 control-label">操作人</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="operator" name="operator"
                               required="true" placeholder="请输入操作人" readonly value="${(student.operator.username)!}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-3 control-label">备注</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="remark" name="remark" disabled
                               placeholder="请输入备注" value="${student.remark}">
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
                            <a href="/student/list" class="btn btn-block btn-danger">返回</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
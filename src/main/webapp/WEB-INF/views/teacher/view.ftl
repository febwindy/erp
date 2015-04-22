[@override name="title"]教师查看[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            教师管理
            <small>教师查看</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/teacher/list"><i class="fa fa-sitemap"></i> 教师管理</a></li>
            <li class="active">教师查看</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <div role="form" class="form-horizontal">

                <div class="form-group">
                    <label for="teacherId" class="col-sm-3 control-label">教师编号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="teacherId" name="teacherId" disabled
                               required="true" placeholder="请输入教师编号" value="${teacher.teacherId}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="teacherName" class="col-sm-3 control-label">教师姓名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="teacherName" name="teacherName" disabled
                               required="true" placeholder="请输入教师姓名" value="${teacher.teacherName}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="sex" class="col-sm-3 control-label">性别</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="sex" name="sex" disabled
                               required="true" placeholder="请输入性别" value="[#if teacher.sex]男[#else]女[/#if]">
                    </div>
                </div>

                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">出生日期</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="birthDate" name="birthDate" disabled
                               required="true" placeholder="请输入学生名" value="${teacher.birthDate?date}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="createdDate" class="col-sm-3 control-label">创建日期</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="createdDate" name="createdDate" disabled
                               placeholder="请输入创建日期" value="${teacher.createdDate}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="updatedDate" class="col-sm-3 control-label">更新日期</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="updatedDate" name="updatedDate" disabled
                               placeholder="请输入更新日期" value="${teacher.createdDate}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="operator" class="col-sm-3 control-label">操作人</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="operator" name="operator"
                               required="true" placeholder="请输入操作人" readonly value="${(teacher.operator.username)!}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-3 control-label">备注</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="remark" name="remark" disabled
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
            </div>
        </div>
    </section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
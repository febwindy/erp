[@override name="title"]课程查看[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        课程管理
        <small>课程详情</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/subject/list"><i class="fa fa-table"></i> 课程管理</a></li>
        <li class="active">课程详情</li>
    </ol>
</section>

<section class="container content">
    <div class="row">
        <div role="form" class="form-horizontal">

            <div class="form-group">
                <label for="subjectId" class="col-sm-3 control-label">课程号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="subjectId" name="subjectId"
                           required="true" placeholder="请输入课程号" readonly value="${subject.subjectId}">
                </div>
            </div>

            <div class="form-group">
                <label for="subjectName" class="col-sm-3 control-label">课程名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="subjectName" name="subjectName"
                           required="true" placeholder="请输入课程名" readonly value="${subject.subjectName}">
                </div>
            </div>

            <div class="form-group">
                <label for="createdDate" class="col-sm-3 control-label">创建日期</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="createdDate" name="createdDate"
                           required="true" placeholder="请输入创建日期" readonly value="${subject.createdDate}">
                </div>
            </div>

            <div class="form-group">
                <label for="updatedDate" class="col-sm-3 control-label">更新日期</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="updatedDate" name="updatedDate"
                           required="true" placeholder="请输入更新日期" readonly value="${subject.updatedDate}">
                </div>
            </div>

            <div class="form-group">
                <label for="operator" class="col-sm-3 control-label">操作人</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="operator" name="operator"
                           required="true" placeholder="请输入操作人" readonly value="${(subject.operator.username)!}">
                </div>
            </div>

            <div class="form-group">
                <label for="remark" class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="remark" name="remark"
                           required="true" placeholder="请输入备注" readonly value="${subject.remark}">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="col-sm-offset-8 col-sm-4">
                        <a href="/subject/list" class="btn btn-block btn-danger" type="button">返回</a>
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
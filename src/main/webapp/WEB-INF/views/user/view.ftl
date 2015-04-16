[@override name="title"]用户创建[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        用户管理
        <small>用户详情</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/user/list"><i class="fa fa-user"></i> 用户管理</a></li>
        <li class="active">用户详情</li>
    </ol>
</section>

<section class="container content">
    <div class="row">
        <div role="form">
            <div class="form-group">
                <lable for="realName">真实姓名:</lable>
                <input type="text" id="realName" name="realName" class="form-control" placeholder="真实姓名" readonly
                       value="${user.realName}"/>
            </div>

            <div class="form-group">
                <lable for="realName">用户名:</lable>
                <input type="text" name="username" class="form-control" placeholder="用户名" readonly
                       value="${user.username}"/>
            </div>

            <div class="form-group">
                <lable for="realName">性别:</lable>
                <input type="text" name="sex" class="form-control" placeholder="性别" readonly
                       value="[#if user.sex]男[#else]女[/#if]"/>
            </div>

            <div class="form-group">
                <lable for="realName">邮箱:</lable>
                <input type="email" name="email" class="form-control" placeholder="邮件" readonly
                       value="${user.email}"/>
            </div>

            <div class="form-group">
                <lable for="realName">手机号码:</lable>
                <input type="tel" name="telephone" class="form-control" placeholder="电话" readonly
                       value="${user.telephone}"/>
            </div>

            [@spring.bind "user.idCard"/]
            <div class="form-group">
                <lable for="realName">身份证:</lable>
                <input type="text" name="idCard" class="form-control" placeholder="身份证" readonly
                       value="${user.idCard}"/>
            </div>

            <div class="form-group">
                <lable for="realName">部门:</lable>
                <input type="text" name="organization" class="form-control" placeholder="部门" readonly
                       value="${user.organization}"/>
            </div>

            <div class="form-group">
                <lable for="realName">备注:</lable>
                <input type="text" name="remark" class="form-control" placeholder="备注" value="${user.remark}"/>
            </div>

            <div class="footer pull-right">
                <a href="/user/create" class="btn bg-olive">创建</a>
                <a href="/user/list" class="btn btn-danger">返回</a>
            </div>
        </form>
    </div>
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
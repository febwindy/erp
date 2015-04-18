[@override name="title"]用户详情[/@override]

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
        <div role="form" class="form-horizontal">

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">真实姓名:</label>
                <div class="col-sm-9">
                    <input type="text" id="realName" name="realName" class="form-control" placeholder="真实姓名" readonly
                           value="${user.realName}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名:</label>
                <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" placeholder="用户名" readonly
                           value="${user.username}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">性别:</label>
                <div class="col-sm-9">
                    <input type="text" name="sex" class="form-control" placeholder="性别" readonly
                           value="[#if user.sex]男[#else]女[/#if]"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">邮箱:</label>
                <div class="col-sm-9">
                    <input type="email" name="email" class="form-control" placeholder="邮件" readonly
                           value="${user.email}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">手机号码:</label>
                <div class="col-sm-9">
                    <input type="tel" name="telephone" class="form-control" placeholder="电话" readonly
                           value="${user.telephone}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">身份证:</label>
                <div class="col-sm-9">
                    <input type="text" name="idCard" class="form-control" placeholder="身份证" readonly
                           value="${user.idCard}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">部门:</label>
                <div class="col-sm-9">
                    <input type="text" name="organization" class="form-control" placeholder="部门" readonly
                           value="${user.organization}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">备注:</label>
                <div class="col-sm-9">
                    <input type="text" name="remark" class="form-control" placeholder="备注" value="${user.remark}"/>
                </div>
            </div>

            [#if user.roles?size > 0]
                <div class="form-group">
                    <label for="roles" class="col-sm-2 control-label">角色列表</label>
                    <div class="col-sm-9" id="roles">
                        [#list user.roles as role]
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="${role.id}" name="roles" checked/>
                                    ${role.role} - ${role.description}
                                </label>
                            </div>
                        [/#list]
                    </div>
                </div>
            [/#if]

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="col-sm-offset-8 col-sm-4">
                        <a href="/user/create" class="btn btn-block bg-olive">创建</a>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="col-sm-4">
                        <a href="/user/list" class="btn btn-block btn-danger">返回</a>
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
[@override name="title"]用户编辑[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            用户管理
            <small>用户编辑</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/user/list"><i class="fa fa-user"></i> 用户管理</a></li>
            <li class="active">用户编辑</li>
        </ol>
    </section>

    <section class="container content">
        <div class="row">
            <form role="form" class="form-horizontal" action="/user/edit/${user.id}" method="post">

                [@spring.bind "user.realName"/]
                <div class="form-group">
                    <label for="realName" class="col-sm-2 control-label">真实姓名:</label>
                    <div class="col-sm-9">
                        <input type="text" name="realName" class="form-control" placeholder="真实姓名" required="true"
                               value="${user.realName}"/>
                        [@spring.showErrors "realName"/]
                    </div>
                </div>

                [@spring.bind "user.username"/]
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名:</label>
                    <div class="col-sm-9">
                        <input type="text" name="username" class="form-control" placeholder="用户名" required="true"
                               value="${user.username}"/>
                        [@spring.showErrors "username"/]
                    </div>
                </div>

                [@spring.bind "user.password"/]
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码:</label>
                    <div class="col-sm-9">
                        <input type="password" name="password" class="form-control" placeholder="密码" value=""/>
                        [@spring.showErrors "password"/]
                    </div>
                </div>

                [@spring.bind "user.confirmPassword"/]
                <div class="form-group">
                    <label for="confirmPassword" class="col-sm-2 control-label">重复密码:</label>
                    <div class="col-sm-9">
                        <input type="password" name="confirmPassword" class="form-control" placeholder="重复密码"
                               value=""/>
                        [@spring.showErrors "confirmPassword"/]
                    </div>
                </div>

                [@spring.bind "user.sex"/]
                <div class="form-group">
                    <label for="sex" class="col-sm-2 control-label">性别:</label>
                    <div class="col-sm-9">
                        <select name="sex" class="form-control" placeholder="性别" required="true">
                            [#assign status=(user.sex)?default("")/]
                            <option value="">请选择</option>
                            <option value="0" [@mc.selected status "0" /]>女</option>
                            <option value="1" [@mc.selected status "1" /]>男</option>
                        </select>
                        [@spring.showErrors "sex"/]
                    </div>
                </div>

                [@spring.bind "user.email"/]
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮件:</label>
                    <div class="col-sm-9">
                        <input type="email" name="email" class="form-control" placeholder="邮件" required="true"
                               value="${user.email}"/>
                        [@spring.showErrors "email"/]
                    </div>
                </div>

                [@spring.bind "user.telephone"/]
                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">电话:</label>
                    <div class="col-sm-9">
                        <input type="tel" name="telephone" class="form-control" placeholder="电话" required="true"
                               value="${user.telephone}"/>
                        [@spring.showErrors "telephone"/]
                    </div>
                </div>

                [@spring.bind "user.idCard"/]
                <div class="form-group">
                    <label for="idCard" class="col-sm-2 control-label">身份证:</label>
                    <div class="col-sm-9">
                        <input type="text" name="idCard" class="form-control" placeholder="身份证" required="true"
                               value="${user.idCard}"/>
                        [@spring.showErrors "idCard"/]
                    </div>
                </div>

                [@spring.bind "user.organization"/]
                <div class="form-group">
                    <label for="organization" class="col-sm-2 control-label">部门:</label>
                    <div class="col-sm-9">
                        <input type="text" name="organization" class="form-control" placeholder="部门" required="true"
                               value="${user.organization}"/>
                        [@spring.showErrors "organization"/]
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注:</label>
                    <div class="col-sm-9">
                        <input type="text" name="remark" class="form-control" placeholder="备注" value="${user.remark}"/>
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
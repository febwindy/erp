<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>注册</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        [@block name="topResources"]
            <!-- bootstrap 3.0.2 -->
            <link href="[@spring.url '/resources/css/bootstrap.min.css'/]" rel="stylesheet" type="text/css" />
            <!-- font Awesome -->
            <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet" type="text/css" />
            <!-- Theme style -->
            <link href="[@spring.url '/resources/css/AdminLTE.css'/]" rel="stylesheet" type="text/css" />

            <!-- self style -->
            <link href="[@spring.url '/resources/css/self/commons.css'/]" rel="stylesheet" type="text/css"/>

            <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
            <![endif]-->
        [/@block]
    </head>

    <body class="bg-black">
        [@block name="content"]
            <div class="form-box" id="login-box">
                <div class="header">注册新用户</div>
                <form action="/register" method="post">
                    <div class="body bg-gray">

                        <div class="error-message" style="color: #ff0000;">${message}</div>

                        [@spring.bind "user.realName"/]
                        <div class="form-group">
                            <input type="text" name="realName" class="form-control" placeholder="真实姓名" required="true"
                                    value="${user.realName}"/>
                            [@spring.showErrors "realName"/]
                        </div>

                        [@spring.bind "user.username"/]
                        <div class="form-group">
                            <input type="text" name="username" class="form-control" placeholder="用户名" required="true"
                                   value="${user.username}"/>
                            [@spring.showErrors "username"/]
                        </div>

                        [@spring.bind "user.password"/]
                        <div class="form-group">
                            <input type="password" name="password" class="form-control" placeholder="密码" required="true"
                                   value="${user.password}"/>
                            [@spring.showErrors "password"/]
                        </div>

                        [@spring.bind "user.confirmPassword"/]
                        <div class="form-group">
                            <input type="password" name="confirmPassword" class="form-control" placeholder="重复密码" required="true"
                                   value="${user.confirmPassword}"/>
                            [@spring.showErrors "confirmPassword"/]
                        </div>

                        [@spring.bind "user.sex"/]
                        <div class="form-group">
                            <select name="sex" class="form-control" placeholder="性别" required="true">
                                <option value="">请选择</option>
                                <option value="0">女</option>
                                <option value="1">男</option>
                            </select>
                            [@spring.showErrors "sex"/]
                        </div>

                        [@spring.bind "user.email"/]
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" placeholder="邮件" required="true"
                                   value="${user.email}"/>
                            [@spring.showErrors "email"/]
                        </div>

                        [@spring.bind "user.telephone"/]
                        <div class="form-group">
                            <input type="tel" name="telephone" class="form-control" placeholder="电话" required="true"
                                   value="${user.telephone}"/>
                            [@spring.showErrors "telephone"/]
                        </div>

                        [@spring.bind "user.idCard"/]
                        <div class="form-group">
                            <input type="text" name="idCard" class="form-control" placeholder="身份证" required="true"
                                   value="${user.idCard}"/>
                            [@spring.showErrors "idCard"/]
                        </div>

                        [@spring.bind "user.organization"/]
                        <div class="form-group">
                            <input type="text" name="organization" class="form-control" placeholder="部门" required="true"
                                   value="${user.organization}"/>
                            [@spring.showErrors "organization"/]
                        </div>

                        <div class="form-group">
                            <input type="text" name="remark" class="form-control" placeholder="备注" value="${user.remark}"/>
                        </div>
                    </div>
                    <div class="footer">

                        <button type="submit" class="btn bg-olive btn-block">注册</button>

                        <a href="/" class="text-center">已拥有账户</a>
                    </div>
                </form>

                <div class="margin text-center">
                    <span>ERP管理系统</span>
                    <br/>
                </div>
            </div>
        [/@block]

        [@block name="bottomResources"]
            <!-- jQuery 2.0.2 -->
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <!-- Bootstrap -->
            <script src="[@spring.url '/resources/js/bootstrap.min.js" type="text/javascript'/]"></script>
            <!-- self js -->
            <script src="[@spring.url '/resources/js/commons.js'/]" type="text/javascript"></script>
        [/@block]
    </body>
</html>
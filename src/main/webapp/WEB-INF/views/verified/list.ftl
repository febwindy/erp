[@override name="title"]用户审核列表[/@override]

[@override name="topResources"]
    [@super /]
[/@override]

[@override name="content"]
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        用户审核
        <small>用户审核列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="/user/verified/list"><i class="fa fa-user"></i> 用户审核</a></li>
        <li class="active">用户审核列表</li>
    </ol>
</section>

<section class="content margin-lr-10 thumbnail">
    <div class="row">

        [@mc.showAlert /]

        <table class="table table-hover">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>真实姓名</th>
                <th>性别</th>
                <th>邮箱</th>
                <th>手机号码</th>
                <th>身份证号</th>
                <th>组织</th>
                <th>操作</th>
            </tr>
            [#if pagination.data!]
                [#if pagination.data?size > 0]
                    [#list pagination.data as user]
                        <tr>
                            <th scope="row">${list.index + 1}</th>
                            <td>${user.username}</td>
                            <td>${user.realName}</td>
                            <td>
                                [#if user.sex]男[#else]女[/#if]
                            </td>
                            <td>${user.email}</td>
                            <td>${user.telephone}</td>
                            <td>${user.idCard}</td>
                            <td>${user.organization}</td>
                            <td>
                                <a class="btn btn-primary btn-sm" href="/user/verified/ok/${user.id}">激活</a>
                            </td>
                        </tr>
                    [/#list]
                [/#if]
            [/#if]
        </table>
    </div>
    [@mc.showPagination '/user/list' /]
</section>
[/@override]

[@override name="bottomResources"]
    [@super /]
[/@override]
[@extends name="/decorator.ftl"/]
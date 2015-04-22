<!-- Left side column. contains the logo and sidebar -->
<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left info">
                <p>您好, <@security.authentication property='name'/></p>

                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <@security.authorize access="hasAnyRole('administrator')">
            <ul class="sidebar-menu">
                <li class="active">
                    <a href="/index">
                        <i class="fa fa-dashboard"></i> <span>公告</span>
                    </a>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-user"></i>
                        <span>用户管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/user/list"><i class="fa fa-angle-double-right"></i> 用户列表</a></li>
                        <li><a href="/user/create"><i class="fa fa-angle-double-right"></i> 用户创建</a></li>
                        <li><a href="/user/verified/list"><i class="fa fa-angle-double-right"></i> 用户审核</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-users"></i>
                        <span>角色管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/role/list"><i class="fa fa-angle-double-right"></i> 角色列表</a></li>
                        <li><a href="/role/create"><i class="fa fa-angle-double-right"></i> 角色创建</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-lock"></i>
                        <span>资源管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/permission/list"><i class="fa fa-angle-double-right"></i> 资源列表</a></li>
                        <li><a href="/permission/create"><i class="fa fa-angle-double-right"></i> 资源创建</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-sitemap"></i>
                        <span>学生管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/student/list"><i class="fa fa-angle-double-right"></i> 学生列表</a></li>
                        <li><a href="/student/create"><i class="fa fa-angle-double-right"></i> 学生创建</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-sitemap"></i>
                        <span>教师管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/teacher/list"><i class="fa fa-angle-double-right"></i> 教师列表</a></li>
                        <li><a href="/teacher/create"><i class="fa fa-angle-double-right"></i> 教师创建</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-table"></i>
                        <span>课程管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/subject/list"><i class="fa fa-angle-double-right"></i> 课程列表</a></li>
                        <li><a href="/subject/create"><i class="fa fa-angle-double-right"></i> 课程创建</a></li>
                    </ul>
                </li>
            </ul>
        </@security.authorize>
    </section>
    <!-- /.sidebar -->
</aside>
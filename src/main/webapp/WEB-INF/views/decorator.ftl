[#--[#assign shiro = JspTaglibs["/WEB-INF/shiro.tld"]]--]
<!DOCTYPE html>
<!--
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
-->
<html lang="zh_cn">
<head>
    [@block name="Meta"]
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <meta name="description" content=""/>
        <meta name="author" content="EthanTu"/>
    [/@block]
    <title>ERP-[@block name="title"][/@block]</title>
    <link rel="shortcut icon" href="[@spring.url '/resources/images/favicon.ico' /]" type="image/x-icon"/>
    [@block name="topResources"]
        <!-- bootstrap 3.0.2 -->
        <link href="[@spring.url '/resources/css/bootstrap.min.css'/]" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="[@spring.url '/resources/css/ionicons.min.css'/]" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="[@spring.url '/resources/css/morris/morris.css'/]" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="[@spring.url '/resources/css/jvectormap/jquery-jvectormap-1.2.2.css'/]" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <link href="[@spring.url '/resources/css/fullcalendar/fullcalendar.css'/]" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="[@spring.url '/resources/css/daterangepicker/daterangepicker-bs3.css'/]" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="[@spring.url '/resources/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css'/]" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="[@spring.url '/resources/css/AdminLTE.css'/]" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    [/@block]
</head>

[@block name="specialBody"]
    <body class="skin-blue">
[/@block]

        [@block name="header"]
            [#include "/shared/header.ftl" /]
        [/@block]

        <div class="wrapper row-offcanvas row-offcanvas-left">
            [@block name="sidebar"]
                [#include "/shared/sidebar.ftl" /]
            [/@block]

            [@block name="content"]

            [/@block]
        </div>

        [@block name="bottomResources"]

            <!-- jQuery 2.0.2 -->
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <!-- jQuery UI 1.10.3 -->
            <script src="[@spring.url '/resources/js/jquery-ui-1.10.3.min.js'/]" type="text/javascript"></script>
            <!-- Bootstrap -->
            <script src="[@spring.url '/resources/js/bootstrap.min.js'/]" type="text/javascript"></script>
            <!-- Morris.js charts -->
            <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
            <script src="[@spring.url '/resources/js/plugins/morris/morris.min.js'/]" type="text/javascript"></script>
            <!-- Sparkline -->
            <script src="[@spring.url '/resources/js/plugins/sparkline/jquery.sparkline.min.js'/]" type="text/javascript"></script>
            <!-- jvectormap -->
            <script src="[@spring.url '/resources/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/]" type="text/javascript"></script>
            <script src="[@spring.url '/resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/]" type="text/javascript"></script>
            <!-- fullCalendar -->
            <script src="[@spring.url '/resources/js/plugins/fullcalendar/fullcalendar.min.js'/]" type="text/javascript"></script>
            <!-- jQuery Knob Chart -->
            <script src="[@spring.url '/resources/js/plugins/jqueryKnob/jquery.knob.js'/]" type="text/javascript"></script>
            <!-- daterangepicker -->
            <script src="[@spring.url '/resources/js/plugins/daterangepicker/daterangepicker.js'/]" type="text/javascript"></script>
            <!-- Bootstrap WYSIHTML5 -->
            <script src="[@spring.url '/resources/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js'/]" type="text/javascript"></script>
            <!-- iCheck -->
            <script src="[@spring.url '/resources/js/plugins/iCheck/icheck.min.js'/]" type="text/javascript"></script>

            <!-- AdminLTE App -->
            <script src="[@spring.url '/resources/js/AdminLTE/app.js'/]" type="text/javascript"></script>

            <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
            <script src="[@spring.url '/resources/js/AdminLTE/dashboard.js'/]" type="text/javascript"></script>

        [/@block]
    </body>
</html>
[#-- 显示提示消息 --]
[#macro showAlert]
    [#if alertMessage?? && (alertMessage.type)??]
        <div class="alert alert-info alert-dismissible fade in list-alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>

            <strong>${alertMessage.type.getName()}!</strong>${alertMessage.message}.

            <script type="text/javascript">
                window.onload = function() {
                    setTimeout(function(){
                        $(".list-alert").alert('close');
                    }, 5000);
                }
            </script>
        </div>
    [/#if]
[/#macro]

[#-- 显示区域--]
[#macro showCascade param]
    [#assign content = param.name /]
    [#if param.parent??]
        ${content}
        [@showCascade param.parent /]
    [#else]
        ${content}
    [/#if]
[/#macro]

[#--用于表单元素是否选中的判断--]
[#macro selected src target]
    [#if src == target]
        selected="selected"
    [/#if]
[/#macro]

[#--//TODO with parameters--]
[#macro showPagination path]
<div class="pagination-nice-scroll row panel-footer">
    <section>
    [#local totalPage = (pagination.count / pagination.pageSize)?ceiling]

    [#if path?contains("?")]
        [#local basePath = path + '&pageSize=' + pagination.pageSize + '&page=']
    [#else]
        [#local basePath = path + '?pageSize=' + pagination.pageSize + '&page=']
    [/#if]

    [#if pagination.data?size > 0]
    <div class="col-sm-5">
        <div class="dataTables_info">总计 ${pagination.count} 条数据, 每页显示${pagination.pageSize}条,总计 ${totalPage}页</div>
    </div>
    <div class="col-sm-7">
            <ul class="pagination pagination-custom pull-right">
                [#if pagination.page - 1 <= 0]
                    <li class="disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
                [#else]
                    <li><a href="[@spring.url basePath + (pagination.page - 1)/]"><i class="fa fa-angle-double-left"></i></a></li>
                [/#if]

                [#list 1..totalPage as index]
                    [#if totalPage < 11]
                        [#if pagination.page == index]
                            <li class="active"><a href="#">${index}</a></li>
                        [#else]
                            <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                        [/#if]
                    [#else]
                        [#if (index > (pagination.page - 5)) && (index < (pagination.page + 4))]
                            [#if pagination.page == index]
                                <li class="active"><a href="#">${index}</a></li>
                            [#else]
                                <li><a href="[@spring.url basePath + index/]">${index}</a></li>
                            [/#if]
                        [/#if]
                    [/#if]
                [/#list]

                [#if pagination.page == totalPage]
                    <li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
                [#else]
                    <li><a href="[@spring.url basePath + (pagination.page + 1)/]"><i class="fa fa-angle-double-right"></i></a></li>
                [/#if]
            </ul>
    </div>
    [#else]
    <div class="col-md-2 col-md-offset-5">
        <Strong>没有查询到数据</Strong>
    </div>
    [/#if]
</div>
[/#macro]
[#macro verificationCode id="verificationCode"]
<img id="${id}" src="[@spring.url '/verificationCode'/]" title="点击可切换" class="verificationCode"/>
<script type="text/javascript">
        $(function(){
            $("#${id}").on('click', function(e){
                var act = "[@spring.url '/verificationCode'/]";
                $(this).attr("src",act+"?"+new Date().getTime());
            }).mouseover(function(){
                $(this).css("cursor","pointer");
            });
        });
</script>
[/#macro]
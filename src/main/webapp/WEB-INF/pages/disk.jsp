<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23 0023
  Time: 21:28
  To change this template use FileMode | Settings | FileMode Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公共文件查询</title>
    <base href="<%=basePath%>">
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
</head>
<body>
<%@include file="layout/nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8">

        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="btn-group" id="toobar" role="group" aria-label="...">
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-star"></span>新增
                </button>
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-edit"></span>修改
                </button>
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-remove"></span>删除
                </button>
                <button type="button" class="btn btn-default ">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
                </button>
            </div>
            <table id="myTable"></table>
        </div>
    </div>
</div>
<script>
    var urlbase = "${url}";
    $(function () {
        var itable = TableInit();
        itable.Init();
    });
    function genderFormatter(value) {
        return "<a href='" + urlbase + "/down/" + value + "'><span class='glyphicon glyphicon-download'></span></a>";
    }
    function setPulic(value, row) {
//        var tem = value == 0 ? "否" : "是";
        return (value == 0 ? "否" : "是")
        "<a href='" + urlbase + "/change/" + row.id + "'><span class='glyphicon glyphicon-pencil'></span></a>";
    }
    var TableInit = function () {
        var myTableInit = new Object();
//        function queryParams(params) {
//            return {
//                limit:params.limit,//每页数据条数
//                offset:params.offset,//当前页偏移
//                order:params.order,//排序
//                sort:params.sort,//需要排序的字段
//                search:params.search//搜索的字段
//            };
//        }
        myTableInit.Init = function () {
            $("#myTable").bootstrapTable({
                url: urlbase + "/list",
                method: 'post',
                toolbar: '#toobar',//工具列
                striped: true,//隔行换色
                cache: false,//禁用缓存
                pagination: true,//启动分页
                sidePagination: 'server',//分页方式
                pageNumber: 1,//初始化table时显示的页码
                pageSize: 10,//每页条目
                showFooter: false,//是否显示列脚
                showPaginationSwitch: true,//是否显示 数据条数选择框
                sortable: true,//排序
                search: true,//启用搜索
                showColumns: true,//是否显示 内容列下拉框
                showRefresh: true,//显示刷新按钮
                idField: 'fileName',//key值栏位
                clickToSelect: true,//点击选中checkbox
                singleSelect: true,//启用单行选中
//                queryParams: queryParams,//传递参数（*）
                height: 545,
                columns: [
                    {
                        field: 'fileName',
                        title: '文件名',
                        titleTooltip: ''
                    },
                    {
                        field: 'fileType',
                        title: '文件类型'
                    },
                    {
                        field: 'fileSize',
                        title: '文件大小',
                        sortable: true,
                        editable: true
                    },
                    {
                        field: 'username',
                        title: '上传人'
                    },
                    {
                        field: 'uploadTime',
                        title: '更新时间'
                    }, {
                        field: 'isPublic',
                        title: '是否公共',
                        formatter: setPulic
                    }, {
                        field: 'id',
                        title: "链接",
                        formatter: genderFormatter
                    }],
//                onClickCell: function (field, value, row, $element) {
//                    alert(row);
//                }
            });
        };

        return myTableInit;
    };
</script>
</body>
</html>

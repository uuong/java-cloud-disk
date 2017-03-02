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
    <style type="text/css">
        #queryDiv {
            margin-right: auto;
            margin-left: auto;
            width: 600px;
        }

        #textInput {
            margin-top: 10px;
        }

        #tableResult {
            margin-right: auto;
            margin-left: auto;
            width: 600px;
        }

        td {
            width: 250px
        }

        tr {
            height: 30px
        }
    </style>
</head>
<body>
<div id="queryDiv">
    <input id="textInput" type="text" placeholder="请输文件名">
    <button id="queryButton" class="btn btn-primary" type="button">查询</button>
</div>
<form id="form1">
    <table class="table table-bordered" id='tableResult'>
        <caption>查询文件结果</caption>
        <thead>
        <tr>
            <th>文件名</th>
            <th>用户名</th>
            <th>文件大小</th>
            <th>上传时间</th>
        </tr>
        </thead>
        <tbody id="tableBody">
        </tbody>
    </table>
    <!-- 底部分页按钮 -->
    <div id="bottomTab"></div>
</form>
<form action="disk/upload" method="post" enctype="multipart/form-data">
    文件名：<input type="text" name="name"/><br/>
    <input type="file" name="file"/><br/>
    <input type="text" name="pid" placeholder="pid"/>
    <input type="submit"/>
</form>
<script type='text/javascript'>
    var PAGESIZE = 10;
    var options = {
        currentPage: 1,  //当前页数
        totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
        size: "normal",
        alignment: "center",
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "第一页";
                case "prev":
                    return "前一页";
                case "next":
                    return "后一页";
                case "last":
                    return "最后页";
                case "page":
                    return page;
            }
        },
        onPageClicked: function (e, originalEvent, type, page) {
            var fileName = $("#textInput").val(); //取内容
            buildTable(fileName, page, PAGESIZE);//默认每页最多10条
        }
    }


    //生成表格
    function buildTable(fileName, pageNumber, pageSize) {
        var url = "open/list"; //请求的网址
        var reqParams = {'fileName': fileName, 'pageNumber': pageNumber, 'pageSize': pageSize};//请求数据
        $(function () {
            $.ajax({
                type: "POST",
                url: url,
                data: reqParams,
                async: false,
                dataType: "json",
                success: function (data) {

                    // options.totalPages = data.pages;
                    var newoptions = {
                        currentPage: 1,  //当前页数
                        totalPages: data.pages == 0 ? 1 : data.pages,  //总页数
                        size: "normal",
                        alignment: "center",
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "第一页";
                                case "prev":
                                    return "前一页";
                                case "next":
                                    return "后一页";
                                case "last":
                                    return "最后页";
                                case "page":
                                    return page;
                            }
                        },
                        onPageClicked: function (e, originalEvent, type, page) {
                            var fileName = $("#textInput").val(); //取内容
                            buildTable(fileName, page, PAGESIZE);//默认每页最多10条
                        }
                    }
                    $('#bottomTab').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
                    var dataList = data;
                    $("#tableBody").empty();//清空表格内容
                    if (dataList.length > 0) {
                        $(dataList).each(function () {//重新生成
                            $("#tableBody").append('<tr>');
                            $("#tableBody").append('<td>' + this.fileName + '</td>');
                            $("#tableBody").append('<td>' + this.username + '</td>');
                            $("#tableBody").append('<td>' + this.fileSize + '</td>');
                            $("#tableBody").append('<td>' + this.uploadTime + '</td>');
                            $("#tableBody").append('<td><a href="open/down' + this.id + "&" + this.username + '"><h2>下载</h2></a></td>');
                            $("#tableBody").append('</tr>');
                        });
                    } else {
                        $("#tableBody").append('<tr><th colspan ="4"><center>查询无数据</center></th></tr>');
                    }

                },
                error: function (e) {
                    alert("查询失败:" + e);
                }
            });
        });
    }

    //渲染完就执行
    $(function () {

        //生成底部分页栏
        $('#bottomTab').bootstrapPaginator(options);

        buildTable("", 1, 10);//默认空白查全部

        //创建结算规则
        $("#queryButton").bind("click", function () {
            var fileName = $("#textInput").val();
            buildTable(fileName, 1, PAGESIZE);
        });
    });
</script>
</body>
</html>

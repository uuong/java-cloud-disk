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
    <base href="<%=basePath%>">
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
</head>
<body>
<%@ include file="layout/nav.jsp" %>

<div class="row">

    <div class="col-md-2">
        <div class="btn-group-vertical" role="group">
            <ul>
                <button onclick="doAjax('our')">全部文件</button>
                <button onclick="doAjax('text')">文档</button>
                <button onclick="doAjax('video')">视频</button>
                <button onclick="doAjax('music')">音乐</button>
                <button onclick="doAjax('image')">图片</button>
                <button onclick="doAjax('none')">其他</button>
            </ul>
        </div>
    </div>
    <div class="col-md-9">
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">Library</a></li>
            <li class="active">Data</li>
        </ol>
        <form action="disk/up" method="post" enctype="multipart/form-data">

            <input type="file" name="file"/><br/>
            <input type="submit"/>
        </form>


        <div id="disk_table">
            <%@include file="layout/disk-table.jsp" %>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    function doAjax(url) {
        $.ajax({
            type: "POST",
            url: "disk?type=" + url,
            success: function (response) {
//                alert(response);

                $("#disk_table").html(response);
            }
        });
    }
</script>
</html>

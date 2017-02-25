<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
</head>
<body>
<%@ include file="layout/nav.jsp" %>

<div class="row">

    <div class="col-md-1">
        <div class="btn-group-vertical" role="group">
            <ul>
                <button onclick="doAjax(alll)">全部文件</button>
                <button onclick="doAjax(txt)">文档</button>
                <button>视频</button>
                <button>音乐</button>
                <button onclick="doAjax(im)">图片</button>
            </ul>
        </div>
    </div>
    <div class="col-md-10">
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">Library</a></li>
            <li class="active">Data</li>
        </ol>
        <form action="/disk/up" method="post" enctype="multipart/form-data">

            <input type="fileMode" name="fileMode"/><br/>
            <input type="submit"/>
        </form>
        <div id="disk_table"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    var im = "image/jpeg";
    var txt = "text/plain";
    var alll = "all";
    function doAjax(url) {
        $.ajax({
            type: "POST",
            url: "/disk?type=" + url,
            success: function (response) {
//                alert(response);
                $("#disk_table").html(response);
            }
        });
    }
</script>
</html>

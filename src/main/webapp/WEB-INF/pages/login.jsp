<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
</head>
<body>
<%@ include file="layout/nav.jsp" %>
<h2>登录</h2>

<hr>

<form action="/user/login" name="loginform" method="post" class="form-inline">
    <input type="text" name="username" class="form-control" placeholder="用户名">
    <input type="password" name="password" class="form-control" placeholder="密码">
    <button type="submit" class="btn btn-default">登录</button>
</form>


</body>
</html>

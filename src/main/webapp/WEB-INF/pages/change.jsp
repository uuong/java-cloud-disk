<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
</head>
<body>
<%@ include file="layout/nav.jsp" %>
<h2>登录</h2>

<hr>
<c:if test='${message == "error"}'>
    <h1>error</h1>
</c:if>
<c:if test='${ message == "ok"}'>
    ok
</c:if>
<form action="user/change-pass" name="loginform" method="post" class="form-inline">
    <input type="password" name="oldpass" class="form-control" placeholder="旧密码"/>
    <input type="password" name="newpass" class="form-control" placeholder="新密码"/>
    <input type="password" name="newpass2" class="form-control" placeholder="重复密码"/>
    <button type="submit" class="btn btn-default">确认修改</button>
</form>


</body>
</html>

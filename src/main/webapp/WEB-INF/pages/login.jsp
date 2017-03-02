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
<c:if test="${message == 'error'}">
    <h1>密码错误</h1>
</c:if>
<form method="post" class="form-inline">
    <table>
        <tr><input type="text" name="username" class="form-control" placeholder="用户名" onblur="checkUser()"
                   id="username"/>
            <div id="div_uname_err_info" class="name-pop"></div>
        </tr>
        <tr><input type="password" class="form-control" placeholder="密码" onblur="checkPass()" id="password"/>
            <div id="div_mm" class="name-pop"></div>
            <input type="hidden" id="md5-password" name="password">
        </tr>
        <tr>
            <td><input name="remember" type="checkbox" id="remember-me">30天内自动登录</td>
            <td>
                <button onclick="a_login()">提交</button>
            </td>
        </tr>
    </table>
</form>


</body>
</html>

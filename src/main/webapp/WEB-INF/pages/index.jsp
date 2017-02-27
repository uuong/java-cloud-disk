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
<%@ include file="./layout/nav.jsp" %>
<h2>Hello World!</h2>
<a href="uuuu">ssssss</a>
<c:if test="${SESSION == null}">
    <div class="lo">
        <form action="user/login/ajax" name="loginform" method="post" class="form-inline">
            <table>
                <tr><input type="text" name="username" class="form-control" placeholder="用户名" id="name"/>
                    <div id="div_uname_err_info" class="name-pop"></div>
                </tr>
                <tr><input type="password" name="password" class="form-control" placeholder="密码" id="pass"/>
                    <div id="div_mm" class="name-pop"></div>
                </tr>
                <tr>
                    <td><input name="remember" type="checkbox" id="remember-me">30天内自动登录</td>
                    <td><input type="button" value="ajaxLogin" onclick="login()" id="ajaxs"></td>
                </tr>
            </table>


        </form>

        <form action="user/register" name="registform" method="post" class="form-inline">
            <input type="text" name="username" class="form-control" placeholder="用户名" id="rname">
            <input type="password" name="password" class="form-control" placeholder="密码" id="rpass">
            <button type="submit" class="btn btn-default">注册</button>
        </form>
    </div>
</c:if>


</body>
<script type="text/javascript">


</script>
</html>

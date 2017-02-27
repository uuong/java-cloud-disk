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
<h2>用户管理</h2>

<c:if test="${message != null}">
    <h1>${message}</h1>
</c:if>
<c:if test="${ message == null}">
    <table class="table table-striped  table-hover">
        <tr>
            <th width="150">user</th>
            <th width="350">pass</th>
            <th width="150">time</th>
            <th width="150">dai</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>

                <td>${user.username}</td>


                <td>${user.password}</td>
                <td>${user.regisTime}</td>
                <td>2</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

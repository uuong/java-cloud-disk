<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="layout/css.jsp" %>
    <%@ include file="layout/js.jsp" %>
</head>
<body>
<%@ include file="layout/nav.jsp" %>
<h2>用户管理</h2>


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
</body>
</html>

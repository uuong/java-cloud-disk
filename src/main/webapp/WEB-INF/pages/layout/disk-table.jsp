<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  第一版用的 现在不用了
  User: Administrator
  Date: 2017/2/24 0024
  Time: 23:53
  To change this template use FileMode | Settings | FileMode Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-striped  table-hover">
    <c:forEach items="${fileModes}" var="fileMode">
        <tr>
            <td>${fileMode.filename}</td>
            <td>${fileMode.filesize} Kb</td>
            <td>${fileMode.filetype}</td>
            <td><a href="disk/down?name=${fileMode.filename}">下载</a></td>
        </tr>
    </c:forEach>
</table>


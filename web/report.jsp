<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/21/2017
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Report</title>
</head>
<body>
    <c:forEach items="${found}" var="act">
        <tr>
            <td><c:out value="${act.workerId}" /></td>
            <td><c:out value="${act.locationId}" /></td>
            <td><c:out value="${act.action}" /></td>
            <td><c:out value="${act.time}" /></td>
        </tr>
    </c:forEach>
</body>
</html>

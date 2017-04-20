<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/19/2017
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Zoo</title>
  </head>
  <body>
  <%--$END$--%>
  <c:forEach items="${animalsList}" var="animal">
    <tr>
      <td><c:out value="${animal.name}" /></td>
    </tr>
  </c:forEach>
  <c:out value="${profile.nutrition}" />
  <c:out value="${profile.wayoflife}" />

  </body>
</html>

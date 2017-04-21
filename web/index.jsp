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

  <form action="${pageContext.request.contextPath}/Zoo" method="post">

    <p><input type="text" name="workerId"/>Worker ID</p>
    <p><input type="text" name="locationId"/>Location ID</p>
    <p><input type="text" name="action"/>Action</p>
    <p><input type="text" name="from"/>From</p>
    <p><input type="text" name="to"/>To</p>

    <p>
      <input type="submit" name="submit" value="Search!" /></p>
  </form>


  </body>
</html>

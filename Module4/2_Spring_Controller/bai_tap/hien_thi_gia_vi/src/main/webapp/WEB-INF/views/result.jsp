<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 23.02.2021
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Condiments</title>
</head>
<body>
    <h1>List Condiments</h1>
    <ul>
        <c:forEach var="condiment" items="${listCondiment}">
            <li>
                <c:out value="${condiment}"></c:out>
            </li>
        </c:forEach>
    </ul>
</body>
</html>

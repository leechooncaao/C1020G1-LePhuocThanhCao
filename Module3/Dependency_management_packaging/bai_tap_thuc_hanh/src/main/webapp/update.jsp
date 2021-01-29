<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 26/01/2021
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
    <form action="/UserServlet" method="post">
        <input type="hidden" name="actionUser" value="update" />
        <input type="hidden" name="id" value="${userInfo.id}" />
        <p>
            Name:
            <input type="text" value="${userInfo.name}" name="name">
        </p>
        <p>
            Email:
            <input type="text" value="${userInfo.email}" name="email">
        </p>
        <p>
            Email:
            <input type="text" value="${userInfo.country}" name="country">
        </p>
        <p>
            <input type="submit" value="Save" />
        </p>
    </form>
</body>
</html>

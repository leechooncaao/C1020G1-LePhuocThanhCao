<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View user</title>
</head>
<body>
<h1>User details</h1>
<p>
    <a href="/UserServlet">Back to user list</a>
</p>
<c:set var = "messenger" scope="session" value = "${requestScope.messenger}"/>
<c:if test="${messenger == ''}">
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["user"].getName()}</td>
        </tr>
        <tr>
            <td>Email: </td>
            <td>${requestScope["user"].getEmail()}</td>
        </tr>
        <tr>
            <td>Country: </td>
            <td>${requestScope["user"].getCountry()}</td>
        </tr>
    </table>
</c:if>
<c:if test="${messenger == 'not found'}">
    <c:out value="${'User not found'}"/>
</c:if>

</body>
</html>
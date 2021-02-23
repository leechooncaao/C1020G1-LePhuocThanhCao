<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 23.02.2021
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1>Successfully updated !</h1>
    <table>
        <tr>
            <td>Language :</td>
            <td>${language}</td>
        </tr>
        <tr>
            <td>Page Size :</td>
            <td>${pageSize}</td>
        </tr>
        <tr>
            <td>Spams Filter :</td>
            <td>
                <c:if test="${spamsFilter == true}">
                    <p><c:out value="Enable"></c:out></p>
                </c:if>
                <c:if test="${spamsFilter != true}">
                    <p><c:out value="Disable"></c:out></p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Signature :</td>
            <td>
                ${signature}
            </td>
        </tr>
    </table>
</body>
</html>

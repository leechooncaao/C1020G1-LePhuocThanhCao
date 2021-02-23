<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 23.02.2021
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Configuration Email</title>
    <style>
        td{
            margin: 10px;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<form:form method="POST" action="/save" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Language: </form:label></td>
            <td>
                <form:select path="language">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Japanese" label="Japanese"/>
                    <form:option value="Chinese" label="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td>
                <form:checkbox path="spamsFilter" value="true"/> Enables spams filter
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

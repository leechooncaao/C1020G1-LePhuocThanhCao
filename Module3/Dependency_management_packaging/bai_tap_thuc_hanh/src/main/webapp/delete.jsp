<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting user</title>
</head>
<body>
<h1>Delete user</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/UserServlet">Back to user list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["userInfo"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["userInfo"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${requestScope["userInfo"].getCountry()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"></td>
                <td><a href="/UserServlet">Back to user list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
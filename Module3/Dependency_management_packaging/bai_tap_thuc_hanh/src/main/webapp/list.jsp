<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List user</title>

</head>
<body>
<p>
    <a href="/UserServlet?actionUser=create">Create new user</a>
</p>
<form>
    <input type="hidden" name="actionUser" value="search">
    <input type="text" placeholder="Search by name" name="name"/>
    <input type="submit" value="Search"/>
</form>

<form>
    <input type="hidden" name="actionUser" value="search_id">
    <input type="text" placeholder="Search by id" name="id"/>
    <input type="submit" value="Search"/>
</form>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Action</th>
        <th>Action</th>
    </tr>

    <c:forEach var="user" items="${userListFromServlet}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td>
                <a href="/UserServlet?actionUser=update&id=${user.id}">Update</a>
            </td>
            <td>
                <a href="/UserServlet?actionUser=delete&id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

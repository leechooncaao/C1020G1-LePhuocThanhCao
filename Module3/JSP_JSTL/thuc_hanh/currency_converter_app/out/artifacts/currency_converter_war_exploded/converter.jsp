<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 25.01.2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
    <h2>Rate : <%=request.getAttribute("rate")%></h2>
    <h2>USD : <%=request.getAttribute("usd")%></h2>
    <h2>Total : <%=request.getAttribute("result")%></h2>
</body>
</html>

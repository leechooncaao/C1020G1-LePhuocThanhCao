<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 23.02.2021
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <title>Calculator</title>
  <style>
    .container {
      border: 1px solid black;
      width: 400px;
      height: 120px;
      padding: 13px;
    }

    input, select {
      margin-bottom: 10px;
    }

    select {
      margin-left: 49px;
    }

  </style>
</head>
<body>
<h1>Simple Calculator</h1>
<div class="container">
  <form action="/calculate">
    <label>First Operand : </label>
    <input type="text" name="number1" style="margin-left: 16px"><br>
    <lable>Operator :</lable>
    <select name="operator">
      <option value="+">Addition</option>
      <option value="-">Subtraction</option>
      <option value="*">Multiplication</option>
      <option value="/">division</option>
    </select><br>
    <label>Second Operand :</label>
    <input type="text" name="number2"><br>
    <input type="submit" value="Calculate" style="margin-left: 119px">
  </form>

  <c:if test="${result != null}">
    <p><c:out value="${result}"></c:out></p>
  </c:if>
</div>
</body>
</html>


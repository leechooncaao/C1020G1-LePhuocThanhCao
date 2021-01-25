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
      <form action="/calculator">
        <label>First Operand : </label>
        <input type="text" name="first-operand" style="margin-left: 16px"><br>
        <lable>Operator :</lable>
        <select name="operator">
          <option value="+">Addition</option>
          <option value="-">Subtraction</option>
          <option value="*">Multiplication</option>
          <option value="/">division</option>
        </select><br>
        <label>Second Operand :</label>
        <input type="text" name="second-operand"><br>
        <input type="submit" value="Calculate" style="margin-left: 119px">
      </form>
    </div>
  </body>
</html>

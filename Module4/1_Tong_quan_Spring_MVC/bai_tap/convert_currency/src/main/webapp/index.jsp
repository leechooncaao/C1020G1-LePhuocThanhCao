<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 22.02.2021
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="/convert">
    <label>Rate: </label><br/>
    <input type="text" name="rate"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd"/><br/>
    <input type = "submit" id = "submit" value = "Convert"/>
  </form>
  </body>
</html>

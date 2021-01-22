<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 22.01.2021
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
</head>
<body>
<div class="container">
  <h2>Currency converter</h2>
  <form action="/convert" method="post">
    <div class="data-input">
      <label>Rate</label><br />
      <input
              type="text"
              name="rate"
              placeholder="RATE"
              value="22000"
      /><br />
      <label>USD</label><br />
      <input type="text" name="usd" placeholder="USD" value="1" /><br />
      <input type="submit" value="Convert" />
    </div>
  </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 22.01.2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>$Title$</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  $END$--%>
<%--  </body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <style>
    .login {
      height: 180px;
      width: 270px;
      margin: 0;
      padding: 10px;
      border: 1px #ccc solid;
    }
    .login input {
      padding: 5px;
      margin: 5px;
    }
  </style>
</head>
<body>
<form action="/login" method="post">
  <div class="login">
    <h2>Login</h2>
    <input type="text" name="username" size="30" placeholder="username" />
    <input
            type="password"
            name="password"
            size="30"
            placeholder="password"
    />
    <input type="submit" value="Sign in" />
  </div>
</form>
</body>
</html>


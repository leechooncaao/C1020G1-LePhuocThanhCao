<%--
  Created by IntelliJ IDEA.
  User: lephu
  Date: 22.01.2021
  Time: 4:01 PM
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
<h2>Product Discount Calculator</h2>
<form action="/display-discount" method="get">
  <label>Product Description</label><br />
  <input type="text" name="description" value="" /><br />
  <label>Price</label><br />
  <input type="text" name="price" value="" /><br />
  <label>Discount Percent</label><br />
  <input type="text" name="discount" value="" /><br />
  <input type="submit" value="Calculate">
</form>
</body>
</html>


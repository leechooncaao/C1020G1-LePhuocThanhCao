<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Show list of Customers</title>
      <style>
          h1 {
              margin-bottom: 2px;
              text-align: center;
          }
          table {
              border: 1px solid black;
              text-align: center;
              box-shadow:0 0 5px 5px aqua;
              width: 650px;
              position: relative;
              top: 4%;
              left: 25%;
              border-spacing: 0;
          }

          td,th {
              padding: 10px;
              border-bottom: 1px solid gray;
              margin-right: 0;
              margin-left: 0;
          }
      </style>
  </head>
  <body>
      <h1>List Of Customer</h1>
      <table>
          <tr>
              <th>Full Name</th>
              <th>Birthday</th>
              <th>Address</th>
              <th>Image</th>
          </tr>

            <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${customer.fullName}"/></td>
                    <td><c:out value="${customer.birthDay}"></c:out></td>
                    <td><c:out value="${customer.address}"></c:out></td>
                    <td><img src="${customer.image}" style="width: 60px; height: 80px"></td>
                </tr>
            </c:forEach>
      </table>
  </body>
</html>

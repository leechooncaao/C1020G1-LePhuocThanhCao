<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        h1 {
            text-align: center;
        }

        table {
            border: 1px solid black;
            width: 70%;
            height: 260px;
            text-align: center;
            border-collapse: collapse;
            margin-left: 214px;
        }

        th {
            background-color: green;
            color: white;
        }

        td {
            padding-left: 5px;
        }

        .create {
            margin: 15px;
            margin-left: 595px;
        }

        table button {
            padding-left: 5px;
        }

        a {
            text-decoration: none;
            color: white;
        }

        a:visited {
            color: white;
        }

        button {
            background-color:  red;
            padding: 10px;
            border-radius: 5px;

        }

        button:hover {
            background-color: black;
        }
    </style>
</head>
<body>
    <h1>Products</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="product" items="${productListFromServlet}">
            <tr>
                <td><c:out value="${product.id}"></c:out></td>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td>
                    <button>
                        <a href="/productServlet?action=update&id=${product.id}">Update</a>
                    </button>
                </td>
                <td>
                    <button>
                        <a href="/productServlet?action=delete&id=${product.id}">Delete</a>
                    </button>
                </td>
                <td>
                    <button>
                        <a href="/productServlet?action=showDetailInfo&id=${product.id}">Detail</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button class="create">
        <a href="/productServlet?action=create">Create New Product</a>
    </button>
</body>
</html>

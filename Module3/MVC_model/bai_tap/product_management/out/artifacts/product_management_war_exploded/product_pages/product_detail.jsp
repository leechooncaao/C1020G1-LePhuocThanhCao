<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
    <h2>Detail Product</h2>
    <p>
        ID : <c:out value="${detailProduct.id}"/>
    </p>
    <p>
        Name : <c:out value="${detailProduct.name}"/>
    </p>
    <p>
        Price : <c:out value="${detailProduct.price}"/>
    </p>
    <p>
        Description : <c:out value="${detailProduct.description}"/>
    </p>
    <p>
        Producer : <c:out value="${detailProduct.producer}"/>
    </p>
</body>
</html>

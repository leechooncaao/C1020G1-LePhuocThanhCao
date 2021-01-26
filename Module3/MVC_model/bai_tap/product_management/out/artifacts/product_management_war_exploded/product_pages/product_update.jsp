<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
    <h1>Update Product</h1>
    <form action="" method="post">
        <p>
            Name :
            <input type="text" name="name" value="${productInfo.name}" style="margin-left: 35px">
        </p>
        <p>
            Price :
            <input type="text" name="price" value="${productInfo.price}" style="margin-left: 42px">
        </p>
        <p>
            Description :
            <input type="text" name="description" value="${productInfo.description}">
        </p>
        <p>
            Producer :
            <input type="text" name="producer" value="${productInfo.producer}" style="margin-left: 17px">
        </p>
        <p>
            <input type="submit" value="Save">
        </p>
    </form>

</body>
</html>

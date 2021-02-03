<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>new</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/table_modal.css">
</head>
<body>
<div class="jumbotron" style="margin-bottom: 0">
    <div class="row">
        <div class="col-md-2 m-0">
            <img class="float-left" src="images/logo2.png" alt="fdsa" />
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#" style="margin-left: 107px">Home</a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#collapsibleNavbar"
    >
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/employeeServlet">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customerServlet">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/serviceServlet">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contractServlet">Contract</a>
            </li>
        </ul>
    </div>
</nav>

<%--<div class="container" style="margin: 0">--%>
<%--    <div class="row">--%>
<%--        <img style="width: 100%" src="62371531.jpg" alt="" />--%>
<%--    </div>--%>
<%--</div>--%>
<div style="position: relative; text-align: center">
    <img src="images/62371531.jpg" alt="" style="width: 100%">
    <div id="centered-text" style="position: absolute;top: 50%; left: 50%; transform: translate(-50%, -50%);">
        <h2 style="font-size: 5rem; color: red">WELCOME TO FURAMA RESORT</h2>
    </div>
</div>
<div
        class="bg-dark text-center"
        style="margin-bottom: 0; height: 40px; color: white"
>
    <p style="padding-top: 8px">Designed By Cao handsome</p>
</div>
</body>
</html>

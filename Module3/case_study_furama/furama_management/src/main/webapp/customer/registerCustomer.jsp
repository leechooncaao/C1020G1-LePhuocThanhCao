<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Employee</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto"
    />
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    />
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/table_modal.css">
    <link rel="stylesheet" href="css/form_edit_create.css">
    <style>

    </style>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom: 0">
    <div class="row">
        <div class="col-md-2 m-0">
            <img class="float-left" src="images/logo2.png" alt="fdsa" />
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="home.jsp" style="margin-left: 107px">Home</a>
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
            <li class="nav-item active">
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

<div class="container rounded bg-white mt-5">
    <div class="row">
        <div class="col-md-12">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <div class="d-flex flex-row align-items-center back">
                        <i class="fa fa-long-arrow-left mr-1 mb-1"></i>
                        <h6>
                            <a href="/customerServlet">Back</a>
                        </h6>
                    </div>
                    <h6 class="text-right">Register</h6>
                </div>
                <form method="post">
                    <div class="row mt-2">
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="name"
                                    class="form-control"
                                    placeholder="Name"
                                    value="<c:out value='${customer.name}' />"
                            />
                        </div>
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="birthday"
                                    class="form-control"
                                    placeholder="Birthday e.g : YYYY-MM-DD"
                                    value="<c:out value='${customer.birthday}' />"
                            />
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="idCard"
                                    class="form-control"
                                    placeholder="ID Card : max 9 or 12 digits"
                                    value="<c:out value='${customer.idCard}' />"
                            />
                        </div>
                        <div class="col-md-6">
                            <select name="gender" class="form-control">
                                <option value="1">Male</option>
                                <option value="2">Female</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="email"
                                    class="form-control"
                                    placeholder="Email e.g : abc@gmail.com"
                                    value="<c:out value='${customer.email}' />"
                            />
                        </div>
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="phone"
                                    class="form-control"
                                    placeholder="Phone Number : 090XXXXXXX - 091XXXXXXX - +(84) 90XXXXXXX - +(84) 91XXXXXXX"
                                    value="<c:out value='${customer.phone}' />"
                            />
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="address"
                                    class="form-control"
                                    placeholder="Address"
                                    value="<c:out value='${customer.address}' />"
                            />
                        </div>
                        <div class="col-md-6">
                            <select name="type" class="form-control">
                                <option value="1">Diamond</option>
                                <option value="2">Platinium</option>
                                <option value="3">Gold</option>
                                <option value="4">Silver</option>
                                <option value="5">Member</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="code"
                                    class="form-control"
                                    placeholder="Customer Code e.g : KH-XXXX"
                                    value="<c:out value='${customer.code}' />"
                            />
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <c:if test='${requestScope["message"] != null}'>
                                <span class="message text-danger">${requestScope["message"]}</span>
                            </c:if>
                        </div>
                    </div>
                    <div class="mt-5 text-right">
                        <input type="submit" value="Save" class="btn btn-primary profile-button">
                    </div>
                </form>
            </div>
        </div>
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

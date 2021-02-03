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
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto"
    />
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/table_modal.css">
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
            <li class="nav-item active">
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

<div class="container">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
                        <h2>
                            Employee <b>Details</b>
                            <span>
                                    <a href="/serviceServlet?action=create">
                                        <button class="btn btn-danger profile-button" type="button">
                                          Register
                                        </button>
                                    </a>
                                </span>
                        </h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="search-box">
                            <form action="serviceServlet" id="searchForm">
                                <a class="search-btn" onclick="$('#searchForm').submit()">
                                    <i class="material-icons">&#xE8B6;</i>
                                </a>
                                <input type="hidden" name="action" value="search">
                                <input
                                        type="text"
                                        class="form-control"
                                        placeholder="Search by name &hellip;"
                                        name="search-data"
                                />
                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover table-bordered table-responsive text-nowrap">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>
                        Name
                        <a href="/serviceServlet?action=sortByName">
                            <i class="fa fa-sort"></i>
                        </a>
                    </th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max People</th>
                    <th>Rent Type</th>
                    <th>Service Type</th>
                    <th>Standard Room</th>
                    <th>Description</th>
                    <th>Pool Area</th>
                    <th>Number Floor</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${listService}">
                    <tr>
                        <td><c:out value="${service.id}" /></td>
                        <td><c:out value="${service.name}" /></td>
                        <td><c:out value="${service.area}" /></td>
                        <td><c:out value="${service.cost}" /></td>
                        <td><c:out value="${service.maxPeople}" /></td>
                        <td><c:out value="${service.rentType}" /></td>
                        <td><c:out value="${service.serviceType}" /></td>
                        <td><c:out value="${service.standardRoom}" /></td>
                        <td><c:out value="${service.description}" /></td>
                        <td><c:out value="${service.poolArea}" /></td>
                        <td><c:out value="${service.numberFloor}" /></td>
                        <td>
                            <a
                                    href="/serviceServlet?action=edit&id=${service.id}"
                                    class="edit"
                                    title="Edit"
                                    data-toggle="tooltip"
                            ><i class="material-icons">&#xE254;</i></a
                            >
                            <a
                                    href="#deleteServiceModal"
                                    class="delete"
                                    title="Delete"
                                    data-toggle="modal"
                                    onclick="setIdService('${service.id}')"
                            >
                                <i class="material-icons">&#xE872;</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Deleting Employee Modal HTML -->
<div id="deleteServiceModal" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <div class="modal-content">
            <div class="modal-header flex-column">
                <div class="icon-box">
                    <i class="material-icons">&#xE5CD;</i>
                </div>
                <h4 class="modal-title w-100">Are you sure?</h4>
                <button
                        type="button"
                        class="close"
                        data-dismiss="modal"
                        aria-hidden="true"
                >
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <p>
                    Do you really want to delete these records? This process cannot be
                    undone.
                </p>
            </div>
            <div class="modal-footer justify-content-center">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-dismiss="modal"
                >
                    Cancel
                </button>
                <button
                        type="button"
                        class="btn btn-danger"
                        onclick="submitDeleteService()"
                >
                    Delete
                </button>
            </div>
        </div>
    </div>
</div>
<!-- forms for deleting employee -->
<form action="/serviceServlet" id="delete-service">
    <input type="hidden" name="action" value="delete" />
    <input type="hidden" id="id-service" name="id" />
</form>

<div
        class="bg-dark text-center"
        style="margin-bottom: 0; height: 40px; color: white"
>
    <p style="padding-top: 8px">Designed By Cao handsome</p>
</div>
<script>
    // functions for deleting employee
    function setIdService(idService) {
        document.getElementById("id-service").value = idService;
    }
    function submitDeleteService() {
        document.getElementById("delete-service").submit();
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>Bootstrap Simple Data Table</title>
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
    <style>
        body {
            color: #566787;
            background:  #ba68c8;
            font-family: "Roboto", sans-serif;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
        }
        .table-title {
            padding-bottom: 10px;
            margin: 0 0 10px;
            min-width: 100%;
        }
        .table-title h2 {
            margin: 8px 0 0;
            font-size: 22px;
        }
        .search-box {
            position: relative;
            float: right;
        }
        .search-box input {
            height: 34px;
            border-radius: 20px;
            padding-left: 35px;
            border-color: #ddd;
            box-shadow: none;
        }
        .search-box input:focus {
            border-color: #3fbae4;
        }
        .search-box i {
            color: #a0a5b1;
            position: absolute;
            font-size: 19px;
            top: 8px;
            left: 10px;
        }
        table.table tr th,
        table.table tr td {
            border-color: #e9e9e9;
        }
        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }
        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table td:last-child {
            width: 130px;
        }
        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }
        table.table td a.view {
            color: #03a9f4;
        }
        table.table td a.edit {
            color: #ffc107;
        }
        table.table td a.delete {
            color: #e34724;
        }
        table.table td i {
            font-size: 19px;
        }
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
                        <h2>
                            User <b>Details</b>
                            <span>
                                <a href="/userServlet?action=create">
                                    <button class="btn btn-danger profile-button" type="button">
                                      Register
                                    </button>
                                </a>
                            </span>
                        </h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="search-box">
                            <i class="material-icons">&#xE8B6;</i>
                            <input
                                    type="text"
                                    class="form-control"
                                    placeholder="Search by country &hellip;"
                            />
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name <i class="fa fa-sort"></i></th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listUser}">
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.country}"/></td>
                        <td>
                            <a href="/userServlet?action=edit&id=${user.id}" class="edit" title="Edit" data-toggle="tooltip"
                            ><i class="material-icons">&#xE254;</i></a
                            >
                            <a
                                    href="/userServlet?action=delete&id=${user.id}"
                                    class="delete"
                                    title="Delete"
                                    data-toggle="tooltip"
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
</body>
</html>

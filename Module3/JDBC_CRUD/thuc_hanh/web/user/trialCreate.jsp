<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Management</title>
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
            background: #ba68c8;
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #ba68c8;
        }

        .profile-button {
            background: #ba68c8;
            box-shadow: none;
            border: none;
        }

        .profile-button:hover {
            background: #682773;
        }

        .profile-button:focus {
            background: #682773;
            box-shadow: none;
        }

        .profile-button:active {
            background: #682773;
            box-shadow: none;
        }

        .back:hover {
            color: #682773;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container rounded bg-white mt-5">
    <div class="row">
        <div class="col-md-12">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <div class="d-flex flex-row align-items-center back">
                        <i class="fa fa-long-arrow-left mr-1 mb-1"></i>
                        <h6>
                            <a href="/userServlet">Back</a>
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
                            />
                        </div>
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="email"
                                    class="form-control"
                                    placeholder="Email"
                            />
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="country"
                                    class="form-control"
                                    placeholder="Country"
                            />
                        </div>
                        <div class="col-md-6">
                            <input
                                    type="text"
                                    name="phoneNumber"
                                    class="form-control"
                                    placeholder="Phone number"
                            />
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
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nhhie
  Date: 1/3/2024
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>
        Add tour
    </title>
    <!-- Favicon -->
    <link href="../assets/img/brand/favicon.png" rel="icon" type="image/png">
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!-- Icons -->
    <link href="../assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
    <link href="../assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
    <!-- CSS Files -->
    <link href="../assets/css/argon-dashboard.css?v=1.1.2" rel="stylesheet" />
</head>

<body class="bg-default">
<div class="main-content">
    <!-- Navbar -->
    <nav class="navbar navbar-top navbar-horizontal navbar-expand-md navbar-dark">
        <div class="container px-4">
            <a class="navbar-brand" href="../index.html">
                <img src="../assets/img/brand/white.png" />
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar-collapse-main">
                <!-- Collapse header -->
                <div class="navbar-collapse-header d-md-none">
                    <div class="row">
                        <div class="col-6 collapse-brand">
                            <a href="../index.html">
                                <img src="../assets/img/brand/blue.png">
                            </a>
                        </div>
                        <div class="col-6 collapse-close">
                            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                                <span></span>
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </nav>
    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8">
        <div class="container">
            <div class="header-body text-center mb-7">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-6">
                        <h1 class="text-white">Manager tour!</h1>
                    </div>
                </div>
                <c:if test="${error != null}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert" id="alert">
                        <span class="alert-icon"><i class="ni ni-like-2"></i></span>
                        <span class="alert-text"><strong>Danger!</strong> ${error}</span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="separator separator-bottom separator-skew zindex-100">
            <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
                <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
            </svg>
        </div>
    </div>
    <!-- Page content -->
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-7">
                <div class="card bg-secondary shadow border-0">
                    <div class="card-body px-lg-5 py-lg-5">

                        <c:choose>
                            <c:when test="${tour != null}">
                                <form method="post">
                                    <div class="form-group">
                                        <label class="form-control-label">Name</label>
                                        <input name="name" class="form-control" value="${tour.name}" type="text">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label">Thể loại</label>
                                        <select  name="type" class="form-control" >
                                            <option value="${tour.type}">${tour.type.getType()}</option>
                                            <c:forEach var="type" items="${typeList}">
                                                <c:if test="${type != tour.type}"><option value="${type}">${type.getType()}</option></c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label">URL Image</label>
                                        <input name="urlImage" value="${tour.urlImage}" class="form-control" type="text">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-success">Update</button>
                                        <a href="/manager-tour" class="btn btn-info">Return</a>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form method="post">
                                    <div class="form-group">
                                        <label class="form-control-label">Name</label>
                                        <input name="name" class="form-control" type="text">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label">Thể loại</label>
                                        <select  name="type" class="form-control" >
                                            <option value="">Chọn loại du lịch</option>
                                            <c:forEach var="type" items="${typeList}">
                                                <option value="${type}">${type.getType()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-control-label">URL Image</label>
                                        <input name="urlImage" class="form-control" type="text">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-success">Add</button>
                                        <a href="/manager-tour" class="btn btn-info">Return</a>
                                    </div>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--   Core   -->
<script src="../assets/js/plugins/jquery/dist/jquery.min.js"></script>
<script src="../assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!--   Optional JS   -->
<!--   Argon JS   -->
<script src="../assets/js/argon-dashboard.min.js?v=1.1.2"></script>
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>

</body>

</html>
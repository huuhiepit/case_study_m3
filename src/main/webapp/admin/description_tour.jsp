<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>
        Manager Description Tour
    </title>
    <!-- Favicon -->
    <link href="./assets/img/brand/favicon.png" rel="icon" type="image/png">
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!-- Icons -->
    <link href="./assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet"/>
    <link href="./assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet"/>
    <!-- CSS Files -->
    <link href="./assets/css/argon-dashboard.css?v=1.1.2" rel="stylesheet"/>
</head>

<body class="">
<c:import url="menu.jsp" charEncoding="UTF-8"/>
<div class="main-content">
    <!-- Navbar -->
    <c:import url="navbar.jsp" />
    <!-- End Navbar -->
    <!-- Header -->
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <div class="card shadow">
                        <div class="card-header border-0">
                            <h3 class="mb-0">Description Tour Manager!  <span class="text-blue">Tour: ${tour.name}</span></h3>
                            <div>
                                <a href="/manager-description-tour?action=create&id=${tour.id}" class="btn btn-outline-secondary">
                                    <i class="ni ni-fat-add"></i>
                                    Add Description Tour
                                </a>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table align-items-center table-flush">
                                <thead class="thead-light">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Date Start</th>
                                    <th scope="col">Date End</th>
                                    <th scope="col">Seat</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Description</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="descriptionTour" items="${descriptionTourList}">
<%--                                    long id, LocalDate dateStart, LocalDate dateEnd, int seat, long price, EStatusTour status, String description, long idTour--%>
                                    <tr id="tour-${descriptionTour.id}">
                                        <td scope="row">
                                            <div class="media align-items-center">
                                                <a href="#" class="avatar rounded-circle mr-3">
                                                    <img alt="Image placeholder" src="../assets/img/tour/${tour.urlImage}">
                                                </a>
                                            </div>
                                        </td>
                                        <td>${descriptionTour.dateStart}</td>
                                        <td>${descriptionTour.dateEnd}</td>
                                        <td>${descriptionTour.seat}</td>
                                        <td>${descriptionTour.getCurrentVND()}</td>
                                        <td>${descriptionTour.status.getStatus()}</td>
                                        <td>${descriptionTour.description}</td>
                                        <td class="text-right">
                                            <div class="dropdown">
                                                <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                    <a class="dropdown-item text-blue" href="./manager-description-tour?action=edit&id=${tour.id}&idDescriptionTour=${descriptionTour.id}">Edit</a>
                                                    <a class="dropdown-item text-red" onclick="return confirm('Bạn có muốn xóa Description Tour có id: ${descriptionTour.id} này không?')" href="./manager-description-tour?action=delete&id=${tour.id}&idDescriptionTour=${descriptionTour.id}">Delete</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <!-- Footer -->
        <footer class="footer">
            <div class="row align-items-center justify-content-xl-between">
            </div>
        </footer>
    </div>

</div>

<!--   Core   -->
<script src="./assets/js/plugins/jquery/dist/jquery.min.js"></script>
<script src="./assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!--   Optional JS   -->
<script src="./assets/js/plugins/chart.js/dist/Chart.min.js"></script>
<script src="./assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
<!--   Argon JS   -->
<script src="./assets/js/argon-dashboard.min.js?v=1.1.2"></script>
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
</body>

</html>

<!-- Table -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>
        Manager Tour
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
                            <h3 class="mb-0">Booking Manager</h3>
                        </div>
                        <div class="table-responsive">
                            <table class="table align-items-center table-flush">
                                <thead class="thead-light">
                                <tr>
                                    <th scope="col">Mã Booking</th>
                                    <th scope="col">Đặt chỗ</th>
                                    <th scope="col">Tổng giá trị</th>

                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Thanh toán</th>
                                    <th scope="col">Khách đặt</th>
                                    <th scope="col">Nhân viên</th>
                                    <th scope="col">Mã hành trình</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="booking" items="${bookingList}">
<%--                                    //                long id, int seat, long totalPrice,--%>
<%--                                    //                LocalDate dateBooking, EStatus status,--%>
<%--                                    //                EPay pay, String customerName, String customerPhone,--%>
<%--                                    //                String tourName, long idDescriptionTour, LocalDate dateStat,--%>
<%--                                    //                LocalDate dateEnd, String employeeName, String employeePhone--%>
                                    <tr id="tour-${booking.id}">
                                        <td>${booking.id}</td>
                                        <td>${booking.seat}</td>
                                        <td>${booking.getCurrentVND()}</td>

                                        <td>${booking.status.getStatus()}</td>
                                        <td>${booking.pay.getPay()}</td>
                                        <td>${booking.customerName}</td>
                                        <td>${booking.employeeName}</td>
                                        <td>${booking.idDescriptionTour}</td>

                                        <td class="text-right">
                                            <div class="dropdown">
                                                <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                    <a class="dropdown-item text-blue" onclick="return confirm('Bạn chấp nhận đơn đặt tour: ${booking.id} này không?')" href="/manager-booking?action=update&id=${booking.id}&status=PROCESSING">Nhận đơn đặt</a>
                                                    <a class="dropdown-item text-red" onclick="return confirm('Bạn có muốn hủy đơn đặt này không: ${booking.id} này không?')" href="/manager-booking?action=update&id=${booking.id}&status=CANCEL">Hủy đơn</a>
                                                    <a class="dropdown-item text-orange" onclick="return confirm('Bạn muốn thay đổi lại trạng thái của đơn đặt tour: ${booking.id} này không?')" href="/manager-booking?action=update&id=${booking.id}&status=PROCESSED">Đổi về trạng thái ban đầu</a>
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

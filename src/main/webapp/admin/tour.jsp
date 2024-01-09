<%--
  Created by IntelliJ IDEA.
  User: nhhie
  Date: 1/3/2024
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
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
                            <h3 class="mb-0">Tour Manager</h3>
                            <div>
                                <br>
                                <label>
                                    <select id="selectSearchType" class="btn btn-secondary">
                                        <option value="">Chọn loại tìm kiếm</option>
                                        <option value="domestic" <c:if test="${type = 'DOMESTIC'}">selected</c:if> >Trong nước</option>
                                        <option value="foreign" <c:if test="${type = 'FOREIGN'}">selected</c:if> >Ngoài nước</option>
                                    </select>
                                </label>
                                <a href="/manager-tour?action=create" class="btn btn-outline-secondary">
                                    <i class="ni ni-fat-add"></i>
                                    Add Tour
                                </a>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table align-items-center table-flush">
                                <thead class="thead-light">
                                <tr>
                                    <th scope="col">Name</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Số lượng hành trình</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="tour" items="${tourList}">
<%--                                    long id, String name, String urlImage, EType type, int total--%>
                                    <tr id="tour-${tour.id}">
                                        <td scope="row">
                                            <div class="media align-items-center">
                                                <a href="#" class="avatar rounded-circle mr-3">
                                                    <img alt="Image placeholder" src="../assets/img/tour/${tour.urlImage}">
                                                </a>
                                                <div class="media-body">
                                                    <span class="mb-0 text-sm">${tour.name}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            ${tour.type.getType()}
                                        </td>
                                        <td>${tour.total}</td>
                                        <td class="text-right">
                                            <div class="dropdown">
                                                <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                    <a class="dropdown-item text-blue" href="/manager-tour?action=edit&id=${tour.id}">Edit</a>
                                                    <a class="dropdown-item text-red" onclick="return confirm('Bạn có muốn xóa Tour: ${tour.name} này không?')" href="/manager-tour?action=delete&id=${tour.id}">Delete</a>
                                                    <a class="dropdown-item text-blue" href="/manager-description-tour?id=${tour.id}">Xem các hành trình</a>
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
<script>
    // Lắng nghe sự kiện thay đổi trên phần tử select
    document.getElementById('selectSearchType').addEventListener('change', function() {
        // Lấy giá trị được chọn
        var selectedValue = this.value;

        // Kiểm tra giá trị và chuyển hướng trang
        if (selectedValue === 'domestic') {
            window.location.href = '/manager-tour?action=search&type=DOMESTIC'; // Thay 'duong-dan-trong-nuoc' bằng đường dẫn cần chuyển
        } else if (selectedValue === 'foreign') {
            window.location.href = '/manager-tour?action=search&type=FOREIGN'; // Thay 'duong-dan-ngoai-nuoc' bằng đường dẫn cần chuyển
        } else {
            // Xử lý trường hợp giá trị không xác định
            alert('Vui lòng chọn loại tìm kiếm.');
        }
    });
</script>
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

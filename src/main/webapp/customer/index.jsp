<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="../assets/css/styleCustomer.css">
</head>

<body>
<div class="wrapper">
    <div class="header">
        <div class="header-top shadow-sm">
            <div class="container-xl ">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="header-top-left">
                        Hotline: <span>1900 9999</span>
                    </div>
                    <div class="header-top-right">
                        <ul class="nav justify-content-end">
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="fa-solid fa-sitemap"></i> Hệ thống giao dịch</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="fa-solid fa-handshake"></i> Đại lý đăng ký</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="fa-solid fa-file-lines"></i> Phiếu góp ý</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-bottom">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-xl">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                            <a class="nav-link" href="#">Features</a>
                            <a class="nav-link" href="#">Pricing</a>
                            <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="content">
        <div class="slide-home">
            <div id="carouselExampleIndicators" class="carousel slide">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="../assets/img/slide/chum-tour-hoa-anh-dao-du-lich-viet.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="../assets/img/tour/hanh-trinh-phuc-loc-tet-2024-du-lich-viet(3).jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <div class="tour-home">
            <div class="container-xl">
                <div class="title-home">
                    TOUR TRONG NƯỚC
                </div>
                <div class="content-home">
                    <div class="text-center">
                        <div class="row row-cols-4">
                            <c:forEach var="tourDescriptionPair" items="${tourDescriptionPair}">
                                <div class="col">
<%--                                    Tour tour, List<DescriptionTour> descriptionTourList--%>
<%--                                    long id, String name, String urlImage, EType type, int total--%>
                                    <div class="item-tour">
                                        <div class="box-item">
                                            <div class="box-img">
                                                <a type="button" data-toggle="modal" data-target="#myModal-${tourDescriptionPair.getTour().id}">
                                                    <img src="../assets/img/tour/${tourDescriptionPair.getTour().urlImage}" alt="">
                                                    <div class="box-ib">
                                                        ${tourDescriptionPair.getTour().type.getType()}
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="box-info">
                                                <div class="box-name">
                                                    <a type="button" data-toggle="modal" data-target="#myModal-${tourDescriptionPair.getTour().id}">
                                                        ${tourDescriptionPair.getTour().name}
                                                    </a>
                                                </div>
                                                <div class="box-wrap">
                                                    <div class="box-time">
                                                        <i class="fa-solid fa-clock"></i>
                                                        4 ngày 3 đêm
                                                    </div>
                                                    <div class="box-shedule">
                                                        <i class="fa-solid fa-calendar-days"></i>
                                                        11/02/2024
<%--                                                        ${tourDescription.descriptionTourList.get(0).dateStart}--%>
                                                    </div>
                                                    <div class="box-place">
                                                        <i class="fa-solid fa-user"></i>
                                                        Còn 10 chỗ
                                                    </div>
                                                    <div class="box-discount">
                                                        12,399,000 đ
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="booking-modal">
                                            <!-- The Modal -->
                                            <div class="modal" id="myModal-${tourDescriptionPair.getTour().id}">
                                                <div class="modal-dialog modal-lg" style="max-width: 1000px;">
                                                    <div class="modal-content">

                                                        <!-- Modal Header -->
                                                        <div class="modal-header">
                                                            <h4 class="modal-title">Lịch trình tour du lịch</h4>
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        </div>

                                                        <!-- Modal Body -->
                                                        <div class="modal-body">
                                                            <table class="table">
                                                                <thead>
                                                                <tr>
                                                                    <th scope="col">STT</th>
                                                                    <th scope="col">Ngày khởi hành</th>
                                                                    <th scope="col">Ngày kết thúc</th>
                                                                    <th scope="col">Đặc điểm</th>
                                                                    <th scope="col">Giá từ</th>
                                                                    <th scope="col">Số chỗ</th>
                                                                    <th scope="col">Book tour</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%--   long id, LocalDate dateStart, LocalDate dateEnd, int seat, long price, EStatusTour status, String description, long idTour--%>


                                                                <c:forEach var="descriptionTourItem" items="${tourDescriptionPair.getDescriptionTour()}" varStatus="loopStatus">

                                                                        <tr>
                                                                            <th scope="row">${loopStatus.index + 1}</th>
                                                                            <td>${descriptionTourItem.dateStart}</td>
                                                                            <td>${descriptionTourItem.dateEnd}</td>
                                                                            <td>${descriptionTourItem.description}</td>
                                                                            <td>${descriptionTourItem.price} đ</td>
                                                                            <td>Còn ${descriptionTourItem.seatResidual} chỗ</td>
                                                                            <td>
                                                                                <button type="button" class="btn btn-primary" onclick="showCustomAlert(${descriptionTourItem.id}, ${descriptionTourItem.seatResidual}, ${descriptionTourItem.price})">
                                                                                    Book
                                                                                </button>
                                                                            </td>
                                                                        </tr>

                                                                </c:forEach>


                                                                <!-- Add more rows as needed -->
                                                                </tbody>
                                                            </table>
                                                        </div>

                                                        <!-- Modal Footer -->
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container mt-5">
    <h2>Sample Form</h2>
    <button type="button" class="btn btn-success" onclick="showCustomAlert()">
        Success Button
    </button>
</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<script>
    function showCustomAlert(id, seat, price) {
        Swal.fire({
            title: 'Đặt tour',
            html:
                '<label for="seatPlace">Số chỗ:</label>' +
                '<input type="number" id="seatPlace" class="swal2-input" placeholder="Nhập số chỗ" min="0">' +
                '<label for="type">Hình thức thanh toán:</label>' +
                '<select id="type" class="swal2-input">' +
                '<option value="ONLINE">Online</option>' +
                '<option value="OFFLINE">Thanh toán tại quầy</option>' +
                '</select>',
            showCancelButton: true,
            confirmButtonText: 'Đặt',
        }).then((result) => {
            if (result.isConfirmed) {
                const seatPlace = document.getElementById('seatPlace').value;
                const type = document.getElementById('type').value;

                if(seatPlace <= seat && seatPlace > 0) {
                    window.location.href = "/customer?action=booking&id="+ id + "&seat=" + seatPlace + "&price=" + seat*price + "&pay=" + type + "";
                }
            }
        });
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>

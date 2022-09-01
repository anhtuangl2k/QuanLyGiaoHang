<%-- 
    Document   : header
    Created on : Apr 23, 2022, 3:12:43 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark" style="margin-bottom:10px">
    <!-- Brand -->
    <a class="navbar-brand" href="<c:url value="/"/>"><i class="fas fa-dragon"></i></a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
            </li>

            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Dịch vụ khách hàng
                </a>
                <div class="dropdown-menu" style="background-color: #343a40">
                    <a class="dropdown-item nav-link" href="<c:url value="/order"/>">Đặt đơn hàng</a>
                    <a class="dropdown-item nav-link" href="<c:url value="/order/list"/>">Quản lý đơn hàng</a>                
                </div>
            </li>

            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Dịch vụ shipper
                </a>
                <div class="dropdown-menu" style="background-color: #343a40">
                    <a class="dropdown-item nav-link" href="<c:url value="/register/shipper"/>">Đăng ký shipper</a>
                    <a class="dropdown-item nav-link" href="<c:url value="/shipper/auctions"/>">Đấu giá đơn hàng</a>
                    <a class="dropdown-item nav-link" href="<c:url value="/shipper/received"/>">Đơn hàng đã nhận</a>
                </div>
            </li>
            
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link " href="<c:url value="/admin"/>">Quản trị hệ thống</a>
                </li>
            </sec:authorize>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/signup"/>">Đăng ký</a>
                </li>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">


                        ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                </li>
            </c:if>
        </ul>
    </div>

    <form class="form-inline" action="/action_page.php">
        <input class="form-control mr-sm-2" type="text" placeholder="Tìm kiếm...">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
</nav>

<%-- 
    Document   : adminleft
    Created on : Apr 29, 2022, 1:36:42 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value="/css/adminleft.css"/>"/>

<nav class="navbar">
    <ul class="navbar-nav">
        <li class="text-white text-center"><h2>QUẢN TRỊ</h2></li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/shipper-browse"/>">Duyệt đơn đăng ký shipper</a>
        </li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/shipper-list"/>">Xem danh sách shipper</a>
        </li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/shipper-setting"/>">Cập nhật thông tin shipper</a>
        </li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/statistique"/>">Thống kê đơn hàng</a>
        </li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/order-search"/>">Tra cứu thông tin đơn hàng</a>
        </li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/chart"/>">Biểu đồ tần suất giao hàng của shipper</a>
        </li>
        <hr/>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/chart2"/>">Biểu đồ doanh thu của shipper</a>
        </li>
        <hr/>
    </ul>

</nav>

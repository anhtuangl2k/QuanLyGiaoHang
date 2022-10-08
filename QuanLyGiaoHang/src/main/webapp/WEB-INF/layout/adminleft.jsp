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
            <a class="nav-link text-white" href="<c:url value="/admin/discount"/>">Khuyễn mãi</a>
        </li>
        <hr/>
        
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/browsing-shipper"/>">Duyệt tài khoản shipper</a>
        </li>
        <hr/>
        
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/product"/>">Quản lý sản phẩm</a>
        </li>
        <hr/>
        
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value="/admin/statistic"/>">Thống kê</a>
        </li>
        <hr/>

    </ul>

</nav>

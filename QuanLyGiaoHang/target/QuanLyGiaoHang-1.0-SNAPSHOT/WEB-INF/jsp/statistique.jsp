<%-- 
    Document   : statistique
    Created on : May 4, 2022, 4:26:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">THỐNG KÊ ĐƠN HÀNG</h1>

<hr>
<h4 style="color: red"> THỐNG KÊ ĐƠN HÀNG CHƯA CÓ SHIPPER</h4>
<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Sản phẩm</th>
            <th>Địa chỉ người gửi</th>
            <th>Địa chỉ người nhận</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${stats1.orderDetailCollection}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.nameProduct}</td>
                <td>${s.senderAddress}</td>
                <td>${s.recipientAddress}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br>

<h4 style="color: red">THỐNG KÊ ĐƠN HÀNG ĐÃ CÓ SHIPPER</h4>
<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Sản phẩm</th>
            <th>Địa chỉ người gửi</th>
            <th>Địa chỉ người nhận</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${stats2.orderDetailCollection}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.nameProduct}</td>
                <td>${s.senderAddress}</td>
                <td>${s.recipientAddress}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>



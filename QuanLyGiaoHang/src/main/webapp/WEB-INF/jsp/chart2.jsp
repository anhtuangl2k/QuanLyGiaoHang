<%-- 
    Document   : chart2
    Created on : May 7, 2022, 7:04:22 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">BIỂU ĐỒ DOANH THU</h1>

<div>
    <canvas id="myRevenueChart"></canvas>
</div>

<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Tên shipper</th>
            <th>Doanh thu</th>
            <th>Số đơn hàng</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${chart}" var="c">
            <tr>
                <td>${c[0]}</td>
                <td>${c[1]}</td>
                <td>${c[2]} VNĐ</td>
                <td>${c[3]}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script>
    let labels = [], info = []
    <c:forEach items="${chart}" var="c">
    labels.push('${c[1]}')
    info.push(${c[2]})
    </c:forEach>

    window.onload = function () {
        revenueChart("myRevenueChart", labels, info)
    }
</script>
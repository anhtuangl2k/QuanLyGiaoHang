<%-- 
    Document   : char
    Created on : May 4, 2022, 4:31:40 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">BIỂU ĐỒ TẦN SUẤT GIAO HÀNG</h1>

<div>
    <canvas id="myDeliveryChart"></canvas>
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
    let labels = [], deliveryInfo = []
    
    <c:forEach items="${chart}" var="c">
        labels.push('${c[1]}')
        deliveryInfo.push(${c[3]})
    </c:forEach>

    window.onload = function () {
        deliveryChart("myDeliveryChart", labels, deliveryInfo)
    }
</script>
<%-- 
    Document   : auctions
    Created on : Apr 28, 2022, 3:59:49 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">DANH SÁCH ĐƠN HÀNG ĐANG ĐẤU GIÁ</h1>

<%--
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(count/6)}" var="i">
            <li class="page-item"><a class="page-link" href="<c:url value="/order/list"/>?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>
--%>

<c:forEach var="o" items="${order}">
    <div style="margin-bottom: 15px">
        <a href="<c:url value="/auctions/${o.id}"/>" style="text-decoration: none">
            <div class="card">
                <div class="card-body card bg-secondary text-white">Tên sản phẩm: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &ensp; ${o.nameProduct}</div>
                <div class="card-body" style="color: black">Địa chỉ người gửi: &nbsp;&nbsp;&nbsp;&nbsp; &ensp; ${o.senderAddress}</div>                
                <div class="card-body" style="color: black">Địa chỉ người nhận: &nbsp;&nbsp;&nbsp;&nbsp; ${o.recipientAddress}</div>
            </div>
        </a>
    </div>
</c:forEach>
<%-- 
    Document   : orderdetail
    Created on : Apr 27, 2022, 5:09:14 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">CHI TIẾT ĐƠN HÀNG</h1>

<div class="row" style="margin-bottom: 10px">
    <div class="col-md-2">
        <h6>Tên sản phẩm:</h6>
        <hr>
        <h6>Tên người gửi: </h6>
        <h6>SĐT người gửi: </h6>
        <h6>Địa chỉ người gửi: </h6>
        <hr>
        <h6>Tên người nhận: </h6>
        <h6>SĐT người nhận: </h6>
        <h6>Địa chỉ người nhận: </h6>
    </div>
    <div class="col-md-10">
        <h6>${order.nameProduct}</h6>
        <hr>
        <h6>${order.senderName}</h6>
        <h6>${order.senderPhone}</h6>
        <h6>${order.senderAddress}</h6>
        <hr>
        <h6>${order.recipientName}</h6>
        <h6>${order.recipientPhone}</h6>
        <h6>${order.recipientAddress}</h6>
    </div>
</div>

<hr>
<h4 class="text-ifno">DANH MỤC ĐẤU GIÁ CỦA SHIPPER</h4>
<br>

<c:forEach items="${order.auctionsCollection}" var="auction">
    <h6> &ensp; Tên shipper: &ensp; &ensp; ${auction.shipperId.loginId.fullName}</h6>
    <div class="row" style="margin: 5px">
        <div class="col-md-1" style="padding: 10px">
            <a href="<c:url value="/${auction.shipperId.id}"/>" style="text-decoration: none">
                <img class="rounded-circle img-fluid" src="${auction.loginId.avatar}" />
            </a>
        </div>
        <div class="col-md-2">
            <p>Phí giao hàng: </p>
            <p>Nội dung: </p>
        </div>
        <div class="col-md-7 my-date">           
            <p>${auction.price}</p>
            <p>${auction.content}</p>
            <i>${auction.createdDate}</i>
        </div>
        <div class="col-md-2 my-date">      
            <a style="text-decoration: none" href="#"><input type="submit" class="btn btn-dark" value="Duyệt đấu giá"/></a>
        </div>
    </div>
    <hr>
</c:forEach>

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>
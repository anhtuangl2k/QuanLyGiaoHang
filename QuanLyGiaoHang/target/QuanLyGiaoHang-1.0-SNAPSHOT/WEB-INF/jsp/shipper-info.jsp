<%-- 
    Document   : inforshipper
    Created on : Apr 27, 2022, 1:52:51 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">THÔNG TIN SHIPPER</h1>

<div class="row" style="margin-bottom: 10px">
    <div class="col-md-3">
        <h6>Họ tên:</h6>
        <h6>Số chứng minh thư:</h6>
        <h6>Địa chỉ:  </h6>
        <h6>Email: </h6>
        <h6>Số điện thoại: </h6>
    </div>
    <div class="col-md-9">
        <h6>${s.loginId.fullName}</h6>
        <h6>${s.idCardNumber}</h6>
        <h6>${s.loginId.address}</h6>
        <h6>${s.loginId.email}</h6>
        <h6>${s.loginId.phone}</h6>
    </div>
</div>
<hr>

<h5>ĐÁNH GIÁ CỘNG ĐỒNG</h5>   
<c:forEach items="${s.rateCollection}" var="rate">
    <div class="row" style="margin: 5px">
        <div class="col-md-1" style="padding: 10px">
            <img src="${rate.loginId.avatar}" class="rounded-circle img-fluid"/>
        </div>
        <div class="col-md-2">
            <p>Đánh giá: </p>
            <p>Bình luận: </p>
        </div>  
        <div class="col-md-9 my-date">
            <p>${rate.rating}<span class="fa fa-star checked"></span></p>
            <p>${rate.comment}</p>
            <p>${rate.createdDate}</p>
        </div>        
    </div>
            <hr>
</c:forEach>





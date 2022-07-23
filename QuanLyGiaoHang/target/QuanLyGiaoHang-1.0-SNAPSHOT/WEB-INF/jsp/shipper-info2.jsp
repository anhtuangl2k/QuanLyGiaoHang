<%-- 
    Document   : shipper-info2
    Created on : Apr 30, 2022, 11:23:01 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">THÔNG TIN SHIPPER</h1>

<div class="row" style="margin-bottom: 10px">
    <div class="col-md-2">
        <h6>Họ tên:</h6>
        <h6>Địa chỉ:  </h6>
        <h6>Email: </h6>
        <h6>Số điện thoại: </h6>
    </div>
    <div class="col-md-10">
        <h6>${shipper.loginId.fullName}</h6>
        <h6>${shipper.loginId.address}</h6>
        <h6>${shipper.loginId.email}</h6>
        <h6>${shipper.loginId.phone}</h6>
    </div>
</div>

<hr>
<h4>ĐÁNH GIÁ CỘNG ĐỒNG</h4>
<br>

<c:forEach items="${shipper.rateCollection}" var="r">
    <div class="row" style="margin: 5px">
        <div class="col-md-1" style="padding: 10px">
            <img src="${r.loginId.avatar}" class="rounded-circle img-fluid"/>
        </div>
        <div class="col-md-2">
            <p>Đánh giá: </p>
            <p>Bình luận: </p>
        </div>  
        <div class="col-md-9 my-date">
            <p>${r.rating}<span class="fa fa-star checked"></span></p>
            <p>${r.comment}</p>
            <p>${r.createdDate}</p>
        </div>        
    </div>
    <hr>
</c:forEach>

<form>    
    <div class="form-group">
        <label for="rating" ></label>
        <input type="text"  id="rating" path="rating" class="form-control" placeholder="Đánh giá">
    </div>
    <div class="form-group">
        <label for="comment"></label>
        <textarea id="comment" path="comment" rows="3" class="form-control" placeholder="Nội dung bình luận"></textarea>
    </div>
    <div class="form-group">
        <input type="submit" class="login" onclick="addRate(${shipper.id})" value="Đánh giá"/>
    </div>
</form>

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>

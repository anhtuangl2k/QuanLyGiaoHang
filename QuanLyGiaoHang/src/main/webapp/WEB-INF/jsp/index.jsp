<%-- 
    Document   : index
    Created on : Apr 23, 2022, 3:13:39 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">TRANG CHỦ</h1>

<c:if test="${currentUser != null}">
    <h4>THÔNG TIN NGƯỜI DÙNG</h4>
    <div class="row" style="margin-bottom: 10px">
        <div class="col-md-1" style="padding: 10px">
            <img src="${currentUser.avatar}" class="rounded-circle img-fluid"/>
        </div>
        <div class="col-md-2">
            <h6>Họ tên:</h6>
            <h6>Địa chỉ:  </h6>
            <h6>Email: </h6>
            <h6>Số điện thoại: </h6>
        </div>
        <div class="col-md-9">
            <h6>${currentUser.fullName}</h6>
            <h6>${currentUser.address}</h6>
            <h6>${currentUser.email}</h6>
            <h6>${currentUser.phone}</h6>
        </div>
    </div>
</c:if>


<%-- 
    Document   : register
    Created on : Apr 23, 2022, 3:51:38 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>

<c:url value="/register" var="action"/>

<form:form method="post" action="${action}" modelAttribute="register" 
           enctype="multipart/form-data">
    <div class="form-group">
        <label for="fullName"></label>
        <form:input type="text" id="fullName" path="fullName" class="form-control" placeholder="Họ và tên"/>
        <form:errors path="fullName" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="address"></label>
        <form:input type="text" id="address" path="address" class="form-control" placeholder="Địa chỉ"/>
        <form:errors path="address" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="email"></label>
        <form:input type="text" id="email" path="email" class="form-control" placeholder="Email"/>
        <form:errors path="email" cssClass="text-danger" element="div"/>
        <c:if test="${errEmail != null}">
            <p class="alert-danger">${errEmail}</p>
        </c:if>
    </div>
    <div class="form-group">
        <label for="phone"></label>
        <form:input type="text" id="phone" path="phone" class="form-control" placeholder="Số điện thoại"/>
        <form:errors path="phone" cssClass="text-danger" element="div"/>
        <c:if test="${errPhone != null}">
            <p class="alert-danger">${errPhone}</p>
        </c:if>
    </div>
    <div class="form-group">
        <label for="file"></label>
        <form:input type="file" id="file" path="file" cssClass="form-control" placeholder="Ảnh đại diện" />
        <form:errors path="file" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="username"></label>
        <form:input type="text" id="username" path="username" class="form-control" placeholder="Tên tài khoản"/>
        <form:errors path="username" cssClass="text-danger" element="div"/>
        <c:if test="${errUser != null}">
            <p class="alert-danger">${errUser}</p>
        </c:if>
    </div>
    <div class="form-group">
        <label for="password"></label>
        <form:input type="password" id="password" path="password" class="form-control" placeholder="Mật khẩu"/>
        <form:errors path="password" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword"></label>
        <form:input type="password" id="confirmPassword" path="confirmPassword" class="form-control" placeholder="Xác nhận mật khẩu"/>
        <form:errors path="confirmPassword" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <input type="submit" class="login" value="Đăng Ký"/>
    </div>
</form:form>

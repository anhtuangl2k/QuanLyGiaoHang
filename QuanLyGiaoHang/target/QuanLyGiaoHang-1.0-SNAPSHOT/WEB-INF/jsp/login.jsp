<%--
    Document   : login
    Created on : Apr 23, 2022, 3:35:28 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">ĐĂNG NHẬP</h1>

<c:if test="${param.error !=null}">
    <div class="alert alert-danger">Bạn đã nhập sai tên đăng nhập hoặc mật khẩu!</div>
</c:if>

<c:url value="/login" var="action"/>

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username"></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Tên tài khoản"/>
    </div>
    <div class="form-group">
        <label for="password"></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Mật khẩu"/>
    </div>
    <div class="form-group">
        <input type="submit" class="login" value="Đăng Nhập"/>
    </div>
</form>
<hr />
<a href="<c:url value="/register"/>" class="nav-link text-dark text-center">Bạn chưa có tài khoản? <b>Đăng ký ngay!!!</b></a>
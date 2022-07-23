<%-- 
    Document   : order-search
    Created on : May 4, 2022, 4:29:09 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">TRA CỨU THÔNG TIN ĐƠN HÀNG</h1>

<form action="">
    <div class="form-group">
        <label></label>
        <input type="text" name="kw" class="form-control" placeholder="Nhập từ khoá"/>
    </div>
    <br>
    <input type="submit" class="btn bg-success" value="Tìm kiếm" style="color: white"/>
</form>

<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Sản phẩm</th>
            <th>Ngày đăng</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${stats}" var="s">

            <tr>
                <td>${s.id}</td>
                <td><a href="<c:url value="/admin/order-search/${s.id}" />" style="text-decoration: none">${s.nameProduct}</a></td>
                <td>${s.createdDate}</td> 
            </tr>

        </c:forEach>
    </tbody>
</table>
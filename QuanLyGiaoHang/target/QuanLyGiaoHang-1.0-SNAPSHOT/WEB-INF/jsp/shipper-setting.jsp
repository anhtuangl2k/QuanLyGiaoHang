<%-- 
    Document   : shipper-setting
    Created on : May 4, 2022, 4:16:59 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">CẬP NHẬT THÔNG TIN SHIPPER</h1>

<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Họ tên</th>
            <th>Số chứng minh thư</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${shipper}" var="s">
            <c:if test="${s[7].startsWith('ROLE_SHIPPER')}">
                <tr>
                    <td>${s[5]}</td>
                    <td>${s[1]}</td>
                    <td>${s[0]}</td>
                    <td>${s[4]}</td>
                    <td>${s[3]}</td>
                    <td>${s[2]}</td>
                </tr>            
            </c:if>           
        </c:forEach>
    </tbody>
</table>

<h5>ĐIỀN THÔNG TIN CẬP NHẬT</h5>
<form>
    <div class="form-group">
        <label for="id"></label>
        <input type="hidden" id="id" class="form-control" placeholder="Nhập ID"/>
    </div>
    <div class="form-group">
        <label for="fullName"></label>
        <input type="text" id="fullName"  class="form-control" placeholder="Nhập họ tên"/>
    </div>
    <div class="form-group">
        <label for="idCardNumber"></label>
        <input type="text" id="idCardNumber" class="form-control" placeholder="Nhập họ số chứng minh thư"/>
    </div>
    <div class="form-group">
        <label for="phone"></label>
        <input type="text" id="phone" class="form-control" placeholder="Nhập họ số điện thoại"/>
    </div>
    <div class="form-group">
        <label for="email"></label>
        <input type="text" id="email" class="form-control" placeholder="Nhập họ email"/>
    </div> 
    <div class="form-group">
        <label for="address"></label>
        <input type="text" id="address" class="form-control" placeholder="Nhập họ địa chỉ"/>
    </div> 
    <br>
    <div class="form-group">
        <input type="submit" class="btn btn-dark" value="Cập nhật"/>
    </div>
</form>

<br>
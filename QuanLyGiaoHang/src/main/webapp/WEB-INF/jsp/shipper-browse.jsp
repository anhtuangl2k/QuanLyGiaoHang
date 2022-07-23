<%-- 
    Document   : shipper-browse
    Created on : May 4, 2022, 4:10:18 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">DUYỆT SHIPPER</h1>

<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Họ tên</th>
            <th>Số chứng minh thư</th>
            <th>Trạng thái</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${shipper}" var="s">
            <tr>
                <td>${s[5]}</td>
                <td>${s[1]}</td>
                <td>${s[0]}</td>
                <td style="color: green;"> 
                    <c:if test="${s[7].startsWith('ROLE_SHIPPER')}">
                        Đã duyệt
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<form action="">
    <div class="form-group">
        <label></label>
        <input type="text" name="id" class="form-control" placeholder="Nhập ID người dùng cần duyệt"/>
    </div>
    <br>
    <div class="form-group">
        <input type="submit" value="Duyệt" class="btn btn-dark" />
    </div>
</form>

<%--
<c:url value="/admin/shipper-browse" var="action"/>

<form:form method="post" action="${action}" modelAttribute="login">
    <div class="form-group">
        <label for="id"></label>
        <form:input type="text" id="id" path="id" name="id" cssClass="form-control" placeholder="Nhập ID người dùng cần duyệt"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Duyệt" class="btn btn-dark" />
    </div>
</form:form>
--%>
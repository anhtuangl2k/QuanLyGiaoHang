<%-- 
    Document   : shipper
    Created on : Apr 23, 2022, 4:05:15 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">ĐĂNG KÝ SHIPPER</h1>

<%--<c:if test="${currentUser.userRole.SHIPPER == true}"> --%>
    <c:url value="/register/shipper" var="action"/>
    <form:form method="post" action="${action}" modelAttribute="shipper" enctype="multipart/form-data">
        <div class="form-group">
            <label for="idCardNumber"></label>
            <form:input type="text" id="idCardNumber" path="idCardNumber" cssClass="form-control" placeholder="Nhập số chứng minh nhân dân"/>
        </div>

        <div class="form-group">
            <form:input type="hidden" path="loginId" cssClass="form-control" value="${currentUser.id}"/>
        </div>

        <div class="form-group">
            <input type="submit" value="Đăng Ký" class="btn btn-dark" />
        </div>
    </form:form>
<%--</c:if> --%>

<%--
<c:if test="${currentUser.userRole(Login.SHIPPER) == true}">
    <h3 class="alert alert-success">BẠN ĐÃ ĐĂNG KÝ THÀNH CÔNG</h3>
</c:if>
--%>




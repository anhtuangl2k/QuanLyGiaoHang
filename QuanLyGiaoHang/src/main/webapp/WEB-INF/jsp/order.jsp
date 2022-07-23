<%-- 
    Document   : order
    Created on : Apr 23, 2022, 7:36:49 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">ĐẶT ĐƠN HÀNG</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<c:url value="/order" var="action"/>

<form:form method="post" action="${action}" modelAttribute="order" enctype="multipart/form-data">
    <div class="form-group">
        <label for="nameProduct"></label>
        <form:input type="text" id="nameProduct" path="nameProduct" cssClass="form-control" placeholder="Tên sản phẩm"/>
        <form:errors path="nameProduct" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="senderName"></label>
        <form:input type="text" id="senderName" path="senderName" cssClass="form-control" placeholder="Tên người gửi"/>
        <form:errors path="senderName" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="senderPhone"></label>
        <form:input type="text" id="senderPhone" path="senderPhone" cssClass="form-control" placeholder="Số điện thoại người gửi"/>
        <form:errors path="senderPhone" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="senderAddress"></label>
        <form:input type="text" id="senderAddress" path="senderAddress" cssClass="form-control" placeholder="Địa chỉ người gửi"/>
        <form:errors path="senderAddress" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="recipientName"></label>
        <form:input type="text" id="recipientName" path="recipientName" cssClass="form-control" placeholder="Tên người nhận"/>
        <form:errors path="recipientName" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="recipientPhone"></label>
        <form:input type="text" id="recipientPhone" path="recipientPhone" cssClass="form-control" placeholder="Số điện thoại người nhận"/>
        <form:errors path="recipientPhone" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <label for="recipientAddress"></label>
        <form:input type="text" id="recipientAddress" path="recipientAddress" cssClass="form-control" placeholder="Địa chỉ người nhận"/>
        <form:errors path="recipientAddress" cssClass="text-danger" element="div"/>
    </div>

    <div class="form-group">
        <form:input type="hidden" path="loginId" cssClass="form-control" value="${currentUser.id}"/>
    </div>
        <%--
    <div class="form-group">
        <form:input type="hide" path="orderStatusId" cssClass="form-control" value="1"/>
    </div>
        --%>

     <div class="form-group">
        <input type="submit" value="Đặt đơn" class="btn btn-dark" />
      </div>
</form:form>

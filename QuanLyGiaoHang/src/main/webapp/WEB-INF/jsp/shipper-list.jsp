<%-- 
    Document   : shipper-list
    Created on : Apr 29, 2022, 2:40:13 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">DANH SÁCH SHIPPER</h1>

<c:forEach var="s" items="${shipper}">
    <c:if test="${s[7].startsWith('ROLE_SHIPPER')}">
        <div style="margin-bottom: 15px">
            <a href="<c:url value="/admin/shipper/${s[6]}"/>" style="text-decoration: none">
                <div class="card">
                    <div class="card-body card bg-secondary text-white">Tên shipper: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&ensp; &ensp; ${s[1]}</div>
                    <div class="card-body" style="color: black">Số chứng minh thư: &nbsp;&nbsp;&nbsp;&nbsp; &ensp; ${s[0]}</div>                   
                </div>
            </a>
        </div>
        <hr>
    </c:if>
</c:forEach>



<%-- 
    Document   : header
    Created on : Apr 23, 2022, 3:12:43 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark" style="margin-bottom:10px">
    <!-- Brand -->
    <a class="navbar-brand" href="<c:url value="/"/>"><i class="fas fa-dragon"></i></a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
            </li>

            <!-- Dropdown -->
            <li class="nav-item">
                <a class="nav-link " href="<c:url value="/sell-Product"/>">
                    Mua hàng
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link " href="<c:url value="/order"/>">
                    Đơn hàng
                </a>
            </li>

            
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link " href="<c:url value="/admin"/>">Quản trị hệ thống</a>
                </li>
            </sec:authorize>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/signup"/>">Đăng ký</a>
                </li>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">
                        ${pageContext.request.userPrincipal.name}
                    </a>
                </li>                
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                </li>
                <li>
                    <a href="<c:url value="/cart"/>">
                        <i class="fas fa-cart-plus"></i>
                        <div class="badge badge-danger" id="cartCounter">${cartCounter}</div>
                    </a> 
                </li>
            </c:if>
        </ul>
    </div>

    <form class="form-inline" action="/action_page.php">
        <input class="form-control mr-sm-2" type="text" placeholder="Tìm kiếm...">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
</nav>

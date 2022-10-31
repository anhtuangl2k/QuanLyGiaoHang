<%-- 
    Document   : header
    Created on : Apr 23, 2022, 3:12:43 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- BEGIN TOP BAR -->
<div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>+1 456 6717</span></li>
                    <!-- BEGIN CURRENCIES -->
                    <li class="shop-currencies">
                        <a href="javascript:void(0);">€</a>
                        <a href="javascript:void(0);">£</a>
                        <a href="javascript:void(0);" class="current">$</a>
                    </li>
                    <!-- END CURRENCIES -->
                    <!-- BEGIN LANGS -->
                    <li class="langs-block">
                        <a href="javascript:void(0);" class="current">English </a>
                        <div class="langs-block-others-wrapper"><div class="langs-block-others">
                          <a href="javascript:void(0);">French</a>
                          <a href="javascript:void(0);">Germany</a>
                          <a href="javascript:void(0);">Turkish</a>
                        </div></div>
                    </li>
                    <!-- END LANGS -->
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="<c:url value="/login"/>">Đăng nhập</a></li>
                        <li><a href="<c:url value="/signup"/>">Đăng ký</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li><a href="#">${pageContext.request.userPrincipal.name}</a></li>
                        <li><a href="<c:url value="/logout"/>">Đăng xuất</a></li>
                    </c:if>
                </ul>
            </div>
            <!-- END TOP BAR MENU -->
        </div>
    </div>        
</div>


    <!-- BEGIN HEADER -->
    <div class="header">
      <div class="container">

        <!-- BEGIN CART -->
        <div class="top-cart-block">
          <div class="top-cart-info">
            <a href="<c:url value="/cart"/>" class="top-cart-info-count" id="cartCounter">${cartCounter} items</a>
            <a href="<c:url value="/cart"/>" class="top-cart-info-value"></a>
          </div>
          <a href="<c:url value="/cart"/>"> <i class="fa fa-shopping-cart"></i></a>
                        
                    
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
          <ul>
            <li class="dropdown"><a data-target="#" href="<c:url value="/"/>">Trang chủ</a></li>
            <li class="dropdown"><a data-target="#" href="<c:url value="/sell-Product"/>">Danh sách sản phẩm</a></li>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="dropdown"><a data-target="#" href="<c:url value="/order"/>">Đơn đặt hàng</a></li>
                <li class="dropdown"><a data-target="#" href="<c:url value="/receive"/>">Nhận đơn</a></li>
            </c:if>
            <li class="dropdown"><a data-target="#" href="#">Thông tin của hàng</a></li>
            <!-- BEGIN TOP SEARCH -->
            <li class="menu-search">
              <span class="sep"></span>
              <i class="fa fa-search search-btn"></i>
              <div class="search-box">
                <form action="#">
                  <div class="input-group">
                    <input type="text" placeholder="Search" class="form-control">
                    <span class="input-group-btn">
                      <button class="btn btn-primary" type="submit">Search</button>
                    </span>
                  </div>
                </form>
              </div> 
            </li>
            <!-- END TOP SEARCH -->
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>



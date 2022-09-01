<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/signup" var="action"/>

<c:if test="${successMsg != null}">
    <div class="alert alert-success">${successMsg}</div>
</c:if>
    
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="${action}" modelAttribute="account" enctype="multipart/form-data">
    <div class="modal-body">
        
        <div class="form-group">
              <label for="username">Tên đăng nhập</label>
              <form:input type="text"  path="username" cssClass="form-control"/>
              <form:errors path="username" cssClass="alert alert-danger" element="div" />
          </div>
          
          <div class="form-group">
              <label for="password">Mật khẩu</label>
              <form:input type="password"  path="password" cssClass="form-control"/>
              <form:errors path="password" cssClass="alert alert-danger" element="div" />
          </div>
          
            <div class="form-group">
              <label for="type">Loại tài khoản</label>
              <form:select path="type" cssClass="form-control">
                  <<option value="1">Khách hàng</option>
                  <<option value="2">Shipper</option>
              </form:select>
              <form:errors path="type" cssClass="alert alert-danger" element="div" />
          </div>

          <div class="form-group">
              <label for="name">Họ và tên</label>
              <form:input type="text"  path="name" cssClass="form-control"/>
              <form:errors path="name" cssClass="alert alert-danger" element="div" />
          </div>
          
          <div class="form-group">
              <label for="address">Địa chỉ</label>
              <form:input type="text"  path="address" cssClass="form-control"/>
              <form:errors path="address" cssClass="alert alert-danger" element="div" />
          </div>
          
          <div class="form-group">
              <label for="cphone">Số điện thoại</label>
              <form:input type="text"  path="phone" cssClass="form-control"/>
              <form:errors path="phone" cssClass="alert alert-danger" element="div" />
          </div>
          
          <div class="form-group">
              <label for="content">Gmail</label>
              <form:input type="email"  path="gmail" cssClass="form-control"/>
              <form:errors path="gmail" cssClass="alert alert-danger" element="div" />
          </div>
          
          <div class="form-group">
              <label for="cmnd">Chứng minh nhân dân</label>
              <form:input type="text"  path="cmnd" cssClass="form-control"/>
              <form:errors path="cmnd" cssClass="alert alert-danger" element="div" />
          </div>
          
          <div class="form-group">
              <label for="content">Avatar</label>
              <form:input type="file"  path="file" cssClass="form-control"/>
              <form:errors path="file" cssClass="alert alert-danger" element="div" />
          </div>

    </div>
    <div class="modal-footer">
      <input type="submit" value="Đăng kí" class="btn btn-primary"/>
    </div>
</form:form>
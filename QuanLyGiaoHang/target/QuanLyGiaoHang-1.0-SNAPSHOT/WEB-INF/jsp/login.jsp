<%-- 
    Document   : login
    Created on : Jul 26, 2022, 2:21:52 PM
    Author     : anhtu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/login" var="action"/>
<h1>Đăng nhập</h1>
<c:if test="${param.error != null}l">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra!
    </div>
</c:if>
<c:if test="${param.accessDenied != null}l">
    <div class="alert alert-danger">
        Bạn ko có quyền truy cập
    </div>
</c:if>

<form method="post" action="${action}">
  <!-- Email input -->
  <div class="form-outline mb-4">
      <input type="text" id="username" name="username" class="form-control" />
    <label class="form-label" for="username">Username</label>
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
      <input type="password" id="password" name="password" class="form-control" />
    <label class="form-label" for="password">Password</label>
  </div>

  <!-- Submit button -->
  <input type="submit" class="btn btn-primary btn-block mb-4" value="Sign in"/>


</form>
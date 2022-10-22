<%-- 
    Document   : login
    Created on : Jul 26, 2022, 2:21:52 PM
    Author     : anhtu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/login" var="action"/>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="<c:url value="/css/styleLogin.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/styleIconLogin.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.login.css"/>">

    <title>Đăng nhập</title>
  </head>
  <body>
  

  
  <div class="content">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-12">
              <div class="form-block">
                  <div class="mb-4">
                  <h3><strong>ĐĂNG NHẬP</strong></h3>
                </div>
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
                  <div class="form-group first">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username">

                  </div>
                  <div class="form-group last mb-4">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                    
                  </div>
                  
                  <input type="submit" value="Log In" class="btn btn-pill text-white btn-block btn-primary">

                  <span class="d-block text-center my-4 text-muted"> or sign in with</span>
                  
                  <div class="social-login text-center">
                    <a href="#" class="facebook">
                      <span class="icon-facebook mr-3"></span> 
                    </a>
                    <a href="#" class="twitter">
                      <span class="icon-twitter mr-3"></span> 
                    </a>
                    <a href="#" class="google">
                      <span class="icon-google mr-3"></span> 
                    </a>
                  </div>
                </form>
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>
  </body>
</html>

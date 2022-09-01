<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/product" var="action"/>
<c:if test="${successMsg != null}">
    <div class="alert alert-success">${successMsg}</div>
</c:if>
    
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter1">
  Thêm sản phẩm
</button>

<!-- Modal Add -->
<div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
            <div class="modal-body">

                  <div class="form-group">
                      <label for="content">Tên sản phẩm</label>
                      <form:input type="text"  path="name" cssClass="form-control"/>
                      <form:errors path="name" cssClass="alert alert-danger" element="div" />
                  </div>

                  <div class="form-group">
                      <label for="moneyReduce">Số tiền</label>
                      <form:input type="number" path="price" cssClass="form-control"/>
                      <form:errors path="price" cssClass="alert alert-danger" element="div" />
                  </div>
                  
                  <div class="form-group">
                      <label for="moneyReduce">Số lượng</label>
                      <form:input type="number" path="amount" cssClass="form-control"/>
                      <form:errors path="amount" cssClass="alert alert-danger" element="div" />
                  </div>
                  
                <div class="form-group">
                  <label for="content">Ảnh</label>
                  <form:input type="file"  path="file" cssClass="form-control"/>
                  <form:errors path="file" cssClass="alert alert-danger" element="div" />
              </div>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <input type="submit" value="Thêm sản phẩm" class="btn btn-primary"/>
            </div>
        </form:form>
    </div>
  </div>
</div> 


<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Tên sản phẩm</th>
      <th scope="col">Giá tiền</th>
      <th scope="col">Số lượng còn lại</th>
      <th scope="col">Sửa</th>
      <th scope="col">Xóa</th>
    </tr>
  </thead>
  <tbody>

  </tbody>
</table>

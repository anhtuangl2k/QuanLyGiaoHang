<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/discount" var="action"/>

<c:if test="${successMsg != null}">
    <div class="alert alert-success">${successMsg}</div>
</c:if>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter1">
  Thêm khuyến mãi
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
        <form:form method="post" action="${action}" modelAttribute="discount">
            <div class="modal-body">

                  <div class="form-group">
                      <label for="content">Chương trình khuyến mãi</label>
                      <form:input type="text"  path="content" cssClass="form-control"/>
                      <form:errors path="content" cssClass="alert alert-danger" element="div" />
                  </div>

                  <div class="form-group">
                      <label for="moneyReduce">Số tiền khuyến mãi</label>
                      <form:input type="number" path="moneyReduce" cssClass="form-control"/>
                      <form:errors path="moneyReduce" cssClass="alert alert-danger" element="div" />
                  </div>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <input type="submit" value="Thêm khuyến mãi" class="btn btn-primary"/>
            </div>
        </form:form>
    </div>
  </div>
</div> 




<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Chương trình khuyễn mãi</th>
      <th scope="col">CODE</th>
      <th scope="col">Số tiền giảm</th>
      <th scope="col">Sửa</th>
      <th scope="col">Xóa</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="discount" items="${discounts}">
        <tr>
          <th scope="row">${discount.id}</th>
          <td>${discount.content}</td>
          <td>${discount.code}</td>
          <td>${discount.moneyReduce}</td>
          <td><button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#exampleModalCenter2" onclick="getDiscount(${discount.id})">Sửa</button></td>
          <td><button type="button" class="btn btn-danger" data-dismiss="modal" >Xóa</button></td>
        </tr>
      </c:forEach>
  </tbody>
</table>

<!-- Pagination -->
<nav aria-label="Page navigation example">
    <ul class="pagination">
      <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">
          <li class="page-item"><a class="page-link" href="<c:url value="/admin/discount"/>?page=${i} ">${i}</a></li>
      </c:forEach> 
  </ul>
</nav>
    
<!-- Modal Update -->
<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle2" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form>
            <div class="modal-body">

                  <div class="form-group">
                      <label for="content">Chương trình khuyến mãi</label>
                      <input type="text" id="contentUpdate"  class="form-control"/>
                  </div>

                  <div class="form-group">
                      <label for="moneyReduce">Số tiền khuyến mãi</label>
                      <input type="number" id="moneyReduceUpdate"  class="form-control"/>
                  </div>

                  <div class="form-group">
                      
                  </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <input type="submit" value="Thêm khuyến mãi" class="btn btn-primary"/>
            </div>
        </form>
    </div>
  </div>
</div> 

<script src="<c:url value="/js/discount.js"/>"></script>
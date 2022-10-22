<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content-wrapper">
    <section class="content">
        <div class="card-body">
                <c:if test="${successMsg != null}">
    <div class="alert alert-success">${successMsg}</div>
</c:if>

<table class="table table-hover">
    <thead>
      <tr>
        <th scope="col">Tên shipper</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Gmail</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">CMND</th>
        <th scope="col">Duyệt đơn</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var="account" items="${accountShipper}">
        <tr>
          <th scope="row">${account.name}</th>
          <td>${account.address}</td>
          <td>${account.gmail}</td>
          <td>${account.phone}</td>
          <td>${account.cmnd}</td>
          <td><button type="button" class="btn btn-success" data-dismiss="modal">  <a style="color: black" href="<c:url value="/admin/changeStatus/${account.id}"/>">Duyệt</a></button></td>
        </tr>

        </c:forEach>
       
    </tbody>
</table>
        </div>
    </section>

</div>

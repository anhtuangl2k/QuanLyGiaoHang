<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/sell-Product" var="action"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Mã hóa đơn</th>
      <th scope="col">Ngày đặt</th>
      <th scope="col">Thành tiền</th>
      <th scope="col">Tình trạng</th>
      <th scope="col">Xem chi tiết</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="r" items="${receipts}">
        <tr>
          <th scope="row">${r.id}</th>
          <td>${r.dateTime}</td>
          <td>${r.amount}</td>
          <td>${r.status}</td>
          <td><button type="button" class="btn btn-danger" data-dismiss="modal" >Xem chi tiết</button></td>
        </tr>
    </c:forEach>
  </tbody>
</table>


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
          <c:if test="${r.status == 0}">
              <td style="color: red">Chưa giao</td>
          </c:if>
        <c:if test="${r.status == 1}">
            <td>Đang giao</td>
          </c:if>
        <c:if test="${r.status == 2}">
            <td style="color: green">Giao thành công</td>
          </c:if>
          <td>
              <a href="<c:url value="/orderdetail?id=${r.id}"/>"><button type="button" class="btn btn-danger" data-dismiss="modal" >Xem chi tiết</button></a>
          </td>
        </tr>
    </c:forEach>
  </tbody>
</table>


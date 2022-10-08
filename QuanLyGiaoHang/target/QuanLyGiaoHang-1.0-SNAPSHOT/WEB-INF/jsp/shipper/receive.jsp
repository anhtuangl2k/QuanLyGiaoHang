<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${successMsg != null}">
    <div class="alert alert-success">${successMsg}</div>
</c:if>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Mã hóa đơn</th>
      <th scope="col">Ngày đặt</th>
      <th scope="col">Thành tiền</th>
      <th scope="col">Trạng thái</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="r" items="${receipts}">
        <tr>
          <th scope="row">${r.id}</th>
          <td>${r.dateTime}</td>
          <td>${r.amount}</td>
          <c:if test="${r.status == 0}">
              <td> <button type="button" class="btn btn-danger" data-dismiss="modal" id="receive${r.id}" onclick="changeStatusReceipt(${r.id})">Nhận đơn</button></td>
          </c:if>
            <c:if test="${r.status == 1}">
              <td><a href="""> <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="changeStatusReceipt(${r.id})" >Đã giao</button></a></td>
          </c:if>
        <c:if test="${r.status == 2}">
              <td>Giao thành công</td>
          </c:if>
        </tr>
    </c:forEach>
  </tbody>
</table>



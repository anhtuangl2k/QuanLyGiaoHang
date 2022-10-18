<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-dark">GIỎ HÀNG </h1>

<c:if test="${carts == null}">
    <h4 class="text-danger">Không có sản phẩm nào trong giỏ</h4>
</c:if>
    
<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
        </tr>
        <c:forEach items="${carts}" var="c">
            <tr id="product${c.productId}">
                <th>${c.productId}</th>
                <th>${c.productName}</th>
                <th>
                    <div class="form-group">
                        <input type="number" value="${c.quantity}" onblur="updateCart(this, ${c.productId})" class="form-control"/>
                    </div>
                </th>
                <th>${c.price}</th>
                <th>
                    <input type="button" 
                           value="Xóa" 
                           onclick="deleteCart(${c.productId})"
                           class="btn btn-danger"/>
                </th>
            </tr>

        </c:forEach>
    </table>
<form action="">
    <div class="input-group mb-3">
      <input type="text" class="form-control" placeholder="Nhập khuyến mãi" name="discount"  aria-describedby="basic-addon2">
      <div class="input-group-append">
          <input type="submit" value="Chọn" class="btn-primary">
      </div>
    </div>
</form>
    
<c:if test="${msg != null}">
    <h6 class="text-danger">${msg}</h6>
</c:if>
    
    <div>
        <h4 class="text-info">Tổng tiền hóa đơn: <span id="amountCart">${cartStats.amount}</span></h4>
    </div>
        <button class="btn btn-danger"><a href="<c:url value="/payment"/>">Thanh toán</a></button>
</c:if>

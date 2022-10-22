<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${carts == null}">
    <h4 class="text-danger">Không có sản phẩm nào trong giỏ</h4>
</c:if>
<c:if test="${carts != null}">
 <div class="row margin-bottom-40">
          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <h1>Shopping cart</h1>
            <div class="goods-page">
              <div class="goods-data clearfix">
                <div class="table-wrapper-responsive">
                <table summary="Shopping cart">
                  <tr>
                    <th class="goods-page-image">Image</th>
                    <th class="goods-page-description">Description</th>

                    <th class="goods-page-quantity">Quantity</th>
                    <th class="goods-page-price">Unit price</th>
                  </tr>
                  <c:forEach items="${carts}" var="c">
                      <tr id="product${c.productId}">
                    <td class="goods-page-image">
                      <a href="javascript:;"><img src="${c.image}" alt="Berry Lace Dress"></a>
                    </td>
                    <td class="goods-page-description">
                      <h3>${c.productName}</h3>
                    </td>
                    <td class="goods-page-quantity">
                      <div class="product-quantity">
                          <input type="number" value="${c.quantity}" onblur="updateCart(this, ${c.productId})" class="form-control"/>
                      </div>
                    </td>
                    <td class="goods-page-price">
                      <strong><span></span>${c.price}</strong>
                    </td>
                    <td class="del-goods-col">
                      <a class="del-goods" onclick="deleteCart(${c.productId})">&nbsp;</a>
                    </td>
                  </tr>
                  </c:forEach>              
                </table>
                </div>
                <div class="shopping-total">
                  <ul>
                    <li class="shopping-total-price">
                      <em>Total</em>
                      <strong class="price"><span>${cartStats.amount}</span></strong>
                    </li>
                  </ul>
                </div>
              </div>
                <form action="">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Nhập khuyến mãi" name="discount"  aria-describedby="basic-addon2" style="z-index: -999">
                    <input type="submit" value="Chọn" class="btn-primary" style="z-index: 999; margin: -33px 0 10px 0;height: 32px;width: 50px;">
                </div>
                </form>
                <c:if test="${msg != null}">
                    <h6 class="text-danger">${msg}</h6>
                </c:if>
              <button class="btn btn-default" type="submit">Continue shopping <i class="fa fa-shopping-cart"></i></button>
              <button class="btn btn-primary" type="submit"><a href="<c:url value="/payment"/>" style="color: black">Checkout</a> <i class="fa fa-check"></i></button>
            </div>
          </div>
          <!-- END CONTENT -->
</div>

</c:if>


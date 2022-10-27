<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <c:forEach items="${list}" var="c">
                <tr>
              <td class="goods-page-image">
                <a href="javascript:;"><img src="<c:out value="${c.productID.image}"/>" alt="Berry Lace Dress"></a>
              </td>
              <td class="goods-page-description">
                <h3><c:out value="${c.productID.name}"/></h3>
              </td>
              <td class="goods-page-quantity">
                <div class="product-quantity">
                    <input type="number" value="${c.quantity}"  class="form-control"/>
                </div>
              </td>
              <td class="goods-page-price">
                <strong><span>${c.price}</span></strong>
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

      </div>
    </div>
</div>
        
        
<form class="form-group">  
    <textarea class="form-control" placeholder="Nhập bình luận" id="commentID"></textarea>
    <br>
    <input type="submit" value="Gửi bình luận" class="btn btn-danger" onclick="addComment(${receipt.id})"/>
</form>

<div id="commentArea">
    <c:forEach items="${receipt.commentCollection}" var="r">
        <div class="row">
            <div class="col-md-3">
                <img class="rounded-circle" src="" />
            </div>
            <div class="col-md-10 mydate">
                <p>${r.content}</p>
                <i>${r.dateTime}</i>
            </div>
        </div>
    </c:forEach>
</div>


<script>
    window.onload() = function (){
        let dates = document.querySelectorAll(".mydate > i");
            for(let i =0; i< dates.length; i++){
                let d = dates[i]
                d.innerText = moment(d.innerText).fromNow();
            }
    }


</script>
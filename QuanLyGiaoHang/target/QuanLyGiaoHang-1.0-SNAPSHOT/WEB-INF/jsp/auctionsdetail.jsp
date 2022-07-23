<%-- 
    Document   : auctionsdetail
    Created on : Apr 28, 2022, 4:51:54 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">ĐẤU GIÁ ĐƠN HÀNG</h1>

<div class="row" style="margin-bottom: 10px">
    <div class="col-md-2">
        <h6>Tên sản phẩm:</h6>
        <hr>
        <h6>Tên người gửi: </h6>
        <h6>SĐT người gửi: </h6>
        <h6>Địa chỉ người gửi: </h6>
        <hr>
        <h6>Tên người nhận: </h6>
        <h6>SĐT người nhận: </h6>
        <h6>Địa chỉ người nhận: </h6>
    </div>
    <div class="col-md-10">
        <h6>${order.nameProduct}</h6>
        <hr>
        <h6>${order.senderName}</h6>
        <h6>${order.senderPhone}</h6>
        <h6>${order.senderAddress}</h6>
        <hr>
        <h6>${order.recipientName}</h6>
        <h6>${order.recipientPhone}</h6>
        <h6>${order.recipientAddress}</h6>
    </div>
</div>

<hr>    
<h3>ĐẤU GIÁ</h3>
<br>


<div id="auctionsArea">
    <c:forEach items="${order.auctionsCollection}" var="auction">
        <div class="row" style="margin: 5px">
            <div class="col-md-1" style="padding: 10px">
                <img class="rounded-circle img-fluid" src="<c:url value="${auction.loginId.avatar}"/>" />
            </div>
            <div class="col-md-2">
                <p>Phí giao hàng: </p>
                <p>Nội dung: </p>
            </div>
            <div class="col-md-9 my-date">           
                <p>${auction.price}</p>
                <p>${auction.content}</p>
                <i>${auction.createdDate}</i>
            </div>
        </div>
            <hr>
    </c:forEach>
</div>



<form>
    <div class="form-group">
        <label for="price"></label>
        <input type="text" id="price" path="price" class="form-control" placeholder="Nhập số tiền đấu giá"/>
    </div>
    <div class="form-group">
        <label for="content"></label>
        <textarea id="content" path="content" rows="3" class="form-control" placeholder="Nội dung"></textarea>
    </div>
    <div class="form-group">
        <input type="submit" class="login" onclick="addAuctions(${order.id})" value="Đấu giá"/>
    </div>
</form>




<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>
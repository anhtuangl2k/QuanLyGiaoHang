/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addAuctions(orderId) {
    fetch("/QuanLyGiaoHang/api/add-auctions", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("content").value,
            "price": document.getElementById("price").value,
            "orderId": orderId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)

        return res.json();
    }).then(function (data) {
        console.info(data);
        
        let area = document.getElementById("auctionsArea");
        
        area.innerHTML = `
            <div class="row" style="margin: 5px">
                <div class="col-md-1" style="padding: 10px">
                    <img class="rounded-circle img-fluid" src="<c:url value="${data.loginId.avatar}"/>" />
                </div>
                <div class="col-md-2">
                    <p>Phí giao hàng: </p>
                    <p>Nội dung: </p>
                </div>
                <div class="col-md-9 my-date">           
                    <p>${data.price}</p>
                    <p>${data.content}</p>
                    <i>${moment(data.createdDate).fromNow()}</i>
                </div>
            </div>
        ` + area.innerHTML
    })
}

function addRate(shipperId) {
    fetch("/QuanLyGiaoHang/api/add-rate", {
        method: 'post',
        body: JSON.stringify({
            "comment": document.getElementById("comment").value,
            "rating": document.getElementById("rating").value,
            "orderId": shipperId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)

        return res.json();
    }).then(function (data) {
        console.info(data);
    })
}


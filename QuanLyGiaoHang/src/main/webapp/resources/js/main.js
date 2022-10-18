/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addToCart(id, name, price){
    event.preventDefault();
    fetch("/QuanLyGiaoHang/api/cart", {
        method: 'post',
        body : JSON.stringify({
            "productId": id,
            "productName": name , 
            "price": price,
            "quantity": 1 
        }),
        headers: {
            "Content-Type" : "application/json"
        }
    }).then(function (res){
        return res.json();
    }).then (function  (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
}

function updateCart(obj, productId){
    fetch("/QuanLyGiaoHang/api/cart", {
        method: 'put',
        body : JSON.stringify({
            "productId": productId,
            "productName": "", 
            "price": "",
            "quantity": obj.value 
        }),
        headers: {
            "Content-Type" : "application/json"
        }
        }).then(function (res){
            return res.json();
        }).then(function (data){
            let counter = document.getElementById("cartCounter");
            counter.innerText = data.counter;
            let amount = document.getElementById("amountCart");
            amount.innerText = data.amount;
    });
}


function deleteCart(productId){
    fetch(`/QuanLyGiaoHang/api/cart/${productId}`, {
    method: 'delete'
    }).then(function (res){
        return res.json();
    }).then(function (data){
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount;
        let row = document.getElementById(`product${productId}`);
        row.style.display = "none";
    });
}

function changeStatusReceipt(id){
    fetch(`/QuanLyGiaoHang/changeStatusReceipt/${id}`, {
        method: 'get'
        }).then(function (res){
            location.reload();
            return res.json();
        });
}

function getProduct(productId){
    fetch(`/QuanLyGiaoHang/api/product/${productId}`, {
    method: 'get'
    }).then(function (res){
        return res.json();
    }).then(function (data){
        let id = document.getElementById("idProduct");
        id.value = data.id;
        let name = document.getElementById("nameProduct");
        name.value = data.name;
        let price = document.getElementById("priceProduct");
        price.value = data.price;
        let amount = document.getElementById("amountProduct");
        amount.value = data.amount;
    });
}

function addComment(receiptID){
    fetch("/QuanLyGiaoHang/api/add-comment", {
        method: 'post',
        body : JSON.stringify({
            "content" : document.getElementById("commentID").value,
            "receiptID" : receiptID
        }),
        headers: {
            "Content-Type" : "application/json"
        }
    }).then(function (res){
        return res.json();
    }).then (function  (data) {
        let area = document.getElementById("commentArea");
        area.innerHTML = `
            <div class="row">
                <div class="col-md-3">
                    <img class="rounded-circle" src="" />
                </div>
                <div class="col-md-10 mydate">
                    <p>${data.content}</p>
                    <i>${moment(data.dateTime).fromNow()}</i>
                </div>
            </div>
    ` + area.innerHTML  ;
    });
}
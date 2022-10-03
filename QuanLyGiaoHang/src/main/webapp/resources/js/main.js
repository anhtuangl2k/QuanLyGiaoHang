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

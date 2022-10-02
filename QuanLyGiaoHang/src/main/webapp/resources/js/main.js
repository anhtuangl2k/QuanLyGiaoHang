/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addToCart(id, name, price){
    console.log("oke");
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


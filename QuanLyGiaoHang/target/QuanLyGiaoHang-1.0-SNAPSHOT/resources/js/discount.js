/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//$("#moneyReduce").keyup(function(){
//    let num = $("#moneyReduce").val();
//    $("#moneyReduce").val(numberWithCommas(num));
//})
function getDiscount(id){
    fetch("/QuanLyGiaoHang/api/getDiscount/" + id).then(res => res.json().then(data =>{
    $('#contentUpdate').val(data.content);
    $('#moneyReduceUpdate').val(data.moneyReduce);
}))
}

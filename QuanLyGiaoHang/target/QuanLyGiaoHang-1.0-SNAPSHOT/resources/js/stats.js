/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);

    return `rgb(${r}, ${g}, ${b})`
}

function revenueChart(id, labels = [], info = []) {
    let colors = []
    for(let i=0; i<info.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: labels,
        datasets: [{
                label: 'Thống kê doanh thu shipper',
                data: info,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'bar',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d")

    new Chart(ctx, config)
}

function deliveryChart(id, labels = [], deliveryInfo = []) {
    let colors = []
    for(let i=0; i<deliveryInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: labels,
        datasets: [{
                label: 'Thống kê doanh thu shipper',
                data: deliveryInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'bar',
        data: data,
    };

    let ctx = document.getElementById(id).getContext("2d")

    new Chart(ctx, config)
}

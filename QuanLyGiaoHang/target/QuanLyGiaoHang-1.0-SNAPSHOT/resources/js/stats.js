
function generateColor(){
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);
    return `rgb(${r}, ${g}, ${b})`;
}

function productChart(id, productLabels = [], productInfo = []){
    let colors = [];
    for(let i = 0; i < productInfo.length; i++)
        colors.push(generateColor());
    
    const  data = {
        labels: productLabels,
        datasets : [{
            label : 'Thống kê doanh thu theo sản phẩm',
            data : productInfo,
            backgroundColor: colors,
            hoverOffset: 4
        }]
    };
    
    const config = {
        type : 'line',
        data : data,
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    console.log("oke");
    new Chart(ctx, config);   
}

function productMonthChart(id, productLabels = [], productInfo = []){
    let colors = [];
    for(let i = 0; i < productInfo.length; i++)
        colors.push(generateColor());
    
    const  data = {
        labels: productLabels,
        datasets : [{
            label : 'Thống kê doanh thu theo tháng',
            data : productInfo,
            backgroundColor: colors,
            hoverOffset: 4
        }]
    };
    
    const config = {
        type : 'bar',
        data : data,
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    console.log("oke");
    new Chart(ctx, config);
    
}

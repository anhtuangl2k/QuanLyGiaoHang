<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content-wrapper">
    <section class="content">
        <div class="card-body">
            <h1>THỐNG KÊ DOANH THU THEO SẢN PHẨM</h1>
            <form action="">
    <div class="form-group">
        <label>Từ khóa</label>
        <input type="text" name="kw" class="form-control" />
    </div>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    <input type="submit" value="Báo cáo" class="btn btn-success" />
</form>


<div>
    <canvas id="myProductStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${productStats}" var="p">
        <tr>
            <td>${p[0]}</td>
            <td>${p[1]}</td>
            <td>${p[2]}VND</td>
        </tr>
        
    </c:forEach>
</table>
        </div>
    </section>

</div>


<script>
    let productLabels = [], productInfo = [];
    
    <c:forEach items="${productStats}" var="p">
        productLabels.push('${p[1]}');
        productInfo.push(${p[2]});
    </c:forEach>
    
    window.onload = function (){
        productChart("myProductStatsChart", productLabels, productInfo);
    }
</script>
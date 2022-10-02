<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/sell-Product" var="action"/>

<form action="">
<div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Search" name="kw" aria-label="Recipient's username" aria-describedby="basic-addon2">
  <div class="input-group-append">
      <input type="submit" value="Search" class="btn-primary">
  </div>
</div>
</form>

<div class="row">
    <c:forEach var="p" items="${products}">
        <div class="card col-md-4" >

            <div class="card-body">
                <img class="card-img-top" src="${p.image}" alt="Card image cap">
            </div>
            <div class="card-footer">
                <h5 class="card-title">${p.name}</h5>
                <p class="card-text">${p.price}</p>
                <a class="btn btn-primary" onclick="addToCart(${p.id}, '${p.name}', ${p.price})">Mua</a>
            </div>
        </div>
    </c:forEach>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination">
      <c:forEach begin="1" end="${Math.ceil(counter/12)}" var="i">
          <li class="page-item"><a class="page-link" href="<c:url value="/sell-Product"/>?page=${i}">${i}</a></li>
      </c:forEach>

  </ul>
</nav>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/sell-Product" var="action"/>

 <div class="main">
      <div class="container">

        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">

            <!-- BEGIN PRODUCT LIST -->
            <div class="row product-list">
              <!-- PRODUCT ITEM START -->
              <c:forEach var="p" items="${products}">
              <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="product-item">
                  <div class="pi-img-wrapper">
                      <img src="${p.image}" class="img-responsive" style="height: 200px !important" alt="Berry Lace Dress">

                  </div>
                  <h3><a href="shop-item.html">${p.name}</a></h3>
                  <div class="pi-price">${p.price}</div>
                  <a href="javascript:;" class="btn btn-default add2cart" onclick="addToCart(${p.id}, '${p.name}', ${p.price}, '${p.image}')">Add to cart</a>
                </div>
              </div>
                </c:forEach>
              <!-- PRODUCT ITEM END -->

            </div>
            <!-- END PRODUCT LIST -->
            <!-- BEGIN PAGINATOR -->
            <div class="row">
              <div class="col-md-8 col-sm-8">
                <ul class="pagination pull-right">
                    <c:forEach begin="1" end="${Math.ceil(counter/12)}" var="i">
                         <li><a href="<c:url value="/sell-Product"/>?page=${i}">${i}</a></li>
                    </c:forEach>
                </ul>
              </div>
            </div>
            <!-- END PAGINATOR -->
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>

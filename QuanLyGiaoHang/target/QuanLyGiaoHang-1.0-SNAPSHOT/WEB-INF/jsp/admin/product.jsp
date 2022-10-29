<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/product" var="action"/>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <!--Content-wrapper-->
        <div class="content-wrapper">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Tour Manage</h1>
                        </div>

                        <!-- Search -->
                        <div class="col-sm-5">
                            <form>
                                <div class="input-group input-group-sm">
                                    <input class="form-control form-control-navbar" name="kw" type="search" placeholder="Search" aria-label="Search" >
                                    <div class="input-group-append">
                                        <button class="btn btn-navbar" type="submit">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div >
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal-lg-add">Add Product</button>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->

                <c:if test="${errMsg != null}">
                    <div class="alert alert-danger">${errMsg}</div>
                </c:if>
                <c:if test="${successMsg != null}">
                    <div class="alert alert-success">${successMsg}</div>
                </c:if>
            </section>


 <!-- ======================================form add========================================== -->
            <div class="modal fade" id="modal-lg-add">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Sản phẩm</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <form:input type="text" class="form-control" path="name" placeholder="Tour name"/>
                                    <form:errors path="name" cssClass="text-danger" element="div"/>
                                </div>
                                <div class="form-group">
                                    <label for="name">Price</label>
                                    <form:input path="price" type="number" class="form-control" placeholder="Price"/>
                                    <form:errors path="price" cssClass="text-danger" element="div"/>
                                </div>
                                <div class="form-group">
                                    <label for="meetingplace">Amount</label>
                                    <form:input path="amount" type="number" class="form-control"  placeholder="Amount"/>
                                    <form:errors path="amount" cssClass="alert alert-danger" element="div"/>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">File input</label>
                                    <div class="input-group">
                                        <div class="custom-file">
                                            <form:input type="file" class="custom-file-input" id="exampleInputFile" path="file" />
                                            <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="modal-footer justify-content-between">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <input type="submit" class="btn btn-primary" value="Save"/>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <!-- ======================================form update========================================== -->
            <div class="modal fade" id="modal-lg">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Update Tour</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <form action="">
                                <input type="hidden" name="id" id="idProduct" class="form-control" />
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" name="name" id="nameProduct"/>
                                </div>
                                <div class="form-group">
                                    <label for="name">Price</label>
                                    <input type="number" class="form-control" name="price" id="priceProduct"/>
                                </div>
                                <div class="form-group">
                                    <label for="meetingplace">Amount</label>
                                    <input type="number" class="form-control"  name="amount" id="amountProduct"/>
                                </div>

                            </form> 

                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <input type="submit" value="Cập nhật" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
            </div>

            <!-- ======================================table========================================== -->
              <section class="content">
                <div class="card-body">
                    <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                        <div class="row">
                            <div class="col-sm-12 col-md-6"></div>
                            <div class="col-sm-12 col-md-6"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="example2" class="table table-bordered table-hover dataTable" role="grid"
                                       aria-describedby="example2_info">
                                    <thead>
                                        <tr role="row">
                                            <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1">
                                                Image</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1">
                                                Tên sản phẩm</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1">
                                                Giá tiền</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1">
                                                Số lượng</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1">
                                                Delete</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1">
                                                Update</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach  var="p" items="${products}">
                                            <tr role="row" class="odd">
                                                <td><img src="${p.image}" height="50px" width="70px"/></td>
                                                <td>${p.name}</td>
                                                <td>${p.price}</td>
                                                <td>${t.amount}</td>
                                                <td style="padding: 5px">
                                                    <a href="<c:url value="/admin/deleteProduct"/>?id=${p.id}">
                                                    <button type="button"
                                                            class="btn btn-block bg-gradient-danger">Delete</button>
                                                    </a>
                                                </td>
                                                <td style="padding: 5px">
                                                    <button type="button"
                                                            class="btn btn-block bg-gradient-primary" onclick="getProduct(${p.id})" data-toggle="modal" data-target="#modal-lg">Update</button>
                                                </td>

                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 col-md-5">
                                <div class="dataTables_info" id="example2_info" role="status" aria-live="polite"></div>
                            </div>
                            <div class="col-sm-12 col-md-7">
                                <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                    <ul class="pagination">



                                        <c:forEach begin="1" end="${Math.ceil(counter/12)}" var="i">   
                                            <li class="paginate_button page-item active" ><a class="page-link" href="<c:url value="/admin/product"/>?page=${i}">${i}</a></li>                                            
                                            </c:forEach>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
          
    </body>
</html>
    
    
    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/discount" var="action"/>

<c:if test="${successMsg != null}">
    <div class="alert alert-success">${successMsg}</div>
</c:if>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>MÃ KHUYẾN MÃI</h1>
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
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal-lg-add">Add Discount</button>
                </div>

            </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- ======================================form add========================================== -->
    <div class="modal fade" id="modal-lg-add">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Discount</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="${action}" method="POST" modelAttribute="discount">  
                    <div class="modal-body">
                        
                        <div class="form-group">
                            <label for="name">Chương trình khuyến mãi</label>
                            <form:input type="text" class="form-control" path="content" placeholder="Promontion"/>
                            <form:errors path="content" cssClass="text-danger" element="div"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="name">Số tiền giảm</label>
                            <form:input type="number" class="form-control" path="moneyReduce" placeholder="Percent"/>
                            <form:errors path="moneyReduce" cssClass="text-danger" element="div"/>
                        </div>
                        
                    </div>

                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Save"  id="randomcode" />
                    </div>
                </form:form> 
            </div>
        </div>
    </div>

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
                            <thead style="text-align: center">
                                <tr role="row">             
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                        colspan="1">
                                        Code</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                        colspan="1">
                                        Content</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                        colspan="1">
                                        Money Reduce</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1">
                                        Delete</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1">
                                        Update</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="d" items="${discounts}">
                                    <tr role="row" class="odd">
                                        <td class="col-sm-2">${d.code}</td>
                                        <td class="col-sm-4">${d.content}</td>
                                        <td>${d.moneyReduce}</td>
                                        <td style="padding: 5px" class="col-sm-2">

                                            <button type="button"
                                                    class="btn btn-block bg-gradient-danger">Delete</button>

                                        <td style="padding: 5px" class="col-sm-2">
                                            <button type="button"
                                                    class="btn btn-block bg-gradient-primary" 
                                                    data-target="#modal-lg-update" 
                                                    data-toggle="modal"
                                                    onclick="getDiscount(${discount.id})">Update</button>
                                        </td>
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


                                <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">   
                                    <li class="paginate_button page-item active" ><a class="page-link"  href="<c:url value="/admin/discount"/>?page=${i}">${i}</a></li>                                            
                                    </c:forEach>



                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>    
</div>    
    
    
    <div class="modal fade" id="modal-lg-update">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Discount</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="#" method="POST" >  
                    <div class="modal-body">
                        
                        <div class="form-group">
                            <label for="name">Chương trình khuyến mãi</label>
                            <input type="text" class="form-control"  id="contentUpdate" path="content" placeholder="Promontion"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="name">Số tiền giảm</label>
                            <input type="number" class="form-control" path="moneyReduce" id="moneyReduceUpdate" placeholder="Percent"/>
                        </div>
                        
                    </div>

                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Save"  id="randomcode" />
                    </div>
                <form> 
            </div>
        </div>
    </div>
    
<script src="<c:url value="/js/discount.js"/>"></script>
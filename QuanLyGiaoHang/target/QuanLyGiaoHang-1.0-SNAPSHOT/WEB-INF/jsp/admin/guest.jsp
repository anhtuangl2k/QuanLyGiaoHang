<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content-wrapper">
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
                                <tr>   
                                    <td colspan="5">
                                        <h3>QUẢN LÝ KHÁCH HÀNG</h3>
                                    </td>
                                </tr>
                                <tr role="row">             
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                        colspan="1">
                                        Tên tài khoản</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                        colspan="1">
                                        Họ tên</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                        colspan="1">
                                        Địa chỉ</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1">
                                        Gmail</th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1">
                                        CMND</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="g" items="${guest}">
                                    <tr role="row" class="odd">
                                        <td class="col-sm-2">${g.username}</td>
                                        <td class="col-sm-4">${g.name}</td>
                                        <td class="col-sm-4">${g.address}</td>
                                        <td class="col-sm-4">${g.gmail}</td>
                                        <td class="col-sm-4">${g.cmnd}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>



            </div>
        </div>
    </section>    
</div>   
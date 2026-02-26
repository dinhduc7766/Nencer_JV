<%@page import="models.Receipts"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="components/head.jsp" %>
<body>
    <div id="main">
        <!-- Begin header -->
        <%@include file="components/header.jsp" %>
        <!-- End header -->
        <div class="clear-fix"></div>
        <!-- Begin content -->
        <div id="content">
            <div class="container">
                <div class="col-md-12">
                    <a href="create-receipts" class="btn btn-primary">Thêm mới</a>
                </div>
                <div class="clear-fix"></div>
                <div class="col-md-12">
                    <table class="table table-bordered table-hover">
                        <thead class="table-header">
                            <tr>
                                <td>Mã đơn hàng</td>
                                <td>Tên đơn hàng</td>
                                <td>Loại sản phẩm</td>
                                <td>Chi tiết</td>
                                <td>Ngày giao hàng</td>
                                <td>Tổng chi phí</td>
                                <td>Hình ảnh</td>
                                <td>Đơn vị vận chuyển</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Receipts> receipts = (List<Receipts>) request.getAttribute("receipts");
                                for (Receipts receipt : receipts) {
                             %>
                            <tr>
                                <td><%= receipt.getId() %></td>
                                <td><%= receipt.getName() %></td>
                                <td><%= receipt.getCategory_name() %></td>
                                <td><%= receipt.getNote() %></td>
                                <td><%= receipt.getDelivery_date() %></td>
                                <td><%= receipt.getTotal_price() %></td>
                                <td><img src="src" alt=""/></td>
                                <td><%= receipt.getLogistics_providers_name() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- End content -->
    </div>
<%@include file="components/footer.jsp" %>
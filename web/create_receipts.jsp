<%@page import="models.LogisticsProviders"%>
<%@page import="models.Categories"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="components/head.jsp" %>
<%@page import="java.util.List" %>
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
                    <a href="index" class="btn btn-secondary">Danh sách đơn hàng</a>
                </div>
                <div class="clear-fix"></div>
                <div class="col-md-4 card-section" id="section-create-receipt">
                    <h3 class="text-center">Thêm đơn hàng</h3>
                    <!-- multipart/form-data cho phep gui file da phuong tien -->
                    <form action="create-receipts" method="post" id="form_create_receipts"> 
                        <label for="receipt_name">Tên đơn hàng <span class="text-danger">*</span></label>
                        <input type="text" name="receipt_name" id="receipt_name" class="form-control" placeholder="Tên đơn hàng">
                        <br>
                        <label for="category">Danh mục <span class="text-danger">*</span></label>
                        <select name="category" id="category" class="form-control">
                            <%
                            // Code java here
                            List<Categories> categories = (List<Categories>) request.getAttribute("categories");
                            for (Categories category : categories) {
                            %>
                            <option value="<%= category.getId()%>"><%= category.getName()%></option>
                            <% } %>
                        </select>
                  
                        <br>
                        <label for="detail">Chi tiết</label>
                        <textarea name="detail" class="form-control" id="detail"></textarea>
                        <br>
                        <label for="delivery_date">Ngày giao hàng <span class="text-danger">*</span></label>
                        <input type="date" name="delivery_date" class="form-control">
                        <br>
                        <label for="image" class="btn btn-primary">Chọn hình ảnh</label>
                        <input type="file" name="image" id="image" value="" class="hide">
                        <br>
                        <label for="logistics_provider">Đơn vị vận chuyển <span class="text-danger">*</span></label>
                        <select name="logistics_provider" class="form-control" id="logistics_provider">
                            <%
                                // Code java here
                            List<LogisticsProviders> providers = (List<LogisticsProviders>) request.getAttribute("providers");
                            for (LogisticsProviders provider : providers) {
                            %>
                            <option value="<%= provider.getId()%>"><%= provider.getName()%></option>
                            <% } %>
                        </select>
                        <br>
                        <label for="quantity">So luong san pham<span class="text-danger">*</span></label>
                        <input type="number" required name="quantity" class="form-control" placeholder="1">
                        <br>     
                        <label for="total_price">Don gia<span class="text-danger">*</span></label>
                        <input type="number" required name="total_price" class="form-control" placeholder="1000(VND)">
                        <br> 
                        <label for="type">Loai don hang<span class="text-danger">*</span></label>
                        <select name="type" class="form-control">
                            <option value="1">Don nhap hang</option>
                            <option value="2">Don xuat hang</option>
                        </select>
                        <br>
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary float-right">Thêm mới</button>
                            <button type="reset" class="btn btn-secondary mx-2 float-right">Huỷ</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- End content -->
    </div>
<%@include file="components/footer.jsp" %>
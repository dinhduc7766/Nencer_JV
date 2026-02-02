<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="header">
    <div class="container">
        <form action="" method="get">
        <div class="row">
            <div class="col-md-3">
                <label for="id" class="text-bold">Mã đơn hàng</label>
                <input type="text" name="id" placeholder="001" class="form-control">
            </div>
            <div class="col-md-3">
                <label for="category" class="text-bold">Danh mục</label>
                <select name="category" id="category" class="form-control">
                    <option value="phone">Điện thoại</option>
                    <option value="laptop">Laptop</option>
                    <option value="pc">PC</option>
                    <option value="other">Phụ kiện</option>
                </select>
            </div>
            <div class="col-md-3">
                <label for="" class="text-bold">Tìm kiếm từ ngày</label>
                <input type="datetime-local" name="from_date" class="form-control">
            </div>
            <div class="col-md-3">
                <label for="" class="text-bold">Tìm kiếm đến ngày</label>
                <input type="datetime-local" name="to_date" class="form-control">
                <br>
                <button type="submit" class="btn btn-primary float-right">Tìm kiếm</button>
            </div>
        </div>
        </form>
    </div>
</div>
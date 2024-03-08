<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<h3>Product List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>MaSP</th>
					<th>TenSP</th>
					<th>SoLuong</th>
					<th>DonGia</th>
					<th>Anh</th>
					<th>Edit</th>
					<th>Delete</th>a
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.maSP_2110900011}</td>
						<td>${product.tenSP_2110900011}</td>
						<td>${product.soLuong_2110900011}</td>
						<td>${product.donGia_2110900011}</td>
						<td><img src="./imgs/${product.anh_2110900011}" style="width: 150px"></td>
						<td>
							<a href="productEdit?code=${product.maSP_2110900011}">Edit</a>
						</td>
						<td>
							<a href="productDelete?code=${product.maSP_2110900011} ">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="productCreate">Create Product</a>
	</section>
</body>
</html>
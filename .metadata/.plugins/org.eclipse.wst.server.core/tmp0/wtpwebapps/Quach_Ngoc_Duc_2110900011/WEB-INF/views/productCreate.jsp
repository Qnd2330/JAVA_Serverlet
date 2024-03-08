<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<h3>Create Product</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/productCreate">
			<table class="table table-bordered">
				<tr>
					<td>MaSP</td>
					<td><input type="text" name="MaSP" value="${product.maSP_2110900011}"></td>
				</tr>
				<tr>
					<td>TenSP</td>
					<td><input type="text" name="TenSP" value="${product.tenSP_2110900011}"></td>
				</tr>
				<tr>
					<td>SoLuong</td>
					<td><input type="text" name="SoLuong" value="${product.soLuong_2110900011}"></td>
				</tr>
				<tr>
					<td>DonGia</td>
					<td><input type="text" name="DonGia" value="${product.donGia_2110900011}"></td>
				</tr>
				<tr>
					<td>Anh</td>
					<td><input type="text" name="Anh" value="${product.anh_2110900011}"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="Ghi lại" class="btn btn-success">
						<a href="ProductList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>

</body>
</html>
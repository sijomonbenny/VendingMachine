<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<!-- jQuery Modal -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<meta charset="ISO-8859-1">
<title>Home - Vending Machine</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="appbar">
		<table>
			<tr>
				<td><h1 style="color: white; margin-top: 0px;">
						<i class="fa fa-cart-arrow-down" aria-hidden="true"></i> Vending
						Machine
					</h1></td>
			</tr>
		</table>
	</div>
	<div class="itemData">
		<form action="buyItem" method="post">
			<table>
				<tr>
					<th>Select</th>
					<th>Item ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Available Quantity</th>
				</tr>
				<c:forEach items="${inventories}" var="inventories">
					<tr>
						<td><input type="checkbox" value="${inventories.inventoryId}"
							name="selectedItems"></td>
						<td>${inventories.item.itemId}</td>
						<td>${inventories.item.itemName}</td>
						<td>${inventories.item.price}</td>
						<td>${inventories.quantity}</td>
					</tr>
				</c:forEach>
			</table>
			<input class="save-btn" type="submit" value="Buy">
		</form>
		<div class='amount-style'>
			<h3>Total Amount To Pay : Rs.${total}</h3>
		</div>	
	</div>
</body>
</html>
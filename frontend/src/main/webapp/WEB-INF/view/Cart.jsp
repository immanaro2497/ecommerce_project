<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Cart</title>
<style>
#sel { width:50px; }
.card {
  background-color: #f2f2f2;
  width: 800px;
  height: 160px;
  border: 1px solid #000000;
  margin-top:25px;
}
.sidebox {
  background-color: #f2f2f2;
  width: 200px;
  height: 100px;
  border: 1px solid #000000;
  margin-top:25px;
  text-align: center;
}
</style>
</head>
<body class="bg">
<%@ include file="Header.jsp"%>
<div class="container">
<div class="col-lg-12">
<c:choose>
<c:when test="${quantity==0}">
<div>
<p style="font-size:90px;font-weight:30px;margin-left:150px;">Your Cart is empty.</p>
</div>
</c:when>
<c:otherwise>
<div class="sidebox" style="float:right;">
<br>
GrandTotal:<b>INR</b>&nbsp;${grandtotal}
<a href="<c:url value="/confirmorder"/>" class="btn btn-success">Proceed to Buy</a>
</div>
<c:forEach items="${listCarts}" var="cart">
<div class="card">
<form method="post" action="<c:url value="/updatecart/${cart.cartId}"/>">
<img style="float:left;" src="<c:url value="/resources/images/${cart.productId}.jpg"/>" width="150px" height="150px">
<a href="<c:url value="/deletecart/${cart.cartId}"/>"><span class="glyphicon glyphicon-remove" style="color:#ff4d4d; float:right;"></span></a>
<b>${cart.productName}</b><br><br>
<b>INR</b>&nbsp;${cart.productPrice}
<div style="float:right;">
<p style="margin-right:10px;">Quantity&emsp;<input name="quantity" id="sel" value="${cart.quantity}"></p>
<p><button type="submit" class="btn btn-success">Check price</button></p>
<p style="margin-right:10px;">SubTotal:<b>INR</b>&nbsp;${cart.total}</p>
</div>
</form>
<br><br><br>
<c:if test="${Cart.cartId==cart.cartId}">
<font color="red"><b>${alert}</b></font>
</c:if>
</div>
</c:forEach>
</c:otherwise>
</c:choose>
</div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>
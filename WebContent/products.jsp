<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>products</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>            </th>
					<th>Product name</th>
					<th>Product price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="products" items="${products}">
					<tr>
						<td><img src="${products.productpicture}" height="100" width="100"></img></td>
						<td><c:out value="${products.productname}" /></td>
						<td>$<c:out value="${products.productprice}" /></td>
						<td><form action="Details" method="get">
						<input type="hidden" name="productid" id="productid" value="${products.productid}"/>
						<input type="submit" name="submit" id="submit" value="View Details"/>
						</form>
						
						<form action="AddToCart" method="get">
						<input type="hidden" name="productid" id="productid" value="${products.productid}"/>
						<fieldset>
						<input type ="text" name="quantity" id="quantity" value="1"/>
						</fieldset>
						<input type="submit" name="submit" id="submit" value="Add to cart"/>
						</form>
						<c:if test="${user != null}"><form action="AddToWishList" method="get">
						<input type="hidden" name="productid" id="productid" value="${products.productid}"/>
						<input type ="hidden" name="quantity" id="quantity" value="1"/>
						<input type="submit" name="submit" id="submit" value="Add to wishlist"/>
						</form>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Products</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
 <div class="container col-md-10 col-md-offset-1">
	<div class="panel panel-default">
		<div class="panel-heading">Search products</div>
		<div class="panel-body">
			<form action="search.php" method="get">
				<label>Key Word</label>
				<input type="text" name="keyWord" value="${model.keyWord}"/>
				<button type="submit" class="btn btn-primary">Search</button>
			</form>
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Designation</th>
					<th>Prix</th>
					<th>Quantity</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${model.products}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.designation}</td>
						<td>${p.prix}</td>
						<td>${p.quantity}</td>
						<td><a href="edit.php?id=${p.id}">Edit</a></td>
						<td><a onclick="return confirm('Are you sure?')" href="delete.php?id=${p.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
 </div>
</body>
</html>
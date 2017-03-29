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
 <div class="container col-md-8 col-md-offset-2 col-xs-12">
	<div class="panel panel-default">
		<div class="panel-heading">Confirmation</div>
		<div class="panel-body">
			<div class="form-group">
				<label>ID</label>
				<label>${product.id}</label>
			</div>
			<div class="form-group">
				<label>Designation</label>
				<label>${product.designation}</label>
			</div>
			<div class="form-group">
				<label>Prix</label>
				<label>${product.prix}</label>
			</div>
			<div class="form-group">
				<label>Quantity</label>
				<label>${product.quantity}</label>
			</div>
		</div>
	</div>
 </div>
</body>
</html>
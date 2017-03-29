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
		<div class="panel-heading">Add product</div>
		<div class="panel-body">
			<form action="SaveProduct.php" method="post">
				<div class="form-group">
					<label class="control-label">Designation</label>
					<input type="text" name="designation" value="${product.designation}" class="form-control" required="required"/>
					<span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Prix</label>
					<input type="text" name="prix" value="${product.prix}" class="form-control"/>
					<span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Quantity</label>
					<input type="text" name="quantity" value="${product.quantity}"  class="form-control"/>
					<span></span>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</form>
		</div>
	</div>
 </div>
</body>
</html>
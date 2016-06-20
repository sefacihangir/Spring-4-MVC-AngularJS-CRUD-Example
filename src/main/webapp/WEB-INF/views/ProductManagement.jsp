<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product Management</title>
<style>
</style>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/product_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/product_controller.js' />"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet" />
</head>
<body ng-app="myApp">
	<div ng-controller="ProductController as ctrl">
		<span ng-bind="ctrl.helloMsgs"></span>
		<div class="panel panel-default">
			<div class="panel-heading"><span class="lead">List of Products</span></div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Product</th>
							<th>Category</th>
							<th width="25%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.products">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.description"></span></td>
							<td><span ng-bind="u.category"></span></td>
							<td>
								<button type="button" class="btn btn-success custom-width">Edit</button> <button type="button" class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>
</html>
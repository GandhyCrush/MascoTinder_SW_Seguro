<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/matches.css">
<title>Lista de Matches</title>
</head>
<body>

	<%@include file="../templates/banner_superior.html"%>

	<div class="screen-margin">
		<h1 class="display-6 text-muted">
			<strong>Matches para "Mascota"</strong>
		</h1>
		<div class="position-relative">
			<div class="position-absolute mascota-pos1">
				<img src="https://picsum.photos/300/200" />
			</div>
			<div class="position-absolute mascota-pos2">
				<img src="https://picsum.photos/300/200" />
			</div>
		</div>
	</div>

</body>
</html>
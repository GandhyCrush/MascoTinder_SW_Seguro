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
		<div class="row">
			<div class="d-flex justify-content-evenly">
				<div class="col-md-6 col-lg-4">
					<div class="card my-3">
						<img src="https://picsum.photos/400/280" class="card-image-top"
							alt="thumbnail">

						<div class="card-body">
							<h3 class="card-title text-wrap">Mascota1</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Etiam purus est, malesuada ut ultrices quis, dictum ac risus.
								Mauris fringilla vehicula finibus.</p>
							<a href="#"
								class="nav-link active text-primary text-end fw-bold m-2">Mensajes</a>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-lg-4">
					<div class="card my-3">
						<img src="https://picsum.photos/400/280" class="card-image-top"
							alt="thumbnail">

						<div class="card-body">
							<h3 class="card-title text-wrap">Mascota2</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Etiam purus est, malesuada ut ultrices quis, dictum ac risus.
								Mauris fringilla vehicula finibus.</p>
							<a href="#"
								class="nav-link active text-primary text-end fw-bold m-2">Mensajes</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="d-flex justify-content-evenly">
				<div class="col-md-6 col-lg-4">
					<div class="card my-3">
						<img src="https://picsum.photos/400/280" class="card-image-top"
							alt="thumbnail">

						<div class="card-body">
							<h3 class="card-title text-wrap">Mascota3</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Etiam purus est, malesuada ut ultrices quis, dictum ac risus.
								Mauris fringilla vehicula finibus.</p>
							<a href="#"
								class="nav-link active text-primary text-end fw-bold m-2">Mensajes</a>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-lg-4">
					<div class="card my-3">
						<img src="https://picsum.photos/400/280" class="card-image-top"
							alt="thumbnail">

						<div class="card-body">
							<h3 class="card-title text-wrap">Mascota4</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Etiam purus est, malesuada ut ultrices quis, dictum ac risus.
								Mauris fringilla vehicula finibus.</p>
							<a href="#"
								class="nav-link active text-primary text-end fw-bold m-2">Mensajes</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>
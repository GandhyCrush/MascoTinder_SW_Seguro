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
<title>Lista de Matches</title>
</head>
<body>

	<%@include file="../templates/banner_superior.html"%>

	<div style="margin: 60px 150px;">
		<h1 class="display-6 text-muted">
			<strong>Matches para "Mascota"</strong>
		</h1>
		<div class="container m-3">

			<div class="row row-cols-2 justify-content-evenly">

				<!-- MASCOTA 1 -->

				<div id="mid1" class="col-md-6 col-lg-4">
					<div class="card my-3">
						<div id="m1" class="carousel slide" data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#m1" data-bs-slide-to="0"
									class="active" aria-current="true" aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#m1" data-bs-slide-to="1"
									aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#m1" data-bs-slide-to="2"
									aria-label="Slide 3"></button>
							</div>
							<div class="carousel-inner">
								<div class="carousel-item  active" data-bs-interval="100000000">
									<img src="https://picsum.photos/id/237/400/280">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="https://picsum.photos/400/280">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="https://picsum.photos/id/230/400/280">
								</div>
							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#m1" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#m1" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
						</div>

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




				<!-- MASCOTA 2 -->

				<div id="mid2" class="col-md-6 col-lg-4">
					<div class="card my-3">
						<div id="m2" class="carousel slide" data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#m2" data-bs-slide-to="0"
									class="active" aria-current="true" aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#m2" data-bs-slide-to="1"
									aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#m2" data-bs-slide-to="2"
									aria-label="Slide 3"></button>
							</div>
							<div class="carousel-inner">
								<div class="carousel-item  active" data-bs-interval="100000000">
									<img src="https://picsum.photos/id/237/400/280">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="https://picsum.photos/400/280">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="https://picsum.photos/id/230/400/280">
								</div>
							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#m2" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#m2" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
						</div>

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


			</div>
		</div>

	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</html>
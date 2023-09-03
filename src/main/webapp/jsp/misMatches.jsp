<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/misMascotasStyles.css">
<title>Lista de Matches</title>
</head>
<body>

	<%@include file="../templates/banner_superior.html"%>


	<div style="margin: 60px 150px;">
		<h1 class="display-6 text-muted">
			<strong>Matches para ${mascota.nombre}</strong>
		</h1>
		<div class="container m-3">

			<div class="misMascotas">

				<!-- MASCOTA 1 -->
				<c:forEach items="${matches}" var="m">
					<div id="mid${m.idMascota}" class="tinder--card">
						<div id="m${m.idMascota}" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#m${m.idMascota}"
									data-bs-slide-to="0" class="active" aria-current="true"
									aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#m${m.idMascota}"
									data-bs-slide-to="1" aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#m${m.idMascota}"
									data-bs-slide-to="2" aria-label="Slide 3"></button>
							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#m${m.idMascota}" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#m${m.idMascota}" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
							<div class="carousel-inner">
								<div class="carousel-item  active" data-bs-interval="100000000">
									<img src="${m.fotos[0].url}">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="${m.fotos[1].url}">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="${m.fotos[2].url}">
								</div>
							</div>
						</div>
						<h3>${m.nombre}</h3>
						<p>${m.descripcion}</p>
						<a href="${pageContext.request.contextPath}/MensajesController?idMatchMascota=${m.idMascota}"
							class="nav-link active text-primary text-end fw-bold me-3 mt-3">Mensajes</a>
					</div>
				</c:forEach>


			</div>
		</div>

	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</html>
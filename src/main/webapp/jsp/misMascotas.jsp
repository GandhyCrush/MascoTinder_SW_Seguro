<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/misMascotasStyles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/banner_style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Mis Mascotas</title>
</head>

<body>
	<div>
		<%@include file="../templates/banner_superior.html"%>
	</div>

	<section>

		<div class="misMascotas">

			<c:forEach items="${misMascotas}" var="m">
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
					<p>
						<span class="negrilla">Sexo:</span> ${m.sexo}
					</p>
					<p>
						<span class="negrilla">Edad:</span> ${m.edad} años
					</p>
					<p>
						<span class="negrilla">Dueño:</span> ${m.propietario}
					</p>
					<span><a class="custom-btn btn-16"
						href="${pageContext.request.contextPath}/MisMatchesController?idMiMascota=${m.idMascota}">Mis
							Matches</a></span> <span><a class="custom-btn btn-16"
						href="${pageContext.request.contextPath}/PreferenciasController?idMiMascota=${m.idMascota}">Preferencias</a></span>
					<span><a class="custom-btn btn-16"
						href="${pageContext.request.contextPath}/LikeNoLikeController?idMiMascota=${m.idMascota}">Buscar</a></span>
				</div>
			</c:forEach>
		</div>
		<a class="float-btn"
			href="${pageContext.request.contextPath}/RegistrarMascotaController">
			<span class="material-icons ">add</span>
		</a>

	</section>




	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js">
		
	</script>

</body>

</html>
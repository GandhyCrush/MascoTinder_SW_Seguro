<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
			<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
			<!-- CSS only -->
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
				crossorigin="anonymous">
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mascotas.css">
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/banner_style.css">
			<title>Like No Like</title>
		</head>

		<body>
			<div>
				<%@include file="../templates/banner_superior.html" %>
			</div>

			<section>

				<div class="misMascotas">
					<div id="mid1" class="tinder--card">
						<div id="m1" class="carousel slide" data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#m1" data-bs-slide-to="0" class="active"
									aria-current="true" aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#m1" data-bs-slide-to="1"
									aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#m1" data-bs-slide-to="2"
									aria-label="Slide 3"></button>
							</div>
							<div class="carousel-inner">
								<div class="carousel-item  active" data-bs-interval="100000000">
									<img src="../imgs/Atom1.jpg">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="../imgs/Atom2.jpg">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="../imgs/Atom3.jpg">
								</div>
							</div>
						</div>
						<button class="carousel-control-prev" type="button" data-bs-target="#c1" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button" data-bs-target="#c1" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
						<h3>dffgdfg</h3>
						<p>dfgdfgdfg</p>
					</div>
					<c:forEach items="${mascotas}" var="m">
						<div id="mid${m.id}" class="tinder--card">
							<div id="m${m.id}" class="carousel slide" data-bs-ride="carousel">
								<div class="carousel-indicators">
									<button type="button" data-bs-target="#m${m.id}" data-bs-slide-to="0" class="active"
										aria-current="true" aria-label="Slide 1"></button>
									<button type="button" data-bs-target="#m${m.id}" data-bs-slide-to="1"
										aria-label="Slide 2"></button>
									<button type="button" data-bs-target="#m${m.id}" data-bs-slide-to="2"
										aria-label="Slide 3"></button>
								</div>
								<div class="carousel-inner">
									<div class="carousel-item  active" data-bs-interval="100000000">
										<img src="${m.rutaImg}">
									</div>
									<div class="carousel-item" data-bs-interval="100000000">
										<img src="${m.rutaImg}">
									</div>
									<div class="carousel-item" data-bs-interval="100000000">
										<img src="${m.rutaImg}">
									</div>
								</div>
							</div>
							<button class="carousel-control-prev" type="button" data-bs-target="#m${m.id}"
								data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button" data-bs-target="#m${m.id}"
								data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
							<h3>${m.nombre}</h3>
							<p>${m.descripcion}</p>
						</div>
					</c:forEach>
				</div>


			</section>




			<!-- JavaScript Bundle with Popper -->
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
				crossorigin="anonymous">
			</script>

		</body>

		</html>
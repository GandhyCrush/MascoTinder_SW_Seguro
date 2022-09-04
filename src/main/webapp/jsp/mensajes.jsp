<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">

.bubble {
	border-radius: 10px;
	margin: 10px;
	width: max-content;
	max-width: 400px;
	height: auto;
}

.bubble-enviado {
	background-color: rgb(152, 158, 157);
	border-color: rgb(152, 158, 157);
	justify-self: end;
}

.bubble-recibido {
	background-color: rgb(129, 195, 253);
	border-color: rgb(129, 195, 253);
	justify-self: start;
}

.display-mensajes {
	display: grid;
	grid-template-rows: 1fr 1fr 1fr;
	overflow-y: scroll;
	width: 685px; 
	height: 340px;
}
</style>
<title>Mensajes</title>
</head>
<body>
	<%@include file="../templates/banner_superior.html"%>
	<div style="margin: 60px 150px;">
		<h1 class="display-6 text-muted">
			<strong>Mensajes</strong>
		</h1>


		<div class="container pt-4" style="width: 700px; height: 350px;">
			<div
				class="border border-dark shadow p-3 bg-body rounded display-mensajes">
				<c:forEach items="${conversacion}" var="con">
					<c:choose>
						<c:when test="${con.emisor.idPersona == idUsuario}">
							<!-- Mensaje enviado -->
							<div class="bubble bubble-enviado text-break">
								<p class="pt-2 px-2">${con.mensaje}</p>
							</div>
						</c:when>
						<c:otherwise>
							<!-- Mensaje recibido -->
							<div class="bubble bubble-recibido">
								<p class="pt-2 px-2">${con.mensaje}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</div>
		</div>



		<div class="container pt-4" style="width: 700px;">
			<div class="row align-items-center">

				<div class="col-11">
					<form class="row align-items-center" method="post"
						action="MensajesController">
						<div class="col-md-auto">
							<input type="text" class="form-control border border-dark shadow"
								style="width: 500px; height: 50px;" placeholder="Mensaje"
								name="mensaje"> <input type="hidden"
								name="idMatchMascota" value="${idMatchMascota}">
						</div>
						<div class="col-2">
							<button type="submit" class="btn"
								style="background-color: rgb(129, 195, 253); width: 100px;">Enviar</button>
						</div>
					</form>

				</div>
				<div class="col-1 d-flex justify-content-center text-center">
					<a
						href="${pageContext.request.contextPath}/MensajesController?idMatchMascota=${idMatchMascota}"
						class="btn"> <img
						src="https://img.icons8.com/ios-glyphs/30/000000/refresh--v1.png" />
					</a>
				</div>
			</div>
		</div>


	</div>
</body>
</html>
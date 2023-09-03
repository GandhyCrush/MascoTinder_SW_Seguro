<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/misMascotasStyles.css">
<title>Preferencias</title>
</head>
<body>
	<%@include file="../templates/banner_superior.html"%>
	<div style="margin: 60px 150px;">
		<h1 class="display-6 text-muted">
			<strong>Preferencias</strong>
		</h1>



		<div class="d-flex justify-content-center">
			<div class="w-50">
				<form method="post" action="PreferenciasController">
					<div class="text-center">
						<h3 class="text-muted">Buscar mascotas que cumplen con:</h3>
					</div>
					<div style="padding: 30px 60px 0px;">
						<h4 class="text-muted">Tipo</h4>
						<select class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);"
							aria-label="Default select example" name="especie">
							<option value="PERRO" <c:if test="${preferenciasMiMascota.especie == 'PERRO'}">selected</c:if>>PERRO</option>
							<option value="GATO" <c:if test="${preferenciasMiMascota.especie == 'GATO'}">selected</c:if>>GATO</option>
							<option value="CONEJO" <c:if test="${preferenciasMiMascota.especie == 'CONEJO'}">selected</c:if>>CONEJO</option>
						</select>


					</div>
					<div style="padding: 30px 60px 0px;">
						<h4 class="text-muted">Sexo</h4>

						<select class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);"
							aria-label="Default select example" name="sexo">
							<option value="HEMBRA" <c:if test="${preferenciasMiMascota.sexo == 'HEMBRA'}">selected</c:if>>HEMBRA</option>
							<option value="MACHO" <c:if test="${preferenciasMiMascota.sexo == 'MACHO'}">selected</c:if>>MACHO</option>
						</select>
					</div>
					<div style="padding: 30px 60px 0px;">
						<h4 class="text-muted">RANGOS DE EDAD</h4>

						<div class="d-flex justify-content-evenly py-3 border border-3">
							<div class="text-center text-muted">
								<h5>Mayores a</h5>
								<select class="form-select text-white fw-bold"
									style="background-color: rgb(129, 195, 253);"
									aria-label="Default select example" name="edadMinima">
									<option value="1" <c:if test="${preferenciasMiMascota.edadMinima == 1}">selected</c:if>>1</option>
									<option value="2" <c:if test="${preferenciasMiMascota.edadMinima == 2}">selected</c:if>>2</option>
									<option value="3" <c:if test="${preferenciasMiMascota.edadMinima == 3}">selected</c:if>>3</option>
									<option value="4" <c:if test="${preferenciasMiMascota.edadMinima == 4}">selected</c:if>>4</option>
									<option value="5" <c:if test="${preferenciasMiMascota.edadMinima == 5}">selected</c:if>>5</option>
									<option value="6" <c:if test="${preferenciasMiMascota.edadMinima == 6}">selected</c:if>>6</option>
									<option value="7" <c:if test="${preferenciasMiMascota.edadMinima == 7}">selected</c:if>>7</option>
									<option value="8" <c:if test="${preferenciasMiMascota.edadMinima == 8}">selected</c:if>>8</option>
									<option value="9" <c:if test="${preferenciasMiMascota.edadMinima == 9}">selected</c:if>>9</option>
									<option value="10" <c:if test="${preferenciasMiMascota.edadMinima == 10}">selected</c:if>>10</option>
									<option value="11" <c:if test="${preferenciasMiMascota.edadMinima == 11}">selected</c:if>>11</option>
									<option value="12" <c:if test="${preferenciasMiMascota.edadMinima == 12}">selected</c:if>>12</option>
									<option value="13" <c:if test="${preferenciasMiMascota.edadMinima == 13}">selected</c:if>>13</option>
									<option value="14" <c:if test="${preferenciasMiMascota.edadMinima == 14}">selected</c:if>>14</option>
									<option value="15" <c:if test="${preferenciasMiMascota.edadMinima == 15}">selected</c:if>>15</option>
								</select>
							</div>

							<div class="text-center text-muted">
								<h5>Menores a</h5>
								<select class="form-select text-white fw-bold"
									style="background-color: rgb(129, 195, 253);"
									aria-label="Default select example" name="edadMaxima">
									<option value="1" <c:if test="${preferenciasMiMascota.edadMaxima == 1}">selected</c:if>>1</option>
									<option value="2" <c:if test="${preferenciasMiMascota.edadMaxima == 2}">selected</c:if>>2</option>
									<option value="3" <c:if test="${preferenciasMiMascota.edadMaxima == 3}">selected</c:if>>3</option>
									<option value="4" <c:if test="${preferenciasMiMascota.edadMaxima == 4}">selected</c:if>>4</option>
									<option value="5" <c:if test="${preferenciasMiMascota.edadMaxima == 5}">selected</c:if>>5</option>
									<option value="6" <c:if test="${preferenciasMiMascota.edadMaxima == 6}">selected</c:if>>6</option>
									<option value="7" <c:if test="${preferenciasMiMascota.edadMaxima == 7}">selected</c:if>>7</option>
									<option value="8" <c:if test="${preferenciasMiMascota.edadMaxima == 8}">selected</c:if>>8</option>
									<option value="9" <c:if test="${preferenciasMiMascota.edadMaxima == 9}">selected</c:if>>9</option>
									<option value="10" <c:if test="${preferenciasMiMascota.edadMaxima == 10}">selected</c:if>>10</option>
									<option value="11" <c:if test="${preferenciasMiMascota.edadMaxima == 11}">selected</c:if>>11</option>
									<option value="12" <c:if test="${preferenciasMiMascota.edadMaxima == 12}">selected</c:if>>12</option>
									<option value="13" <c:if test="${preferenciasMiMascota.edadMaxima == 13}">selected</c:if>>13</option>
									<option value="14" <c:if test="${preferenciasMiMascota.edadMaxima == 14}">selected</c:if>>14</option>
									<option value="15" <c:if test="${preferenciasMiMascota.edadMaxima == 15}">selected</c:if>>15</option>
								</select>
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-center m-5">
						<button type="submit" class="btn w-25 text-white"
							style="background-color: rgb(129, 195, 253);">Guardar</button>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</html>
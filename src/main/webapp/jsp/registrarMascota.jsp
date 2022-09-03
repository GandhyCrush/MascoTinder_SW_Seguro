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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/misMascotasStyles.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/registroMascotaStyle.css">
<title>Registrar mascota</title>
</head>
<body>
	<%@include file="../templates/banner_superior.html"%>
	<div style="margin: 60px 150px;">
		<h1 class="display-6 text-muted">
			<strong>Registrar mascota</strong>
		</h1>

		<div class="d-flex justify-content-center">
			<div class="w-50">
				<form method="post" action="RegistrarMascotaController" enctype="multipart/form-data">
					<div class="text-center">
						<h3 class="text-muted">Ingrese los datos de su nueva mascota:</h3>
					</div>
					
					<div class="input-group mb-3">
						<div class="form-floating">
							<input type="text" class="form-control text-light fw-bold" id="floatingInputGroup1"
								name="nombre" style="background-color: rgb(129, 195, 253);" placeholder="username" required> 
								<label class="text-light h6" for="floatingInputGroup1">Nombre</label>
						</div>
					</div>
					
					<div class="input-group mb-3">
						<div class="form-floating">
							<input type="text" class="form-control text-light fw-bold" id="floatingInputGroup1"
								name="descripcion" style="background-color: rgb(129, 195, 253);" placeholder="username" required> 
								<label class="text-light h6" for="floatingInputGroup1">Descripción</label>
						</div>
					</div>

					<div style="padding: 10px 60px 0px;">
						<h4 class="text-muted">Tipo</h4>
						<select class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);"
							aria-label="Default select example" name="especie" required>
							<option value="PERRO">PERRO</option>
							<option value="GATO">GATO</option>
							<option value="CONEJO">CONEJO</option>
						</select>
					</div>
					
					<div style="padding: 10px 60px 0px;">
						<h4 class="text-muted">Sexo</h4>
						<select class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);"
							aria-label="Default select example" name="sexo">
							<option value="HEMBRA">HEMBRA</option>
							<option value="MACHO">MACHO</option>
						</select>
					</div>
					<div style="padding: 10px 60px 0px;">
						<h4 class="text-muted">Edad</h4>

						<div class="d-flex justify-content-evenly py-3 border border-3">
							<div class="text-center text-muted">
								<h5>Selecciona la edad (años):</h5>
								<select class="form-select text-white fw-bold"
									style="background-color: rgb(129, 195, 253);"
									aria-label="Default select example" name="edad" required>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
								</select>
							</div>
							
						</div>
					</div>
					<div style="padding: 10px 60px 0px;">
						<label id="upload"> <span>Selecciona una foto</span> <input id="input"
							type="file" name="foto1" required="required" accept="image/*">
						</label>

					</div>
					<div style="padding: 10px 60px 0px;">
						<label id="upload"> <span>Selecciona una foto</span> <input id="input"
							type="file" name="foto2" required="required" accept="image/*">
						</label>

					</div>
					<div style="padding: 10px 60px 0px;">
						<label id="upload"> <span>Selecciona una foto</span> <input id="input"
							type="file" name="foto3" required="required" accept="image/*">
						</label>

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
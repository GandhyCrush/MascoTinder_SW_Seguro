<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/registroMascotaStyle.css">
<title>Registrar mascota</title>
</head>
<body>
	<%@include file="../templates/banner_superior.html"%>
	<div class="container my-5">
		<h1 class="display-6 text-muted">
			<strong>Registrar mascota</strong>
		</h1>
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<form method="post" action="RegistrarMascotaController"
					enctype="multipart/form-data">
					<div class="mb-3">
						<h3 class="text-center text-muted">Ingrese los datos de su
							nueva mascota:</h3>
					</div>
					<div class="mb-3">
						<label for="nombre" class="form-label text-muted h6">Nombre</label>
						<input type="text" class="form-control text-light" id="nombre"
							name="nombre" style="background-color: rgb(129, 195, 253);"
							required>
					</div>
					<div class="mb-3">
						<label for="descripcion" class="form-label text-muted h6">Descripción</label>
						<input type="text" class="form-control text-light"
							id="descripcion" name="descripcion"
							style="background-color: rgb(129, 195, 253);" required>
					</div>

					<div class="mb-3">
						<label for="especie" class="form-label text-muted h6">Tipo</label>
						<select class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);" id="especie"
							name="especie" required>
							<option value="PERRO">PERRO</option>
							<option value="GATO">GATO</option>
							<option value="CONEJO">CONEJO</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="sexo" class="form-label text-muted h6">Sexo</label> <select
							class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);" id="sexo"
							name="sexo">
							<option value="HEMBRA">HEMBRA</option>
							<option value="MACHO">MACHO</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="edad" class="form-label text-muted h6">Edad</label> <select
							class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);" id="edad"
							name="edad" required>
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
					<div class="mb-3">
						<label for="foto1" class="form-label">Selecciona una foto</label>
						<input class="form-control" type="file" id="foto1" name="foto1"
							required accept="image/*">
					</div>
					<div class="mb-3">
						<label for="foto2" class="form-label">Selecciona una foto</label>
						<input class="form-control" type="file" id="foto2" name="foto2"
							required accept="image/*">
					</div>
					<div class="mb-3">
						<label for="foto3" class="form-label">Selecciona una foto</label>
						<input class="form-control" type="file" id="foto3" name="foto3"
							required accept="image/*">
					</div>
					<div class="d-flex justify-content-center mt-5">
						<button type="submit" class="btn w-100 text-white"
							style="background-color: rgb(129, 195, 253);">Guardar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

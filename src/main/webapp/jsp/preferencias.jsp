<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
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
							aria-label="Default select example">
							<option value="1">PERRO</option>
							<option value="2">GATO</option>
							<option value="3">CONEJO</option>
						</select>


					</div>
					<div style="padding: 30px 60px 0px;">
						<h4 class="text-muted">Sexo</h4>

						<select class="form-select text-white fw-bold"
							style="background-color: rgb(129, 195, 253);"
							aria-label="Default select example">
							<option value="1">HEMBRAS</option>
							<option value="2">MACHOS</option>
						</select>
					</div>
					<div style="padding: 30px 60px 0px;">
						<h4 class="text-muted">RANGOS DE EDAD</h4>

						<div class="d-flex justify-content-evenly py-3 border border-3">
							<div class="text-center text-muted">
								<h5>Mayores a</h5>
								<select class="form-select text-white fw-bold"
									style="background-color: rgb(129, 195, 253);"
									aria-label="Default select example">
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
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
								</select>
							</div>

							<div class="text-center text-muted">
								<h5>Menores a</h5>
								<select class="form-select text-white fw-bold"
									style="background-color: rgb(129, 195, 253);"
									aria-label="Default select example">
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
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
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
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</html>
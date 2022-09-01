<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
.align-message-right {
	background-color: rgb(152, 158, 157);
	border-color: rgb(152, 158, 157);
	border-radius: 10px;
	margin: 10px;
	width: max-content;
	max-width: 400px;
	float: right;
}

.align-message-left {
	background-color: rgb(129, 195, 253);
	border-color: rgb(129, 195, 253);
	border-radius: 10px;
	margin: 10px;
	width: max-content;
	max-width: 400px;
	float: left;
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
		<div class="d-flex justify-content-center">
			<div class="mt-3 border border-dark shadow p-3 bg-body rounded"
				style="width: 700px; height: 350px;">

				<!-- Mensaje recibido -->
				<div class="align-message-left">
					<p class="pt-2 px-2">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Vivamus scelerisque laoreet consequat.</p>
				</div>


				<!-- Mensaje enviado -->
				<div class="align-message-right">
					<p class="pt-2 px-2">Cras et placerat erat. Pellentesque
						pulvinar accumsan odio, et ultrices eros sodales tempus. Donec dui
						ante, fermentum ac posuere nec, cursus sed neque. Praesent a sem
						sem.</p>
				</div>

			</div>
		</div>
		<div class="d-flex justify-content-center">
			<form method="post" action="PreferenciasController">
				<div class="d-flex flex-row justify-content-evenly m-3"
					style="width: 700px;">

					<input type="text" class="form-control border border-dark shadow"
						style="width: 500px; height: 50px;" placeholder="Mensaje">

					<button type="submit" class="btn"
						style="background-color: rgb(129, 195, 253); width: 100px;">Enviar</button>
					<button type="submit" class="btn">
						<img
							src="https://img.icons8.com/ios-glyphs/30/000000/refresh--v1.png" />
					</button>
				</div>

			</form>
		</div>


	</div>
</body>
</html>
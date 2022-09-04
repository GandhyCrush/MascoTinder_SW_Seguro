<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG IN</title>
<!-- BOOTSTRAP -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registroStyle.css">
</head>
<body>
	<div class="container">
		<form method="post" action="LoginController">
			<h1>LOGIN MascoTinder</h1>
			<div class="img"><img src="https://img.icons8.com/cotton/64/000000/dog-heart--v3.png" /></div> 
			<div class="form-group">
				<input type="text" required="required" name="username" pattern="[A-Za-z0-9]+" minlength="5" maxlength="12" 
				title="Letras y números. Tamaño mínimo: 5 caráteres. Tamaño máximo: 12 caráteres"  /> 
				<label for="input" class="control-label">Nombre de Usuario</label><i class="bar"></i>
			</div>
			<div class="form-group">
				<input id="password" type="password" required="required" name="clave" minlength="5" 
				title="Tamaño mínimo: 12 caráteres"  /> 
				<label for="input" class="control-label">Contraseña</label><i class="bar"></i>
			</div>
			<div class="button-container">
				<button type="submit" class="button">
					<span>INGRESAR</span>
				</button>
				<div id="registro"><a href="RegistrarPersonaController" >¿Aun no tienes cuenta? Registrate</a></div>
			</div>
			
		</form>

	</div>

</body>
</html>
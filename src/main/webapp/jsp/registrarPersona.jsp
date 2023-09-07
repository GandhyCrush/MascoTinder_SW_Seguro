<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registroStyle.css">
<title>Registro Personal</title>
</head>
<body>
	<div class="container">
		<form method="post" action="RegistrarPersonaController">
			<h1>Registro MascoTinder</h1>
			<div class="img"><img src="https://img.icons8.com/cotton/64/000000/dog-heart--v3.png" /></div> 
			<div class="form-group">
				<input type="text" required="required" name="nombre" pattern="^[a-zA-Z'\-]+(\s+[a-zA-Z'\-]+)*$" maxlength="30" 
					title="Por favor, ingrese un formato de nombre válido. Se aceptan guiones y apóstrofes (no tildes ni diéresis). El nombre debe comenzar con una letra."/> 
				<label for="input" class="control-label" >Nombre</label><i class="bar"></i>
			</div>
			<div class="form-group">
				<input type="text" required="required" name="apellido" pattern="^[a-zA-Z'\-]+(\s+[a-zA-Z'\-]+)*$" maxlength="30"
					title="Por favor, ingrese un formato de apellido válido. Se aceptan guiones y apóstrofes (no tildes ni diéresis). El apellido debe comenzar con una letra."/> 
				<label for="input"class="control-label">Apellido</label><i class="bar"></i>
			</div>
			<div class="form-group">
				<input type="text" required="required" name="username" pattern="[A-Za-z0-9]+" minlength="5" maxlength="12" 
				title="Letras y números. Tamaño mínimo: 5 caráteres. Tamaño máximo: 12 caracteres"  /> 
				<label for="input" class="control-label">Nombre de Usuario</label><i class="bar"></i>
			</div>
			<div class="form-group">
				<input id="password" type="password" required="required" name="clave" minlength="12" maxlength="16" 
				title="Tamaño mínimo: 12 caráteres. Tamaño máximo: 16 caracteres"/> 
				<label for="input" class="control-label">Contraseña</label><i class="bar"></i>
			</div>
			<div class="button-container">
				<button type="submit" class="button">
					<span>Registrame</span>
				</button>
			</div>
		</form>

	</div>
</body>
</html>
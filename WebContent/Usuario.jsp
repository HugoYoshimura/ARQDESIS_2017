<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@page import="br.usjt.arqdesis.sistemaPredial.model.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="viewport"
	content="width=device-width, initial-scale=1">
<title>Visualizar Usuário</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<!-- 
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.html">Sistema Controle
				Predial</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="disable"><a href="index.html">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Usuário<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="user.html">Cadastrar</a></li>
					<li><a href="Usuario.jsp">Configurar</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Empresa<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="empresa.html">Cadastrar</a></li>
					<li><a href="Empresa.jsp">Configurar</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<%
		Usuario user = (Usuario) request.getAttribute("usuario");
	%>


</body>
</html>
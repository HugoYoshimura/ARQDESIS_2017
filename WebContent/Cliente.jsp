<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.usjt.arqdesis.sistemaPredial.model.Cliente"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Cliente</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>
	<!-- Barra superior com os menus de navegação -->

	<!-- Barra superior com os menus de navegação -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Cadastro</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html">Clientes</a>                    
                    </li>
                    <li><a href="user.html">Usuário</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			Visualizar Cliente #<%=cliente.getId()%></h3>
		<div class="row">
			<div class="col-md-12">
				<p>
					<strong>Nome</strong>
				</p>
				<p>
					<%=cliente.getNome()%>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Celular</strong>
				</p>
				<p>
					<%=cliente.getFone()%>
				</p>
			</div>
			<div class="col-md-6">
				<p>
					<strong>E-Mail</strong>
				</p>
				<p>
					<%=cliente.getEmail()%>
				</p>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.html" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>
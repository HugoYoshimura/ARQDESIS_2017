<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@page import="br.usjt.arqdesis.sistemaPredial.model.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Usuário</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
					<li><a href="usuario.html">Controle</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Empresa<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="empresa.html">Cadastrar</a></li>
					<li><a href="Empresa.jsp">Controle</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<%
		Usuario user = (Usuario) request.getAttribute("usuario");
	%>
	<div id="main" class="container">
		<h3 class="page-header">Incluir Usuário</h3>
		<form action="ManterUsuario" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-2">
					<label class="disable" for="id">ID</label>
					<p><%=user.getIdUsuario()%></p>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-8">
					<label for="nome">Nome</label>
					<p><%=user.getNome()%></p>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="login">Login</label>
					<p><%=user.getLogin()%></p>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="cpf">CPF</label>
					<p><%=user.getCpf()%></p>
				</div>

				<div class="form-group col-md-3">
					<label for="data">Data de Nascimento</label>
					<p><%=user.getDataNascimento()%></p>
				</div>


				<div class="form-group col-md-2">
					<label for="sexo">Sexo</label>
					<p><%=user.getSexo()%></p>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="endereco">Endereço</label>
					<p><%=user.getEndereco()%></p>
				</div>

				<div class="form-group col-md-3">
					<label for="cep">CEP</label>
					<p><%=user.getCep()%></p>
				</div>

				<div class="form-group col-md-3">
					<label for="telefone">Celular</label>
					<p><%=user.getTelefone()%></p>
				</div>

				<div class="form-group col-md-3">
					<label for="email">E-Mail</label>
					<p><%=user.getEmail()%></p>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="conta">Tipo de Conta</label>
					<p><%=user.getConta()%></p>
				</div>

				<div class="form-group col-md-3">
					<label for="acesso">Tipo de Acesso</label>
					<p><%=user.getAcesso()%></p>
				</div>
			</div>

			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="action" value="put">Alterar</button> 
					<button type="submit" class="btn btn-success" name="action" value="delete">Excluir</button>
					<a href="index.html" class="btn btn-danger">Voltar</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

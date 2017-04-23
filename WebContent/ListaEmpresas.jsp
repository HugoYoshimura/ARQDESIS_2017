<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Usuários</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<c:import url="Menu.jsp" />
	<h3 class="page-header">Lista de Empresas</h3>
	<form action="ManterEmpresa" method="post">
		<table>

			<c:forEach var="empresa" items="${lista}">
				<tr>
					<td>${empresa.idEmpresa}</td>
					<td>${empresa.cnpj}</td>
					<td>${empresa.razaoSocial}</td>
					<td>${empresa.nomeFantasia}</td>
				</tr>
				<tr>
					<td>${empresa.conjuntosString}</td>
					<td>${empresa.horarioInicio}</td>
					<td>${empresa.horarioFim}</td>
					<td></td>
				</tr>
				<tr>
					<td>${empresa.temperatura}</td>
					<td>${empresa.horLigarAC}</td>
					<td>${empresa.horDesligarAC}</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" class="btn btn-primary btn-sm"
							name="action" value="select-${empresa.idEmpresa}">Alterar</button></td>
					<td><button type="submit" class="btn btn-danger btn-sm"
							name="action" value="delete-${empresa.idEmpresa}">Excluir</button></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</form>
</body>
</html>
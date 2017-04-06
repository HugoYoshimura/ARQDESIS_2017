<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@page import="br.usjt.arqdesis.sistemaPredial.model.Usuario"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat" %>
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
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".data").datepicker(
						{
							dateFormat : 'dd/mm/yy',
							dayNames : [ 'Domingo', 'Segunda', 'Terça',
									'Quarta', 'Quinta', 'Sexta', 'Sábado',
									'Domingo' ],
							dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S',
									'D' ],
							dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
									'Qui', 'Sex', 'Sáb', 'Dom' ],
							monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
									'Abril', 'Maio', 'Junho', 'Julho',
									'Agosto', 'Setembro', 'Outubro',
									'Novembro', 'Dezembro' ],
							monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
									'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out',
									'Nov', 'Dez' ],
							nextText : 'Próximo',
							prevText : 'Anterior'
						});
			});
</script>
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
			<div class="row">
				<div class="form-group col-md-2">
					<label for="idLb">ID</label>
					<input type="text"
						class="form-control" name="idUsuario" id="idUsuario" required maxlength="4"
						value=<%=user.getIdUsuario()%>>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-8">
					<label for="nomeLb">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" required maxlength="45"
						value=<%=user.getNome()%>>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="loginLb">Login</label> <input type="text"
						class="form-control" name="login" id="login" required
						maxlength="45" value=<%=user.getLogin()%>>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="cpfLb">CPF</label> <input type="text"
						class="form-control" name="cpf" id="cpf" required maxlength="11"
						value=<%=user.getCpf()%>>
				</div>

				<div class="form-group col-md-3">
				<%!	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy"); %>
				<%!	String date = ""; %>
				<%	date = f.format(user.getDataNascimento()); %>
				
				
					<label for="data">Data de Nascimento</label> <input type="date"
						data-provide="datepicker" class="form-control data" name="data" id="data"
						value=<%=date.toString()%>>
				</div>


				<div class="form-group col-md-2">
					<label for="sexoLb">Sexo</label> <input type="text"
						class="form-control" name="sexo" id="sexo" required maxlength="9"
						value=<%=user.getSexo()%>>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="enderecoLb">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco" required
						maxlength="60" value=<%=user.getEndereco()%>>
				</div>

				<div class="form-group col-md-3">
					<label for="cepLb">CEP</label> <input type="text"
						class="form-control" name="cep" id="cep" required maxlength="8"
						value=<%=user.getCep()%>>
				</div>

				<div class="form-group col-md-3">
					<label for="telefoneLb">Celular</label> <input type="text"
						class="form-control" name="telefone" id="telefone" required
						maxlength="11" value=<%=user.getTelefone()%>>
				</div>

				<div class="form-group col-md-3">
					<label for="emailLb">E-Mail</label> <input type="text"
						class="form-control" name="email" id="email" required
						maxlength="60" value=<%=user.getEmail()%>>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="contaLb">Tipo de Conta</label> 
					<%! String contaS = "";	
						String contaT = ""; 
						String conta = ""; %>
					<% conta = user.getConta(); %>
					<%! String contaP(){
						if(conta.equals("funcionario")){
							contaS = "atendente";
							contaT = "sindico";
							return "funcionario";
						} if(conta.equals("atendente")){
							contaS = "funcionario";
							contaT = "sindico";
							return "atendente";
						}
						else {
							contaS = "funcionario";
							contaT = "atendente";
							return "sindico";
						}
					}%>
					<select id="conta">
					<option value=<%=contaP() %>><%=contaP() %></option>
					<option value=<%=contaS %>><%=contaS %></option>
					<option value=<%=contaT %>><%=contaT %></option>
					</select>
					
				</div>

				<div class="form-group col-md-3">
					<label for="acessoLb">Tipo de Acesso</label>
					
					 <select id="acesso">
					 <%! String acesso = "";	
						String acessoS = ""; %>
					<% acesso = user.getAcesso(); %>
					<%! String acessoP(){
						if(acesso.equals("restrito")){
							acessoS = "livre";
							return "restrito";
						} else {
							acessoS = "restrito";
							return "livre";
						}
					}%>
					<option value=<%=acessoP() %>><%=acessoP() %></option>
					<option value=<%=acessoS %>><%=acessoS %></option>
					 </select>
				</div>
			</div>

			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="action"
						value="update">Alterar</button>
					<button type="submit" class="btn btn-success" name="action"
						value="delete">Excluir</button>
					<a href="index.html" class="btn btn-danger">Voltar</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

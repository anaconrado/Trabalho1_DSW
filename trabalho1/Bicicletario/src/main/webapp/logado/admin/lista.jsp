<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Administração</title>
</head>

<style>
	table {
            border-collapse: collapse;
        }
        
        th, td {
            padding: 8px;
            text-align: left;
        }
        
        tr:hover {
            background-color: #a9ade2;
        }
		caption{
			font-family: Verdana, Geneva, Tahoma, sans-serif;
		}
</style>

<body>
	<div align="center">
		<h1>Gerenciamento de usuários</h1>
		<h2><a href="/${requestScope.contextPath}">Menu Principal</a></h2> &nbsp;&nbsp;&nbsp; 
		<h2>
			<a href="/${requestScope.contextPath}/admin/cadastroCliente">Adicione Novo Cliente</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de clientes</caption>
			<tr>
				<th>CPF</th>
				<th>Email</th>
				<th>Papel</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Sexo</th>
				<th>Data de nascimento</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<td>${cliente.cpf}</td>
					<td>${cliente.email}</td>
					<td>${cliente.papel}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.sexo}</td>
					<td>${cliente.nascimento}</td>
					<td>
						<button class="button-link" onclick="location.href='/${requestScope.contextPath}/admin/formularioCliente?cpf=${cliente.cpf}'">Edição</button>
						<button class="button-link" onclick="if(confirm('Tem certeza de que deseja excluir este item?')) location.href='/${requestScope.contextPath}/admin/remocaoCliente?cpf=${cliente.cpf}'">Remoção</button>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<h2>
			<a href="/${requestScope.contextPath}/admin/cadastroLocadora">Adicione Nova Locadora</a>
		</h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de locadoras</caption>
			<tr>
				<th>CNPJ</th>
				<th>Email</th>
				<th>Papel</th>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.cnpj}</td>
					<td>${locadora.email}</td>
					<td>${locadora.papel}</td>
					<td>${locadora.nome}</td>
					<td>${locadora.cidade}</td>
					<td>
						<button class="button-link" onclick="location.href='/${requestScope.contextPath}/admin/formularioLocadora?cnpj=${locadora.cnpj}'">Edição</button>
						<button class="button-link" onclick="if(confirm('Tem certeza de que deseja excluir este item?')) location.href='/${requestScope.contextPath}/admin/remocaoLocadora?cnpj=${locadora.cnpj}'">Remoção</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
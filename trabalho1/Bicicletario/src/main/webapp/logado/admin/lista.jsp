<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
<head>
	<title><fmt:message key="page.tittle.admin" /></title>
</head>

<body>
	<div align="center">
		<h1>
			<fmt:message key="page.welcome" /> ${sessionScope.clienteLogado.papel} .
		</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/logout.jsp"> 
				<fmt:message key="page.logout" />
			</a>
		</h2>
		<h2>
			<a href="/${requestScope.contextPath}/admin/cadastroCliente"><fmt:message key="cliente.add" /></a>
		</h2>
	</div>

	<div align="center">
		<h3><fmt:message key="cliente.list" /></h3>
		<table border="1">
			<tr>
				<th><fmt:message key="cliente.cpf" /></th>
				<th><fmt:message key="cliente.email" /></th>
				<th><fmt:message key="cliente.papel" /></th>
				<th><fmt:message key="cliente.nome" /></th>
				<th><fmt:message key="cliente.telefone" /></th>
				<th><fmt:message key="cliente.sexo" /></th>
				<th><fmt:message key="cliente.dataNasc" /></th>
				<th><fmt:message key="page.acoes" /></th>
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
						<button class="button-link" onclick="location.href='/${requestScope.contextPath}/admin/formularioCliente?cpf=${cliente.cpf}'"><fmt:message key="page.editar" /></button>
						<button class="button-link" onclick="if(confirm('Tem certeza de que deseja excluir este item?')) location.href='/${requestScope.contextPath}/admin/remocaoCliente?cpf=${cliente.cpf}'"><fmt:message key="page.remover" /></button>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<h2>
			<a href="/${requestScope.contextPath}/admin/cadastroLocadora"><fmt:message key="locadora.adicionar" /></a>
		</h2>
	</div>
	<div align="center">
		<h3><fmt:message key="locadora.lista" /></h3>
		<table border="1">
			<tr>
				<th><fmt:message key="locadora.cnpj" /></th>
				<th><fmt:message key="locadora.email" /></th>
				<th><fmt:message key="locadora.papel" /></th>
				<th><fmt:message key="locadora.nome" /></th>
				<th><fmt:message key="locadora.cidade" /></th>
				<th><fmt:message key="page.acoes" /></th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.cnpj}</td>
					<td>${locadora.email}</td>
					<td>${locadora.papel}</td>
					<td>${locadora.nome}</td>
					<td>${locadora.cidade}</td>
					<td>
						<button class="button-link" onclick="location.href='/${requestScope.contextPath}/admin/formularioLocadora?cnpj=${locadora.cnpj}'"><fmt:message key="page.editar" /></button>
						<button class="button-link" onclick="if(confirm('Tem certeza de que deseja excluir este item?')) location.href='/${requestScope.contextPath}/admin/remocaoLocadora?cnpj=${locadora.cnpj}'"><fmt:message key="page.remover" /></button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>
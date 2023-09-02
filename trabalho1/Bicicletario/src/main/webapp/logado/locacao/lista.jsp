<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gerenciamento de locação</title>
	</head>

	<body>

		<div align="center">
			<h1>
				Bem vindo
			</h1>
			<h2>
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					logout
				</a>
			</h2>
			<br />
			<h3> Lista de locações </h3>
			<br />
		</div>

		<div align="center">
			<table border="1">
				<caption></caption>
				<tr>
					<th>ID da locação</th>
					<th>Status</th>
					<th>Data</th>
					<th>Valor</th>
					<th>ID da locadora </th>
					<th>ID do cliente</th>
				</tr>
				<c:forEach var="locacao" items="${requestScope.listaLocacoes}">
					<tr>
						<td>${locacao.id}</td>
						<td>${locacao.status}</td>
						<td>${locacao.data}</td>
						<td>${locacao.val}</td>
						<td>${locacao.locadora.cnpj}</td>
						<td>${locacao.cliente.cpf}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>

</html>
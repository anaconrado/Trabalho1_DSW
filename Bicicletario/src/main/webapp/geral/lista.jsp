<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Livraria Virtual</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Livros</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/Locadoras/">Lista Locadoras</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Livros</caption>
			<tr>
				<th>CNPJ</th>
				<th>Descrição</th>
				<th>Cidade</th>
				
			</tr>
			<c:forEach var="locadora" items="${requestScope.locadora}">
				<tr>
					<td>${locadora.getCnpj()}</td>
					<td>${locadora.getDescricao()}</td>
					<td>${locadora.getCidade()}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

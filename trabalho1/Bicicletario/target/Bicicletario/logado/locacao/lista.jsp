<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
<head>
	<title><fmt:message key="locacao.management" /></title>
</head>

	<body>

		<div align="center">
			<h1>
				<fmt:message key="locacao.welcome" />
			</h1>
			<h2>
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					<fmt:message key="locacao.logout" />
				</a>
			</h2>
			<br />
			<h3> <fmt:message key="locacao.lista" /> </h3>
			<br />
		</div>

		<div align="center">
			<table border="1">
				<caption></caption>
				<tr>
					<th><fmt:message key="locacao.ID" /></th>
					<th><fmt:message key="locacao.status" /></th>
					<th><fmt:message key="locacao.data" /></th>
					<th><fmt:message key="locacao.valor" /></th>
					<th><fmt:message key="locacao.locadora.ID" /> </th>
					<th><fmt:message key="locacao.cliente.ID" /></th>
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
</fmt:bundle>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Sistema de locação</title>
</head>

<body>
	<div align="center">
		<h1>Gerenciamento de usuários</h1>
		<h2>
			<a href="lista">Lista de Locadoras</a>
		</h2>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${locadora != null}">
				<form action="atualizacaoLocadora" method="post">
					<%@include file="camposLocadora.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercaoLocadora" method="post">
					<%@include file="camposLocadora.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>

</html>
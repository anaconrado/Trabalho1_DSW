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
		<h2>
			<a href="lista"><fmt:message key="cliente.list" /></a>
		</h2>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${cliente != null}">
				<form action="atualizacaoCliente" method="post">
					<%@include file="camposCliente.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercaoCliente" method="post">
					<%@include file="camposCliente.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</fmt:bundle>
</html>
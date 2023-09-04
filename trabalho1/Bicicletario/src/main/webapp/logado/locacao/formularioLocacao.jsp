<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<fmt:bundle basename="message">
<head>
<title><fmt:message key="page.title.locacao" /></title>
</head>

<body>
	<div align="center">
		<h2>
			<a href="/${requestScope.contextPath}/locacao/listaLocacoes"><fmt:message key="locacao.list" /></a>
		</h2>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${locacao != null}">
				<form action="atualizacaoLocacao" method="post">
					<%@include file="camposLocacao.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercaoLocacao" method="post">
					<%@include file="camposLocacao.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</fmt:bundle>
</html>
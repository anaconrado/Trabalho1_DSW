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
			<a href="lista"><fmt:message key="locadora.lista" /></a>
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
</body>
</fmt:bundle>
</html>
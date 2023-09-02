<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:bundle basename="message">
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${locadora != null}">
							<fmt:message key="locadora.title.edicao" />
							<tr>
								<td><label for="cnpj">CNPJ</label></td>
								<td><input type="text" id="cnpj" name="cnpj" size="45" 
									value="${locadora.cnpj}" readonly /></td>
							</tr>
                        </c:when>
			<c:otherwise>
							<fmt:message key="locadora.title.cadastro" />
							<tr>
								<td><label for="cnpj">CNPJ</label></td>
								<td><input type="text" id="cnpj" name="cnpj" size="45" 
									value="${locadora.cnpj}" required /></td>
							</tr>
                        </c:otherwise>
		</c:choose>
	</caption>
	
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			required value="${locadora.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="page.senha" /></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${locadora.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel"><fmt:message key="locadora.papel" /></label></td>
		<td><input type="text" id="papel" name="papel" size="45"
			value="${locadora.papel}"/></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="locadora.nome" /></label></td>
		<td><input type="text" id="nome" name="nome" size="45" 
			value="${locadora.nome}" /></td>
	</tr>
	<tr>
		<td><label for="cidade"><fmt:message key="locadora.cidade" /></label></td>
		<td><input type="text" id="cidade" name="cidade" size="45" 
			value="${locadora.cidade}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Save" /></td>
	</tr>
</table>
</fmt:bundle>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html> 
<html>
<fmt:bundle basename="message">
<head>
    <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
</head>
<table border="1">
	<c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
	</c:if>
	<caption>
		<c:choose>
			<c:when test="${cliente != null}">
							<fmt:message key="cliente.tittle.edicao" />
							<tr>
								<td><label for="cpf">CPF</label></td>
								<td><input type="text" id="cpf" name="cpf" size="14" 
									value="${cliente.cpf}" readonly /></td>
							</tr>
                        </c:when>
			<c:otherwise>
							<fmt:message key="cliente.tittle.cadastro" />

							<tr>
								<td><label for="cpf">CPF</label></td>
								<td><input type="text" id="cpf" name="cpf" size="14" 
									value="<c:out value='${cliente.nome}' />" required/></td>
							</tr>
                        </c:otherwise>
		</c:choose>
	</caption>
	
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			required value="${cliente.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="page.senha" /></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${cliente.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel"><fmt:message key="cliente.papel" /></label></td>
		<td><input type="text" id="papel" name="papel" size="45"
			value="${cliente.papel}"/></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="cliente.nome" /></label></td>
		<td><input type="text" id="nome" name="nome" size="45" 
			value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="telefone"><fmt:message key="cliente.telefone" /></label></td>
		<td><input type="text" id="telefone" name="telefone" size="45" 
			value="${cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo"><fmt:message key="cliente.sexo" /></label></td>
		<td><input type="text" id="sexo" name="sexo" size="10" 
			value="${cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="nascimento"><fmt:message key="cliente.dataNasc" /></label></td>
		<td><input type="text" id="nascimento" name="nascimento" size="45" 
			value="${cliente.nascimento}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Save" /></td>
	</tr>
</table>
</fmt:bundle>
</html>
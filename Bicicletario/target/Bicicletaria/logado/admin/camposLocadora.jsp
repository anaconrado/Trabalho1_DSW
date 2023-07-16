<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${locadora != null}">
                            Edição de locadora
                        </c:when>
			<c:otherwise>
                            Cadastro de locadora
                        </c:otherwise>
		</c:choose>
	</caption>
	<tr>
		<td><label for="codigo">Código</label></td>
		<td><input type="text" id="codigo" name="codigo" size="20" required
			required value="${cliente.codigo}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			required value="${cliente.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${cliente.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel">Papel</label></td>
		<td><input type="text" id="papel" name="papel" size="45"
			value="${cliente.papel}"/></td>
	</tr>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45" 
			value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="cpf">CNPJ</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="45" 
			value="${locadora.cnpj}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Cidade</label></td>
		<td><input type="text" id="cidade" name="cidade" size="45" 
			value="${locadora.cidade}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>
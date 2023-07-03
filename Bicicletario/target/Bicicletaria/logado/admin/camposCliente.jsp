<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${cliente != null}">
                            Edição de Cliente
                        </c:when>
			<c:otherwise>
                            Cadastro de Cliente
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
		<td><label for="cpf">CPF</label></td>
		<td><input type="text" id="cpf" name="cpf" size="45" 
			value="${cliente.cpf}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Telefone</label></td>
		<td><input type="text" id="telefone" name="telefone" size="45" 
			value="${cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo">Sexo</label></td>
		<td><input type="text" id="sexo" name="sexo" size="45" 
			value="${cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="nascimento">Nascimento</label></td>
		<td><input type="text" id="nascimento" name="nascimento" size="45" 
			value="${cliente.nascimento}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>
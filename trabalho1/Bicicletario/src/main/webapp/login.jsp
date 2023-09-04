<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Autenticação de Usuário</title>
    <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
   
</head>
<body>
    <div>
        <h1 align="center"><fmt:message key="page.autenticacao" /></h1>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <form method="post" action="index.jsp">
            <table style="margin: 0 auto;">
                <tr>
                    <th>Email: </th>
                    <td><input type="text" name="email" value="${param.email}"/></td>
                </tr>
                <tr>
                    <th><fmt:message key="page.senha" /></th>
                    <td><input type="password" name="senha" /></td>
                </tr>
                <tr>
                    <td colspan="2"> 
                        <input type="submit" name="bOK" value="Entrar"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div align="center"> 
		<button class="button-link" onclick="location.href='locadora/listaLocadoras'"><fmt:message key="page.editar" /></button>
		<button class="button-link" onclick="location.href='locadora/locadorasPorCidade'"><fmt:message key="page.editar" /></button>

    </div>

</body>
</fmt:bundle>
</html>

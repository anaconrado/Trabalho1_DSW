<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Autenticação de Usuário</title>
    <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }
        
        input[type="submit"] {
            background-color: #878de0;
            color: #fff;
            cursor: pointer;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }
        th, h1 {
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }
    </style>
</head>
<body>
    <div>
        <h1>Autenticação de Usuário</h1>
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
                    <th>Senha: </th>
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
</body>
</html>

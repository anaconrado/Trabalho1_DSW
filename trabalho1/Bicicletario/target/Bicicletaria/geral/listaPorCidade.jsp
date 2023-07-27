<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Locadoras por Cidade</title>
</head>
<body>
    <h1>Lista de Locadoras por Cidade</h1>
    <p>Cidade: <%= request.getAttribute("cidade") %></p>
    <table>
        <thead>
            <tr>
                <th>CNPJ</th>
                <th>Descrição</th>
                <th>Cidade</th>
            </tr>
        </thead>
        <tbody>
            <% List<Locadora> locadoras = (List<Locadora>) request.getAttribute("locadoras");
            for (Locadora locadora : locadoras) { %>
                <tr>
                    <td><%= locadora.getCnpj() %></td>
                    <td><%= locadora.getDescricao() %></td>
                    <td><%= locadora.getCidade() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
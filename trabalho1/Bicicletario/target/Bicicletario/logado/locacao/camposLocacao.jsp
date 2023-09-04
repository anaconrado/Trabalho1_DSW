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
			<c:when test="${locacao != null}">
				<fmt:message key="locacao.tittle.edicao" />
				<tr>
					<td><label for="id">ID</label></td>
					<td><input type="text" id="id" name="id" size="14" 
						value="${locacao.id}" readonly /></td>
				</tr>
            </c:when>
			<c:otherwise>
			<fmt:message key="locacao.tittle.cadastro" />

			<tr>
				<td><label for="id">ID</label></td>
				<td><input type="text" id="id" name="id" size="14" 
					value="<c:out value='${locacao.id}' />" required/></td>
			</tr>
        </c:otherwise>
		</c:choose>
	</caption>
	
	<tr>
		<td><label for="valor">Valor:</label></td>
		<td><input type="text" id="valor" name="valor" size="45" required
			required value="${locacao.valor}" /></td>
	</tr>
	
	<tr>
		<td><label for="locadora">Locadora:</label></td>
		   <td> <select id="locadora" name="locadora" th:field="*{locadora}">
		        <option th:each="locadora : ${Locadora}" 
		                th:value="${locadora.id}" 
		                th:text="${locadora.nome}"></option>
		    </select>
		    
		    <div class="invalid-feedback">
				<span th:errors="*{locadora}"></span>
			</div> </td>
	</tr>
	<tr>
		<td><label for="bicicleta">Bicicleta:</label></td>
		   <td> <select id="bicicleta" name="bicicleta" th:field="*{bicicleta}">
		        <option th:each="bicicleta : ${Bicicleta}" 
		                th:value="${bicicleta.id}" 
		                th:text="${bicicleta.modelo}"></option>
		    </select>
		    
		    <div class="invalid-feedback">
				<span th:errors="*{bicicleta}"></span>
			</div> </td>
	</tr>
	<tr>
		<td><label th:text="#{locacao.data.label}" for="data"></label> 
	        <input type="text" class="form-control" id="data" th:field="*{data}"
	               placeholder="Selecione a data e hora" required/></td>
	</tr>
	
	<tr>
		<td><input type="hidden" th:field="*{cliente.id}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Save" /></td>
	</tr>
</table>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.1/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script>
    $(document).ready(function() {
        $('#data').datetimepicker({
            format: 'DD/MM/YYYY HH:mm',
            stepping: 60,
            minDate: moment(),
            defaultDate: moment()
        });
    });
</script>
</fmt:bundle>
</html>
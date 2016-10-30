<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<html>
<body>
   <table border="1">
      <tr>
         <th>Id</th>
         <th>Descrição</th>
         <th>Finalizado</th>
         <th>Data de finalização</th>
         <th>Remoção</th>
         <th>Alteração</th>
         <th>Finalização</th>
      </tr>
      <c:forEach items="${tarefas}" var="tarefa">
         <tr>
  
            <td>${tarefa.id}</td>
		
            <td>${tarefa.descricao}</td>
				
            <c:if test="${tarefa.finalizado eq false}">
               <td>Não finalizada</td>
            </c:if>
            <c:if test="${tarefa.finalizado eq true}">
               <td>Finalizado</td>
            </c:if>
				
            <td>
               <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
            </td>
   			<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
   			<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
   			<td><a href="mostrafinalizaTarefa?id=${tarefa.id}">Finalizar</a></td>
         </tr>
      </c:forEach>
   </table>
   <br>
   <a href="homepage">Clique aqui para voltar para a homepage</a><br>
</body>
</html>
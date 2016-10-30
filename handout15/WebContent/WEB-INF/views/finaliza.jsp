<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finalizar tarefa</title>
</head>
<body>
<h3>Finalizar tarefa - ${id.id} </h3>
<form action="finalizaTarefa" method="post">
<input type="hidden" name="id" value="${id.id}"/>
<input type="hidden" name="finalizado"
value="true" ${id.finalizado? 'checked' : '' }/>

<input type='hidden' name="dataFinalizacao"
value="<fmt:formatDate value='${id.dataFinalizacao.time}' pattern='dd/MM/yyyy'/>"/>


<input type="submit" value="Finalizar"/>  
<input type="submit" action="listaTarefas" value="voltar"/>
</form>
</body>
</html>
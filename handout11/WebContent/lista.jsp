<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cadastro</title>
</head>
<body>
<%@ page import="java.util.*,handout11.*" %>
<table border='1'>       
<% DAO dao = new DAO();
   Date data = new Date();
   String mensagem = " Horario local: ";
   out.println(mensagem);
   out.println(data); %>
   <%List<Pessoas> pessoas = dao.getLista();%>
<br>
<br>
   
   <tr><td>ID</td><td>Nome</td><td>Nascimento</td><td>Altura</td></tr> <%
   
   for (Pessoas pessoa : pessoas ) { %>
    <tr>
    	<td><%=pessoa.getId()%></td>
        <td><%=pessoa.getNome()%></td>
        <td><%=pessoa.getNascimento().getTime()%></td>
        <td><%=pessoa.getAltura()*3.28084%></td>
        
    </tr>
<% } %>
</table>
<br>

<br>
<table border='1'>
<%List<Passaportes> passaportes = dao.getListaPassaportes();%>
<tr><td>ID</td><td>pessoa_id</td><td>Pais</td><td>Validade</td></tr>
<%	for (Passaportes passaporte : passaportes) { %>
	<tr>
	    <td><%=passaporte.getId() %></td>
		<td><%=passaporte.getPessoa_id() %></td>
		<td><%=passaporte.getPais() %></td>
		<td><%=passaporte.getValidade().getTime() %>
	</td>
<%} %>
		
</table>
</body>
</html>
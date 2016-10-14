<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,handout11.*" %>    
<% DAO dao = new DAO();
   Date data = new Date(); %>
   <%List<Pessoas> pessoas = dao.getLista();%>
   <?xml version="1.0" encoding="UTF-8"?>

   <%= request.getParameter("format") %>

<Lista>
   <%for (Pessoas pessoa : pessoas ) { %>
    <Pessoa>
    
    	<ID><%=pessoa.getId() %></ID>
        <Nome><%=pessoa.getNome()%></Nome>
        <Data><%=pessoa.getNascimento().getTime()%></Data>
        <Altura><%=pessoa.getAltura()*3.28084%></Altura>
        
    </Pessoa>
    
<%} %>
</Lista>
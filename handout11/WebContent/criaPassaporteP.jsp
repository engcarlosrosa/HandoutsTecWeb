<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Passaporte</title>
</head>
<body>
<%@ page import="java.text.SimpleDateFormat,java.text.ParseException,
				java.io.IOException,java.util.*,handout11.*" %>
<%
DAO dao = new DAO();
Passaportes passaporte = new Passaportes();
passaporte.setPessoa_id(Integer.valueOf(request.getParameter("pessoa_id")));
passaporte.setPais(request.getParameter("pais"));

String validade = request.getParameter("validade");
Date data;
try {
	 data = new SimpleDateFormat("yyyy-MM-dd").parse(validade);
	 
Calendar dataValidade = Calendar.getInstance();
	 dataValidade.setTime(data);
	 passaporte.setValidade(dataValidade);
} catch (ParseException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
}
dao.adicionaPassaporte(passaporte); %>

adicionado ${ param.passaporte }

<%	dao.close();%>
			


</body>
</html>
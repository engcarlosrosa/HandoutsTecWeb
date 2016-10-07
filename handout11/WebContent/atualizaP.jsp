<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.text.SimpleDateFormat,java.text.ParseException,
				 java.io.IOException,java.util.*,handout11.*" %>
<% 	
DAO dao = new DAO();

Pessoas pessoa = new Pessoas();
pessoa.setId(Integer.valueOf(request.getParameter("id")));
pessoa.setNome(request.getParameter("nome"));   
pessoa.setAltura(Double.valueOf(request.getParameter("altura")));

String nascimento = request.getParameter("nascimento");
Date data;
try {
	data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
	Calendar dataNascimento = Calendar.getInstance();
dataNascimento.setTime(data);

pessoa.setNascimento(dataNascimento);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


dao.altera(pessoa);%>

atualizado ${ param.pessoa }
<% dao.close();%>
</body>
</html>
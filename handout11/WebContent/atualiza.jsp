<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualiza Cadastro de Pessoa</title>
</head>
<body>
<form method='post' action='atualizaP.jsp'>
ID: <input type='number' name='id'><br>
Nome: <input type='text' name='nome'><br>
Nascimento: <input type='date' name='nascimento'><br>
Altura: <input type='number' name='altura' step='0.01'><br>
<input type='submit' value='Submit'>
</form>
</body>
</html>
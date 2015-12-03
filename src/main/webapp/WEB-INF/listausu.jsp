<%@page import="br.com.ritchie.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usu&aacute;rios</title>
</head>
<body>
	<h3>Lista de Usuários</h3>
	<table border =1 width="50%">
	<tr>
		<td>Nome</td>
		<td>Login</td>
	</tr>
<%
	List<Usuario> lista = (List<Usuario>)request.getAttribute("rl");
	
	for (Usuario u: lista){
		
%>
	<tr>
		<td><%out.print(u.getNome()); %></td>
		<td><%out.print(u.getLogin()); }%></td>
	</tr>	
	</table>
</body>
</html>
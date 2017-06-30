<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String usuario = (String) request.getAttribute("usuario");

	out.println("<h1>Seja bem vindo " + usuario + "!</h1>");
	
//	request.setAttribute("usuario", usuario);
	
//	RequestDispatcher rd = request.getRequestDispatcher("/detalha-filme.jsp");
//	rd.forward(request, response);
%>

<a href='/Trabalho_Final_Marcos_LTP2/admin'>VA PARA A LISTA DE FILMES CLICANDO AQUI!</a>-->
</body>
</html>
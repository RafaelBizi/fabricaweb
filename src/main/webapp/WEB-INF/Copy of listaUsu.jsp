<%@page import="br.com.fabricadeprogramador.persistence.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuários</title>
</head>
<body>
<% 
	List<Usuario> list = (List<Usuario>) request.getAttribute("CopylistaUsuarios");

	out.print("<table border=1>");
	out.print("<tr> <th> ID	 <td>nome</td> </tr>");
	
	for (Usuario u: list){
		out.print("<tr>");
		out.print("<td>" + u.getId() + "</td>"
				  + "<td>" +u.getNome() + "</td>");
		out.print("</tr>");
	}
%>
</body>
</html>
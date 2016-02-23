<!DOCTYPE html>
<%@page import="br.com.fabricadeprogramador.persistence.entity.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Usuario usuario = (Usuario) request.getAttribute("usu");
	%>
	<form action="usucontroller.do" method="post"> 
		
		ID: <input type="number" name="id" value="<%=usuario.getId()%>"/> <br>
		Nome: <input type="text" name="nome" value="<%=usuario.getNome()%>"/> <br>
		Login: <input type="text" name="login" value="<%=usuario.getLogin()%>"/> <br>
		Senha: <input type="text" name="senha" value="<%=usuario.getSenha()%>"/> <br>
		
		<input type="submit" name="Salvar"/>
		
	</form>
</body>
</html>
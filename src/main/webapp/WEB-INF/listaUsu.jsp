<%@page import="br.com.fabricadeprogramador.persistence.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuários</title>

<script type="text/javascript">
function confirmaExclusao(id) { // no javascript, as variáveis são auto-declaráveis
	if (window.confirm('Tem certeza que deseja excluir?')){
		location.href="usucontroller.do?acao=excluir&id="+id;
	}
}
</script>

</head>
<body>
<% 
	List<Usuario> list = (List<Usuario>) request.getAttribute("listaUsuarios");
%>

<table border=1>
<tr> <th>ID</th> <th>Nome</th> <th>Ação</th> </tr>
	
	<% for (Usuario u: list){  %>
		<tr>
		<td> <% out.print(u.getId()); %> </td>
		<td> <%= u.getNome() %> </td> <!-- O comando '%=' repete o out.print da linha anterior -->
		<td> <%= u.getLogin() %> </td>
		
		<td> <a href="javascript:confirmaExclusao(<%= u.getId()%>)"> Excluir </a> </td>
		<td> <a href="usucontroller.do?acao=alterar&id=<%= u.getId()%>"> Alterar </a> </td>
		
		 </td>
			
		</tr>
	<% } %>

</body>
</html>
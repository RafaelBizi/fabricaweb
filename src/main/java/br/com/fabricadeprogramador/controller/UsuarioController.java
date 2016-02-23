package br.com.fabricadeprogramador.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.fabricadeprogramador.persistence.entity.Usuario;
import br.com.fabricadeprogramador.persistence.jdbc.UsuarioDAO;


//Define o caminho web exemplo: http://localhost:8080/fabricaweb/usucontroller.do
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet{
	
	public UsuarioController(){
		System.out.println("Construtor...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init...");
		super.init();
	}
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
	resp.setContentType("text/html");
	
	String acao = req.getParameter("acao");
		
		if (acao.equals("excluir")){
			
			Usuario usu = new Usuario();
			String id = req.getParameter("id");
			if (id != null)
				usu.setId(Integer.parseInt(id));
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.ExcluirDAO(usu);
			resp.getWriter().print("<b>Exclusão bem sucedida!</b>");	
			resp.sendRedirect("usucontroller.do?acao=listar");
			
		} else if (acao.equals("alterar")){
				
				Usuario usu = new Usuario();
				String id = req.getParameter("id");
				if (id != null)
					usu.setId(Integer.parseInt(id));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
				req.setAttribute("usu", usuario);
				RequestDispatcher dispatcher =  req.getRequestDispatcher("WEB-INF/frmUsuario.jsp");
				dispatcher.forward(req, resp);
				
				}	else if (acao.equals("listar")){
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					List<Usuario> lista = usuarioDAO.buscarTodos();
				
					// Adiciona atributos ao 'req' para que lá no JSP ele possa ser acessado
					req.setAttribute("listaUsuarios",lista);
				
					RequestDispatcher dispatcher =  req.getRequestDispatcher("WEB-INF/listaUsu.jsp");
					dispatcher.forward(req, resp);
			
					} else if (acao.equals("cadastrar")){
						Usuario usuario = new Usuario();
						usuario.setId(0);
						usuario.setNome("");
						usuario.setLogin("");
						usuario.setSenha("");
						
						req.setAttribute("usu", usuario);
						RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/frmUsuario.jsp");
						dispatcher.forward(req, resp);
					}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		if (id != null)
			usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usu);
		resp.getWriter().print("<b>Alterado com sucesso!</b><br>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy...");
		super.destroy(); 
	}
}

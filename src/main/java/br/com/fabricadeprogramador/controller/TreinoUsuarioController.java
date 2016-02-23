package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.fabricadeprogramador.persistence.entity.Usuario;
import br.com.fabricadeprogramador.persistence.jdbc.UsuarioDAO;


//Define o caminho web exemplo: http://localhost:8080/fabricaweb/treinousucontroller.do
@WebServlet("/treinousucontroller.do")
public class TreinoUsuarioController extends HttpServlet{
	
	public TreinoUsuarioController(){
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
			usu.setId(Integer.parseInt(id));
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.ExcluirDAO(usu);
			resp.getWriter().print("<b>Exclusão bem sucedida!</b>");
			
			} else if (acao.equals("listar")){
			
				Usuario usu = new Usuario();
				String id = req.getParameter("id");
				usu.setId(Integer.parseInt(id));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usu = usuarioDAO.buscarPorId(usu.getId());
				resp.getWriter().print("<b>Listagem bem sucedida!</b><br>");
				resp.getWriter().print("" + usu.getLogin());
				
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt(id));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.ExcluirDAO(usu);
		resp.getWriter().print("<b>Exclusão bem sucedida!</b><br>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy...");
		super.destroy(); 
	}
}

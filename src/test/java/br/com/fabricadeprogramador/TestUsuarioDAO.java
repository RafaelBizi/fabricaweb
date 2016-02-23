package br.com.fabricadeprogramador;

import java.sql.PreparedStatement;
import java.util.List;

import junit.extensions.TestDecorator;
import br.com.fabricadeprogramador.persistence.entity.Usuario;
import br.com.fabricadeprogramador.persistence.jdbc.UsuarioDAO;

public class TestUsuarioDAO {
	
	public static void main (String[] args){
		testBuscarPorLogin();
	}
	
	public static void testAlterar(){
		// criando o Usuário
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("Rafael Gomes Bizi (test)");
		usu.setLogin("rafaelbizi");
		usu.setSenha("123456");
		// cadastrando Usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.AlterarDAO(usu);
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testCadastrar(){
		// criando o Usuário
		Usuario usu = new Usuario();
		usu.setNome("Rafael Gomes Bizi");
		usu.setLogin("rafaelbizi");
		usu.setSenha("123456");
		// cadastrando Usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.CadastrarDAO(usu);
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testExcluir(){
		// criando o Usuário
		Usuario usu = new Usuario();
		usu.setId(4);
		// cadastrando Usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.ExcluirDAO(usu);
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testSalvar(){
		Usuario usu = new Usuario();
		usu.setNome("Flavio");
		usu.setLogin("flavio");
		usu.setSenha("123456");
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
	}

	public static Object testBuscarPorCodigo(){
		UsuarioDAO usuDAO = new UsuarioDAO();
		Object usuario = usuDAO.buscarPorId(5);
		return usuario;
	}
	
	public static void testBuscarPorId(){
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.buscarPorId(5);
		System.out.println(usuario);
	}
	
	public static void testBuscarTodos(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> listUsuario = usuarioDAO.buscarTodos();
		for (Usuario u: listUsuario){
		System.out.println(u.getId() +" | "+ u.getNome() +" | "+  u.getLogin() +" | "+ u.getNome());	
		}
	}
	
	public static void testBuscarPorLogin (){
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario u = usuDAO.buscaPorLogin("rafaelbizi", "1234");
		System.out.println(u.getId() +" | "+ u.getNome() +" | "+  u.getLogin() +" | "+ u.getNome());
	}
}

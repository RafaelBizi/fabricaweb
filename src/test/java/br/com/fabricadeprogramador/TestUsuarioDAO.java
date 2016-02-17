package br.com.fabricadeprogramador;

import junit.extensions.TestDecorator;
import br.com.fabricadeprogramador.persistence.entity.Usuario;
import br.com.fabricadeprogramador.persistence.jdbc.UsuarioDAO;

public class TestUsuarioDAO {
	
	public static void main (String[] args){
		testExcluir();
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
		usuDAO.DeleteDAO(usu);
		System.out.println("Cadastrado com sucesso!");
	}
}

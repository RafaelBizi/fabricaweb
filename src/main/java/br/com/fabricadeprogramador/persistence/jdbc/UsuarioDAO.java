package br.com.fabricadeprogramador.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ListUI;

import br.com.fabricadeprogramador.persistence.entity.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	
	public void CadastrarDAO (Usuario usu){
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			//Executa o comando no banco
			preparador.execute();
			//Encerra o Statment
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AlterarDAO(Usuario usu) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			//Executa o comando no banco
			preparador.execute();
			//Encerra o Statment
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ExcluirDAO(Usuario usu) {
		String sql = "delete from usuario where id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());
			//Executa o comando no banco
			preparador.execute();
			//Encerra o Statment
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usu){
		if ((usu.getId()!=null && usu.getId()!=0)){
			AlterarDAO(usu);
			System.out.println("Alterado com sucesso!");
		}else{
			CadastrarDAO(usu);
			System.out.println("Cadastrado com sucesso!");
		}
	}
	
	
	/*Buscar de um registro no banco de dados pelo número do id do usuário 
	 * @param id É um inteiro que representa o número do id do usuário a ser buscado
	 * @return Um objeto usuário quando encontra ou null quando não encontra 
	 * */
	
	public Usuario buscarPorId(Integer id){
		//Objeto de retorno do método
		Usuario usuRetornar = null;
		
		String sql = "select * from usuario where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
		preparador.setInt(1, id);
		
		//Retorno da consulta em ResultSet
		ResultSet resultado = preparador.executeQuery();
			//Se tem registro
			if (resultado.next()){
			//Instância do objeto Usuario
			usuRetornar = new Usuario();
			usuRetornar.setId(resultado.getInt("id"));
			usuRetornar.setNome(resultado.getString("nome"));
			usuRetornar.setLogin(resultado.getString("login"));
			usuRetornar.setSenha(resultado.getString("senha"));
			return usuRetornar;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuRetornar;
	}
	
	/*Realiza a busca de todos registros da tabela usuários
	 * @return Uma lista de objetos usuário, contendo 0 elementos quando não tiver registros 
	 * ou N elementos quando encontrar
	 * */
	
	public List<Usuario> buscarTodos(){
		//Objeto de retorno do método
		Usuario usuRetornar = null;
		
		String sql = "select * from usuario";
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
		//Retorno da consulta em ResultSet
		ResultSet resultado = preparador.executeQuery();
			//Se tem registro
			while (resultado.next()){
			//Instância do objeto Usuario
			Usuario usu = new Usuario();
			usu.setId(resultado.getInt("id"));
			usu.setNome(resultado.getString("nome"));
			usu.setLogin(resultado.getString("login"));
			usu.setSenha(resultado.getString("senha"));
			//Adicionando usuario na lista
			listUsuario.add(usu);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listUsuario;
	}
	
	public Usuario buscaPorLogin(String login, String senha){
		//Objeto de retorno do método
		Usuario usuRetornar = null;
		
		String sql = "select * from usuario where login=? and senha=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
		preparador.setString(1,login);
		preparador.setString(2,senha);
		
		//Retorno da consulta em ResultSet
		ResultSet resultado = preparador.executeQuery();
			//Se tem registro
			if (resultado.next()){
			//Instância do objeto Usuario
			usuRetornar = new Usuario();
			usuRetornar.setId(resultado.getInt("id"));
			usuRetornar.setNome(resultado.getString("nome"));
			usuRetornar.setLogin(resultado.getString("login"));
			usuRetornar.setSenha(resultado.getString("senha"));
			return usuRetornar;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuRetornar;
	}
	
}

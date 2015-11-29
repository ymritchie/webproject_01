package br.com.ritchie.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ritchie.entidades.Usuario;

public class UsuarioDAO {
	private Connection con = ConnectionFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";
		
		try (PreparedStatement pre = con.prepareStatement(sql)){
			pre.setString(1, usu.getNome());
			pre.setString(2, usu.getLogin());
			pre.setString(3, usu.getSenha());
			
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Usuario usu) {
		String sql = "update usuario set nome=?,login=?,senha=? where id=?";
		
		try (PreparedStatement pre = con.prepareStatement(sql)){
			pre.setString(1, usu.getNome());
			pre.setString(2, usu.getLogin());
			pre.setString(3, usu.getSenha());
			pre.setInt(4, usu.getId());
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";
		
		try (PreparedStatement pre = con.prepareStatement(sql)){
			pre.setInt(1, usu.getId());
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

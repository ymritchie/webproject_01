package br.com.ritchie.persistencia.jdbc;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void salvar (Usuario usuario){
		if (usuario.getId()!= null){
			atualizar(usuario);
		} else {
			cadastrar(usuario);
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Usuario buscaPorId (Integer id){
		Usuario usuRetorno = null;
		
		String sql = "select * from usuario where id=?";
		try (PreparedStatement pre = con.prepareStatement(sql)){
			pre.setInt(1, id);
			
			ResultSet resultado = pre.executeQuery();
			if (resultado.next()){
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				
				return usuRetorno;
			}
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public List<Usuario> buscaTodos (){
		
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		try (PreparedStatement pre = con.prepareStatement(sql)){
					
			ResultSet resultado = pre.executeQuery();
			while (resultado.next()){
				Usuario usuRetorno  = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				
				lista.add(usuRetorno);
			}
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Usuario autenticar (Usuario usuario){
		
		String sql = "select * from usuario where login=? and senha=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()){
				Usuario usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				
				return usuRetorno;
			} 
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		return null;
	}

}

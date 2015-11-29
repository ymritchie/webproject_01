package br.com.ritchie;

import br.com.ritchie.entidades.Usuario;
import br.com.ritchie.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testExcluir();
	}
	
	public static void testCadastrar(){
		Usuario usu = new Usuario();
		usu.setNome("Yanisley Mora Ritchie");
		usu.setLogin("ymritchie");
		usu.setSenha("1234");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}
	
	public static void testExcluir() {
		Usuario usu = new Usuario();
		usu.setId(2);
		
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usu);
	}

	public static void testAtualizar() {
		Usuario usu = new Usuario();
		usu.setId(2);
		usu.setNome("Yanisley Mora");
		usu.setLogin("ymritchie1");
		usu.setSenha("12345");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.atualizar(usu);
	}

}

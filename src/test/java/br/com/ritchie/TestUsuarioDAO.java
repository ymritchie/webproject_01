package br.com.ritchie;

import java.util.List;

import br.com.ritchie.entidades.Usuario;
import br.com.ritchie.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		//testarBuscarTodos();
		//testeAutenticar();
		testSalvar();
	}
	
	private static void testeAutenticar() {
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario user = new Usuario();
		user.setLogin("ymritchie");
		user.setSenha("1234");
		
		Usuario userRetorno = dao.autenticar(user);
		
		if (userRetorno.getId() > 0) {
			System.out.println("Bem Vindo: " + userRetorno.getNome());
		} else {
			System.out.println("Login ou senha Incorretos");
		}

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
	
	public static void testSalvar(){
		Usuario usu = new Usuario();
		//usu.setId(7);
		usu.setNome("Nicholas Mora");
		usu.setLogin("nic");
		usu.setSenha("123");
		
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usu);
		
		System.out.println("Salvo com sucesso!!");
	}
	
	public static void testBuscarPorId(){
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = usuDao.buscaPorId(7);
		System.out.println(usuario);
	}
	
	public static void testarBuscarTodos(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> listaTodos = usuarioDAO.buscaTodos();
		if (listaTodos.size()>0) {
			for (Usuario usu : listaTodos){
				System.out.println(usu);
			}
		} else {
			System.out.println("Nenhum registro encontrado!!");
		}
	}

}

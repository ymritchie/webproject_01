package br.com.ritchie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ritchie.entidades.Usuario;
import br.com.ritchie.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usercontroller.do")
public class UsuarioController extends HttpServlet{
	
	public UsuarioController() {

		System.out.println("Construtor...");
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  id = req.getParameter("id");
		String  nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		if (id != null) 
			usuario.setId(Integer.parseInt(id));
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.salvar(usuario);
		resp.getWriter().println("<h3>Usuário " + usuario.getNome()+", foi salvo com sucesso!</h3>");
		
	}
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
		if (acao.equals("excl")){
			String  id = req.getParameter("id"); 
			Usuario usuario = new Usuario();
			if (id != null) 
				usuario.setId(Integer.parseInt(id));
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);
			resp.getWriter().println("<h3>Usuário deletado com sucesso!!");
			
		} else if (acao.equals("list")){
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> lista = usuarioDAO.buscaTodos();
			
			req.setAttribute("rl", lista);	
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispacher.forward(req, resp);
		}	
		
		
	}
	
	
	
	
	@Override
	public void init() throws ServletException{
		System.out.println("Init...");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy....");
		super.destroy();
	}
}

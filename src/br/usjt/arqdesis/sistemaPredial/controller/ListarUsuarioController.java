package br.usjt.arqdesis.sistemaPredial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sistemaPredial.model.Usuario;
import br.usjt.arqdesis.sistemaPredial.service.UsuarioService;

@WebServlet("/ListarUsuario.do") 
public class ListarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListarUsuarioController() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService us = new UsuarioService();
		
		List<Usuario> lista = us.carregarTodosUsuarios();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher view = request.getRequestDispatcher("ListaUsuarios.jsp");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

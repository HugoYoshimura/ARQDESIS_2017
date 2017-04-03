package br.usjt.arqdesis.sistemaPredial.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sistemaPredial.model.Usuario;
import br.usjt.arqdesis.sistemaPredial.service.UsuarioService;

@WebServlet("/ManterUsuario")
public class ManterUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("insert")) {
			insert(request, response);
		} else if (action.equals("update")) {
			update(request, response);
		} else if (action.equals("select")) {
			select(request, response);
		} else if (action.equals("delete")) {
			delete(request, response);
		}

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = setAttributes(request);

		UsuarioService us = new UsuarioService();
		us.criar(user);
		user = us.carregar(user.getIdUsuario());

		request.setAttribute("usuario", user);

		RequestDispatcher view = request.getRequestDispatcher("Usuario.jsp");
		view.forward(request, response);
	}

	protected void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = new Usuario();

		UsuarioService us = new UsuarioService();

		user = us.carregar(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("usuario", user);

		RequestDispatcher view = request.getRequestDispatcher("Usuario.jsp");
		view.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = setAttributes(request);
		user.setIdUsuario(Integer.parseInt(request.getParameter("id")));

		UsuarioService us = new UsuarioService();

		us.atualizar(user);

		request.setAttribute("usuario", user);

		RequestDispatcher view = request.getRequestDispatcher("Usuario.jsp");
		view.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = new Usuario();

		UsuarioService us = new UsuarioService();

		us.excluir(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("usuario", user);

		RequestDispatcher view = request.getRequestDispatcher("Usuario.jsp");
		view.forward(request, response);
	}

	protected Usuario setAttributes(HttpServletRequest request) throws ServletException, IOException {
		String pCpf = request.getParameter("cpf");
		String pNome = request.getParameter("nome");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");
		String pSexo = request.getParameter("sexo");
		String pDataNasc = request.getParameter("data");
		String pEndereco = request.getParameter("endereco");
		String pCep = request.getParameter("cep");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		String pConta = request.getParameter("conta");
		String pAcesso = request.getParameter("acesso");

		SimpleDateFormat dtFormatter = new SimpleDateFormat("dd/MM/yyyy");

		Usuario user = new Usuario();
		user.setCpf(pCpf);
		user.setNome(pNome);
		user.setLogin(pLogin);
		user.setSenha(pSenha);
		user.setSexo(pSexo);
		try {
			user.setDataNascimento(dtFormatter.parse(pDataNasc));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEndereco(pEndereco);
		user.setCep(pCep);
		user.setTelefone(pTelefone);
		user.setEmail(pEmail);
		user.setConta(pConta);
		user.setAcesso(pAcesso);

		return user;
	}

	public void validar(String pCpf, String pNome, String pLogin, String pSenha, String pSexo, String pDataNasc,
			String pEndereco, String pCep, String pTelefone, String pEmail, String pConta, String pAcesso) {
		boolean[] validacao = new boolean[12];
		
		
	}

}

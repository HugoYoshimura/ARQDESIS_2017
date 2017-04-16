package br.usjt.arqdesis.sistemaPredial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sistemaPredial.model.Empresa;
import br.usjt.arqdesis.sistemaPredial.service.EmpresaService;

@WebServlet("/ListarEmpresa.do")
public class ListarEmpresaController {
	private static final long serialVersionUID = 1L;
	
	public ListarEmpresaController() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaService es = new EmpresaService();
		
		List<Empresa> lista = es.carregarTodasEmpresas();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher view = request.getRequestDispatcher("ListaEmpresas.jsp");
		view.forward(request,  response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

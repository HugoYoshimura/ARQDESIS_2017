package br.usjt.arqdesis.sistemaPredial.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sistemaPredial.model.Conjunto;
import br.usjt.arqdesis.sistemaPredial.model.Empresa;
import br.usjt.arqdesis.sistemaPredial.service.ConjuntoService;
import br.usjt.arqdesis.sistemaPredial.service.EmpresaService;
import br.usjt.arqdesis.sistemaPredial.service.OrdenarService;

@WebServlet("/ManterEmpresa")
public class ManterEmpresaController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		select(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action, id, command = request.getParameter("action");

		if (command != null) {
			if (command.length() == 6) {
				action = command;
				if (action != null) {
					if (action.equals("insert")) {
						insert(request, response);
					} else if (action.equals("select")) {
						select(request, response);
					} else if (action.equals("update")) {
						update(request, response);
					} else if (action.equals("delete")) {
						delete(request, response);
					}
				}
			} else {
				String[] cmd = command.split("-");
				action = cmd[0];
				id = cmd[1];
				if (action.equals("select")) {
					select(request, response, Integer.parseInt(id));
				} else if (action.equals("delete")) {
					delete(request, response, Integer.parseInt(id));
				}
			}
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Empresa emp = setAttributes(request);

		EmpresaService es = new EmpresaService();
		es.criar(emp);
		emp = es.carregar(emp.getIdEmpresa());

		Conjunto conj = new Conjunto();
		ConjuntoService cs = new ConjuntoService();

		int[] conjs = emp.getConjuntos();
		int[] conjuntos = new int[conjs.length];

		if (conjs.length != 0) {
			for (int i = 0; i < conjs.length; i++) {
				conj.setNumeroConjunto(conjs[i]);
				conj.setIdEmpresa(emp.getIdEmpresa());
				conj.setStatus(true);
				cs.criar(conj);
				conj = cs.carregar(conj.getNumeroConjunto());
				conjuntos[i] = conj.getNumeroConjunto();
			}
		}

		emp.setConjuntos(conjuntos);

		request.setAttribute("empresa", emp);

		RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
		view.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idEmpresa");

		Empresa emp = setAttributes(request);
		emp.setIdEmpresa(Integer.parseInt(id));
		
		EmpresaService es = new EmpresaService();
		es.atualizar(emp);

		emp = es.carregar(Integer.parseInt(id));

		ConjuntoService cs = new ConjuntoService();
		List<Conjunto> listaConjuntosBD = new ArrayList<Conjunto>();
		listaConjuntosBD = cs.carregarConjuntosEmpresa(emp.getIdEmpresa());
		for(int i = 0; i < listaConjuntosBD.size(); i++) {
			cs.delete(listaConjuntosBD.get(i).getNumeroConjunto());
		}
		
		Conjunto conjunto;
		for(int i = 0; i < emp.getConjuntos().length; i++) {
			conjunto = new Conjunto();
			conjunto.setIdEmpresa(emp.getIdEmpresa());
			conjunto.setNumeroConjunto(emp.getConjuntos()[i]);
			conjunto.setStatus(true);
			cs.criar(conjunto);
		}
		
		List<Conjunto> lista = cs.carregarConjuntosEmpresa(emp.getIdEmpresa());
		
		request.setAttribute("empresa", emp);

		RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
		view.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Empresa emp = new Empresa();

		EmpresaService es = new EmpresaService();

		es.excluir(Integer.parseInt(request.getParameter("idEmpresa")));

		request.setAttribute("empresa", emp);

		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		Empresa emp = new Empresa();

		EmpresaService es = new EmpresaService();

		es.excluir(id);

		request.setAttribute("empresa", emp);

		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	protected void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Empresa emp = new Empresa();

		EmpresaService es = new EmpresaService();

		emp = es.carregar(Integer.parseInt(request.getParameter("idEmpresa")));

		request.setAttribute("empresa", emp);

		RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
		view.forward(request, response);
	}

	protected void select(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		Empresa emp = new Empresa();

		EmpresaService es = new EmpresaService();

		emp = es.carregar(id);

		request.setAttribute("empresa", emp);

		RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
		view.forward(request, response);
	}

	/**
	 * Atribuir valores ao atributos da empresa
	 * @param request
	 * @return empresa com os dados que vieram no request
	 * @throws ServletException
	 * @throws IOException
	 */
	protected Empresa setAttributes(HttpServletRequest request) throws ServletException, IOException {
		String cnpj = request.getParameter("cnpj");
		String razaoSocial = request.getParameter("razaoSocial");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String horarioInicio = request.getParameter("horarioInicio");
		String horarioFim = request.getParameter("horarioFim");
		String temperatura = request.getParameter("temperatura");
		String horLigarAC = request.getParameter("horLigarAC");
		String horDesligarAC = request.getParameter("horDesligarAC");
		String conjunto = request.getParameter("conjuntos");
		String[] conjuntos;
		int[] conjuntosInt;

		if (conjunto.indexOf("-") == -1) {
			conjuntosInt = new int[0];
		} else {
			conjuntos = conjunto.split("-");
			conjuntosInt = new int[conjuntos.length];
			for (int i = 0; i < conjuntos.length; i++) {
				conjuntosInt[i] = Integer.parseInt(conjuntos[i]);
			}
			OrdenarService os = new OrdenarService();
			os.quick(conjuntosInt);
		}
		Empresa emp = new Empresa();

		emp.setCnpj(cnpj);
		emp.setRazaoSocial(razaoSocial);
		emp.setNomeFantasia(nomeFantasia);
		emp.setHorarioInicio(horarioInicio);
		emp.setHorarioFim(horarioFim);
		emp.setTemperatura(Integer.parseInt(temperatura));
		emp.setHorLigarAC(horLigarAC);
		emp.setHorDesligarAC(horDesligarAC);
		emp.setConjuntos(conjuntosInt);

		return emp;
	}

	/**
	 * Converter uma lista de conjuntos para um vetor de números de conjunto 
	 * @param lista - lista de conjuntos
	 * @return
	 */
	protected int[] listaToVetor(List<Conjunto> lista) {
		int[] conjuntos = new int[lista.size()];
		if (lista.size() != 0) {
			for (int i = 0; i < lista.size(); i++) {
				conjuntos[i] = lista.get(i).getNumeroConjunto();
			}
		}
		return conjuntos;
	}
	
	/**
	 * Converter um vetor de números de conjunto para uma lista de conjuntos 
	 * @param conjuntos - vetor dos números dos conjuntos
	 * @param idEmpresa - id da empresa
	 * @return
	 */
	protected List<Conjunto> vetorToLista(int[] conjuntos, int idEmpresa) {
		List<Conjunto> lista = new ArrayList<Conjunto>();
		Conjunto conjunto;
		if(conjuntos.length != 0) {
			for(int i = 0; i < conjuntos.length; i++) {
				conjunto = new Conjunto();
				conjunto.setIdEmpresa(idEmpresa);
				conjunto.setNumeroConjunto(conjuntos[i]);
				conjunto.setStatus(true);
				lista.add(conjunto);
			}
		}
		return lista;
	}
}

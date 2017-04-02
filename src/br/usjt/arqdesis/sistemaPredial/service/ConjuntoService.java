package br.usjt.arqdesis.sistemaPredial.service;

import br.usjt.arqdesis.sistemaPredial.dao.ConjuntoDAO;
import br.usjt.arqdesis.sistemaPredial.model.Conjunto;

public class ConjuntoService {
	ConjuntoDAO dao = new ConjuntoDAO();
	
	public int criar(Conjunto conjunto) {
		return dao.criar(conjunto);
	}
	
	public void atualizar(Conjunto conjunto){
		dao.atualizar(conjunto);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Conjunto carregar(int id){
		return dao.carregar(id);
	}
}

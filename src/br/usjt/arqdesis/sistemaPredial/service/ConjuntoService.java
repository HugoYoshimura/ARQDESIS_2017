package br.usjt.arqdesis.sistemaPredial.service;

import java.util.List;

import br.usjt.arqdesis.sistemaPredial.dao.ConjuntoDAO;
import br.usjt.arqdesis.sistemaPredial.model.Conjunto;

public class ConjuntoService {
	ConjuntoDAO dao = new ConjuntoDAO();
	
	public void criar(Conjunto conjunto) {
		dao.criar(conjunto);
	}
	
	public void excluir(Conjunto conjunto) {
		dao.excluir(conjunto);
	}
	
	public Conjunto carregar(int numeroConjunto) {
		return dao.select(numeroConjunto);
	}
	
	public List<Conjunto> carregarConjuntosVagos() {
		return dao.carregarConjuntosVagos();
	}
	
	public List<Conjunto> carregarConjuntosEmpresa(int idEmpresa) {
		return dao.carregarConjuntosEmpresa(idEmpresa);
	}
	
	public void insert(Conjunto conjunto) {
		dao.insert(conjunto);
	}
	
	public void update(Conjunto conjunto) {
		dao.update(conjunto);
	}
	
	public void delete(int numeroConjunto) {
		dao.delete(numeroConjunto);
	}
	
	public Conjunto select(int numeroConjunto) {
		return dao.select(numeroConjunto);
	}
	
	public List<Conjunto> selectAll() {
		return dao.selectAll();
	}
}

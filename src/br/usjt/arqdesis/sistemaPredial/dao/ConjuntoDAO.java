package br.usjt.arqdesis.sistemaPredial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.sistemaPredial.model.Conjunto;

public class ConjuntoDAO {
	public int criar(Conjunto conjunto) {
		String sqlInsert = "INSERT INTO conjunto(numeroConjunto, status, id_empresa) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, conjunto.getNumeroConjunto());
			if(conjunto.isStatus()) {
				stm.setString(2, "Y");
			} else {
				stm.setString(2, "N");
			}
			stm.setInt(3, conjunto.getIdEmpresa());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					conjunto.setIdConjunto(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conjunto.getIdConjunto();
	}

	public void atualizar(Conjunto conjunto) {
		String sqlUpdate = "UPDATE conjunto SET numeroConjunto = ?, status = ?, id_empresa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, conjunto.getNumeroConjunto());
			if(conjunto.isStatus()){
				stm.setString(2, "Y");
			} else {
				stm.setString(2, "N");
			}
			stm.setInt(3, conjunto.getIdEmpresa());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM conjunto WHERE id_conjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Conjunto carregar(int id) {
		Conjunto conjunto = new Conjunto();
		conjunto.setIdConjunto(id);
		String sqlSelect = "SELECT numeroConjunto, status, id_empresa FROM conjunto WHERE conjunto.id_conjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conjunto.getIdConjunto());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
						conjunto.setNumeroConjunto(rs.getInt("numeroConjunto"));
					if(rs.getString("status").equals("Y")) {
						conjunto.setStatus(true);
					} else {
						conjunto.setStatus(false);
					}
					conjunto.setIdEmpresa(rs.getInt("id_empresa"));
					
				} else {
					conjunto.setNumeroConjunto(0);
					conjunto.setStatus(false);
					conjunto.setIdEmpresa(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conjunto;
	}

}

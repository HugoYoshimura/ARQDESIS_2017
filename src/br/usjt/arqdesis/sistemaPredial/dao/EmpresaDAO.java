package br.usjt.arqdesis.sistemaPredial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.sistemaPredial.model.Empresa;

public class EmpresaDAO {
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa(cnpj, razaoSocial, nomeFantasia, horarioInicio, horarioFim, temperatura, horLigarAC, horDesligarAC) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getNomeFantasia());
			stm.setTime(4, convertTime(empresa.getHorarioInicio()));
			stm.setTime(5, convertTime(empresa.getHorarioFim()));
			stm.setInt(6, empresa.getTemperatura());
			stm.setTime(7, convertTime(empresa.getHorLigarAC()));
			stm.setTime(8, convertTime(empresa.getHorDesligarAC()));
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setIdEmpresa(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa.getIdEmpresa();
	}

	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE empresa SET cnpj = ?, razaoSocial = ?, nomeFantasia = ?, horarioInicio = ?, horarioFim = ?, temperatura = ?, horLigarAC = ?, horDesligarAC = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getNomeFantasia());
			stm.setTime(4, convertTime(empresa.getHorarioInicio()));
			stm.setTime(5, convertTime(empresa.getHorarioFim()));
			stm.setInt(6, empresa.getTemperatura());
			stm.setTime(7, convertTime(empresa.getHorLigarAC()));
			stm.setTime(8, convertTime(empresa.getHorDesligarAC()));
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM empresa WHERE id_empresa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Empresa carregar(int id) {
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(id);
		String sqlSelect = "SELECT cnpj, razaoSocial, nomeFantasia, horarioInicio, horarioFim, temperatura, horLigarAC, horDesligarAC FROM empresa WHERE empresa.id_empresa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, empresa.getIdEmpresa());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setNomeFantasia(rs.getString("nomeFantasia"));
					empresa.setHorarioInicio(rs.getTime("horarioInicio") + "");
					empresa.setHorarioFim(rs.getTime("horarioFim") + "");
					empresa.setTemperatura(rs.getInt("temperatura"));
					empresa.setHorLigarAC(rs.getTime("horLigarAC") + "");
					empresa.setHorDesligarAC(rs.getTime("horDesligarAC") + "");
				} else {
					empresa.setIdEmpresa(-1);
					empresa.setCnpj(null);
					empresa.setRazaoSocial(null);
					empresa.setNomeFantasia(null);
					empresa.setHorarioInicio(null);
					empresa.setHorarioFim(null);
					empresa.setTemperatura(0);
					empresa.setHorLigarAC(null);
					empresa.setHorDesligarAC(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}
	
	private java.sql.Time convertTime(String tempoS) {
		String[] tempo = tempoS.split(":");
		int hora = Integer.parseInt(tempo[0]);
		int minuto = Integer.parseInt(tempo[1]);
		return new java.sql.Time(hora, minuto, 00);
	}

}

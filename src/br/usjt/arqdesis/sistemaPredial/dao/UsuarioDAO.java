package br.usjt.arqdesis.sistemaPredial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.sistemaPredial.model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(cpf, nome, login, senha, dataNascimento, sexo, endereco, cep, telefone, email, conta, acesso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stm.setString(6, usuario.getSexo());
			stm.setString(7, usuario.getEndereco());
			stm.setString(8, usuario.getCep());
			stm.setString(9, usuario.getTelefone());
			stm.setString(10, usuario.getEmail());
			stm.setString(11, usuario.getConta());
			stm.setString(12, usuario.getAcesso());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getIdUsuario();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET cpf = ?, nome = ?, login = ?, senha = ?, dataNascimento = ?, sexo = ?, endereco = ?, cep = ?, telefone = ?, email = ?, conta = ?, acesso = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stm.setString(6, usuario.getSexo());
			stm.setString(7, usuario.getEndereco());
			stm.setString(8, usuario.getCep());
			stm.setString(9, usuario.getTelefone());
			stm.setString(10, usuario.getEmail());
			stm.setString(11, usuario.getConta());
			stm.setString(12, usuario.getAcesso());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id_usuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		String sqlSelect = "SELECT cpf, nome, login, senha, dataNascimento, sexo, endereco, cep, telefone, email, conta, acesso FROM usuario WHERE usuario.id_usuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getIdUsuario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setCpf(rs.getString("cpf"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setDataNascimento(rs.getDate("dataNascimento"));
					usuario.setSexo(rs.getString("sexo"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setCep(rs.getString("cep"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setTelefone(rs.getString("email"));
					usuario.setConta(rs.getString("conta"));
					usuario.setAcesso(rs.getString("acesso"));
				} else {
					usuario.setIdUsuario(-1);
					usuario.setCpf(null);
					usuario.setNome(null);
					usuario.setLogin(null);
					usuario.setSenha(null);
					usuario.setDataNascimento(null);
					usuario.setSexo(null);
					usuario.setEndereco(null);
					usuario.setCep(null);
					usuario.setTelefone(null);
					usuario.setEmail(null);
					usuario.setConta(null);
					usuario.setAcesso(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

}

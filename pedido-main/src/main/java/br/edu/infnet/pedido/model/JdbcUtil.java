package br.edu.infnet.pedido.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcUtil {

	private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);
	
	public static Connection obterConexao() {
		logger.info("Inciando conexao com o banco de dados");
		String password = "postgres";
		String user= "postgres";
		String url = "jdbc:postgresql://localhost:5430/pedidos?createDatabaseIfNotExist=true";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error("Erro ao conectar", e);
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		obterConexao();
	}
}

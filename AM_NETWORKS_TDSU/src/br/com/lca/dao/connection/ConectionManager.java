package br.com.lca.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.lca.exception.LcaExpection;

/**
 * Gerenciador de conex�o com banco de dados Oracle. Utilizada nas
 * implementa��es das DAO's para execu��o de querys.
 */
public class ConectionManager {

	String usuario = "OPS$RM71505";
	String senha = "240595";
	String jdbcUrl = "jdbc:oracle:thin:@192.168.60.15:1521:ORCL";

	public static ConectionManager INSTANCE;

	private ConectionManager() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public static ConectionManager getInstance() throws LcaExpection {
		try {
			if (INSTANCE == null) {
				INSTANCE = new ConectionManager();
			}
			return INSTANCE;
		} catch (ClassNotFoundException e) {
			throw new LcaExpection(
					"O driver de JDBC Oracle n�o foi encontrado.");
		}
	}

	public Connection getConnection() throws LcaExpection {
		try {
			return DriverManager.getConnection(jdbcUrl, usuario, senha);

		} catch (SQLException e) {

			e.printStackTrace();
			throw new LcaExpection("Erro ao abrir a conex�o com banco de dados");
		}
	}

	public void closeConnection(Connection conexao) throws LcaExpection {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new LcaExpection(
						"Erro ao fechar conex�o com banco de dados.");
			}
		}
	}
}

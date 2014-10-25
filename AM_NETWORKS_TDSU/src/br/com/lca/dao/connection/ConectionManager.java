package br.com.lca.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.lca.exception.LcaExpection;

/**
 * Gerenciador de conexão com banco de dados Oracle. Utilizada nas
 * implementações das DAO's para execução de querys.
 */
public class ConectionManager {

	public static ConectionManager instance;

	private ConectionManager() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	
	public static ConectionManager getInstance() throws LcaExpection {
		try {
			if (instance.equals(null)) {
				instance = new ConectionManager();
			}
			return instance;
		} catch (ClassNotFoundException e) {
			throw new LcaExpection(
					"O driver de JDBC Oracle não foi encontrado.");
		}
	}
	
public Connection getConnection() throws LcaExpection {
				
		
		// parametros da conexao
		String usuario = "OPS$RMXXXXX";
		String senha = "DDMMAA";
		String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; //acesso externo
		//String jdbcUrl = "jdbc:oracle:thin:@192.168.60.15:1521:ORCL"; //acesso interno
		//String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; //acesso local express edition
		
		
		try{
			return DriverManager.getConnection(jdbcUrl, usuario, senha);
	
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new LcaExpection("Erro ao abrir a conexão com banco de dados");
		}
	}
}

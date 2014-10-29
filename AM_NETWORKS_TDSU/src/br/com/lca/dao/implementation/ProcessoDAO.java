package br.com.lca.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.dao.connection.ConectionManager;
import br.com.lca.exception.LcaExpection;

public class ProcessoDAO implements br.com.lca.dao.interfaces.ProcessoDAO {

	public ProcessoDAO() {

	}

	@Override
	public ArrayList<Processo> listarProcessoPorNumero(Processo processo)
			throws LcaExpection {

		Connection conexaoBanco = null;
		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandolistar = conexaoBanco
					.prepareStatement("SELECT PROC.NR_PROCESSO, PROC.DS_PROCESSO, CLI.DS_RAZAO_SOCIAL "
							+ "FROM T_AM_NTW_PROCESSO PROC INNER JOIN T_AM_NTW_CLIENTE CLI ON (PROC.CD_CLIENTE = CLI.CD_CLIENTE) "
							+ "WHERE PROC.NR_PROCESSO = ? AND PROC.DT_FECHAMENTO IS NULL;");

			comandolistar.setInt(1, processo.getCodigo());
			
			ResultSet retornoConsulta = comandolistar.executeQuery();

			return geraListaProcesso(retornoConsulta);
		} catch (SQLException e) {
			throw new LcaExpection("Erro ao realizar ao listar.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public ArrayList<Processo> listarProcessoPorCliente(Cliente cliente)
			throws LcaExpection {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Processo> listarProcessoPorPeriodo(Periodo periodo)
			throws LcaExpection {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int obterSituacao(Processo processo) throws LcaExpection {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaEncerrado(Processo processo) throws LcaExpection {
		// TODO Auto-generated method stub
		return false;
	}

	private ArrayList<Processo> geraListaProcesso(ResultSet retornoConsulta)
			throws LcaExpection {

		ArrayList<Processo> relacaoProcesso = new ArrayList<Processo>();
		try {
			while (retornoConsulta.next()) {

				Processo processo = new Processo();

				processo.setCodigo(retornoConsulta.getInt("NR_PROCESSO"));
				processo.setDescricao(retornoConsulta.getString("DS_PROCESSO"));
				processo.setCliente(new Cliente(retornoConsulta
						.getString("DS_RAZAO_SOCIAL")));

				relacaoProcesso.add(processo);
			}
		} catch (SQLException e) {
			throw new LcaExpection("Erro ao ler retorno do banco.");
		}
		return relacaoProcesso;
	}
}

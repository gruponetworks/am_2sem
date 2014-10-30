package br.com.lca.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT PROC.NR_PROCESSO, PROC.DS_PROCESSO, CLI.DS_RAZAO_SOCIAL "
							+ "FROM T_AM_NTW_PROCESSO PROC INNER JOIN T_AM_NTW_CLIENTE CLI ON (PROC.CD_CLIENTE = CLI.CD_CLIENTE) "
							+ "WHERE PROC.NR_PROCESSO = ? AND PROC.DT_FECHAMENTO IS NULL");

			comandoListar.setInt(1, processo.getCodigo());

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaProcesso(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar processo. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public ArrayList<Processo> listarProcessoPorCliente(Cliente cliente)
			throws LcaExpection {

		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT PROC.NR_PROCESSO, PROC.DS_PROCESSO, CLI.DS_RAZAO_SOCIAL"
							+ "FROM T_AM_NTW_PROCESSO PROC INNER JOIN T_AM_NTW_CLIENTE CLI ON (PROC.CD_CLIENTE = CLI.CD_CLIENTE)"
							+ "WHERE CLI.DS_RAZAO_SOCIAL = ? AND PROC.DT_FECHAMENTO IS NULL");

			comandoListar.setString(1, cliente.getNome());

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaProcesso(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar processo. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public ArrayList<Processo> listarProcessoPorPeriodo(Periodo periodo)
			throws LcaExpection {

		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT PROC.NR_PROCESSO, PROC.DS_PROCESSO, CLI.DS_RAZAO_SOCIAL"
							+ "FROM T_AM_NTW_PROCESSO PROC INNER JOIN T_AM_NTW_CLIENTE CLI ON (PROC.CD_CLIENTE = CLI.CD_CLIENTE)"
							+ "WHERE DT_ABERTURA >= TO_DATE(?, 'DD/MM/YYYY') AND DT_ABERTURA <= TO_DATE(?, 'DD/MM/YYYY')"
							+ "AND PROC.DT_FECHAMENTO IS NULL");

			SimpleDateFormat formatorDeData = new SimpleDateFormat("dd/MM/yyyy");

			comandoListar.setString(1,
					formatorDeData.format(periodo.getDataInicial().getTime()));
			comandoListar.setString(2,
					formatorDeData.format(periodo.getDataFinal().getTime()));

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaProcesso(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar processo. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public Processo obterSituacao(Processo processo) throws LcaExpection {

		Connection conexaoBanco = null;

		try {

			conexaoBanco = ConectionManager.getInstance().getConnection();
			PreparedStatement comandoSql = conexaoBanco
					.prepareStatement("SELECT NR_SITUACAO FROM T_AM_NTW_PROCESSO WHERE NR_PROCESSO = ?");

			comandoSql.setInt(1, processo.getCodigo());

			ResultSet retornoConsulta = comandoSql.executeQuery();

			if (retornoConsulta.next()) {
				if (retornoConsulta.getInt("NR_SITUACAO") > 0) {
					processo.setSituacaoBloqueio(true);
				} else {
					processo.setSituacaoBloqueio(false);
				}
			}

			return processo;

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao obter situação. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public Processo obterDataEncerramento(Processo processo)
			throws LcaExpection {

		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();
			PreparedStatement comandoSql = conexaoBanco
					.prepareStatement("SELECT DT_FECHAMENTO FROM T_AM_NTW_PROCESSO WHERE NR_PROCESSO = ?");

			comandoSql.setInt(1, processo.getCodigo());

			ResultSet retornoConsulta = comandoSql.executeQuery();

			if (retornoConsulta.next()) {

				Date retornoFechamento = retornoConsulta
						.getDate("DT_FECHAMENTO");

				Calendar dataFechamento = Calendar.getInstance();

				if (retornoFechamento.equals(null)) {
					processo.setDataFechamento(dataFechamento);
				} else {
					dataFechamento.setTime(retornoFechamento);
					processo.setDataFechamento(dataFechamento);
				}
			}

			return processo;

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao obter o status do processo. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
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

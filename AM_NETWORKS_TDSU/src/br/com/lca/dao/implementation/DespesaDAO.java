package br.com.lca.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.lca.beans.despesa.Despesa;
import br.com.lca.dao.connection.ConectionManager;
import br.com.lca.exception.LcaExpection;

public class DespesaDAO implements br.com.lca.dao.interfaces.DespesaDAO {

	@Override
	public ArrayList<Despesa> obter(Despesa parametros) throws LcaExpection {
		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT  DESP.CD_LANCAMENTO, TDESP.DS_TIPO_DESPESA, DESP.DT_DESPESA, DESP.VL_DESPESA, DESP.DS_OBSERVACAO"
							+ " FROM    T_AM_NTW_LANCA_DESPESA DESP INNER JOIN T_AM_NTW_TIPO_DESPESA TDESP"
							+ " ON (DESP.CD_TIPO_DESPESA = TDESP.CD_TIPO_DESPESA)"
							+ " WHERE   NR_PROCESSO = ?");

			comandoListar.setInt(1, parametros.getNumeroProcesso());

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaTipoDespesa(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar despesas. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public boolean incluir(Despesa parametros) throws LcaExpection {
		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoIncluir = conexaoBanco
					.prepareStatement("INSERT INTO T_AM_NTW_LANCA_DESPESA(CD_LANCAMENTO, NR_PROCESSO, CD_TIPO_DESPESA, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO)"
							+ "VALUES (SQ_AM_LANCA_DESPESA.nextval, ?, ?, (SYSDATE), ?, ?)");

			comandoIncluir.setInt(1, parametros.getNumeroProcesso());
			comandoIncluir.setInt(2, parametros.getTipoDespesa().getCodigo());
			comandoIncluir.setDouble(3, parametros.getValor());
			comandoIncluir.setString(4, parametros.getObservacao());

			int linhasAfetadas = comandoIncluir.executeUpdate();

			return (linhasAfetadas > 0);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao incluir despesa. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public boolean alterar(Despesa parametros) throws LcaExpection {
		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoAlterar = conexaoBanco
					.prepareStatement("UPDATE  T_AM_NTW_LANCA_DESPESA"
							+ " SET DT_DESPESA = TO_DATE(?,  'DD/MM/YYYY'),"
							+ " VL_DESPESA = ?," + " DS_OBSERVACAO = ?"
							+ " WHERE   CD_LANCAMENTO = ?");

			SimpleDateFormat formatorDeData = new SimpleDateFormat("dd/MM/yyyy");
			
			comandoAlterar.setString(1, formatorDeData.format(parametros.getDataLancamento().getTime()));
			comandoAlterar.setDouble(2, parametros.getValor());
			comandoAlterar.setString(3, parametros.getObservacao());
			comandoAlterar.setInt(4, parametros.getCodigo());

			int linhasAfetadas = comandoAlterar.executeUpdate();

			return (linhasAfetadas > 0);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao alterar despesa. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	@Override
	public boolean excluir(Despesa parametros) throws LcaExpection {
		// TODO Auto-generated method stub
		return false;
	}

	private ArrayList<Despesa> geraListaTipoDespesa(ResultSet retornoConsulta)
			throws LcaExpection {

		ArrayList<Despesa> listaDespesa = new ArrayList<Despesa>();
		try {
			while (retornoConsulta.next()) {

				Despesa processo = new Despesa();

				listaDespesa.add(processo);
			}
		} catch (SQLException e) {
			throw new LcaExpection("Erro ao ler retorno do banco.");
		}
		return listaDespesa;
	}
}

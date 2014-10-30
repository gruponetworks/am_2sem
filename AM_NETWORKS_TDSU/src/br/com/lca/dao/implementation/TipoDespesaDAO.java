package br.com.lca.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.lca.beans.despesa.TipoDespesa;
import br.com.lca.dao.connection.ConectionManager;
import br.com.lca.exception.LcaExpection;

public class TipoDespesaDAO implements br.com.lca.dao.interfaces.TipoDespesaDAO {

	@Override
	public ArrayList<TipoDespesa> obterListaTipoDespesa() throws LcaExpection {

		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT  CD_TIPO_DESPESA, DS_TIPO_DESPESA FROM T_AM_NTW_TIPO_DESPESA");

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaTipoDespesa(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar tipo despesa. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	private ArrayList<TipoDespesa> geraListaTipoDespesa(
			ResultSet retornoConsulta) throws LcaExpection {

		ArrayList<TipoDespesa> listaTipoDespesa = new ArrayList<TipoDespesa>();
		try {
			while (retornoConsulta.next()) {

				TipoDespesa processo = new TipoDespesa(
						retornoConsulta.getInt("CD_TIPO_DESPESA"),
						retornoConsulta.getString("DS_TIPO_DESPESA"));

				listaTipoDespesa.add(processo);
			}
		} catch (SQLException e) {
			throw new LcaExpection("Erro ao ler retorno do banco.");
		}
		return listaTipoDespesa;
	}
}

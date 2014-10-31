package br.com.lca.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.lca.beans.despesa.TipoDespesa;
import br.com.lca.beans.honorario.TipoTarefa;
import br.com.lca.dao.connection.ConectionManager;
import br.com.lca.exception.LcaExpection;

public class TipoTarefaDAO implements br.com.lca.dao.interfaces.TipoTarefaDAO {

	@Override
	public ArrayList<TipoTarefa> obterListaTipoTarefa() throws LcaExpection {

		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT  CD_TIPO_DESPESA, DS_TIPO_DESPESA FROM T_AM_NTW_TIPO_DESPESA");

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaTipoTarefa(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar tipo despesa. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}

	private ArrayList<TipoTarefa> geraListaTipoTarefa(
			ResultSet retornoConsulta) throws LcaExpection {

		ArrayList<TipoTarefa> listaTipoTarefa = new ArrayList<TipoTarefa>();
		try {
			while (retornoConsulta.next()) {

				TipoTarefa processo = new TipoTarefa(
						retornoConsulta.getInt("CD_TIPO_DESPESA"),
						retornoConsulta.getString("DS_TIPO_DESPESA"));

				listaTipoTarefa.add(processo);
			}
		} catch (SQLException e) {
			throw new LcaExpection("Erro ao ler retorno do banco.");
		}
		return listaTipoTarefa;
	}
}

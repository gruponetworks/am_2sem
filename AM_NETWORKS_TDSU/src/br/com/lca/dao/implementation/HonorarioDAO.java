package br.com.lca.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.lca.beans.honorario.Honorario;
import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Processo;
import br.com.lca.dao.connection.ConectionManager;
import br.com.lca.exception.LcaExpection;

public class HonorarioDAO implements br.com.lca.dao.interfaces.HonorarioDAO {

	public HonorarioDAO() {

	}
	
	@Override
	public ArrayList<Honorario> obter(Honorario parametros) throws LcaExpection {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public boolean incluir(Honorario parametros) throws LcaExpection {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Honorario parametros) throws LcaExpection {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Honorario parametros) throws LcaExpection {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Honorario> listarHonorarioPorNumero(Honorario honorario)
			throws LcaExpection {
		Connection conexaoBanco = null;

		try {
			conexaoBanco = ConectionManager.getInstance().getConnection();

			PreparedStatement comandoListar = conexaoBanco
					.prepareStatement("SELECT  HON.cd_tipo_tarefa, " 
					        + "TPTAR.ds_tipo_tarefa, " 
					        + "HON.dt_honorario, " 
					        + "HON.qt_hora, " 
					        + "HON.DS_OBSERVACAO " 
					        + "FROM    T_AM_NTW_LANCA_HONOR HON INNER JOIN T_AM_NTW_TIPO_TAREFA TPTAR "
					        + "ON (HON.cd_tipo_tarefa = TPTAR.cd_tipo_tarefa) "
							+ "WHERE NR_PROCESSO = ?");


			comandoListar.setInt(1, honorario.getCodigo());

			ResultSet retornoConsulta = comandoListar.executeQuery();

			return geraListaHonorario(retornoConsulta);

		} catch (SQLException e) {
			throw new LcaExpection(
					"Erro ao listar honorario. Tente novamente mais tarde.");
		} finally {
			ConectionManager.getInstance().closeConnection(conexaoBanco);
		}
	}
	
	private ArrayList<Honorario> geraListaHonorario(ResultSet retornoConsulta)
			throws LcaExpection {

		ArrayList<Honorario> relacaoHonorario = new ArrayList<Honorario>();
		try {
			while (retornoConsulta.next()) {

				Honorario honorario = new Honorario();

				honorario.setCodigo(retornoConsulta.getInt("NR_PROCESSO"));
				

				relacaoHonorario.add(honorario);
			}
		} catch (SQLException e) {
			throw new LcaExpection("Erro ao ler retorno do banco.");
		}
		return relacaoHonorario;
	}

}

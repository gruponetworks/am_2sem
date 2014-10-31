package br.com.lca.bo;

import java.util.ArrayList;

import br.com.lca.beans.honorario.Honorario;
import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.dao.factory.DAOFactory;
import br.com.lca.dao.interfaces.HonorarioDAO;
import br.com.lca.dao.interfaces.ProcessoDAO;
import br.com.lca.exception.LcaExpection;

public class HonorarioBO {

	public static HonorarioBO INSTANCE;

	private HonorarioBO() {

	}

	public static HonorarioBO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new HonorarioBO();
		}
		return INSTANCE;
	}

	public ArrayList<Honorario> listarHonorarioPorNumero(Honorario honorario)
			throws LcaExpection {
		HonorarioDAO honorarioDAO = DAOFactory.getHonorarioDAO();
		return honorarioDAO.listarHonorarioPorNumero(honorario);
	}


	public Processo carregaSituacaoProcesso(Processo processo) throws LcaExpection {
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.obterSituacao(processo);
	}

	public Processo obterDataEncerramento(Processo processo) throws LcaExpection {
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.obterDataEncerramento(processo);
	}
}

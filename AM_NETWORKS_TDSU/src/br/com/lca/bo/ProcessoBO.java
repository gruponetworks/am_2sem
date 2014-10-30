package br.com.lca.bo;

import java.util.ArrayList;

import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.dao.factory.DAOFactory;
import br.com.lca.dao.interfaces.ProcessoDAO;
import br.com.lca.exception.LcaExpection;

public class ProcessoBO {

	public static ProcessoBO INSTANCE;

	private ProcessoBO() {

	}

	public static ProcessoBO getInstance() {

		if (INSTANCE.equals(null)) {
			INSTANCE = new ProcessoBO();
		}
		return INSTANCE;
	}

	public ArrayList<Processo> listarProcessoPorNumero(Processo processo)
			throws LcaExpection {
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.listarProcessoPorNumero(processo);
	}

	public ArrayList<Processo> listarProcessoPorCliente(Cliente cliente)
			throws LcaExpection {
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.listarProcessoPorCliente(cliente);
	}

	public ArrayList<Processo> listarProcessoPorPeriodo(Periodo periodo)
			throws LcaExpection {
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.listarProcessoPorPeriodo(periodo);
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

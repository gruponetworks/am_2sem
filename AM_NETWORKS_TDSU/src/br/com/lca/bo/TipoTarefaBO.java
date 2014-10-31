package br.com.lca.bo;

import java.util.ArrayList;

import br.com.lca.beans.despesa.TipoDespesa;
import br.com.lca.beans.honorario.TipoTarefa;
import br.com.lca.dao.factory.DAOFactory;
import br.com.lca.dao.interfaces.TipoDespesaDAO;
import br.com.lca.dao.interfaces.TipoTarefaDAO;
import br.com.lca.exception.LcaExpection;

public class TipoTarefaBO {
	
	public static TipoTarefaBO INSTANCE;

	private TipoTarefaBO() {

	}

	public static TipoTarefaBO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new TipoTarefaBO();
		}
		return INSTANCE;
	}
	
	public ArrayList<TipoTarefa> obterListaTipoTarefa() throws LcaExpection{
		TipoTarefaDAO TipoTarefaDAO = DAOFactory.getTipoTarefaDAO();
		return TipoTarefaDAO.obterListaTipoTarefa();
	}
}
